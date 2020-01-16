/* ####### setting Meta ####### */
package application;

/* ####### setting Imports ####### */
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/* ####### setting TitleBar Class "TitleBar.java" ####### */
public class TitleBar {

    /* ####### Adding Attributes ####### */
    int count = 0;
    // Building Nodes
    HBox titleBar = new HBox();
    // Build ImageView for icons
    ImageView close = new ImageView();
    ImageView fullscreen = new ImageView();
    ImageView hide = new ImageView();
    //Build Icon for TitleBar-Buttons
    Image closeI = new Image("/pictures/Close.png");
    Image fullscreenI = new Image("/pictures/fullscreen.png");
    Image hideI = new Image("/pictures/hide.png");
    // Build Node for TitleBar-Buttons
    AnchorPane Icon1 = new AnchorPane();
    AnchorPane Icon2 = new AnchorPane();
    AnchorPane Icon3 = new AnchorPane();

    public HBox addTitleBar()   {

        // setting icon size
        close.setFitWidth(20);
        close.setFitHeight(20);
        fullscreen.setFitWidth(20);
        fullscreen.setFitHeight(20);
        hide.setFitWidth(20);
        hide.setFitHeight(20);

        // setting icon function
        Icon1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.getStage().close();
            }
        });
        Icon2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (count == 0) {
                    Main.getStage().setMaximized(true);
                    count++;
                }
                else    {
                    Main.getStage().setMaximized(false);
                    count--;
                }
            }
        });
        Icon3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.getStage().setIconified(true);
            }
        });

        // setting icon layout
        Icon1.setMaxWidth(20);
        Icon1.setMaxHeight(20);
        Icon2.setMaxWidth(20);
        Icon2.setMaxHeight(20);
        Icon3.setMaxWidth(20);
        Icon3.setMaxHeight(20);
        // Adding children
        close.setImage(closeI);
        fullscreen.setImage(fullscreenI);
        hide.setImage(hideI);
        Icon1.getChildren().add(close);
        Icon2.getChildren().add(fullscreen);
        Icon3.getChildren().add(hide);
        titleBar.getChildren().add(Icon3);
        titleBar.getChildren().add(Icon2);
        titleBar.getChildren().add(Icon1);
        titleBar.setId("TitleBar");
        titleBar.setPrefHeight(18);
        titleBar.setAlignment(Pos.CENTER_RIGHT);
        titleBar.setMinHeight(25);
        // return TitleBar
        return titleBar;
    }
}
