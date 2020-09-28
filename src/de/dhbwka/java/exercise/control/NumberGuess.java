package de.dhbwka.java.exercise.control;

import java.util.Random;
import java.util.Scanner;

/**
 * NumberGues
 */
public class NumberGuess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Wie ist dein Name? ");
        String name = sc.next();
        boolean stopGame = false;

        while(!stopGame)
        {
            int random = new Random().nextInt(101);

            for(int i = 1; ;i++)
            {
                System.out.printf("%s, rate eine Zahl [1-100]: ", name);
                int next = sc.nextInt();

                if(next > random)
                {
                    System.out.printf("Versuch %d: %d ist zu hoch.\r\n", i, next);
                }
                else if (next < random)
                {
                    System.out.printf("Versuch %d: %d ist zu niedrig..\r\n", i, next);
                }
                else
                {
                    System.out.printf("Versuch %d: %d ist korrekt.\r\n", i, next);
                    break;
                }                
            }

            System.out.println("Was möchtest du tun?");
            System.out.println("0 - Das Spiel beenden");
            System.out.println("1 - Das Spiel fortsetzen");
            stopGame = !sc.next().equals("1");
        }

        sc.close();
    }
}