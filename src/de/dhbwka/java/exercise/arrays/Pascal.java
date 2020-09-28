package de.dhbwka.java.exercise.arrays;

/**
 * Pascal
 */
public class Pascal {

    public static void main(String[] args) {
        int[][] pasc = new int[9][];

        for(int i = 0; i < pasc.length; i++)
        {
            pasc[i] = new int[i+1];
            pasc[i][0] = 1;
            pasc[i][i] = 1;

            for(int j = 1; j < i; j++)
                pasc[i][j] = pasc[i-1][j] + ( j == 0 ? 0 : pasc[i-1][j-1]);
        }
        
        for(int i = 0; i < pasc.length; i++)
        {
            System.out.printf("%" + (pasc.length - i +1) + "s", "");

            for(int j : pasc[i])
                System.out.printf("" + (j == 0 ? "" : "%3d"), j);   
            System.out.println();
        }
    }

       /* public static void main(String[] args) {
        int[][] pasc = new int[9][9];

        pasc[0][0] = 1;

        for(int i = 1; i < pasc.length; i++)
            for(int j = 0; j <= i; j++)
                pasc[i][j] = pasc[i-1][j] + ( j == 0 ? 0 : pasc[i-1][j-1]);
                
        for(int i = 0; i < pasc.length; i++)
        {
            System.out.printf("%" + (pasc.length - i +1) + "s", "");

            for(int j : pasc[i])
                System.out.printf("" + (j == 0 ? "" : "%3d"), j);   
            System.out.println();
        }
    }*/
}