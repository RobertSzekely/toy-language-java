package domain.DataTypes;

import java.io.*;
import java.util.EmptyStackException;

import controller.ControllerException;
import domain.Expression.ExpException;
import domain.Statement.IStmt;
import view.Start;

public class PrgState<T> implements Serializable {
    private MyIStack<T> exeStack;
    private MyIDictionary symTable;
    private MyIList out;
    private MyIHeap mHeap;
    public T s;
    private int mId;


    public PrgState(MyIStack stk, MyIDictionary symtbl, MyIList ot, MyIHeap heap, int id) {
        exeStack = stk;
        out = ot;
        symTable = symtbl;
        mHeap = heap;
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public MyIHeap getHeap() {
        return mHeap;
    }

    public void SetHeap(MyIHeap heap) {
        mHeap = heap;
    }

    public MyIStack getStk() {
        return exeStack;
    }

    public void setStk(MyIStack ex) {
        exeStack = ex;
    }

    public MyIDictionary getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary dic) {
        symTable = dic;
    }

    public MyIList getOut() {
        return out;
    }

    public void setOut(MyIList o) {
        out = o;
    }

    public void addExeStack(T st) throws ExpException {

        exeStack.push(st);

    }

    public void addSymTable(String id, int val) throws ExpException, MyClassCastException, MyUnsupportedOperationException, MyNullPointerException, MyIllegalArgumentException {

        symTable.put(id, val);


    }

    public void addOut(String val) throws ExpException, MyClassCastException, MyUnsupportedOperationException, MyNullPointerException, MyIllegalArgumentException {

        out.add(val);

    }



    public String toString() {
        return "\nProgram State Id: " + mId + "\n" +

                exeStack.toString() +
                "------------------------------------------------" +
                symTable.toString() +
                "\n-------------------------------------------------"+
                out.toString() +
                "\n-------------------------------------------------"+
                mHeap.toString() + "\n"+
                "\n==================================================";
    }

    public void addHeap(int addr, int value) {
        mHeap.put(addr, value);
    }

    public boolean isNotCompleted() {
        return !exeStack.isEmpty();
    }

    public PrgState oneStep() throws Exception, ControllerException, ExpException, MyEmptyStackException, MyClassCastException, MyUnsupportedOperationException, MyNullPointerException, MyIllegalArgumentException {

        if (exeStack.isEmpty())
           return null;
        IStmt crtStmt = (IStmt) exeStack.pop();
        return crtStmt.execute(this);

    }



    private void writeToConsole(String string) {
        System.out.printf("%s", string);


    }

    private void writeToText(String obj)
    {
        try
        {
            File file = new File("file.txt");
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(obj.replace("\n", "\r\n"));
            bw.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public String displayState()
    {
        String result = "";
        result += "\nProgram State Id: " + mId + "\n" +

                exeStack.toString() +
                "------------------------------------------------" +
                symTable.toString() +
                "\n-------------------------------------------------"+
                out.toString() +
                "\n-------------------------------------------------"+
                mHeap.toString() + "\n"+
                "\n==================================================";
        if(Start.fileFlag)writeToText(result);
        //writeToConsole(result);
        return result;
    }


}
