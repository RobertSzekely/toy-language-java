package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIllegalArgumentException;
import domain.DataTypes.MyNullPointerException;
import domain.DataTypes.MyUnsupportedOperationException;
import domain.DataTypes.PrgState;
import domain.Expression.BoolExp;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class RepeatStmt implements IStmt{
	private Exp exp2;
	private IStmt stmt1;
	
	public RepeatStmt(Exp expression, IStmt statement) {
		exp2 = expression;
		stmt1 = statement;
	}
	
	public String toString() {
		return "repeat {" + stmt1.toString() + "} untill (" + exp2.toString() + ") ";
 	}
	
	public Exp getExp() {
		return exp2;
	}
	
	public IStmt getStatement() {
		return stmt1;
	}

	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException,MyNullPointerException, MyUnsupportedOperationException, MyIllegalArgumentException {
		
			state.addExeStack(new WhileStmt(new BoolExp ("!", exp2), stmt1));
			state.addExeStack(stmt1);
		
		return null;
	}

}
