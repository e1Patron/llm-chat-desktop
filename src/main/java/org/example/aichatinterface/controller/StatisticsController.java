package org.example.aichatinterface.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.aichatinterface.model.ChatSession;
import org.example.aichatinterface.model.StatisticsCalculator;

// Steuert das Statistik-Panel und aktualisiert die Labels wenn sich was ändert
public class StatisticsController {

    @FXML private Label labelMessageCount;
    @FXML private Label labelAvgLength;
    @FXML private Label labelLongest;
    @FXML private Label labelTotalWords;

    private final StatisticsCalculator calculator = new StatisticsCalculator();

    // Wird vom MainController aufgerufen sobald eine neue Nachricht da ist
    public void update(ChatSession session) {
        if (session == null) {
            labelMessageCount.setText("0");
            labelAvgLength.setText("0");
            labelLongest.setText("0");
            labelTotalWords.setText("0");
            return;
        }

        var messages = session.getMessages();

        labelMessageCount.setText(String.valueOf(calculator.countMessages(messages)));
        labelAvgLength.setText(String.format("%.1f", calculator.averageMessageLength(messages)));
        labelLongest.setText(String.valueOf(calculator.longestMessageLength(messages)));
        labelTotalWords.setText(String.valueOf(calculator.countTotalWords(messages)));
    }
}