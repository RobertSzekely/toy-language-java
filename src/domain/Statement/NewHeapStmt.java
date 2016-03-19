package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.*;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class NewHeapStmt implements IStmt {
	
	private String mVarName;
	private Exp mExp;
	
	public NewHeapStmt(String varName, Exp exp)
	{
		mVarName = varName;
		mExp = exp;
	}
	
	public String toString()
	{
		return "NewHeap( " + mVarName + " , " + mExp.toString()+" )"; 
	}
	
	public String getVarName()
	{
		return mVarName;
	}
	
	public Exp getExp()
	{
		return mExp;
	}

	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException, MyUnsupportedOperationException, MyNullPointerException, MyIllegalArgumentException {
		MyIHeap heap = state.getHeap();
		MyIDictionary symTable = state.getSymTable();
			
		symTable.put(mVarName, heap.size() + 1);
		heap.put(heap.size() + 1, mExp.eval(symTable, heap));
		
		return null;
	}
	


}











