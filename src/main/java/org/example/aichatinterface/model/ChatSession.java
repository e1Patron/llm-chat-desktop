package org.example.aichatinterface.model;

import java.util.ArrayList;
import java.util.List;

// Eine ChatSession ist quasi ein einzelner Chat-Verlauf mit einem Namen
public class ChatSession {

    private String name;
    private List<Message> messages;

    public ChatSession(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }
}