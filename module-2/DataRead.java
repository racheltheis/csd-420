//Rachel Theis
//Module 2 Programming Assignment
//CSD 420
//3.30.25

//This program read the DataWrite.java file and prints the contents

import java.io.*;

public class DataRead {
    public static void main(String[] args) {
        String filename = "Theis_datafile.dat";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Data written to " + filename + ":");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("An error occurred. File not found: " + filename);
        } catch (IOException e) {
            System.err.println("An error occurred. Could not read: " + e.getMessage());
        }
    }
}
