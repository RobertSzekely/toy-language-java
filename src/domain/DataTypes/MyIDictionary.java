package domain.DataTypes;



public interface MyIDictionary {
	
	int lookup(String id) throws  MyClassCastException, MyNullPointerException;

	boolean update(String id, int val) throws  MyUnsupportedOperationException, MyClassCastException, MyNullPointerException, MyIllegalArgumentException;

	
	
	String toString();

	boolean isDefined(String id) throws  MyClassCastException, MyNullPointerException;

	boolean put(String id, int value) throws  MyUnsupportedOperationException, MyClassCastException, MyNullPointerException, MyIllegalArgumentException;

	MyIDictionary deepCopy();

	

}
