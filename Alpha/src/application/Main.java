package application; 

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
 
public class Main  extends Application {
	
		public Stage primaryStage;
		
		@Override
		public void start(Stage primaryStage) {
			this.primaryStage = primaryStage;
			mainWindow();
		}
		
		public void mainWindow() {
			double [] x = {1,2,3,4,5,6,7,8,9,10};
			int[] y = {1,2,3,4,2,2,1,21,9,10};
			AnalyseRegression test = new AnalyseRegression();
			System.out.println(test.AnalyseLinear());
			
		
		
			
			try {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
				AnchorPane pane = (AnchorPane) loader.load();
				primaryStage.setMaxHeight(1080);
				primaryStage.setMaxWidth(1920);
				MainWindowController mainWindowController = loader.getController();
				mainWindowController.setMain(this);
				
				Scene scene = new Scene(pane);
				
				primaryStage.setTitle("GMZ-Software");
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		public static void main(String[] args) {
        launch(args);
    }
    
}