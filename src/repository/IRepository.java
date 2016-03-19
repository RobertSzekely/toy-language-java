package repository;
import java.util.List;

import domain.DataTypes.*;
import domain.Expression.ExpException;
import domain.Statement.IStmt;

public interface IRepository<T> {
	

	

	List<PrgState> getPrgList();
	
	void setPrgList(List<PrgState> prgStateList);

}
