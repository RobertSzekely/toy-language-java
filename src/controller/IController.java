package controller;

import domain.DataTypes.PrgState;
import domain.Expression.ExpException;

import java.util.List;

public interface IController<T> {
	
	void allStep();
	
	List<PrgState> setState(T stmt);

	List<PrgState> removeCompletedPrg(List<PrgState> inPrgList);

	void oneStepForAllPrg(List<PrgState> prgList);

}
