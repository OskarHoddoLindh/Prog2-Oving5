package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Map;



public class Main extends Application {

    private DeckOfCards deck = new DeckOfCards(); // kaller dealHand(int n)-metoden fra DeckOfCards-klassen
    private AnalyzeHand analyzer = new AnalyzeHand();
    private String[] currentHand;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kortspill");

        Label handLabel = new Label("Din hånd vises her");
        Label analysisLabel = new Label("Trykk for analyse av kort");
        Button dealButton = new Button("Del ut hånd");
        Button analyzeButton = new Button("Analyser hånd");
        Button flushButton = new Button("Sjekk 5-flush");


        dealButton.setPrefWidth(150);
        dealButton.setPrefHeight(50);
        analyzeButton.setPrefWidth(150);
        analyzeButton.setPrefHeight(50);
        flushButton.setPrefWidth(150);
        flushButton.setPrefHeight(50);



        dealButton.setOnAction(e -> {
            System.out.println("Deal button pressed");
            currentHand = deck.dealHand(5); // Du kan endre antall kort her
            handLabel.setText(String.join(" ", currentHand));
            analysisLabel.setText(""); // Tøm analysen når en ny hånd deles ut
        });

        analyzeButton.setOnAction(e -> {
            System.out.println("Analyze button pressed");
            if (currentHand != null) {
                Map<Character, Integer> analysis = analyzer.analyzeHand(currentHand);
                analysisLabel.setText(analysis.toString());
            }
        });

        flushButton.setOnAction(e -> {
            if (currentHand != null) {
                boolean isFlush = analyzer.isFlush(currentHand);
                analysisLabel.setText(isFlush ? "Hånden er en 5-flush!" : "Hånden er ikke en 5-flush.");
            }
        });

        VBox vbox = new VBox(20); // 10 pixels spacing
        vbox.getChildren().addAll(dealButton, handLabel, analyzeButton, analysisLabel, flushButton);
        Scene scene = new Scene(vbox, 300, 250);


        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public static void main(String[] args) {
        // Metoden som starter JavaFX-applikasjon

        launch(args);
    }
}

