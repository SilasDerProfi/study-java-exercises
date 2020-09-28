package de.dhbwka.java.exercise.classes;

import java.util.Arrays;

/**
 * Lotto
 */
public class Lotto {

    private int m;
    private int n;

    private int[] tip;
    private int[] draw;
    /**
     * @param m Anzahl der zu ziehenden Kugeln
     * @return n Gesamtanzahl der Kugeln
     */
    public Lotto(int m, int n)
    {
        this.m = m;
        this.n = n;
        tip = new int[m];
        draw = new int[m];
    }

    void tippen(){
        for (int i = 0; i < m; i++) {
            System.out.print("Bitte Zahl " + (i +1) + " fuer Tipp Eingeben: ");
            
            String input = System.console().readLine();
            int tip = 0;
            try {
                tip = Integer.parseInt(input);
            } catch (NumberFormatException e) {
            }

            if (tip > 0 && tip <= n)
                this.tip[0] = tip;
            else
            {
                System.out.println("ungueltige Eingabe.");
                i--;
            }

            Arrays.sort(this.tip);
        }
    }

    
    void tippen(int... tipp){
        Arrays.sort(tipp);
        tip = tipp;
    }

    void ziehen()
    {
        for(int i = 0; i < draw.length; i++)
        {
            draw[0] = (int)(Math.random() * n) + 1;

            Arrays.sort(draw);
            for(int j = 0; j < draw.length; j++)
            {
                if(j > 0 && draw[j] != 0 && draw[j] == draw[j-1])
                {
                    draw[j-1] = 0;
                    i--;
                }
            }
            Arrays.sort(draw);
        }
        
    }

    int richtige()
    {
        int richtige = 0;
        for(int i = 0; i < draw.length; i++)
            richtige += draw[i] == tip[i] ? 1 : 0;

        return richtige;
    }

    public String toString(){
        String retVal = "Ihr Tipp: ";
        for(int i : tip)
        {
            if(i == 0)
                return "noch kein Tipp abgegeben!";
            else
                retVal += i + " ";
        }

        retVal += "\r\nGezogene Zahlen: ";

        for(int i: draw)
        {
            if(i == 0)
                return retVal;
            else
                retVal += i + " "; 
        }

        return retVal;
    }
}