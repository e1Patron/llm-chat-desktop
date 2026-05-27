package org.example.aichatinterface.model;

import java.util.List;

public class StatisticsCalculator {

    public int countMessages(List<Message> messages) {
        return messages.size();
    }

    public int countTotalWords(List<Message> messages) {
        int summe = 0;
        for (Message m : messages) {
            summe += zaehleWoerter(m.getText());
        }
        return summe;
    }

    // Durchschnitt berechnen
    public double averageMessageLength(List<Message> messages) {
        if (messages.isEmpty()) return 0.0;
        int zeichenGesamt = 0;
        for (Message m : messages) {
            zeichenGesamt += m.getText().length();
        }
        return (double) zeichenGesamt / messages.size();
    }

    public int longestMessageLength(List<Message> messages) {
        int max = 0;
        for (Message m : messages) {
            if (m.getText().length() > max) {
                max = m.getText().length();
            }
        }
        return max;
    }

    private int zaehleWoerter(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] woerter = text.trim().split("\\s+");
        return woerter.length;
    }
}