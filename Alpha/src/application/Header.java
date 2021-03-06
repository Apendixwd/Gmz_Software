/* ####### setting Meta ####### */
package application;

/* ####### setting Imports ####### */
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

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;

/* ####### setting Header Class "Header.java" ####### */
public class Header {
    // setting attributes
    static int i = 0;
    static int j = 0;
    static int k = 0;
    static double [] Daten;
    static double e = 2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264800168477411853742345442437107539077744992069;
    // adding objects
    static DataImport DataImport = new DataImport();
    static AnalyseRegression Analyse = new AnalyseRegression();
    static DataTableView dataTableView = new DataTableView();
    static About about = new About();
    static Graph graph = new Graph();
    // adding Nodes
    static public XYChart.Series seriesnormal = new XYChart.Series();
    static public XYChart.Series serieslinear = new XYChart.Series();
    static public XYChart.Series seriesexponential = new XYChart.Series();
    public static SeparatorMenuItem separator() {
        SeparatorMenuItem separator = new SeparatorMenuItem();
        return separator;
    }
    static AreaChart overridelinechart = graph.graph();
    static TableView overrideTableView = dataTableView.dataTableView();



    // Creating a Header
    public static HBox addheader()   {

        /* ###################################### */
        /* ########## adding MenuItems ########## */
        /* ###################################### */
        /* ###################################### */
        MenuItem messureStart = new MenuItem("Auzeichnung starten");
        MenuItem messurePause = new MenuItem("Aufzeichnung pausieren");
        MenuItem messureReset = new MenuItem("Auzeichnung zur\u00fccksetzen");
        MenuItem fullscreen = new MenuItem("Vollbild");
        fullscreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getStage().setFullScreenExitHint("Um den Vollbildmodus zu verlassen, dr\u00fccken sie \"ESC\"!");
                Main.getStage().setFullScreen(true);
            }
        });
        MenuItem close = new MenuItem("schlie\u00dfen");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        // setting MenuButton "Graph"
        // setting Eventhandler "Lineare Regression"
        MenuItem linearRegression = new MenuItem("Lineare Regression");
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
                    double roundm = Math.round(100.0 * m) / 100.0;
                    double roundn = Math.round(100 * n) / 100.0;
                    serieslinear.setName(roundm + " * X + " + roundn);
                    int xValue = 0;
                    for (int i = 0; i < countX; i++) {
                        serieslinear.getData().add(new XYChart.Data(xValue, Regression[i]));
                        String XWert = String.valueOf(xValue);
                        String YWert = String.valueOf(Regression[i]);
                        xValue++;
                    }
                    //adding series to the linechart
                    overridelinechart.getData().add(serieslinear);
                    linearRegression.setText("Lineare Regression entfernen");
                    i++;
                }
                else    {
                    overridelinechart.getData().remove(serieslinear);
                    linearRegression.setText("Lineare Regression");
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
                    //double roundk = Math.round(100000 * k) / 1000;
                    System.out.println(k);
                    int Divisor = 1000000;
                    if (k >= 1 || k <= -1)  {
                        Divisor = 1000;
                    }
                    else if(k >= 0.1 || k <= -0.1)  {
                        Divisor = 10000;
                    }
                    else if(k >= 0.01 || k <= -0.01)  {
                        Divisor = 100000;
                    }
                    else if(k >= 0.001 || k <= -0.001)  {
                        Divisor = 1000000;
                    }
                    else if(k >= 0.0001 || k <= -0.0001)  {
                        Divisor = 10000000;
                    }

                    double roundk= k * Divisor;
                    roundk = (int) roundk;
                    roundk = roundk / Divisor;
                    double roundd = Math.round(100 * d) / 100.0;
                    seriesexponential.setName(roundd + " * e^ " + roundk + " * X");
                    int xValue = 0;
                    for (int i = 0; i < countX; i++) {
                        seriesexponential.getData().add(new XYChart.Data(xValue, Regression[i]));
                        String XWert = String.valueOf(xValue);
                        String YWert = String.valueOf(Regression[i]);
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

        MenuItem removeRegression = new MenuItem("Regressionen entfernen");
        removeRegression.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                overridelinechart.getData().remove(seriesexponential);
                j = 0;
                overridelinechart.getData().remove(serieslinear);
                i = 0;
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
                int xValue = 1;
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
        MenuItem changeT = new MenuItem("Messreihe in min");
        changeT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int l = 1;
                if (k == 0) {
                    overrideTableView.getItems().clear();
                    for (int i = 0; i < Daten.length; i++)  {
                        if (i % 60 == 0 || i == 0) {
                            String XWert = String.valueOf(l);
                            String YWert = String.valueOf(Daten[i]);
                            Messung messung = new Messung(XWert, YWert);
                            overrideTableView.getItems().add(messung);
                            l++;
                        }
                    }
                    dataTableView.Column1.setText("T in min");
                    changeT.setText("Messreihe in sec");
                    k++;
                }
                else {
                    overrideTableView.getItems().clear();
                    for (int i = 0; i < Daten.length; i++)  {
                        String XWert = String.valueOf(l);
                        String YWert = String.valueOf(Daten[i]);
                        Messung messung = new Messung(XWert, YWert);
                        overrideTableView.getItems().add(messung);
                        l++;
                    }
                    dataTableView.Column1.setText("T in sec");
                    changeT.setText("Messreihe in min");
                    k--;
                }
            }
        });
        MenuItem dataRemove = new MenuItem("Messreihe entfernen");
        dataRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                overridelinechart.getData().remove(seriesexponential);
                overridelinechart.getData().remove(seriesnormal);
                overridelinechart.getData().remove(serieslinear);
                overrideTableView.getItems().clear();
                i = 0;
                j = 0;
                exponentialRegression.setText("Exponential Regression");
                linearRegression.setText("Lineare Regression");
            }
        });
        // setting MenuButton "Hilfe"
        MenuItem info = new MenuItem("Info");
        info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               about.showAbout();
            }
        });

        /* ########## setting MenuButtons ########## */
        /* ######################################### */
        MenuButton menuGraph = new MenuButton("Graph", null, linearRegression, exponentialRegression, separator(), removeRegression);
        MenuButton menuMessure = new MenuButton("Messreihe", null, dataImport, changeT, separator(), dataRemove);
        MenuButton menuHelp = new MenuButton("Hilfe", null, info);
        MenuButton menuMenue = new MenuButton("Men\u00fc", null, messureStart, messurePause, messureReset, separator(), fullscreen, separator(), close);

        //setting Parent
        HBox addheader = new HBox();
        addheader.setStyle("-fx-background-color: #2b2b2b;");
        addheader.setAlignment(Pos.CENTER_LEFT);
        addheader.setPrefWidth(1600);
        addheader.setPrefHeight(25);
        // adding children
        addheader.getChildren().add(menuMenue);
        addheader.getChildren().add(menuGraph);
        addheader.getChildren().add(menuMessure);
        addheader.getChildren().add(menuHelp);

        // return header
        return addheader;
    }
}
