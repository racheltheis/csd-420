//Rachel Theis
//Module 7 Assignment
//CSD 420

//This program tests the CircleDisplayApp.java program

public class CircleDisplayTest {
    public static void main(String[] args) {

        Circle circle = new Circle(50);
        circle.getStyleClass().add("white_circle");

        if (circle.getStyleClass().contains("white_circle")) {
            System.out.println("Pass: Circle has 'white_circle' style class");
        } else {
            System.out.println("Fail: Circle missing 'white_circle' style class");
        }

        Circle redCircle = new Circle(50);
        redCircle.setId("red_circle");

        if ("red_circle".equals(redCircle.getId())) {
            System.out.println("pass: Circle ID is 'red_circle'");
        } else {
            System.out.println("fail: Circle ID is not 'red_circle'");
        }

        Circle greenCircle = new Circle(50);
        greenCircle.setId("green_circle");

        if ("green_circle".equals(greenCircle.getId())) {
            System.out.println("pass - Circle ID is 'green_circle'");
        } else {
            System.out.println("fail - Circle ID is not 'green_circle'");
        }
    }
}

