package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TitleBar {
    int i = 0;
    Main main = new Main();
    public HBox addTitleBar()   {
        HBox titleBar = new HBox();

        ImageView close = new ImageView();
        Image closeI = new Image("/pictures/Close.png");
        close.setImage(closeI);
        close.setFitWidth(20);
        close.setFitHeight(20);
        ImageView fullscreen = new ImageView();
        Image fullscreenI = new Image("/pictures/fullscreen.png");
        fullscreen.setImage(fullscreenI);
        fullscreen.setFitWidth(20);
        fullscreen.setFitHeight(20);
        ImageView hide = new ImageView();
        Image hideI = new Image("/pictures/hide.png");
        hide.setImage(hideI);
        hide.setFitWidth(20);
        hide.setFitHeight(20);
        AnchorPane Icon1 = new AnchorPane();
        Icon1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.getStage().close();
            }
        });
        AnchorPane Icon2 = new AnchorPane();
        Icon2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Doin sth");
                if (i == 0) {
                    Main.getStage().setMaximized(true);
                    i++;
                }
                else    {
                    Main.getStage().setMaximized(false);
                    i--;
                }
            }
        });
        AnchorPane Icon3 = new AnchorPane();
        Icon3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Doin sth");
                Main.getStage().setIconified(true);
            }
        });
        Icon1.getChildren().add(close);
        Icon2.getChildren().add(fullscreen);
        Icon3.getChildren().add(hide);
        titleBar.getChildren().add(Icon3);
        titleBar.getChildren().add(Icon2);
        titleBar.getChildren().add(Icon1);
        titleBar.setId("TitleBar");
        titleBar.setPrefHeight(25);
        titleBar.setAlignment(Pos.CENTER_RIGHT);
        return titleBar;
    }
}
