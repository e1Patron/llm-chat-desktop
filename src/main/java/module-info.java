module org.example.aichatinterface {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.aichatinterface to javafx.fxml;
    opens org.example.aichatinterface.controller to javafx.fxml;
    opens org.example.aichatinterface.model to javafx.fxml;

    exports org.example.aichatinterface;
    exports org.example.aichatinterface.model;
}