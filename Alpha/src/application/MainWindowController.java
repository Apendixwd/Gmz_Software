package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController  {
	
	
	
	//Verbingung zur Main.java
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	
	//Werte der abgeschlossenden Messung werden in Arrays gespeichert
		AnalyseRegression Analyse = new AnalyseRegression();
		public final int countX = 7;
		public final int [] x = {1,2,3,4,5,6,7}; //Testwert
		public final double [] y = {1,2,3,4,5,6,7}; //Testwert
		
		
//MenuItems
		
	//Men�	
	@FXML
	public void startRecord() {
		double hallo = Analyse.AnalyseExponential(x,y,countX)[0];
		double hallo1 = Analyse.AnalyseExponential(x,y,countX)[1];
		System.out.println(hallo);
		System.out.println(hallo1);
		
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
	public void importData() {
		Stage primaryStage = new Stage();
		FileChooser file = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
		file.getExtensionFilters().add(extFilter);
		file.setTitle("Datei öffnen");
		File Datei = file.showOpenDialog(primaryStage);
		String TsvFile = "" + Datei;
		String FieldDelimiter = "\t";

		BufferedReader br;

		try {
			br = new BufferedReader ( new FileReader ( TsvFile ) );
			int fLine = 0;
			String line = null;
			while ((line = br.readLine ( )) != null) {
				String[] fields = line.split ( FieldDelimiter, -1 );
				if (fLine == 0) {
					fLine ++;

				}
				else    {
					System.out.println(fields[3]);
					Integer DataSolution = Integer.valueOf(fields[3]);
					ArrayList<Integer> Daten = new ArrayList<Integer>();
					Daten.add(DataSolution);
				}
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger ( Main.class.getName ( ) )
					.log ( Level.SEVERE, null, ex );
		} catch (IOException ex) {
			Logger.getLogger ( Main.class.getName ( ) )
					.log ( Level.SEVERE, null, ex );
		}

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

