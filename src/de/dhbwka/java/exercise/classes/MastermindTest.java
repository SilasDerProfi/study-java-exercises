package de.dhbwka.java.exercise.classes;
/**
 * MastermindTest
 */
public class MastermindTest {

    public static void main(String[] args) {
        Mastermind game = new Mastermind();
        
        while (game.attemptsLeft()) {
            System.out.print("Geben Sie Ihren Tipp ab: ");
            String input = System.console().readLine();
            game.tipp(input);
        }   
    }
}