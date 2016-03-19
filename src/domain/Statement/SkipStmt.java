package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.PrgState;
import domain.Expression.ExpException;

public class SkipStmt implements IStmt {

	public SkipStmt() {}
	
	@Override
	public String toString() {
		return "skip ";
	}

	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException {
		
		return null;
	}
	
}
