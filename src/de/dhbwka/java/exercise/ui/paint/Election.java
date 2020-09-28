package de.dhbwka.java.exercise.ui.paint;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JFrame;

/**
 * Election
 */
public class Election extends JFrame{
    private static final long serialVersionUID = 1L;

    Election(){
        HashMap<String, Double> parties = new LinkedHashMap<String, Double>();
        parties.put("Union", 33.);
        parties.put("SPD", 20.5);
        parties.put("Afd", 12.6);
        parties.put("FDP", 10.7);
        parties.put("Linke", 9.2);
        parties.put("Grüne", 8.9);
        parties.put("Andere", 5.1);
        setTitle("Bundestagswahl 2017");
        setSize(900,400);

        add(new ElectionCanvas(parties));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
    }
}