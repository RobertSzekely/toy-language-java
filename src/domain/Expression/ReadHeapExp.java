package domain.Expression;

import domain.DataTypes.MyClassCastException;
import domain.DataTypes.MyIDictionary;
import domain.DataTypes.MyIHeap;
import domain.DataTypes.MyNullPointerException;

public class ReadHeapExp extends Exp{

	private String mVarName;
	
	public ReadHeapExp(String varName)
	{
		mVarName = varName;
	}
	
	@Override
	public int eval(MyIDictionary tbl, MyIHeap heap) throws Exception, ExpException, MyClassCastException, MyNullPointerException {
		int heapAddr = tbl.lookup(mVarName);
		
		try
		{
			heap.containsKey(heapAddr);
		}
		catch(NullPointerException npe)
		{
			throw new MyNullPointerException("Heap memory location unallocated");
		}
		
		return heap.get(heapAddr);
	}
	
	

	@Override
	public String toString() {
		return "rH(" + mVarName + ")";
	}

}
