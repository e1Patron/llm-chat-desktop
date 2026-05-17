package org.example.aichatinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/aichatinterface/main-view.fxml")
        );
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(
                getClass().getResource("/org/example/aichatinterface/style.css").toExternalForm()
        );
        stage.setTitle("AI Chat Interface");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}