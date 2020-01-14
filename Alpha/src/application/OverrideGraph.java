package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class OverrideGraph {
    Graph graph = new Graph();

    public AreaChart overwridelinechart() {
        AreaChart overwritelinechart = graph.graph();
        return overwritelinechart;
    }


}