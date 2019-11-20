package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowController  {
	
	
	
	//Verbingung zur Main.java
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	
	//Werte der abgeschlossenden Messung werden in Arrays gespeichert
		public final int countX = 7;
		public final int [] x = {1,2,3,4,5,6,7}; //Testwert
		public final double [] y = {1,2,3,4,5,6,7}; //Testwert
		
		
//MenuItems
		
	//Menü	
	@FXML
	public void startRecord() {
	
		
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
	
	//Graph
	@FXML 
	public void DrawLinearRegression() {
		
		
	}
	
	@FXML
	public void DrawExponentialRegression() {
		
		
	}
	
	@FXML
	public void DeleteAllRegressions() {
		
		
	}
	
	//Messreihe
	@FXML 
	public void ImportData() {
		
		
	}
	
	@FXML
	public void ExportData() {
		
		
	}
	
	//Hilfe
	@FXML
	public void showAboutWindow() {
		//Das About-Window wird mit der "About.fxml" erstellt und angezeigt
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

