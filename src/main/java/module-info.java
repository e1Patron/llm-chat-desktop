module org.example.aichatinterface {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.aichatinterface to javafx.fxml;
    opens org.example.aichatinterface.controller to javafx.fxml; // Diese Zeile MUSS da sein!

    exports org.example.aichatinterface;
    exports org.example.aichatinterface.model;
    opens org.example.aichatinterface.model to javafx.fxml;
}