/* ####### setting Meta ####### */
package application;

/* ####### setting Imports ####### */
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/* ####### setting Messung Class "Messung.java" ####### */
public class Messung {

    private final SimpleStringProperty zeit;
    private final SimpleStringProperty messDaten;

    public Messung(String zeit, String messDaten) {
        this.zeit = new SimpleStringProperty(zeit);
        this.messDaten = new SimpleStringProperty(messDaten);
    }

    //add getters to properties with the appropriate naming convention
    public final StringProperty zeitProperty() {
        return zeit;
    }
    public final StringProperty messDatenProperty() {
        return messDaten;
    }
}

