package view;

import domain.Statement.IncStmt;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by sssse_000 on 11-Jan-16.
 */
public class GetNumberInputBox {

    static int number;

    public static int display(){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label("Give number");
        TextField textField = new TextField();
        VBox vBox = new VBox(10);
        Button button = new Button("Ok");
        button.setOnAction(e->{
            number = Integer.parseInt(textField.getText());
            window.close();
        });

        vBox.getChildren().addAll(label,textField,button);



        Scene scene = new Scene(vBox, 300,300);
        window.setScene(scene);
        window.showAndWait();
        return number;

    }
}
