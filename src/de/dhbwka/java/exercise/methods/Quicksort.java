package de.dhbwka.java.exercise.methods;

/**
 * Quicksort
 */
public class Quicksort {

    public static void main(String[] args) {
        int[] arr = new int[] { 6, 5, 7, 8, 9, 3, 2, 10, 4, 1 };
        quickSort(arr, 0, 9);

        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {

        // Mitte
        int partition = teile(arr, start, end);

        // erste hälfte rekursiv sortieren (durch weiter Unterteilung)
        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1);
        }
        // zweite hälfte rekursiv sortieren (durch weiter Unterteilung)
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    public static int teile(int[] arr, int start, int end) {
        int pivot = arr[end];

        // sortiere kleine Elemente nach links & große Elemente nach rechts
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
