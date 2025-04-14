//Rachel Theis
//Module 5 Assignment
//CSD 420
//4.13.25

//This program reads a list of names from collection_of_words.txt, and displays all non-duplicated names in ascending and descending order.

import java.io.*;
import java.util.*;

public class NamesSort {
    public static void main(String[] args) {
        Set<String> uniqueNames = readNames("collection_of_words.txt");

        if (uniqueNames == null) {
            System.out.println("An error occured when reading the file.");
            return;
        }

        List<String> sortedNames = new ArrayList<>(uniqueNames);

        Collections.sort(sortedNames);
        System.out.println("Names in Ascending Order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }

        Collections.sort(sortedNames, Collections.reverseOrder());
        System.out.println("\nNames in Descending Order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }

        testValues();
    }

    private static Set<String> readNames(String fileName) {
        Set<String> names = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String name = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                //ensuring that names are not duplicated with case-sensitivity issues
                if (!name.isEmpty()) {
                    names.add(name);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Not found: " + fileName);
            return null;
        }
        return names;
    }
    
//test that the file is reading correctly
    private static void testValues() {
        Set<String> expected = new HashSet<>(Arrays.asList("mary", "mark", "frances", "john", "william", "brianna", "olivia", "james", "austin", "zoe"));
        Set<String> actual = readNames("collection_of_words.txt");

        if (actual != null && actual.equals(expected)) {
            System.out.println("\nPassed: Expected values match actual values.");
        } else {
            System.out.println("\nFailed: Actual values do not match expected values.");
            System.out.println("Expected: " + expected);
            System.out.println("Actual  : " + actual);
        }
    }
}
