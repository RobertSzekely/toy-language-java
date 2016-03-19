package domain.DataTypes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class MyHeap implements MyIHeap, Serializable{

	private Hashtable<Integer, Integer> heapMap;
	
	public MyHeap()
	{
		heapMap = new Hashtable<>();
	}
	
	@Override
	public int get(int addr) 
	{
		return heapMap.get(addr);
	}

	@Override
	public void put(int addr, int value) 
	{
		heapMap.put(addr, value);
	}
	
	public boolean containsKey(int addr)
	{
		return heapMap.containsKey(addr);
	}
	
	public String toString()
	{
		String result = "\n Heap \n {  ";
		Set<Integer> keys = heapMap.keySet();
		Set<Integer> sortedKeys = new TreeSet<Integer>(keys);
		for(Integer key : sortedKeys)
		{
			result += key.toString() + " -> " + heapMap.get(key).toString()+ ", ";
		}
		return result+ "  }";
	}
	
	public int size()
	{
		return heapMap.size();
	}

}
