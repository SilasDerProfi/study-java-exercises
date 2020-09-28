package de.dhbwka.java.exercise.classes.periodic;

import java.util.Arrays;

/**
 * PeriodicTable
 */
public class PeriodicTable {
    private Element[] elements = new Element[118];

    public static void main(String[] args) {
        PeriodicTable pt = new PeriodicTable();
        pt.addElement(new Element("Wasserstoff", "H", 1, 'K', Element.ePhase.GAS, true));
        pt.addElement(new Element("Helium", "He", 2, 'K', Element.ePhase.GAS, true));
        pt.addElement(new Metal("Natrium", "Na", 11, 'M', Element.ePhase.SOLID, true, false, 2.1E7));
        pt.addElement(new Metal("Eisen", "Fe", 26, 'N', Element.ePhase.SOLID, false, false, 1.002E7));
        pt.addElement(new Metal("Germanium", "Ge", 32, 'N', Element.ePhase.SOLID, false, true, 1.45));
        pt.addElement(new Element("Brom", "Br", 35, 'N', Element.ePhase.LIQUID, true));
        pt.addElement(new Metal("Tellur", "Te", 52, 'O', Element.ePhase.SOLID, true, true, 0.005));
        pt.addElement(new Metal("Gold", "Au", 79, 'P', Element.ePhase.SOLID, false, false, 4.4E7));

        System.out.println("Elemente:");
        for (Element e : pt.elements)
            if (e != null)
                System.out.println(e);

        System.out.println();
        System.out.println("Metalle:");
        for (Element e : pt.getMetals())
            System.out.println(e);

        System.out.println();
        System.out.println("Gold:");

        System.out.println(pt.getElement(79));
    }

    //#region public methods
    public void addElement(Element e) {
        if (!hasElement(e.getOrdinal()))
            elements[e.getOrdinal() - 1] = e;
    }

    public boolean hasElement(int o) {
        return elements[o - 1] != null;
    }

    public Element getElement(int o) {
        return elements[o - 1];
    }

    public Element[] getMetals() {
        return Arrays.stream(elements).filter(e -> e instanceof Metal).toArray(Element[]::new);
    }

    //#endregion public methods
}