package de.dhbwka.java.exercise.classes.periodic;

/**
 * Metal
 */
public class Metal extends Element {
    //#region private members
    private boolean isMetalloid;
    private double conductivity;
    //#endregion private members

    //#region constructors
    public Metal(String name, String symbol, int ordinal, char shell, ePhase phase, boolean isMainGroup, boolean isMetalloid, double conductivity){
        super(name, symbol, ordinal, shell, phase, isMainGroup);
        setIsMainGroup(isMainGroup);
        setConductivity(conductivity);
    }
    //#endregion constructors

    //#region GetSet
    public boolean isIsMetalloid() {
        return this.isMetalloid;
    }

    public boolean getIsMetalloid() {
        return this.isMetalloid;
    }

    public void setIsMetalloid(boolean isMetalloid) {
        this.isMetalloid = isMetalloid;
    }

    public double getConductivity() {
        return this.conductivity;
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }
    //#endregion GetSet
    
    //#region public methods
    public String toString(){
        return String.format("%s%s, \u03C3: %s",super.toString(), isMetalloid ? ", Halbleiter" : "", conductivity + "");
    }
    //#endregion public methods
}
