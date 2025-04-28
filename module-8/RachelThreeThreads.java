//Rachel Theis
//Module 8 Assignment
//CSD 420
//4.27.25

//This program creates three threads that generates random characters. The output is written to a file, and a success message is printed.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RachelThreeThreads {

    private static final int COUNT = 10000;
    private static final String OUTPUT_FILE = "rachelthreethreads.txt";

    public static void main(String[] args) {

        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        Thread letterThread = new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char c = (char) (rand.nextInt(26) + 'a');
                letters.append(c);
            }
        });

        Thread digitThread = new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char c = (char) (rand.nextInt(10) + '0');
                digits.append(c);
            }
        });

        Thread symbolThread = new Thread(() -> {
            char[] symbolsArray = {'!', '@', '#', '$', '%', '&', '*'};
            Random rand = new Random();
            for (int i = 0; i < COUNT; i++) {
                char c = symbolsArray[rand.nextInt(symbolsArray.length)];
                symbols.append(c);
            }
        });

        letterThread.start();
        digitThread.start();
        symbolThread.start();

        try {
            letterThread.join();
            digitThread.join();
            symbolThread.join();
        } catch (InterruptedException e) {
            System.err.println("Error - thread interruption: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            writer.write("Letters:\n" + letters + "\n\n");
            writer.write("Digits:\n" + digits + "\n\n");
            writer.write("Symbols:\n" + symbols + "\n\n");
            System.out.println("Output from threads was successfully written to: " + OUTPUT_FILE);
        } catch (IOException e) {
            System.err.println("An error occured when writing file: " + e.getMessage());
        }
    }
}