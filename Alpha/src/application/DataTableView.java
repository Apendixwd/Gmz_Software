package application;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataTableView {
    TableView dataTableView = new TableView();

    public TableView dataTableView()    {
        dataTableView.setPrefWidth(300);
        TableColumn Column1 = new TableColumn("T in Sekunden");
        Column1.setCellValueFactory(new PropertyValueFactory<>("zeit"));

        TableColumn Column2 = new TableColumn("Messdaten in CPM");
        Column2.setCellValueFactory(new PropertyValueFactory<>("messDaten"));
        dataTableView.getColumns().add(Column1);
        Column1.setPrefWidth(149);
        Column2.setPrefWidth(149);
        dataTableView.getColumns().add(Column2);
        dataTableView.setPlaceholder(new Label("Fügen sie eine Messreihe ein, um sie hier anzuzeigen!"));
        return dataTableView;
    }
}
