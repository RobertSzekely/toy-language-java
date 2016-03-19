package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.MyIDictionary;
import domain.DataTypes.PrgState;
import domain.Expression.ArithExp;
import domain.Expression.ConstExp;
import domain.Expression.Exp;
import domain.Expression.ExpException;
import domain.Expression.VarExp;

public class IncStmt implements IStmt {

	private String mVarName;
	
	public IncStmt(String varName) {
		mVarName = varName;
	}

	public String getVarName(){
		return mVarName;
	}

	@Override
	public String toString() {
		return "INC("+mVarName+")";
	}

	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException 
	{
		
		state.addExeStack(new AssignStmt(mVarName,new ArithExp("+", new VarExp(mVarName) , new ConstExp(1) ) ));
		return null;
	}
	
	
	
}
