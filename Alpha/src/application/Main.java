/* ####### setting Meta ####### */
package application;

/* ####### setting Imports ####### */
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;


/* ####### setting Main Class "Main.java" ####### */
public class Main extends Application {

    /* ####### Adding Attributes ####### */
    // Building Nodes
    TitleBar titleBar = new TitleBar();
    BorderPane layout = new BorderPane();
    VBox headersection = new VBox();
    Scene scene = new Scene(layout);
    // Adding Building "stage"
    private static Stage stage;
        //Adding return Method for Stage "stage"
        public static Stage getStage() { return stage; }
    // Adding offset for root movement
    private double xOffset = 0;
    private double yOffset = 0;

    /* ####### Adding start Method ####### */
    @Override
    public void start (Stage primarystage) throws Exception  {

        // Building Header
        headersection.getChildren().add(titleBar.addTitleBar());
        headersection.getChildren().add(Header.addheader());

        // Eventhandler for root movement
            layout.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    xOffset = mouseEvent.getSceneX();
                    yOffset = mouseEvent.getSceneY();
                }
            });
            layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    stage.setX(mouseEvent.getScreenX() - xOffset);
                    stage.setY(mouseEvent.getScreenY() - yOffset);
                }
            });

        //Adding Content to BorderPane "layout"
        layout.setTop(headersection);
        layout.setRight(Header.overrideTableView);
        layout.setCenter(Header.overridelinechart);
        //setStyling
        layout.setPrefHeight(900);
        layout.setPrefWidth(1600);
        // Add Stylesheet "Style.css"
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        // Edit Stage
        stage = primarystage;
        stage.getIcons().add(new Image("/pictures/title.png"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(600);
        stage.show();
    }

    /* ####### set main method ####### */
    public static void main  (String[] args) {
        // launch
        launch(args);
    }
}