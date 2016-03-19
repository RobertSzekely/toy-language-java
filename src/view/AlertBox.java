package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by sssse_000 on 12-Jan-16.
 */
public class AlertBox {


    public static void display(String message)
    {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        VBox vBox = new VBox(10);
        Label label = new Label(message);

        vBox.getChildren().addAll(label);

        Scene scene = new Scene(vBox, 300,300);

        window.setScene(scene);
        window.showAndWait();


    }



}
