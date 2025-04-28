//Rachel Theis
//Module 7 Assignment
//CSD 420
//4.27.25

//This program displays four circles using CSS styling

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleDisplayApp extends Application {
    @Override
    public void start(Stage primaryStage) {

        Circle circle1 = new Circle(50); 
        Circle circle2 = new Circle(50);
        Circle circle3 = new Circle(50);
        Circle circle4 = new Circle(50);

        circle1.getStyleClass().add("white_circle");
        circle2.getStyleClass().add("white_circle");
        circle3.setId("red_circle");
        circle4.setId("green_circle");

        StackPane circle1Border = new StackPane(circle1);
        circle1Border.getStyleClass().add("border");

        HBox hbox = new HBox(20);
        hbox.setAlignment(javafx.geometry.Pos.CENTER);
        hbox.setPadding(new javafx.geometry.Insets(0));
        hbox.setPrefHeight(200);
        hbox.setStyle("-fx-background-color: white;");
        hbox.getChildren().addAll(circle1Border, circle2, circle3, circle4);

        Scene scene = new Scene(hbox, 500, 200);
        scene.getStylesheets().add("theis_module7_style.css");

        primaryStage.setTitle("Module 7 Assignment - Circles with CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

