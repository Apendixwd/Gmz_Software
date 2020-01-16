/* ####### setting Meta ####### */
package application;

/* ####### setting Imports ####### */
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/* ####### setting DataTableView Class "DataTableView.java" ####### */
public class DataTableView {

    // adding Nodes
    TableView dataTableView = new TableView();
    TableColumn Column1 = new TableColumn("T in Sekunden");
    TableColumn Column2 = new TableColumn("Messdaten in CPM");
    public TableView dataTableView()    {
        // setting Columns T & M
        Column1.setCellValueFactory(new PropertyValueFactory<>("zeit"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("messDaten"));

        // editing Columns
        Column1.setPrefWidth(199);
        Column1.setSortable(false);
        Column2.setPrefWidth(199);
        Column2.setSortable(false);

        // import Children
        dataTableView.getColumns().add(Column1);
        dataTableView.getColumns().add(Column2);

        // editing Tableview
        dataTableView.setPrefWidth(400);
        dataTableView.setPlaceholder(new Label("F\u00fcgen sie eine Messreihe ein!"));

        // return Tableview
        return dataTableView;
    }
}
