package domain.Expression;
import domain.DataTypes.MyIDictionary;
import domain.DataTypes.MyIHeap;

public class ConstExp extends Exp {
	int mNumber;
	
	public ConstExp(int number) {
		mNumber = number;
	}
	
	// Evaluates the exp
	public int eval(MyIDictionary tbl, MyIHeap heap) {return mNumber;}
	
	//converts the exp to string
	public String toString() {
		return String .valueOf(mNumber);
	}

}
