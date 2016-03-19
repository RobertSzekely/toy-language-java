package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.*;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class WriteHeapStmt implements IStmt{

	private String mVarName;
	private Exp mExp;

	public WriteHeapStmt(String varName, Exp exp)
	{
		mVarName = varName;
		mExp = exp;
	}
	
	public String getVarName()
	{
		return mVarName;
	}
	
	public Exp getExp()
	{
		return mExp;
	}
	
	public String toString()
	{
		return "WriteHeapStmt("+mVarName+","+mExp.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException, MyNullPointerException {
		
		MyIHeap heap = state.getHeap();
		MyIDictionary symTable = state.getSymTable();
		if(symTable.isDefined(mVarName))
		{
			heap.put(symTable.lookup(mVarName), mExp.eval(symTable, heap));
		}
		else
		{
			throw new IllegalArgumentException("Heap address undefined");
		}
	
		return null;
	}
	
}
