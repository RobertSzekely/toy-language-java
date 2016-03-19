package domain.Expression;

import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIDictionary;
import domain.DataTypes.MyIHeap;
import domain.DataTypes.MyNullPointerException;

public class ArithExp extends Exp {
	Exp mExp1;
	Exp mExp2;
	String mOp; 
	
	public ArithExp(String op, Exp exp1, Exp exp2) {
		mExp1 = exp1;
		mExp2 = exp2;
		mOp = op;
	}
	/**
	 * Evaluates the Expression
	 * @throws Exception 

	 * @throws ExpException 
	 */
	public int eval(MyIDictionary tbl, MyIHeap heap) throws Exception, ExpException {
		int leftOp = 0;
		try {
			leftOp = mExp1.eval(tbl, heap);
		} catch (MyClassCastException e) {
			e.printStackTrace();
		} catch (MyNullPointerException e) {
			e.printStackTrace();
		}
		int rightOp = 0;
		try {
			rightOp = mExp2.eval(tbl, heap);
		} catch (MyClassCastException e) {
			e.printStackTrace();
		} catch (MyNullPointerException e) {
			e.printStackTrace();
		}
		switch(mOp) 
		{
			case "+": return leftOp + rightOp;
			case "-": return leftOp - rightOp;
			case "*": return leftOp * rightOp;
			case "/": 
				
				try 
				{
					return leftOp / rightOp;
				}
				catch (ArithmeticException dbze) 
				{
					 throw new MyDivisionByZeroException(dbze.getMessage());
				}
			
			default: return 123123123;
		}
	}
	
	/**
	 * Converts the Exp to string
	 */
	@Override
	public String toString() {
		return mExp1.toString() + mOp + mExp2.toString();
	}
	
}






