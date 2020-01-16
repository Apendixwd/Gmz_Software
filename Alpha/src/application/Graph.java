package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Graph {

    //Defining Axis
    final NumberAxis xaxis = new NumberAxis();
    final NumberAxis yaxis = new NumberAxis();
    //Defining LineChart
    AreaChart areachart = new AreaChart(xaxis,yaxis);

    public AreaChart graph() {
        //Defining Label for Axis
        xaxis.setLabel("T in Sekunden");
        yaxis.setLabel("Messung in CPM");
        //Defining Messure Series
        areachart.setCreateSymbols(false);
        return areachart;
    }
}
