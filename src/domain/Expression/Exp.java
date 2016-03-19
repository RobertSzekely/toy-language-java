package domain.Expression;

import java.io.Serializable;

import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIDictionary;
import domain.DataTypes.MyIHeap;
import domain.DataTypes.MyNullPointerException;

public abstract class Exp implements Serializable{
	
	//Evaluates the Exp
	public abstract int eval(MyIDictionary tbl, MyIHeap heap) throws Exception, ExpException, MyClassCastException, MyNullPointerException;
	
	//converts exp to string
	@Override
	public abstract String toString();
}
