package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import domain.DataTypes.*;

public class Repository<T> implements IRepository<T> {


	private List<PrgState> mPrgStateList;
	
	public Repository(List<PrgState> ps) {
		mPrgStateList = ps;
	}
	

	@Override
	public List<PrgState> getPrgList() {
		return mPrgStateList;
	}

	@Override
	public void setPrgList(List<PrgState> prgStateList) {
		mPrgStateList = prgStateList;
		
	}

	

}
