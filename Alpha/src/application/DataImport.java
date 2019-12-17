package application;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataImport {

    public static double[] Data;

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
        ArrayList<Double> Data = new ArrayList<Double>();
        int fLine = 0;
        String line = null;
        while ((line = br.readLine ( )) != null) {
            String[] fields = line.split ( FieldDelimiter, -1 );
            if (fLine == 0) {
                fLine ++;

            }
            else    {
                    fields[3] = fields[3].replace(",", ".");
                    double DataSolution = Double.parseDouble(fields[3]);
                    Data.add(DataSolution);

            }
        }
        System.out.print(Data);
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
