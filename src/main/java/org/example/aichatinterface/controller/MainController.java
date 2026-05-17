package org.example.aichatinterface.controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.example.aichatinterface.model.ChatSession;
import org.example.aichatinterface.model.Message;

public class MainController {

    @FXML private VBox chatBox;
    @FXML private TextField inputField;
    @FXML private ScrollPane scrollPane;
    @FXML private ListView<String> sessionList;
    @FXML private VBox statsPanel;

    // JavaFX setzt diesen automatisch weil fx:id="statistics" in der FXML steht
    @FXML private StatisticsController statisticsController;

    private ChatSession currentSession;
    private int sessionCount = 1;
    private boolean statsVisible = true;

    @FXML
    public void initialize() {
        newChat();
    }

    @FXML
    public void newChat() {
        currentSession = new ChatSession("Chat " + sessionCount++);
        sessionList.getItems().add(currentSession.getName());
        sessionList.getSelectionModel().selectLast();
        chatBox.getChildren().clear();
        aktualisiereStats();
    }

    // Ein- und Ausblenden des Statistik-Panels per Button
    @FXML
    public void toggleStats() {
        statsVisible = !statsVisible;
        statsPanel.setVisible(statsVisible);
        statsPanel.setManaged(statsVisible);
    }

    @FXML
    public void sendMessage() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        Message userMessage = new Message(text, Message.Sender.USER);
        currentSession.addMessage(userMessage);
        addBubble(text, true);
        inputField.clear();
        aktualisiereStats();

        // Simulierte KI-Antwort nach 1 Sekunde
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            String aiText = "Simulierte Antwort auf: \"" + text + "\"";
            Message aiMessage = new Message(aiText, Message.Sender.AI);
            currentSession.addMessage(aiMessage);
            addBubble(aiText, false);
            aktualisiereStats();
        });
        pause.play();
    }

    private void addBubble(String text, boolean isUser) {
        Label label = new Label(text);
        label.setWrapText(true);
        label.setMaxWidth(500);
        label.getStyleClass().add(isUser ? "bubble-user" : "bubble-ai");

        HBox hBox = new HBox(label);
        hBox.setPadding(new Insets(5, 10, 5, 10));
        hBox.setAlignment(isUser ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);

        chatBox.getChildren().add(hBox);
        scrollPane.layout();
        scrollPane.setVvalue(1.0);
    }

    // Gibt die aktuellen Chat-Daten an den StatisticsController weiter
    private void aktualisiereStats() {
        if (statisticsController != null) {
            statisticsController.update(currentSession);
        }
    }
}