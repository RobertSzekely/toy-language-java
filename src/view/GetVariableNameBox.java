package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 * Created by sssse_000 on 11-Jan-16.
 */
public class GetVariableNameBox {

    static String var;

    public static String display()
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);


        VBox vBox = new VBox(10);

        TextField textField = new TextField();
        Label label = new Label("Give variable name:");
        Button button = new Button("Ok");
        button.setOnAction(e -> {
            var = textField.getText();
            window.close();
        });
        vBox.getChildren().addAll(label,textField,button);



        Scene scene = new Scene(vBox, 300,300);
        window.setScene(scene);
        window.showAndWait();
        return var;

    }
}
