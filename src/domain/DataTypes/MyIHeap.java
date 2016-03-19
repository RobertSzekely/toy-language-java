package domain.DataTypes;

public interface MyIHeap {
	
	int get(int addr);
	
	void put(int addr, int value);
	
	int size();
	
	boolean containsKey(int addr);
	
	String toString();
	
}
