package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("Hei JavaFX!");
        StackPane root = new StackPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Min JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void Main(String[] args) {
        // Metoden som starter JavaFX-applikasjon

        launch(args);
    }
}

