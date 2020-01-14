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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;

public class Header {
    static int i = 0;
    static int j = 0;
    static DataImport DataImport = new DataImport();
    static AnalyseRegression Analyse = new AnalyseRegression();
    static double [] Daten;
    static double e = 2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264800168477411853742345442437107539077744992069;
    static public XYChart.Series seriesnormal = new XYChart.Series();
    static public XYChart.Series serieslinear = new XYChart.Series();
    static public XYChart.Series seriesexponential = new XYChart.Series();
    // setting Seperator
    public static SeparatorMenuItem separator() {
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
    public static HBox addheader()   {
        MenuItem messureStart = new MenuItem("Auzeichnung starten");
        MenuItem messurePause = new MenuItem("Aufzeichnung pausieren");
        MenuItem messureReset = new MenuItem("Auzeichnung zurücksetzen");
        MenuItem fullscreen = new MenuItem("Vollbild");
        fullscreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getStage().setFullScreenExitHint("Um den Vollbildmodus zu verlassen, drücken sie \"ESC\"!");
                Main.getStage().setFullScreen(true);
            }
        });
        MenuItem close = new MenuItem("schließen");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        // setting MenuButton "Graph"
        // setting Eventhandler "Lineare Regression"
        MenuItem linearRegression = new MenuItem("Lineare Regression (M * X + B)");
        linearRegression.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (i==0) {
                    int countX = Daten.length;
                    int count = 0;
                    int[] x = new int[countX];
                    double[] y = Daten;
                    while (count != countX) {
                        x[count] = count;
                        count++;
                    }

                    double m = Analyse.AnalyseLinear(x, Daten, countX)[0];
                    double n = Analyse.AnalyseLinear(x, Daten, countX)[1];
                    double[] Regression = new double[countX];
                    count = 0;
                    while (count != countX) {
                        Regression[count] = m * count + n;
                        count++;

                    }
                    //setting name and the date to the series
                    serieslinear.setName("Lineare Regression");
                    int xValue = 0;
                    for (int i = 0; i < countX; i++) {
                        serieslinear.getData().add(new XYChart.Data(xValue, Regression[i]));
                        String XWert = String.valueOf(xValue);
                        String YWert = String.valueOf(Regression[i]);
                        Messung messung = new Messung(XWert, YWert);
                        xValue++;
                    }
                    //adding series to the linechart
                    overridelinechart.getData().add(serieslinear);
                    linearRegression.setText("Lineare Regression entfernen");
                    i++;
                }
                else    {
                    overridelinechart.getData().remove(serieslinear);
                    linearRegression.setText("Lineare Regression (M * X + B)");
                    i--;
                }
            }

        });
        MenuItem exponentialRegression = new MenuItem("Exponential Regression");
        exponentialRegression.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (j==0) {
                    int countX = Daten.length;
                    int count = 0;
                    int[] x = new int[countX];
                    double[] y = Daten;
                    while (count != countX) {
                        x[count] = count;
                        count++;
                    }

                    double k = Analyse.AnalyseExponential(x, Daten, countX)[0];
                    double d = Analyse.AnalyseExponential(x, Daten, countX)[1];

                    double[] Regression = new double[countX];
                    count = 0;
                    while (count != countX) {
                        Regression[count] = d * Math.pow(e, k * count);
                        count++;

                    }

                    //setting name and the date to the series
                    seriesexponential.setName("Exponentielle Regression");
                    int xValue = 0;
                    for (int i = 0; i < countX; i++) {
                        seriesexponential.getData().add(new XYChart.Data(xValue, Regression[i]));
                        String XWert = String.valueOf(xValue);
                        String YWert = String.valueOf(Regression[i]);
                        Messung messung = new Messung(XWert, YWert);
                        xValue++;
                    }
                    //adding series to the linechart
                    overridelinechart.getData().add(seriesexponential);
                    exponentialRegression.setText("Exponentielle Regression entfernen");
                    j++;
                }
                else    {
                    overridelinechart.getData().remove(seriesexponential);
                    exponentialRegression.setText("Exponential Regression");
                    j--;
                }
            }

        });

        MenuItem removeRegression = new MenuItem("Regressionen entferenen");
        removeRegression.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                overridelinechart.getData().remove(seriesexponential);
                overridelinechart.getData().remove(serieslinear);
            }
        });
        // setting MenuButton "Messreihe"
        MenuItem dataImport = new MenuItem("Daten importieren");
        // Setting Eventhandler for importing Data to LineChart
        dataImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Daten = DataImport.main();
                //setting name and the date to the series
                seriesnormal.setName("Messung");
                int xValue = 0;
                for (int i = 0; i < Daten.length; i++)  {
                    seriesnormal.getData().add(new XYChart.Data(xValue,Daten[i]));
                    String XWert = String.valueOf(xValue);
                    String YWert = String.valueOf(Daten[i]);
                    Messung messung = new Messung(XWert, YWert);
                    overrideTableView.getItems().add(messung);
                    xValue ++;
                }
                //adding series to the linechart
                overridelinechart.getData().add(seriesnormal);
            }
        });
        MenuItem dataExport = new MenuItem("Daten exportieren");
        MenuItem dataRemove = new MenuItem("Messreihe entfernen");
        dataRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                overridelinechart.getData().remove(seriesexponential);
                overridelinechart.getData().remove(seriesnormal);
                overridelinechart.getData().remove(serieslinear);
            }
        });
        // setting MenuButton "Hilfe"
        MenuItem info = new MenuItem("Info");
        info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               /* Stage aboutstage = new Stage();
                VBox Parent = new VBox();
                aboutstage.setScene(); */
            }
        });
        // setting MenuButtons
        MenuButton menuGraph = new MenuButton("Graph", null, linearRegression, exponentialRegression, separator(), removeRegression);
        MenuButton menuMessure = new MenuButton("Messreihe", null, dataImport, dataExport, separator(), dataRemove);
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
