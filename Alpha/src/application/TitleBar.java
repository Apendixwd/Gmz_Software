package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TitleBar {
    Main main = new Main();
    public HBox addTitleBar()   {
        HBox titleBar = new HBox();

        ImageView close = new ImageView();
        Image closeI = new Image("/pictures/Close.png");
        close.setImage(closeI);
        close.setFitWidth(24);
        close.setFitHeight(24);
        close.setStyle("-fx-padding: 10;");
        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            }
        });
        ImageView fullscreen = new ImageView();
        Image fullscreenI = new Image("/pictures/fullscreen.png");
        fullscreen.setImage(fullscreenI);
        fullscreen.setFitWidth(24);
        fullscreen.setFitHeight(24);
        fullscreen.setStyle("-fx-padding: 10;");

        ImageView hide = new ImageView();
        Image hideI = new Image("/pictures/hide.png");
        hide.setImage(hideI);
        hide.setFitWidth(24);
        hide.setFitHeight(24);
        fullscreen.setStyle("-fx-padding: 10;");

        titleBar.getChildren().add(hide);
        titleBar.getChildren().add(fullscreen);
        titleBar.getChildren().add(close);
        titleBar.setId("TitleBar");
        titleBar.setPrefHeight(25);
        titleBar.setAlignment(Pos.CENTER_RIGHT);
        return titleBar;
    }
}
