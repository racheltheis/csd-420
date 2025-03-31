//Rachel Theis
//Module 2 Programming Assignment
//CSD 420
//3.30.25

//This program will randomly write integers and doubles to a file

import java.io.*;
import java.util.Random;

public class DataWrite {
    public static void main(String[] args) {
        String filename = "Theis_datafile.dat";
        Random random = new Random();

        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];

        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = random.nextInt(100);
            randomDoubles[i] = random.nextDouble() * 100;
        }

        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            pw.print("Random Integers: ");
            for (int num : randomIntegers) {
                pw.print(num + " ");
            }
            pw.println();

            pw.print("Random Doubles: ");
            for (double num : randomDoubles) {
                pw.print(num + " ");
            }
            pw.println();

            System.out.println("Success! Data was written to " + filename);

        } catch (IOException e) {
            System.err.println("An error occurred. Data was not written: " + e.getMessage());
        }
    }
}

