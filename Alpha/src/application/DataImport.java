package application;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataImport {
    public static void main() {

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
               // System.out.println(fields[3]);
                    fields[3] = fields[3].replace(",", ".");
                    Double DataSolution = Double.valueOf(fields[3]);
					ArrayList<Double> Daten = new ArrayList<Double>();
					Daten.add(DataSolution);
					System.out.println(Daten);
            }
        }

    } catch (
    FileNotFoundException ex) {
        Logger.getLogger ( Main.class.getName ( ) )
                .log ( Level.SEVERE, null, ex );
    } catch (
    IOException ex) {
        Logger.getLogger ( Main.class.getName ( ) )
                .log ( Level.SEVERE, null, ex );
    }


    }
}
