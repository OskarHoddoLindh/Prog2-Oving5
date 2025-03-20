package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;




public class Main extends Application {

    private DeckOfCards deck = new DeckOfCards();


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kortspill");

        Label handLabel = new Label("Din hånd vises her");
        Button dealButton = new Button("Del ut hånd");

        dealButton.setOnAction(e -> {
            String[] hand = deck.dealHand(5); // Du kan endre antall kort her
            handLabel.setText(String.join(" ", hand));
        });

        VBox vbox = new VBox(dealButton, handLabel);
        Scene scene = new Scene(vbox, 500, 500);


        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public static void Main(String[] args) {
        // Metoden som starter JavaFX-applikasjon

        launch(args);
    }
}

