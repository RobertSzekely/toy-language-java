package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.*;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class PrintStmt implements IStmt {
	private Exp mExp;
	
	public PrintStmt(Exp exp) {
		mExp = exp;
	}
	
	//converts the statement to string
	@Override
	public String toString() {
		return "print("+mExp.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException, MyNullPointerException, MyUnsupportedOperationException, MyIllegalArgumentException {
	
			//state.addExeStack(mExp);
			state.addOut(String.valueOf(mExp.eval(state.getSymTable(), state.getHeap())));
		
		return null;
	}
	

}
