package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.MyIStack;
import domain.DataTypes.MyStack;
import domain.DataTypes.PrgState;
import domain.Expression.ExpException;

public class ForkStmt<T> implements IStmt
{

	T mStmt;
	
	public ForkStmt(T stmt)
	{
		mStmt = stmt;
	}
	
	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException {
		
		
		
		MyIStack<T> stk2 = new MyStack<T>();
		stk2.push(mStmt);
		int id = state.getId();



		return new PrgState(
				stk2, state.getSymTable().deepCopy(), state.getOut(), state.getHeap(), ++id
		);
	}
	
	public String toString()
	{
		return "fork (" + mStmt.toString() + " ) ";
	}

}
