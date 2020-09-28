package de.dhbwka.java.exercise.java8.soccer;

/**
 * Player
 */
public class Player {

    //#region private members
    private int number;
    private String name;
    private String position;
    private String birthday;
    private String club;
    private int games;
    private int goals;
    //#endregion private members

    //#region Getter & Setter
    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getClub() {
        return this.club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getGames() {
        return this.games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGoals() {
        return this.goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
    //#endregion Getter & Setter


    public Player(int number, String name, String position, String birthday, String club, int games, int goals) {
        this.number = number;
        this.name = name;
        this.position = position;
        this.birthday = birthday;
        this.club = club;
        this.games = games;
        this.goals = goals;
    }

    public static int comparePlayerByNumber( Player p1, Player p2){
        return Integer.compare(p1.getNumber(), p2.getNumber());
    }

    public static int comparePlayerByName( Player p1, Player p2){
        return p1.getName().compareTo(p2.getName());
    }


    
    @Override
    public String toString() {
        return 
            String.format("%2d | %s, %s, %s, %s, %d games, %d goals", getNumber(), getName(), getPosition(), getBirthday(), getClub(), getGames(), getGoals());
    }
}