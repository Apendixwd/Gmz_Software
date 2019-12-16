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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController  {

	//SetMain
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	//MenuItems
	public int countX = 10;
	@FXML
	public void startRecord() {
		System.out.println("Diagramm gestartet!");
		
		}
	
	
	public void pauseRecord() {
		
		
	}
	@FXML
	public void stopRecord() {
	
	}
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
                /* Integer DataSolution = Integer.valueOf(fields[3]);
                ArrayList<Integer> Daten = new ArrayList<Integer>();
                Daten.add(DataSolution); */
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

