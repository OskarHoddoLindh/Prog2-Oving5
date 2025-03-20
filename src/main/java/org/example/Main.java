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

        VBox vbox = new VBox(dealButton, handLabel, analyzeButton, analysisLabel);
        Scene scene = new Scene(vbox, 1000, 700);


        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public static void Main(String[] args) {
        // Metoden som starter JavaFX-applikasjon

        launch(args);
    }
}

