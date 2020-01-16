package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class About {

    /* ####### Adding Attributes ####### */
    int count = 0;
    // Building Nodes
    HBox titleBar = new HBox();
    // Build ImageView for icons
    ImageView close = new ImageView();
    ImageView hide = new ImageView();
    //Build Icon for TitleBar-Buttons
    Image closeI = new Image("/pictures/Close.png");
    Image hideI = new Image("/pictures/hide.png");
    // Build Node for TitleBar-Buttons
    AnchorPane Icon1 = new AnchorPane();
    AnchorPane Icon2 = new AnchorPane();

    public HBox addTitleBar()   {

        // setting icon size
        close.setFitWidth(20);
        close.setFitHeight(20);
        hide.setFitWidth(20);
        hide.setFitHeight(20);

        // setting icon function
        Icon1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.close();
            }
        });
        Icon2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setIconified(true);
            }
        });

        // setting icon layout
        Icon1.setMaxWidth(20);
        Icon1.setMaxHeight(20);
        Icon2.setMaxWidth(20);
        Icon2.setMaxHeight(20);
        // Adding children
        close.setImage(closeI);
        hide.setImage(hideI);
        Icon1.getChildren().add(close);
        Icon2.getChildren().add(hide);
        titleBar.getChildren().add(Icon2);
        titleBar.getChildren().add(Icon1);
        titleBar.setId("TitleBar");
        titleBar.setPrefHeight(18);
        titleBar.setAlignment(Pos.CENTER_RIGHT);
        titleBar.setMinHeight(25);
        // return TitleBar
        return titleBar;
    }
    BorderPane parent = new BorderPane();
    VBox content = new VBox();
    Label row1 = new Label("Product Version");
    Label row2 = new Label("GMZ-Software 1.0");
    Label row3 = new Label("Build Information");
    Label row4 = new Label("Version 1.0");
    Label row5 = new Label("Date: 2020-1-15");
    Label row6 = new Label("Java Version: 11.0.1+13-LTS, Oracle Corporation");
    Label row7 = new Label("Java ");
    Label row8 = new Label("11.0.1+13-LTS, Oracle Corporation");
    Label row9 = new Label("Developed by");
    Label row10 = new Label("Otto Rohenkohl");
    Label row11 = new Label("Jan Bl\u00f6mer");
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    private double xOffset = 0;
    private double yOffset = 0;
    public void showAbout() {
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });
        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setX(mouseEvent.getScreenX() - xOffset);
                stage.setY(mouseEvent.getScreenY() - yOffset);
            }
        });
        row1.setPadding(new Insets(20, 200, 0,30));
        row2.setPadding(new Insets(0, 200, 10,30));
        row3.setPadding(new Insets(10, 200, 0,30));
        row4.setPadding(new Insets(0, 200, 0,30));
        row5.setPadding(new Insets(0, 200, 0,30));
        row6.setPadding(new Insets(0, 200, 10,30));
        row7.setPadding(new Insets(10, 200, 0,30));
        row8.setPadding(new Insets(0, 200, 10,30));
        row9.setPadding(new Insets(10, 200, 0,30));
        row10.setPadding(new Insets(0, 200, 0,30));
        row11.setPadding(new Insets(0, 200, 30,30));
        content.getChildren().addAll(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11);
        parent.setCenter(content);
        content.setId("content");
        parent.setTop(addTitleBar());
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
