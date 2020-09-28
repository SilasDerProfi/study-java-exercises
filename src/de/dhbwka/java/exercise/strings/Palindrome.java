package de.dhbwka.java.exercise.strings;

/**
 * Palindrome,
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Beende mit [STRG]+[C]");

        while (true)
            checkPalindrome();
    }
    /**
     * Liest eine Eingabe und gibt aus, ob diese ein Palindrom ist.
     * @return das Palindrom, wenn es eines ist oder {@code null}
     */
    public static String checkPalindrome() {
        System.out.println("Bitte Wort eingeben: ");
        String input = System.console().readLine();
        char[] inputArray = input.toCharArray();
        String palindrome = "";

        for (int i = inputArray.length - 1; i >= 0; i--)
            palindrome += inputArray[i];
        // palindrome = new StringBuffer(input).reverse().toString();

        System.out.println("Umgekehrt: " + palindrome);

        System.out.println(
                input + " ist " + (palindrome.toUpperCase().equals(input.toUpperCase()) ? "" : "k") + "ein Palindrom.");
        System.out.println();
        return palindrome.toUpperCase().equals(input.toUpperCase()) ? palindrome : null;
    }

}