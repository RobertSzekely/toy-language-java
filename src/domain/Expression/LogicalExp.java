package domain.Expression;

import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIDictionary;
import domain.DataTypes.MyIHeap;
import domain.DataTypes.MyNullPointerException;

public class LogicalExp extends Exp {
	
	Exp exp1;
	Exp exp2 = null;
	String operator;
	
	public LogicalExp() {}
	
	public LogicalExp(Exp Exp1, Exp Exp2, String op) {
		this.exp1 = Exp1;
		this.exp2 = Exp2;
		this.operator = op;
	}
	
	public LogicalExp(Exp Exp1, String op){
		this.exp1 = Exp1;
		this.operator = op;
	}
	

	@Override
	public int eval(MyIDictionary tbl, MyIHeap heap)
			throws Exception, ExpException, MyClassCastException, MyNullPointerException {
		int left = exp1.eval(tbl, heap);
		int right = -1;
		
		if(exp2 != null) {
			right = exp2.eval(tbl, heap);
		}
		switch (operator) {
		case "&&":
			if(left != 0 && right != 0) return 1;
			else return 0;
		case "||":
			if(left != 0 || right != 0) return 1;
			else return 0;
			
		case "!":
			if(left == 0) return 1;
			else return 0;
			
		default: 
			return 0;
		}
		//return 0;
	}

	@Override
	public String toString() {
		
		return null;
	}

}
