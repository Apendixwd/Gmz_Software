package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Fehlermeldung {
    Label text = new Label();
    HBox content = new HBox();
    Scene scene = new Scene(content);
    Stage stage = new Stage();
    public void showErrorMessage(String errorTitle,String errorContent)  {
        text.setText(errorContent);
        text.setPadding(new Insets(50, 30,30,50));
        content.getChildren().add(text);
        stage.setResizable(false);
        stage.setTitle(errorTitle);
        stage.setScene(scene);
        stage.show();
    }
}
