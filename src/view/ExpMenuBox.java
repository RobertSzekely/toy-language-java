package view;

import domain.Expression.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by sssse_000 on 11-Jan-16.
 */
public class ExpMenuBox {

    static Exp exp;

    public static Exp display()
    {


        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        VBox vBox = new VBox(10);

        Label label = new Label("Expression Menu:");

        Button arithButton = new Button("Arithmetic Expression");
            arithButton.setOnAction(e->
            {
                exp = new ArithExp(GetSymbolBox.display(),ExpMenuBox.display(), ExpMenuBox.display());
                window.close();
            });

        Button boolButton = new Button("Boolean Expression");
            boolButton.setOnAction(e->
            {
                exp = new BoolExp(GetSymbolBox.display(), ExpMenuBox.display(),ExpMenuBox.display());
                window.close();
            });

        Button constButton = new Button("Constant Expression");
            constButton.setOnAction(e -> {
                exp = new ConstExp(GetNumberInputBox.display());
                window.close();
            });

        Button readButton = new Button("Read Expression");
            readButton.setOnAction(e->
            {
                exp = new ReadExp();
                window.close();
            });
        Button readHeapButton = new Button("RH Expression");
            readHeapButton.setOnAction(e->
            {
                exp = new ReadHeapExp(GetVariableNameBox.display());
                window.close();
            });

        Button varButton = new Button("Var Expression");
            varButton.setOnAction(e->
            {
                exp = new VarExp(GetVariableNameBox.display());
                window.close();
            });

        vBox.getChildren().addAll(label,arithButton,boolButton,constButton,readButton,readHeapButton,varButton);



        Scene scene = new Scene(vBox,300,300);

        window.setScene(scene);
        window.showAndWait();

        return exp;

    }
}
