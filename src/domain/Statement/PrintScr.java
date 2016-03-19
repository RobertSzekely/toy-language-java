package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIllegalArgumentException;
import domain.DataTypes.MyNullPointerException;
import domain.DataTypes.MyUnsupportedOperationException;
import domain.DataTypes.PrgState;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class PrintScr implements IStmt {
	private Exp mExp;
	
	public PrintScr(Exp exp) {
		mExp = exp;
	}
	
	@Override
	public String toString() {
		return "printSc("+mExp.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException,
			MyNullPointerException, MyUnsupportedOperationException, MyIllegalArgumentException {
		/*
		 *   - pop the statement
			- evaluate the expression
			- write the expression evaluation into the list Out
			- print on the screen (or in GUI) the following pair (the identifier 
				of the current program state, the expression evaluation)

		 */
		
		state.addOut(String.valueOf(mExp.eval(state.getSymTable(), state.getHeap())));
		
		return null;
	}

}
