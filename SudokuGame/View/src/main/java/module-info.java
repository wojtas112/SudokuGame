module org.compprog {
    requires javafx.controls;
    requires javafx.fxml;
    requires Model;

    //requires Model;

    opens org.compprog to javafx.fxml;
    exports org.compprog;
}