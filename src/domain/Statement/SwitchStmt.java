package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.PrgState;
import domain.Expression.ArithExp;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class SwitchStmt implements IStmt { 
	
	private Exp mVarExp;
	private Exp mExp1;
	private Exp mExp2;
	private IStmt mStatement1;
	private IStmt mStatement2;
	private IStmt mStatement3;
	
	public SwitchStmt(Exp varExp, Exp exp1, IStmt statement1, Exp exp2, IStmt statement2, IStmt statement3)
	{
		mVarExp = varExp;
		mExp1 = exp1;
		mExp2 = exp2;
		mStatement1 = statement1;
		mStatement2 = statement2;
		mStatement3 = statement3;
	}
	@Override
	public String toString() {
		return "SWITCH ("+mVarExp.toString()+")  CASE ("+mExp1.toString()+"): "+mStatement1.toString() + 
				"   CASE ("+mExp2.toString()+"): " + mStatement2.toString()+"  DEFAULT: "+ mStatement3.toString();
	}
	/**
	 * @return the mVarExp
	 */
	public Exp getVarExp() {
		return mVarExp;
	}
	/**
	 * @return the mExp1
	 */
	public Exp getExp1() {
		return mExp1;
	}
	/**
	 * @return the mExp2
	 */
	public Exp getExp2() {
		return mExp2;
	}
	/**
	 * @return the mStatement1
	 */
	public IStmt getStatement1() {
		return mStatement1;
	}
	/**
	 * @return the mStatement2
	 */
	public IStmt getStatement2() {
		return mStatement2;
	}
	/**
	 * @return the mStatement3
	 */
	public IStmt getStatement3() {
		return mStatement3;
	}
	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException {
		
//		MyIDictionary symTable = state.getSymTable();
//		int var = switchStmt.getExp2().eval(symTable);
//		if(var - switchStmt.getExp1().eval(symTable) == 0)  
//			if(var - switchStmt.getExp1().eval(symTable) == 0)
//				state.addExeStack(switchStmt.getStatement3());
//			else state.addExeStack(switchStmt.getStatement1());
//		else state.addExeStack(switchStmt.getStatement2());
		
		IStmt stmt = new IfStmt(new ArithExp("-", mVarExp, mExp2),
				 new IfStmt( new ArithExp("-", mVarExp, mExp1), 
					mStatement3 , mStatement1), mStatement2);
		
			state.addExeStack(stmt);
		
		return null;
	}

}
