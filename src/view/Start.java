package view;



import java.util.Scanner;

import controller.*;
import domain.DataTypes.*;
import domain.Expression.ArithExp;
import domain.Expression.BoolExp;
import domain.Expression.ConstExp;
import domain.Expression.ExpException;
import domain.Expression.ReadExp;
import domain.Expression.VarExp;
import domain.Expression.ReadHeapExp;
import domain.Statement.*;
import javafx.application.*;
import javafx.event.*;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import repository.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Start extends Application {


	static IStmt prg = null;
	public static boolean fileFlag;

	Controller ctr;


	public static void main(String[] args) throws Exception, ExpException, ControllerException {

		launch(args);
		/*
		 * 	v=0;
			(while(v<3) (fork(print(v);v=v+1) ;v=v+1);
			sleep(5);
			print(v*10)*/
	/*	IStmt expsleep = new CompStmt(new AssignStmt("v" , new ConstExp(0)),
								new CompStmt(new WhileStmt(new BoolExp("<", new VarExp("v"), new ConstExp(3)) ,new CompStmt(
																														new ForkStmt(new CompStmt (new PrintStmt(new VarExp("v")) , new AssignStmt("v", new ArithExp("+", new VarExp("v"), new ConstExp(1)),
																														new AssignStmt("v", new ArithExp("+", new VarExp("v"), new ConstExp(1))))))
																														)), new CompStmt(
																																new SleepStmt(5), new PrintStmt(new ArithExp("*", new VarExp("v"), new ConstExp(10))))
											));
      */
		
		
		//Controller ctr = new Controller(expsleep);
//		Scanner in = new Scanner(System.in);
////		Menu menu = new Menu(in);
////		IStmt program = menu.StatementMenu();
//
//		IStmt ex1= new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new
//				VarExp("v")));
//
//		IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp("+",new ConstExp(2),new
//				ArithExp("*",new ConstExp(3), new ConstExp(5)))),
//				 new CompStmt(new AssignStmt("b",new ArithExp("+",new VarExp("a"), new
//				ConstExp(1))), new PrintStmt(new VarExp("b"))));
//
//
//		IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp("-",new ConstExp(2), new
//				ConstExp(2))),
//				 new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
//				AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
//
//		IStmt ex4 = new CompStmt(new AssignStmt("v", new ConstExp(6)),
//				new CompStmt( new WhileStmt(new ArithExp("-", new VarExp("v"), new ConstExp(4) ) ,
//						new CompStmt(new PrintStmt(new VarExp("v")), new AssignStmt("v", new ArithExp("-", new VarExp("v"),
//								new ConstExp(1)) ) )) ,  new PrintStmt(new VarExp("v"))) );
//
//
//		IStmt skipProg = new CompStmt(new AssignStmt("v", new ConstExp(6)),
//				new IfStmt(new BoolExp("<", new VarExp("v"), new ConstExp(10)), new IncStmt("v"), new SkipStmt()  ) );
//
//
////		IStmt readProg = new CompStmt( new AssignStmt("v", new ReadExp()) ,
////				new CompStmt(new IfStmt(new BoolExp("!", new VarExp("v")), new IncStmt("v"), new SkipStmt()) ,
////						new IncStmt("v" )));
//
//		IStmt switchProg = new CompStmt( new AssignStmt("v", new ConstExp(2)) ,
//				new CompStmt( new AssignStmt("a", new ArithExp("+", new VarExp("v"), new ConstExp(10))) ,
//					 new SwitchStmt(
//							new VarExp("v"), new ArithExp("-", new VarExp("a"), new ConstExp(11)),
//							new CompStmt (new IncStmt("a"), new PrintStmt(new VarExp("a"))) ,
//							new ArithExp("-", new VarExp("a"), new ConstExp(10)),
//							new CompStmt(new AssignStmt("a", new ArithExp("+", new VarExp("a"), new ConstExp(2))),
//									new PrintStmt(new VarExp("a"))), new PrintStmt(new VarExp("a")) )	) ) ;
//
//		IStmt heap1 = new CompStmt(new AssignStmt("v", new ConstExp(10)), new CompStmt(new NewHeapStmt("v", new ConstExp(20)),
//				new CompStmt(new NewHeapStmt("a", new ConstExp(22)), new PrintStmt(new VarExp("v")))));
//
//		// v=10;new(v,20);new(a,22);print(rH(v));print(rH(a)) at the end of execution Heap={1->20, 2->22}, SymTable={v->1, a->2} and Out={20,22}
//		IStmt heap2 = new CompStmt(new AssignStmt("v", new ConstExp(10)), new CompStmt(new NewHeapStmt("v", new ConstExp(20)), new CompStmt(new NewHeapStmt("a", new ConstExp(22)),
//				 new CompStmt(new PrintStmt(new ReadHeapExp("v")), new PrintStmt(new ReadHeapExp("a"))))));
//
//		//v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a)) at the end of execution: Heap={1->20, 2->30}, SymTable={v->1, a->2} and Out={2,30}
//		IStmt heap3 = new CompStmt(new AssignStmt("v", new ConstExp(10)),new CompStmt(new NewHeapStmt("v", new ConstExp(20)), new CompStmt(new NewHeapStmt("a", new ConstExp(22)),
//				 new CompStmt(new WriteHeapStmt("a", new ConstExp(30)), new CompStmt(new PrintStmt(new VarExp("a")), new PrintStmt(new ReadHeapExp("a")))))));
//
//
//
//
//
//
//		int opt;
//		do
//		{
//			System.out.println("\nChoose:\n"
//	                + "0 - Exit\n"
//	                + "1 - One step\n"
//	                + "2 - All Step\n"
//	                + "3 - Debug\n"
//	                + "4 - Serialize\n"
//	                + "5 - Deserialize\n");
//	        opt=in.nextInt();
//	        switch(opt)
//	        {
//	        case 0:
//	        	System.exit(0);
//	        case 1:
//	        	ctr.oneStepForAllPrg(ctr.getProgramStateList());
//
//	        	break;
//	        case 2:
//	        	try {
//	    			ctr.allStep();
//	    		} catch (ControllerException e) {
//	    			e.printStackTrace();
//	    		}
//
//	        	break;
////	        case 3:
////	        	ctr.debug();
////	        	break;
////	        case 4:
////	        	ctr.serialize(ctr.getCurrentProgram());
////	        	break;
////	        case 5:
////	        	ctr.setCurrentProgram(ctr.deserialize());
////	        	ctr.displayState();
////	        	break;
//	        default:
//	        	ctr.allStep();
//
//	        }
//
//		} while (true);
//
//
////		in.close();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		//v = 10; new(a, 22);
		//fork(wH(a, 30); v = 32; print(v); print(rH(a)));
		//print(v); print(rH(a))
		//    Id = 1
		//SymTable_1 ={ v->10,a->1}
		//Id = 10
		//SymTable_10 ={ v->32,a->1}
		//Heap ={ 1->30}
		//Out ={ 32,22,30,30}
		//or Out = { 22, 32, 30, 30 }

//		IStmt forkStmt = new ForkStmt(new CompStmt(new WriteHeapStmt("a", new ConstExp(30)),
//				new CompStmt(new AssignStmt("v", new ConstExp(32)),
//						new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new ReadHeapExp("a"))))));
//
//		IStmt lab9 = new CompStmt(new AssignStmt("v", new ConstExp(10)),
//				new CompStmt(new NewHeapStmt("a", new ConstExp(22)),
//						new CompStmt(forkStmt, new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new ReadHeapExp("a"))))));
//
		IStmt expsleep = new CompStmt(
				new AssignStmt("v" , new ConstExp(0)),
				new CompStmt(
						new WhileStmt(new BoolExp("<", new VarExp("v"), new ConstExp(3)),
										new CompStmt(
											new ForkStmt(
												new CompStmt (
													new PrintStmt(new VarExp("v")),
													new AssignStmt("v", new ArithExp("+", new VarExp("v"), new ConstExp(1)))
													)
												),
											new AssignStmt("v", new ArithExp("+", new VarExp("v"), new ConstExp(1)))
											)
							),
						new CompStmt(
								new SleepStmt(5),
								new PrintStmt(new ArithExp("*", new VarExp("v"), new ConstExp(10)))
								)
								
					)
			);
		IStmt exp = new CompStmt (
						new AssignStmt("v", new ConstExp(0)),
						new WhileStmt(new BoolExp("!", new BoolExp("==", new VarExp("v"), new ConstExp(3))), new IncStmt("v") ));
		
		IStmt ex8 = new CompStmt(new AssignStmt("v", new ConstExp(0)),
				 new WhileStmt(new BoolExp("!", new BoolExp("==", new VarExp("v"), new ConstExp(3))), new AssignStmt("v", new ArithExp("+", new VarExp("v"), new ConstExp(1)))));
			
		IStmt repStmt = new CompStmt(
				new AssignStmt ("v", new ConstExp(0)),
				new CompStmt(
					new RepeatStmt (new BoolExp("==", new VarExp("v"), new ConstExp(3)),
									new CompStmt(
										new ForkStmt (new CompStmt (
															new PrintStmt(new VarExp("v")),
															new AssignStmt("v", new ArithExp("+", new VarExp("v"), new ConstExp(1))))),
										new AssignStmt("v", new ArithExp("+", new VarExp("v"), new ConstExp(1))))
									),
					
					new CompStmt (
							new SkipStmt(),
							new CompStmt(
								new SkipStmt(),
								new CompStmt(
									new SkipStmt(),
									new PrintStmt(new ArithExp("*", new VarExp("v"), new ConstExp(10) )))))));						
	//	IStmt repeattest = new CompStmt(
	//								new AssignStmt ("v", new ConstExp(0)),
	//								new RepeatStmt(new BoolExp("==", new VarExp("v"), new ConstExp(3), new InctStmt ())))
		//Controller  ctr = new Controller(expsleep);

		
		IStmt PrintScStmt = new CompStmt (
				new AssignStmt("v", new ConstExp(5)),
				new CompStmt(
					new ForkStmt(new CompStmt(
										new CompStmt (
											new WhileStmt(new ArithExp("-", new VarExp("v"), new ConstExp(3)), new PrintScr(new VarExp("v"))),
											new AssignStmt("v", new ArithExp("-", new VarExp("v"), new ConstExp(1)))
													),
										new ForkStmt(new PrintScr(new VarExp("v"))))
										 ),
					new PrintScr(new ArithExp("*", new VarExp("v"), new ConstExp(10))))
							);
		
//		IStmt PrintScStmt2 = new CompStmt (
//				new AssignStmt("v", new ConstExp(5)),
//				new CompStmt(
//						new ForkStmt(new CompStmt (
//							new WhileStmt(new ArithExp("-", new VarExp("v"), new ConstExp(3)), 
//							new CompStmt(
//									new PrintScr(new VarExp("v")),
//									new AssignStmt("v", new ArithExp("-", new VarExp("v"), new ConstExp(1)))
//									)),
//						new ForkStmt(new PrintScr(new VarExp("v")))
//									)
//						 )),
//	new PrintScr(new ArithExp("*", new VarExp("v"), new ConstExp(10))));
			
		
		Stage mainWindow;
		Stage stmtWindow;
		Stage expWindow;
		Scene mainScene;
		Scene stmtScene;
		Scene expScene;

		mainWindow = primaryStage;
		mainWindow.setTitle("Interpreter");



		//VBox - where the current program and the threads will be shows-------------------
		VBox vBox = new VBox(10);
		Label currentProgLabel = new Label("Current program:");
		TextArea currentProgArea = new TextArea();

		Label threadsLabel = new Label("Threads running:");
		TextArea threadArea1 = new TextArea();
		threadArea1.setMinHeight(400);
		TextArea threadArea2 = new TextArea();
		threadArea2.setMinHeight(400);
		TextArea threadArea3 = new TextArea();
		threadArea3.setMinHeight(500);


		vBox.getChildren().addAll(currentProgLabel,currentProgArea,threadsLabel,threadArea1,threadArea2,threadArea3);
		//---------------------------------------------------------------------------------------------------------



		// Menu layout  -----------------------------------------------------
		VBox menuLayout = new VBox(10);
		Label mainLabel = new Label("Menu:");

		Button addProgButton = new Button("Add a program");
		addProgButton.setOnAction(e -> {
			
			//AddProgBox.display();

			//prg = AddProgBox.prg;
			//ctr = new Controller(prg);
			
			
			//ctr = new Controller(repStmt);
			//currentProgArea.setText(repStmt.toString());
			
			ctr = new Controller(PrintScStmt);
			currentProgArea.setText(PrintScStmt.toString());

			//ctr = new Controller(ex8);
			//currentProgArea.setText(ex8.toString());
			
			//currentProgArea.setText(prg.toString());
			
		});


		Button oneStepButton = new Button("One Step");
			oneStepButton.setOnAction(e -> {
				ctr.oneStepForAllPrg(ctr.getProgramStateList());
				threadArea1.setText(ctr.getProgramStateList().get(0).toString());
				if(ctr.getProgramStateList().size() > 1 ) threadArea2.setText(ctr.getProgramStateList().get(1).toString());
			});
	
		Button allStepButton = new Button ("All Steps");
			allStepButton.setOnAction(e -> {
				ctr.allStep();
				threadArea1.setText(ctr.getProgramStateList().get(0).toString());
				//if(ctr.getProgramStateList().size() > 1) threadArea2.setText(ctr.getProgramStateList().get(1).toString());
			});
		Button serializeButton = new Button("Serialize");
			serializeButton.setOnAction(e->
			{
				ctr.serialize();
			});
		Button deserializeButton = new Button("Deserialize");
			deserializeButton.setOnAction(e->
			{
				Object o = null;
				ctr = new Controller(o);
				ctr.deserialize();
			});

		Button writeToFileFlagButton = new Button("File Flag");
			writeToFileFlagButton.setOnAction(e->
			{
				if(fileFlag) fileFlag = false;
				else fileFlag = true;
				AlertBox.display("The flag is " + fileFlag);
			});


		menuLayout.getChildren().addAll(mainLabel,addProgButton, oneStepButton, allStepButton, serializeButton, deserializeButton, writeToFileFlagButton);
		//---------------------------------------------------------------------------------------------------------




		//mainLayout - Border Pane --------------------------------------------------------------------------
		BorderPane mainLayout = new BorderPane();
		mainLayout.setLeft(menuLayout);
		mainLayout.setCenter(vBox);


		//---------------------------------------------------------------------------------------------------------


		mainScene = new Scene(mainLayout,800,900);

		mainWindow.setScene(mainScene);

		mainWindow.show();

















//		//Layout 1 - children layd out in vertical column
//		VBox layout1 = new VBox(20);
//		layout1.getChildren().add(button1);
//		layout1.getChildren().add(button3);
//
//		scene1 = new Scene(layout1, 200,200);
//
//
//		//layout 2
//		StackPane layout2 = new StackPane();
//		layout2.getChildren().add(button2);
//		scene2 = new Scene(layout2,600,300);
//
//		window.setScene(scene1);
//		window.show();











	}// end of .start() method




}//end of Start class





