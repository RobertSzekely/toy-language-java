package domain.Statement;

import controller.ControllerException;
import domain.DataTypes.*;
import domain.Expression.Exp;
import domain.Expression.ExpException;

public class AssignStmt implements IStmt {

	private String mId;
	private Exp mExp;
	
	public AssignStmt(String id, Exp exp) {
		mId = id;
		mExp = exp;
	}
	//converts the statement to string
	@Override
	public String toString(){
		return mId + " = " + mExp.toString();
	}
	
	public String getId() {
		return mId;
	}
	
	public Exp getExp() {
		return mExp;
	}
	@Override
	public PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException, MyNullPointerException, MyUnsupportedOperationException, MyIllegalArgumentException {
		MyIDictionary symTbl = state.getSymTable();
		int val;
		val = mExp.eval(symTbl, state.getHeap());

		if (symTbl.isDefined(mId)) 
			symTbl.update(mId,val);
		else 
			symTbl.put(mId,val);
		return null;
	}
}
