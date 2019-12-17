package application;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataImport {
    public static Double [] main() {
        Double[] Data = new Double[0];
        Stage primaryStage = new Stage();
        FileChooser file = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        file.getExtensionFilters().add(extFilter);
        file.setTitle("Datei öffnen");
        File Datei = file.showOpenDialog(primaryStage);
        String TsvFile = "" + Datei;
        String FieldDelimiter = "\t";
        BufferedReader br;
        BufferedReader br2;
        try {
            br = new BufferedReader(new FileReader(TsvFile));
            long lineAmountCache = br.lines().count() - 1;
            int lineAmount = (int) lineAmountCache;
            int currentLine = 0;
            Data = new Double[lineAmount];
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
                    Data[currentLine] = DataSolution;
                    currentLine++;
                }
            }
            System.out.println(Arrays.asList(Data));
        } catch (
                FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (
                IOException ex) {
            Logger.getLogger(Main.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return Data;
    }
}
