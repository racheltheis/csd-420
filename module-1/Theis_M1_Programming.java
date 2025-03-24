//Rachel Theis
//Module 1 Programming Assignment
//CSD 420
//3.23.25

//This program will display four randomly shuffled cards from a deck.

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import java.util.*;

public class Main extends Application {
    private static final int IMAGE_WIDTH = 100;
    private static final int IMAGE_HEIGHT = 150;
    private static final int TOTAL_CARDS = 52;

    private List<ImageView> cardViews;
    private Random random;
    private Map<Integer, Image> cardImages;

    @Override
    public void start(Stage primaryStage) {
        random = new Random();
        cardViews = new ArrayList<>();
        cardImages = new HashMap<>();

        preloadImages();

        HBox cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);

        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView();
            imageView.setFitWidth(IMAGE_WIDTH);
            imageView.setFitHeight(IMAGE_HEIGHT);
            cardViews.add(imageView);
            cardBox.getChildren().add(imageView);
        }

        Button refreshButton = new Button("Refresh - Display New Cards");
        refreshButton.setOnAction(e -> refreshCards());

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(cardBox, refreshButton);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Card Shuffler");
        primaryStage.setScene(scene);
        primaryStage.show();

        refreshCards();
    }

    private void preloadImages() {
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            try {
                Image cardImage = new Image("cards/" + i + ".png");
                cardImages.put(i, cardImage);
            } catch (Exception e) {
                System.err.println("Error displaying: " + i);
            }
        }
    }

    private void refreshCards() {
        Set<Integer> usedNumbers = new HashSet<>();

        for (ImageView cardView : cardViews) {
            int cardNumber;
            do {
                cardNumber = random.nextInt(TOTAL_CARDS) + 1;
            } while (!usedNumbers.add(cardNumber));

            cardView.setImage(cardImages.getOrDefault(cardNumber, null));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
