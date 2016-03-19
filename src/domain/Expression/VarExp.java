package domain.Expression;

import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIDictionary;
import domain.DataTypes.MyIHeap;
import domain.DataTypes.MyNullPointerException;

public class VarExp extends Exp {
	String mId;
	
	public VarExp(String id) {
		mId = id;
	}
	
	//Evaluates the exp
	public int eval(MyIDictionary tbl, MyIHeap heap) throws Exception, MyClassCastException, MyNullPointerException {return tbl.lookup(mId);}

	//converts the exp to string
	@Override
	public String toString() {
		return mId;
	}
	
	public String getId(){
		return mId;
	}
}
