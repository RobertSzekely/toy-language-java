package domain.Expression;

import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIDictionary;
import domain.DataTypes.MyIHeap;
import domain.DataTypes.MyNullPointerException;

public class BoolExp extends Exp {

	private String mOp;
	private Exp mExp1;
	private Exp mExp2;
	
	public BoolExp(String op, Exp exp1, Exp exp2) {
		mOp = op;
		mExp1 = exp1;
		mExp2 = exp2;
	}
	
	public BoolExp(String op, Exp exp1) {
		mOp = op;
		mExp1 = exp1;
	}
	
	
	
	/**
	 * Evaluates the expression
	 * Return :
	 * 	0 - true
	 *  1 - false

	 * @throws ExpException 
	 */
	@Override
	public int eval(MyIDictionary tbl, MyIHeap heap) throws Exception, ExpException {
		int rightOp = 0;
		int leftOp = 0;
		try {
			leftOp = mExp1.eval(tbl, heap);
		} catch (MyClassCastException e) {
			e.printStackTrace();
		} catch (MyNullPointerException e) {
			e.printStackTrace();
		}
		if(mExp2 != null)
		{
			try {
				rightOp = mExp2.eval(tbl, heap);
			} catch (MyClassCastException e) {
				e.printStackTrace();
			} catch (MyNullPointerException e) {
				e.printStackTrace();
			}
		}
		switch(mOp) 
		{
		case "==": 
			if (leftOp == rightOp) return 1;
			else return 0;
		case "!=": 
			if (leftOp != rightOp) return 1;
			else return 0;
		case "<": 
			if (leftOp < rightOp) return 1;
			else return 0;
		case "<=":
			if(leftOp <= rightOp) return 1;
			else return 0;
		case ">":
			if (leftOp > rightOp) return 1;
			else return 0;
		case ">=":
			if (leftOp >= rightOp) return 1;
			else return 0;
		case "&&": 
			if( leftOp != 0 && rightOp != 0) return 1;
			else return 0;
		case "||": 
			if (leftOp != 0 || rightOp != 0) return 1;
			else return 0;
		case "!":
			if(leftOp == 0) return 1;
			else return 0;
		default:
			return 0;
		}
	}

	@Override
	public String toString() {
		if (mExp2 != null)
		return mExp1.toString()+" "+mOp+" "+mExp2.toString();
		else return mOp+"("+mExp1.toString()+")";
	}




	
	
	
	
}