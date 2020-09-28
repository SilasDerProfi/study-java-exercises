package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * MatrixSubtraction
 */
public class MatrixSubtraction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Zeilen n eingeben: ");
        int n = sc.nextInt();
        System.out.print("Bitte Anzahl der Spalten m eingeben: ");
        int m = sc.nextInt();
        sc.nextLine();

        System.out.println("X:");
        String[][] matrixX = readMatrix(n, m, sc);
        System.out.println("Y:");
        String[][] matrixY = readMatrix(n, m, sc);

        System.out.println("X-Y:");
        for (int i = 0; i < matrixX.length; i++) {
            for (int j = 0; j < matrixX[i].length; j++) {
                System.out.printf("%4d", Integer.parseInt(matrixX[i][j]) - Integer.parseInt(matrixY[i][j]));
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(int n, int m, Scanner sc) {
        String[][] matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            String row = sc.nextLine().trim();

            while (row.contains("  "))
                row = row.replace("  ", " ");

            matrix[i] = row.split(" ");
        }

        return matrix;
    }
}