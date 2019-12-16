package application;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.prism.impl.Disposer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;

public class DataImport extends MainWindowController {

    public static void readTSV() {

            // System.out.println(MainWindowController.value);
            String TsvFile = "" + "C:/Users/ottor/Desktop/Test/src/sample/Test.txt";
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
}