package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by sssse_000 on 12-Jan-16.
 */
public class GetSymbolBox {

    static String symbol;

    public static String display()
    {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        TextField textField = new TextField();
        Button button = new Button("Ok");
        button.setOnAction(e->
        {
            symbol = textField.getText();
            window.close();
        });

        Label label = new Label("Give Symbol:");

        VBox vBox = new VBox(10);

        vBox.getChildren().addAll(label,textField,button);

        Scene scene = new Scene(vBox,300,300);
        window.setScene(scene);




        window.showAndWait();
        return symbol;

    }

}
