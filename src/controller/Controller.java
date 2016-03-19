package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import domain.DataTypes.*;
import domain.Expression.ArithExp;
import domain.Expression.ConstExp;
import domain.Expression.Exp;
import domain.Expression.ExpException;
import domain.Expression.VarExp;
import domain.Statement.AssignStmt;
import domain.Statement.CompStmt;
import domain.Statement.IStmt;
import domain.Statement.IfStmt;
import domain.Statement.IncStmt;
import domain.Statement.NewHeapStmt;
import domain.Statement.PrintStmt;
import domain.Statement.SkipStmt;
import domain.Statement.SwitchStmt;
import domain.Statement.WhileStmt;
import domain.Statement.WriteHeapStmt;
import repository.*;

public class Controller<T> implements IController<T> {

    private IRepository<T> mRepo;

    public Controller(T stmt) {
        mRepo = new Repository<T>(setState(stmt));
    }

    public List<PrgState> setState(T stmt) {
        MyList output = new MyList();
        MyDictionary symTable = new MyDictionary();
        MyStack<T> exeStack = new MyStack<>();
        MyHeap heap = new MyHeap();
        PrgState<T> prog = new PrgState<>(exeStack, symTable, output, heap, 1);
        try {
            prog.addExeStack(stmt);
        } catch (ExpException e) {
            e.printStackTrace();
        }
        List<PrgState> prgList = new ArrayList<>();

        prgList.add(prog);

        return prgList;
    }


    public void serialize() {
        try
        {

            FileOutputStream fileOut = new FileOutputStream("serialized.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(mRepo.getPrgList());
            out.close();
            fileOut.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.out.println("Serialization successful");
    }

    public void deserialize() {
        List<PrgState> ps;
        try
        {
            FileInputStream fileIn = new FileInputStream("serialized.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ps = (List<PrgState>) in.readObject();
            in.close();
            fileIn.close();
            mRepo.setPrgList(ps);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Program state class not found");
            cnfe.printStackTrace();

        }
        System.out.println("Deserialization succsessful");

    }

    public List<PrgState> removeCompletedPrg(List<PrgState> inPrgList) {

        inPrgList.stream()
                .filter(p -> p.isNotCompleted())
                .collect(Collectors.toList());
        return inPrgList;
    }

    public void oneStepForAllPrg(List<PrgState> prgList) {
        //Prints the program states
//        prgList.forEach(prg -> controllerMeth(prg.displayState()));

        //Run the states concurrently
        //Prepare the list of callables
        List<Callable<PrgState>> callList = prgList.stream()
                .map(p -> (Callable<PrgState>) () -> {
                    try {
                        return p.oneStep();
                    } catch (ControllerException e) {
                        e.printStackTrace();
                    } catch (ExpException e) {
                        e.printStackTrace();
                    } catch (MyEmptyStackException e) {
                        e.printStackTrace();
                    } catch (MyClassCastException e) {
                        e.printStackTrace();
                    } catch (MyUnsupportedOperationException e) {
                        e.printStackTrace();
                    } catch (MyNullPointerException e) {
                        e.printStackTrace();
                    } catch (MyIllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());



        //start the execution of the callables
        //it returns the list of newly created threads

        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<PrgState> newPrgList = null;
        try {
            newPrgList = executor.invokeAll(callList).stream()
                    .map(future -> {

                        try {
                            return future.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        } catch (ExecutionException e) {
                            e.printStackTrace();

                        }
                        return null;
                    })
                    .filter(p -> p!= null)
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //add the new created threads to the list of existing threads
        prgList.addAll(newPrgList);

        //print the prg states after the execution
        prgList.forEach(prg -> prg.displayState());

        //save the current programs in the repository
        mRepo.setPrgList(prgList);

    }

    private void controllerMeth(String s) {
        System.out.println(s);
    }

    public List<PrgState> getProgramStateList()
    {
        return mRepo.getPrgList();
    }

    public void setProgramStateList(List<PrgState> prgList )
    {
        mRepo.setPrgList(prgList);
    }

	@Override
	public void allStep() {
		while (true) {
			List<PrgState> prgList = removeCompletedPrg(mRepo.getPrgList());
			if(prgList.size() == 0)
				return;
			else
				oneStepForAllPrg(prgList);
		}
		
	}




}






