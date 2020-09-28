package de.dhbwka.java.exercise.classes.periodic;

/**
 * Element
 */
public class Element {

    //#region private members
    private String name;
    private String symbol;
    private int ordinal;
    private char shell;
    private ePhase phase;
    private boolean isMainGroup;
    //#endregion private members

    //#region construcors
    public Element(String name, String symbol, int ordinal, char shell, ePhase phase, boolean isMainGroup){
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.isMainGroup = isMainGroup;
    }
    //#endregion construcors

    //#region GetSet
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public char getShell() {
        return this.shell;
    }

    public void setShell(char shell) {
        this.shell = shell;
    }

    public ePhase getPhase() {
        return this.phase;
    }

    public void setPhase(ePhase phase) {
        this.phase = phase;
    }

    public boolean isIsMainGroup() {
        return this.isMainGroup;
    }

    public boolean getIsMainGroup() {
        return this.isMainGroup;
    }

    public void setIsMainGroup(boolean isMainGroup) {
        this.isMainGroup = isMainGroup;
    }

    private String getPhaseName(ePhase phase) {
        switch (phase) {
        case SOLID:
            return "fest";
        case LIQUID:
            return "flüssig";
        case GAS:
            return "gasf.";
        default:
            return new String();
        }
    }
    //#endregion GetSet

    //#region public methods
    public String toString() {
        return String.format("%s (%s,%d) Schale: %c, %s, Gruppe: %s", getName(), getSymbol(), getOrdinal(), getShell(),
                getPhaseName(getPhase()), isMainGroup ? "Hauptgruppe" : "Nebengruppe");
    }

    public boolean equals(Object o)
    {
        Element e = (Element)o;
        return e != null && e.getOrdinal() == this.getOrdinal(); 
    }
    //#endregion public methods

    public static enum ePhase { SOLID, LIQUID, GAS }
}