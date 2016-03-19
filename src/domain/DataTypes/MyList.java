package domain.DataTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyList implements MyIList, Serializable {

//	private int mSize;
//	private String[] listArray;
	private List<String> output;
	
	public MyList() 
	{
		output = new ArrayList<>();
	}
	
	@Override
	public boolean contains(int e) throws MyClassCastException, MyNullPointerException {
		try
		{
			return output.contains(e);
		}
		catch(ClassCastException cce)
		{
			cce.printStackTrace();
			throw new MyClassCastException(cce.getMessage());
		}
		catch(NullPointerException npe)
		{
			npe.printStackTrace();
			throw new MyNullPointerException(npe.getMessage());
		}
		
	}
	@Override
	public boolean add(String element) throws MyUnsupportedOperationException, MyClassCastException, MyNullPointerException, MyIllegalArgumentException {
		try
		{
			output.add(element);
		}
		catch(UnsupportedOperationException uoe)
		{
			uoe.printStackTrace();
			throw new MyUnsupportedOperationException(uoe.getMessage());
		}
		catch(ClassCastException cce)
		{
			cce.printStackTrace();
			throw new MyClassCastException(cce.getMessage());
		}
		catch(NullPointerException npe)
		{
			npe.printStackTrace();
			throw new MyNullPointerException(npe.getMessage());
		}
		catch (IllegalArgumentException iae)
		{
			iae.printStackTrace();
			throw new MyIllegalArgumentException(iae.getMessage());
		}
		return true;
	}
	
	@Override
	public String toString() {
		String result = "\n Output \n";
		for (String str : output) {
			if(str != null)
				result += str+",  ";
		}
		return result;
	}
}
