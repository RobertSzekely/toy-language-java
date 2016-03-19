/**
 * 
 */
package domain.Statement;

import java.io.Serializable;

import controller.ControllerException;
import domain.DataTypes.*;
import domain.Expression.ExpException;

/**
 * @author sssse_000
 *
 */
public interface IStmt extends Serializable {
	String toString();
	
	PrgState execute(PrgState state) throws Exception, ExpException, ControllerException, MyClassCastException, MyNullPointerException, MyUnsupportedOperationException, MyIllegalArgumentException;

}
