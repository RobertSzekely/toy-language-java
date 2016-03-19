package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.PrgState;
import domain.Expression.ExpException;

public class CompStmt implements IStmt {

	public IStmt mFirst;
	public IStmt mSecond;
	
	public CompStmt(IStmt first, IStmt second) {
		mFirst = first;
		mSecond = second;
	}
	//converts the statement to string
	@Override
	public String toString(){
		return mFirst.toString()+"; "+mSecond.toString();
	}
	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException {
			state.getStk().push(mSecond);
		
			state.getStk().push(mFirst);
		
		return null;
	}
}
