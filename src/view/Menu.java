package view;

import java.util.Scanner;

import domain.Expression.ArithExp;
import domain.Expression.ConstExp;
import domain.Expression.Exp;
import domain.Expression.VarExp;
import domain.Statement.AssignStmt;
import domain.Statement.CompStmt;
import domain.Statement.IStmt;
import domain.Statement.IfStmt;
import domain.Statement.PrintStmt;

public class Menu {
	
	public Scanner in;
	public Menu(Scanner in) 
	{
		this.in = in;
	}
	
	/**
	 * 
	 */
	public IStmt StatementMenu() 
	{
		System.out.println("Choose statement: \n"
				+ "1: If Statement\n"
				+ "2: Print Statement\n"
				+ "3: Assignment Statement\n"
				+ "4: Copound Statement\n"
				+ "5: While Statement"
				);
		int n = in.nextInt();
		switch(n)
		{
		case 1:
			return new IfStmt(ExpressionMenu(), StatementMenu(), StatementMenu());
		case 2:
			return new PrintStmt(ExpressionMenu());
		case 3:
			System.out.println("Give the name of the variable: ");
			String variable = in.next();
			return new AssignStmt(variable, ExpressionMenu());
		case 4:
			return new CompStmt(StatementMenu(), StatementMenu());
		default:
			System.out.println("Wrong command");
			return StatementMenu();
		}
	}
	/**
	 * 
	 */
	public Exp ExpressionMenu()
	{
		System.out.println("Choose expression:\n"
				+ "1-Arithmetic Expression\n"
				+ "2-Variable Expression\n"
				+ "3-Constant Expression\n");
		int n = in.nextInt();
		switch(n)
		{
		case 1:
			System.out.println("Give the operator: ");
			String operator = in.next();
			return new ArithExp(operator, ExpressionMenu(), ExpressionMenu());
		case 2:
			System.out.println("Give variable name: ");
			String variable = in.next();
			return new VarExp(variable);
		case 3: 
			System.out.println("Give a number: ");
			int number = in.nextInt();
			return new ConstExp(number);
		default:
			System.out.println("Try again \n");
			return ExpressionMenu();
	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
