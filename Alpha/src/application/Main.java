package application;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

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
        DataTableView dataTableView = new DataTableView();
        OverrideGraph overrideGraph = new OverrideGraph();
        //Adding Content Sections
        AnchorPane graphsection = new AnchorPane();
        graphsection.getChildren().add(Header.overrideGraph());
        AnchorPane tablesection = new AnchorPane();
        tablesection.getChildren().add(Header.overrideTableView);
        tablesection.setId("tablesection");
        //Adding Content to BorderPane
        layout.setTop(header.addheader());
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