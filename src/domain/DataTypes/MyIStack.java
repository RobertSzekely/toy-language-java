package domain.DataTypes;

import domain.Statement.IStmt;

public interface MyIStack<T> {

	

	boolean isEmpty() ;

	T pop() throws MyEmptyStackException;
	
	T peek() throws MyEmptyStackException;
	
	//boolean isFull();
	
	String toString();

	boolean push (T prg) ;

	

	
	
	
	

}
