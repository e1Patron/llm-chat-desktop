# LLM Chat Desktop

Desktop-Chat-Anwendung im Stil eines KI-Assistenten, entwickelt mit **Java** und **JavaFX** im Rahmen des Moduls *Programmieren 2* an der Hochschule Aalen (Sommersemester 2026, Teamprojekt mit 4 Personen).



## Funktionen

- Neue Chats starten und zwischen Sitzungen wechseln
- Chat-Fenster mit Nachrichten-Bubbles für Nutzer- und KI-Nachrichten
- Eingabefeld mit simulierter KI-Antwort
- Sidebar mit Chat-Historie
- Fehlermeldungen bei ungültigen Eingaben

## Spezialfunktion: Statistik-Dashboard

Eigene Ansicht mit Live-Statistiken zum aktuell aktiven Chat. Die Werte aktualisieren sich sofort, sobald eine neue Nachricht gesendet wird:

- Anzahl der Nachrichten
- Anzahl der Wörter insgesamt
- Durchschnittliche Nachrichtenlänge
- Längste Nachricht

Die Berechnungen sind in einer eigenen Klasse `StatisticsCalculator` im Model gekapselt, die Anzeige erfolgt über `StatisticsController` und `statistics-view.fxml`.

## Technologien

- Java, JavaFX (FXML)
- CSS für ein einheitliches UI-Design
- MVC-Architektur (Trennung von Oberfläche, Logik und Datenmodell)
- Maven

## Starten

Voraussetzung: Java 17+ und Maven

```bash
git clone https://github.com/e1Patron/llm-chat-desktop.git
cd llm-chat-desktop
mvn clean javafx:run
```

## Projektstruktur

```
src/main/java        Java-Code (Model, View, Controller)
src/main/resources   FXML-Dateien, CSS und Ressourcen
```