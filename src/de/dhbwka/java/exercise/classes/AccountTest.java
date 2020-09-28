package de.dhbwka.java.exercise.classes;

/**
 * AccountTest
 */
public class AccountTest {

    public static void main(String[] args) {
        Account account= new Account("Donald Duck", 500, 1000);
        System.out.println(account);
        account.processDeposit(200);
        System.out.println(account);
        account.processPayment(400);
        System.out.println(account);
        account.processPayment(2000);
        System.out.println(account);
    }
}