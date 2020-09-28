package de.dhbwka.java.exercise.theoinfo;

/**
 * Max
 */
public class Max {
    public static void main(String[] args) {
        // Wohin reist Max, wenn er kein Auto hat?
        
        calc(0, 128);
    }

    private static void calc(int i, int lim) {
        if (i < lim) {
            boolean[] v = new boolean[7];

            String binary = String.format("%7s", Integer.toBinaryString(i));

            for (int j = 0; j < binary.length(); j++)
                v[j] = binary.charAt(j) == '1';

            if ((!v[0] || v[1]) && (v[0] || v[2]) && (!v[1] || v[3]) && (!v[2] || v[4]) && (!v[5]) && (!v[6])
                    && (v[0] || v[5] || v[6]))
                System.out.println(binary.replace(' ', '0'));

            calc(++i, lim);
        }
    }
}