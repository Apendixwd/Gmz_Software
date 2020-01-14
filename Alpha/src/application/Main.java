package application;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

import java.awt.event.MouseEvent;

public class Main extends Application {
    public static void main  (String[] args) {
        launch(args);
    }

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
        primarystage.initStyle(StageStyle.UNDECORATED);
        primarystage.setScene(scene);
        primarystage.setMinWidth(1000);
        primarystage.setMinHeight(600);
        primarystage.show();
    }
}