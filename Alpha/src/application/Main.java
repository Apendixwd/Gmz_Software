package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

public class Main extends Application {
    //define your offsets here
    private double xOffset = 0;
    private double yOffset = 0;
    public static void main  (String[] args) {
        launch(args);
    }
    private static Stage stage;
    public static Stage getStage() { return stage; }
    @Override
    public void start (Stage primarystage) throws Exception  {
        //Defining BorderPane "layout"
        BorderPane layout = new BorderPane();
        //Embed Classes and objects
        Header header = new Header();
        Graph graph = new Graph();
        TitleBar titleBar = new TitleBar();
        DataTableView dataTableView = new DataTableView();
        OverrideGraph overrideGraph = new OverrideGraph();
        //Adding Content Sections
        VBox headersection = new VBox();
        headersection.getChildren().add(titleBar.addTitleBar());
        headersection.getChildren().add(Header.addheader());
        //Adding Content to BorderPane
        layout.setTop(headersection);
        layout.setRight(Header.overrideTableView);
        layout.setCenter(Header.overrideGraph());
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        //grab your root here
        layout.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });


        //move around here
        layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setX(mouseEvent.getScreenX() - xOffset);
                stage.setY(mouseEvent.getScreenY() - yOffset);
            }
        });
        layout.setPrefHeight(900);
        layout.setPrefWidth(1600);
        stage = primarystage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(600);
        stage.show();
    }
}