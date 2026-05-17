package org.example.aichatinterface.model;

import java.util.List;

// Diese Klasse kümmert sich um alle Berechnungen für das Statistik-Dashboard
public class StatisticsCalculator {

    public int countMessages(List<Message> messages) {
        return messages.size();
    }

    public int countTotalWords(List<Message> messages) {
        int total = 0;
        for (Message m : messages) {
            total += countWordsInText(m.getText());
        }
        return total;
    }

    // Durchschnittliche Länge in Zeichen über alle Nachrichten
    public double averageMessageLength(List<Message> messages) {
        if (messages.isEmpty()) return 0.0;
        int totalChars = 0;
        for (Message m : messages) {
            totalChars += m.getText().length();
        }
        return (double) totalChars / messages.size();
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

    // Hilfsmethode: zählt Wörter in einem Text anhand von Leerzeichen
    private int countWordsInText(String text) {
        if (text == null || text.isBlank()) return 0;
        return text.trim().split("\\s+").length;
    }
}