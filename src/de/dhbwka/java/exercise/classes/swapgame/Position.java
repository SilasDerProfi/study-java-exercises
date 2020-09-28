package de.dhbwka.java.exercise.classes.swapgame;

/**
 * Position
 */
public class Position {

    //#region private members
    private int arrayCol;
    private int arrayRow;
    //#endregion private members

    //#region constructors
    /**
     * Initialisiert eine Position auf Basis der Spalten- & Zeilenbezeichnung
     * @param col Buchstabenbezeichner der Spalte
     * @param row Zeilennummer
     */
    Position(char col, int row){
        arrayCol = col - 'A';
        arrayRow = row - 1;
    }

    /**
     * Initialisiert eine Position auf Basis 0-Basierter Angaben.
     * @param col Spaltennummer (0-Basiert)
     * @param row Zeilennummer (0-Basiert)
     */
    Position(int col, int row){
        arrayCol = col;
        arrayRow = row;
    }

    //#endregion constructors

    //#region GetSet
    public char getCol(){
        return (char) ('A' + arrayCol);
    }

    public int getRow(){
        return arrayRow + 1;
    }

    public int getColArrayIndex(){
        return arrayCol;
    }

    public int getRowArrayIndex(){
        return arrayRow;
    }
    //#endregion GetSet

    //#region public methods
    public String toString(){
        return getCol() + "" + getRow();
    }
    //#endregion public methods
}