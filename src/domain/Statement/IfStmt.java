package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyNullPointerException;
import domain.DataTypes.PrgState;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class IfStmt implements IStmt {
	
	public Exp mExp;
	public IStmt mThenS;
	public IStmt mElseS;
	
	public IfStmt(Exp exp, IStmt thenS, IStmt elseS) {
		mExp = exp; 
		mThenS = thenS;
		mElseS = elseS;
	}
	
	public IfStmt(Exp exp, IStmt thenS) {
		mExp = exp; 
		mThenS = thenS;
		mElseS = new SkipStmt();
	}
	
	
	@Override
	public String toString() {
		return "IF("+mExp.toString()+")THEN("+mThenS.toString()+")ELSE("+mElseS.toString()+")";
		
	}
	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException, MyNullPointerException {
			if (mExp.eval(state.getSymTable(), state.getHeap()) != 0) 
			{
				state.addExeStack(mThenS);
			}
			else
			{
				state.addExeStack(mElseS);
			}
		return null;
	}
		
		
	

}
