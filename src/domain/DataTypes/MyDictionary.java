package domain.DataTypes;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.*;
import java.util.TreeSet;

public class MyDictionary implements MyIDictionary, Serializable {

//	private int mSize;
//	private DictionaryItem[] dictionaryArray;
	private Hashtable<String, Integer> dictionaryArray;
	
	public MyDictionary() {
		dictionaryArray = new Hashtable<>();
	}
	
	/**
	 *  find the variable with specific id
	 *
	 */
	@Override
	public int lookup(String id) throws MyClassCastException, MyNullPointerException {
		int val = 123123;
		try 
		{
			Integer value = dictionaryArray.get(id);
			if (value != null) 
			{
				val =  value;
			}
		}
		catch(ClassCastException cce)
		{
			cce.printStackTrace();
			throw new MyClassCastException(cce.getMessage());
		}
		catch(NullPointerException npe) 
		{
			npe.getStackTrace();
			throw new MyNullPointerException(npe.getMessage());
		}
		return val;
		
	}
	
	// updates the variable
	@Override
	public boolean update(String id, int value) throws MyUnsupportedOperationException, MyClassCastException, MyNullPointerException, MyIllegalArgumentException {
		Integer val = dictionaryArray.get(id);
		if(val != null) 
		{
			try
			{
				dictionaryArray.put(id, value);
				return true;
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
			
		}
		return false;
	}
	
	//add a new variable to the dictionary
	@Override
	public boolean put(String id, int value) throws MyUnsupportedOperationException, MyClassCastException, MyNullPointerException, MyIllegalArgumentException {
		try
		{
			dictionaryArray.put(id, value);
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
	
	//converts to string
	@Override
	public String toString() {
		String result = "\n Dictionary \n";
		Set<String> keys = dictionaryArray.keySet();
		Set<String> sortedKeys = new TreeSet<String>(keys);
		for(String key : keys)
		{
				result += key +" = "+String.valueOf(dictionaryArray.get(key))+ " , ";
		}
		return result;
	}

	@Override
	public boolean isDefined(String id) throws MyClassCastException, MyNullPointerException {
		try
		{
			return dictionaryArray.containsKey(id);
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
	
	

	public MyIDictionary deepCopy()
	{
//		Hashtable<String, Integer> newDict = new Hashtable<>();
//
//		for (entry : dictionaryArray)
//		{
//			newDict.put(entry);
//		}
		MyDictionary dict =  new MyDictionary();
				dict.dictionaryArray = (Hashtable<String, Integer>)dictionaryArray.clone();
		return dict;


	}
}
