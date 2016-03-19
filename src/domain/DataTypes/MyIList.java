package domain.DataTypes;

public interface MyIList {
	
	boolean add(String element) throws MyUnsupportedOperationException, MyClassCastException, MyNullPointerException, MyIllegalArgumentException;
	
	String toString();

	boolean contains(int e) throws MyClassCastException, MyNullPointerException;


}
