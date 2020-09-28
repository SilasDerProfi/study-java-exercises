package de.dhbwka.java.exercise.enums;

/**
 * Months
 */
public enum Months {

    JANUAR(31, "Hartung", "Eismond"),
    FEBRUAR(28, "Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"),
    MAERZ(31, "Lenzing", "Lenzmond"),
    APRIL(30, "Launing", "Ostermond"),
    MAI(31, "Winnemond", "Blumenmond"),
    JUNI(30, "Brachet", "Brachmond"),
    JULI(31, "Heuert", "Heumond"),
    AUGUST(31, "Ernting", "Erntemond", "Bisemond"),
    SEPTEMBER(30, "Scheiding", "Herbstmond"),
    OKTOBER(31, "Gilbhart", "Gilbhard", "Weinmond"),
    NOVEMBER(30, "Nebelung", "Windmond", "Wintermond"),
    DEZEMBER(31, "Julmond", "Heilmond", "Christmond", "Dustermond");

    private int days;
    private String[] oldNames;
    Months(int days, String... oldNames){
        this.days = days;
        this.oldNames = oldNames;
    }

    public String getInformation(){
        return "Der Monat " + toString() + " hat " + days + " Tage und hieß früher '" + String.join(", ", oldNames) + "'";
    }

    @Override
    public String toString() {
        String s= super.toString();
        return s.charAt(0) + s.substring(1).toLowerCase();
    }
}