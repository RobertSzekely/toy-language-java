package domain.DataTypes;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Stack;

import domain.Statement.IStmt;

public class MyStack<T> implements MyIStack<T>, Serializable {
	
//	private IStmt[] stackArray;
//	private int top;	
	
	private Stack<T> stackArray;
	
	public MyStack() {
		stackArray = new Stack<T>();
		
	}
	
	public boolean push(T prg)  {
		stackArray.push(prg);
		return true;
	}
	
	@Override
	public boolean isEmpty()
	{
			return stackArray.isEmpty();
	}
	
	@Override
	public T pop() throws MyEmptyStackException {
		try 
		{
			return stackArray.pop();
		}
		catch (EmptyStackException e) 
		{
			e.printStackTrace();
			throw new MyEmptyStackException(e.getMessage());
		}
		
	}
	@Override
	public T peek() throws MyEmptyStackException {
		try
		{
			return stackArray.peek();
		}
		catch(EmptyStackException e)
		{
			e.printStackTrace();
			throw new MyEmptyStackException("Error at peek in MyStack+"+e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		String result = "\n Stack \n";
		
		for(int i = stackArray.size() - 1; i >= 0; i-- ) {
			if(stackArray.elementAt(i) != null)
				result += stackArray.elementAt(i).toString() + "\n";
		}
		return result;
	}
	

}
