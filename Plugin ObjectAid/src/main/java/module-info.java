module org.example.sae301objectaid {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.sae301objectaid to javafx.fxml;
    exports org.example.sae301objectaid;
}