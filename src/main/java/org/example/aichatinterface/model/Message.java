package org.example.aichatinterface.model;

// Repräsentiert eine einzelne Nachricht im Chat
public class Message {

    // Unterscheidung ob die Nachricht vom User oder der KI kommt
    public enum Sender {
        USER, AI,
    }

    private String text;
    private Sender sender;

    public Message(String text, Sender sender) {
        this.text = text;
        this.sender = sender;

    }

    public String getText() {
        return text;
    }

    public Sender getSender() {
        return sender;
    }
}