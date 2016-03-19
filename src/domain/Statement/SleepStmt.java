package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIllegalArgumentException;
import domain.DataTypes.MyNullPointerException;
import domain.DataTypes.MyUnsupportedOperationException;
import domain.DataTypes.PrgState;
import domain.Expression.ArithExp;
import domain.Expression.ConstExp;
import domain.Expression.ExpException;
import domain.Expression.VarExp;

public class SleepStmt implements IStmt {
	
	private int number;
	
	public SleepStmt (int Number) {
		number = Number;
	}

	@Override
	public String toString () {
		return "sleep(" + number + ")";
	}
	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException,
			MyNullPointerException, MyUnsupportedOperationException, MyIllegalArgumentException {
		if (number == 0) {
			//do nothing
		} else {
			int newNumber = number - 1;
			state.addExeStack(new SleepStmt(newNumber))  ;
			
		}
		return null;
	}
	
	

}
