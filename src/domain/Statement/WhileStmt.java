package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyNullPointerException;
import domain.DataTypes.PrgState;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class WhileStmt implements IStmt {

	private Exp mExp;
	private IStmt mStatement;
	
	
	public WhileStmt(Exp exp, IStmt statement) {
		mExp = exp;
		mStatement = statement;
	}
	
	@Override
	public String toString() {
		return "while("+mExp.toString()+") {"+mStatement.toString()+" }";
	}
	
	public Exp getExp() {
			return  mExp;
	}
	
	public IStmt getStatement() {
		return mStatement;
	}

	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException, MyNullPointerException {
			if(mExp.eval(state.getSymTable(),state.getHeap()) > 0) 
			{
				state.addExeStack(this);
				state.addExeStack(mStatement);
			}
		
		return null;
	}
}