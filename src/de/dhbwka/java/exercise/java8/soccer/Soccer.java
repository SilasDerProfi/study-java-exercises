package de.dhbwka.java.exercise.java8.soccer;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Soccer
 */
public class Soccer {

    public static void main(String[] args) throws IOException {
        List<Player> players = Arrays.asList(Files.readAllLines(Paths.get("io/33_Java8_Aufgaben_TeamDE.csv").toAbsolutePath())
        .stream()
        .map(l -> l.split(";"))
        .map(p -> new Player(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4], Integer.parseInt(p[5]), Integer.parseInt(p[6]))).toArray(Player[]::new));


        Collections.sort(players, Player::comparePlayerByNumber);
        System.out.println("Players sorted by number:");
        players.forEach(p -> System.out.println(p.toString()));
        System.out.println("-----");
        
        Collections.sort(players, Player::comparePlayerByName);
        System.out.println("Players with more than 50 games, sorted by name:");
        players.stream().filter(p -> p.getGames() > 50).forEach(p -> System.out.println(p.toString()));
        System.out.println("-----");

        System.out.println("All clubs of the players:");
        players.stream().map(p -> p.getClub()).sorted().distinct().forEach(c -> System.out.println(c));
        System.out.println("-----");

        System.out.print("Count of players with less than 5 goals: ");
        System.out.println(players.stream().filter(p -> p.getGoals() < 5).count());

        System.out.print("Count of goals of all players: ");
        System.out.println(players.stream().mapToInt(p -> p.getGoals()).sum());
    }
}