/* ####### setting Meta ####### */
package application;

/* ####### setting Imports ####### */
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* ####### setting DataImport Class "DataImport.java" ####### */
public class DataImport {
    /* ####### Adding attributes ####### */
    static File Datei;
    static double[] Data = new double[0];
    static Stage primaryStage = new Stage();
    static BufferedReader br;
    static BufferedReader br2;
    // Adding object instances
    static Fehlermeldung error = new Fehlermeldung();
    // adding DataImport.main()
    public static double [] main() {
        int count = 0;
        // Build open file dialog
        FileChooser file = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        file.getExtensionFilters().add(extFilter);
        file.setTitle("Datei \u00f6ffnen");
        Datei = file.showOpenDialog(primaryStage);
        String TsvFile = "" + Datei;
        String FieldDelimiter = "\t";
        // read TSV file
        try {
            br = new BufferedReader(new FileReader(TsvFile));
            long lineAmountCache = br.lines().count() - 1;
            int lineAmount = (int) lineAmountCache;
            int currentLine = 0;
            Data = new double[lineAmount];
            int fLine = 0;
            String line = null;
            br2 = new BufferedReader(new FileReader(TsvFile));
            while ((line = br2.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                if (fLine == 0) {
                    fLine++;

                } else {
                    fields[3] = fields[3].replace(",", ".");
                    double DataSolution = Double.parseDouble(fields[3]);
                    // adding Data to Data-array
                    Data[currentLine] = DataSolution;
                    currentLine++;
                }
            }
        } catch (
                FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (
                IOException ex) {
            Logger.getLogger(Main.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        catch (Exception e) {
            String errorTitle = "Error";
            String errorMessage = "Die Datei ist Fehlerhaft. Bitte veruschen sie es erneut!";
            error.showErrorMessage(errorTitle, errorMessage);
            count++;

        }
        if (count != 0) {
            Data = null;
        }
        else    {}
        return Data;
    }
}
