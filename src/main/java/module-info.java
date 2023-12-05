module es.ieslosmontecillos.componentes_gomezantonio {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.componentes_gomezantonio to javafx.fxml;
    exports es.ieslosmontecillos.componentes_gomezantonio;
}