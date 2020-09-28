package de.dhbwka.java.exam.dartscounter;

import java.util.Arrays;

/**
 * Player
 */
public class Player {

    private String name;
    private int countDartsThrown;
    private Visit[] visits = new Visit[10];
    private int remPoints = 501;

    Player(String name) {
        this.name = name;
    }

    public int getRemainingPoints() {
        return remPoints;
    }

    public Boolean addVisit(Visit visit) {
        countDartsThrown += visit.getFields().length;
        if (getRemainingPoints() - visit.getValue() < 0)
            return false;

        if (getRemainingPoints() - visit.getValue() == 0) {
            if (!visit.getLastField().isDoubleField())
                return false;
        }

        if (getRemainingPoints() - visit.getValue() == 1) {
            return false;
        }

        if (getmadeVisitCount() < 10) {
            visits[getmadeVisitCount()] = visit;
            remPoints -= visit.getValue();
            return true;
        }

        return false;
    }

    public int getmadeVisitCount() {
        return 10 - (int) Arrays.stream(visits).filter(v -> v == null).count();
    }

    public String getName() {
        return name;
    }

    public int getDartsThrown() {
        return countDartsThrown;
    }
}