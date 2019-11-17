package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class MainWindowController  {
	
	
	//SetMain
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	//MenuItems
	@FXML
	public void startRecord() {
		System.out.println("Diagramm gestratet!");
		
		}
	
	
	public void pauseRecord() {
		
		
	}
	@FXML
	public void stopRecord() {
		
		
	}
	@FXML
	public void Close() {
		System.exit(0);
	}
	
	@FXML
	public void showAboutWindow() {
        try {
        	Stage primaryStage = new Stage();
        	
            Parent root = FXMLLoader.load(getClass()
                    .getResource("About.fxml"));
            
            primaryStage.setTitle("About GMZ-Software");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
         
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

	
}

