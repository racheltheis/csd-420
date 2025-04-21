//Rachel Theis
//CSD 420
//Module 6 Programming Assignment

//This program will sort and print two arrays: one with comparable, and one with comparator

import java.util.Comparator;

public class Bubble_Sort {

    // Sort with Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Sort with Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static <E> void printArray(E[] array) {
    for (E e : array) {
        System.out.print(e + " ");
    }
    System.out.println();
    }

    public static void main(String[] args) {
        //Test 1: Comparable sorting with integers
        Integer[] comparablenumbers = {11, 1, 901, 45, 3, 719, 2109, 78, 6766, 80766};
        System.out.println("\nTest 1: Sorting Integers with Comparable\nOriginal List:");
        printArray(comparablenumbers);
        bubbleSort(comparablenumbers);
        System.out.println("Sorted List:");
        printArray(comparablenumbers);
        
        //Test 2: Comparable sorting with strings
        String[] comparablewords = {"Yellow", "Orange", "Blue", "Maroon", "Black", "Indigo"};
        System.out.println("\nTest 2: Sorting Strings with Comparable\nOriginal List:");
        printArray(comparablewords);
        bubbleSort(comparablewords);
        System.out.println("Sorted List:");
        printArray(comparablewords);
        
        //Test 3: Comparator sorting with integers
        Integer[] comparatornumbers = {333, 192, 57, 1, 19, 4008, 5, 308, 66709, 2};
        System.out.println("\nTest 3: Sorting Integers with Comparator\nOriginal List:");
        printArray(comparatornumbers);
        bubbleSort(comparatornumbers, Comparator.naturalOrder());
        System.out.println("Sorted List - Ascending Order:");
        printArray(comparatornumbers);

        bubbleSort(comparatornumbers, Comparator.reverseOrder());
        System.out.println("Sorted List - Descending Order:");
        printArray(comparatornumbers);

        //Test 4: Comparator sorting with strings
        String[] comparatorwords = {"Claire", "Denise", "Abby", "Beth"};
        System.out.println("\nTest 4: Sorting Strings with Comparator\nOriginal List:");
        printArray(comparatorwords);
        bubbleSort(comparatorwords, Comparator.naturalOrder());
        System.out.println("Sorted List - Ascending Order:");
        printArray(comparatorwords);

        bubbleSort(comparatorwords, Comparator.reverseOrder());
        System.out.println("Sorted List - Descending Order:");
        printArray(comparatorwords);
    }
}
