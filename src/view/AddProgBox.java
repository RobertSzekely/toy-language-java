package view;

import domain.Statement.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AddProgBox {

    static IStmt prg = null;

    public static IStmt display ()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        TextArea constructArea = new TextArea();


        Label label = new Label("Choose statement:");
        Button comp = new Button("Comp");
            comp.setOnAction(e -> {
                if(prg !=null) constructArea.setText(prg.toString());
                prg = new CompStmt(display(), display());

                window.close();
            });

        Button assign = new Button("Assign");
            assign.setOnAction(e -> {
                if(prg !=null) constructArea.setText(prg.toString());
                prg = new AssignStmt(GetVariableNameBox.display(), ExpMenuBox.display());
                System.out.println(prg.toString());

                window.close();


            });
        Button printscButton = new Button("PrintSc");
        	printscButton.setOnAction(e -> {
        		prg = new PrintScr(ExpMenuBox.display());
        		window.close();
        	});
        	
        Button fork = new Button("Fork");
            fork.setOnAction(e -> {
                prg = new ForkStmt<IStmt>(display());
                window.close();
            });
        Button ifB = new Button("If");
            ifB.setOnAction(e -> {
                prg = new IfStmt(ExpMenuBox.display(), display(), display());
                window.close();
            });


        Button inc = new Button("Inc");
            inc.setOnAction(e -> {
                prg = new IncStmt(GetVariableNameBox.display());
                window.close();
            });

        Button newHeap = new Button("New");
            newHeap.setOnAction(e ->{
                prg = new NewHeapStmt(GetVariableNameBox.display(),ExpMenuBox.display());
                window.close();

            });

        Button print = new Button("Print");
            print.setOnAction(e->{
                prg = new PrintStmt(ExpMenuBox.display());
                window.close();
            });

        Button skip = new Button("Skip");
            skip.setOnAction(e->{
                prg = new SkipStmt();
                window.close();
            });
        Button switchB = new Button("Switch");
            switchB.setOnAction(e->{
                prg = new SwitchStmt(ExpMenuBox.display(), ExpMenuBox.display(), display(), ExpMenuBox.display(), display(),display());
                window.close();
            });
        Button whileB = new Button("While");
            whileB.setOnAction(e->
            {
                prg = new WhileStmt(ExpMenuBox.display(), display());
                window.close();
            });
        Button writeHeap = new Button("WHeap");
            writeHeap.setOnAction(e-> {
                prg = new WriteHeapStmt(GetVariableNameBox.display(),ExpMenuBox.display());
                window.close();
            });
        Button forButton = new Button("For");
        	forButton.setOnAction(e -> {
        		
        	});
        Button sleepButton = new Button ("Sleep");
        	sleepButton.setOnAction(e -> {
        		prg = new SleepStmt(GetNumberInputBox.display());
        		window.close();
        	});
        Button repeatButton = new Button("Repeat");
        	repeatButton.setOnAction(e -> {
        		prg = new RepeatStmt(ExpMenuBox.display(), display());
        		window.close();
        	});



        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(label,comp, assign, printscButton,ifB, inc, fork, newHeap, print, skip, switchB, whileB, writeHeap, forButton, sleepButton, repeatButton);

        VBox vBox1 = new VBox(10);
        vBox1.setPadding(new Insets(10,10,10,10));
        Label label1 = new Label("Constructing program:");
        label1.setAlignment(Pos.BASELINE_CENTER);



        vBox1.getChildren().addAll(label1, constructArea);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vBox);
        borderPane.setRight(vBox1);

        Scene scene = new Scene(borderPane, 500,500);

        window.setScene(scene);
        window.showAndWait();

        return prg;

    }

//    static void prgMaker(String stmt)
//    {
//        switch (stmt)
//        {
//            case "comp":
//                new CompStmt();
//        }
//
//    }



}
