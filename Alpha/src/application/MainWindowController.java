package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowController  {
	
	
	//SetMain
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	//MenuItems
	public int countX = 7;
	@FXML
	public void startRecord() {
		AnalyseRegression test = new AnalyseRegression();
		test.AnalyseLinear();
		
		}
	
	
	public void pauseRecord() {
		
		
	}
	@FXML
	public void stopRecord() {
	
	}
	@FXML
	public void FullScreen() {
		main.primaryStage.setFullScreen(true);
		
	
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

