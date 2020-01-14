package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.Arrays;

public class Header {
    DataImport DataImport = new DataImport();
    double [] Daten;
    // setting Seperator
    public SeparatorMenuItem separator() {
        SeparatorMenuItem separator = new SeparatorMenuItem();
        return separator;
    }
    // embedding Classes, Objects, usw.
    static DataTableView dataTableView = new DataTableView();
    static Graph graph = new Graph();
    static AreaChart overridelinechart = graph.graph();
    static TableView overrideTableView = dataTableView.dataTableView();
    public static AreaChart overrideGraph()    {
        overridelinechart.setMinWidth(1500);
        overridelinechart.setMinWidth(700);
        overridelinechart.setCreateSymbols(false);
        return overridelinechart;
    }
    public static TableView overrideTableView()    {
        return overrideTableView;
    }

    // Creating a Header
    public HBox addheader()   {
        MenuItem messureStart = new MenuItem("Auzeichnung starten");
        MenuItem messurePause = new MenuItem("Aufzeichnung pausieren");
        MenuItem messureReset = new MenuItem("Auzeichnung zurücksetzen");
        MenuItem fullscreen = new MenuItem("Vollbild");
        MenuItem close = new MenuItem("schließen");
        // setting MenuButton "Graph"
        // setting Eventhandler "Lineare Regression"
        MenuItem linearRegression = new MenuItem("Lineare Regression (M * X + B)");
        linearRegression.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        MenuItem exponentialRegression = new MenuItem("Exponential Regression ( M^X + B");
        MenuItem removeRegression = new MenuItem("Regressionen entferenen");
        // setting MenuButton "Messreihe"
        MenuItem dataImport = new MenuItem("Daten importieren");
        // Setting Eventhandler for importing Data to LineChart
        dataImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Daten = DataImport.main();
                XYChart.Series series = new XYChart.Series();
                //setting name and the date to the series
                series.setName("Messung");
                int xValue = 0;
                for (int i = 0; i < Daten.length; i++)  {
                    series.getData().add(new XYChart.Data(xValue,Daten[i]));
                    String XWert = String.valueOf(xValue);
                    String YWert = String.valueOf(Daten[i]);
                    Messung messung = new Messung(XWert, YWert);
                    overrideTableView.getItems().add(messung);
                    xValue ++;
                }
                //adding series to the linechart
                overridelinechart.getData().add(series);
            }
        });
        MenuItem dataExport = new MenuItem("Daten exportieren");
        // setting MenuButton "Hilfe"
        MenuItem info = new MenuItem("Info");
        // setting MenuButtons
        MenuButton menuGraph = new MenuButton("Graph", null, linearRegression, exponentialRegression, separator(), removeRegression);
        MenuButton menuMessure = new MenuButton("Messreihe", null, dataImport, dataExport);
        MenuButton menuHelp = new MenuButton("Hilfe", null, info);
        MenuButton menuMenue = new MenuButton("Menü", null, messureStart, messurePause, messureReset, separator(), fullscreen, separator(), close);
        //setting Parent
        HBox addheader = new HBox();
        addheader.setStyle("-fx-background-color: #2b2b2b;");
        addheader.setAlignment(Pos.CENTER_LEFT);
        addheader.setPrefWidth(1600);
        addheader.setPrefHeight(25);
        addheader.getChildren().add(menuMenue);
        addheader.getChildren().add(menuGraph);
        addheader.getChildren().add(menuMessure);
        addheader.getChildren().add(menuHelp);

        // setting MenuButton "Menü"
        return addheader;
    }
}
