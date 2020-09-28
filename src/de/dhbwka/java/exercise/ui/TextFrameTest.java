package de.dhbwka.java.exercise.ui;

/**
 * TextFrameTest
 */
public class TextFrameTest {

    public static void main(String[] args) {
       args = new String[] { "io/CrossTotal.txt", "500", "400" };

        if (args.length != 3) {
            System.out.println("Bitte starten sie die Anwendung mit 3 Parametern.");
            System.out.println("- Pfad zu einer Datei");
            System.out.println("- Breite des Fensters");
            System.out.println("- Höhe des Fensters");
            System.console().readLine();
        } else {
            int width, height;
            try {
                width = Integer.parseInt(args[1]);
                height = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                main(new String[0]);
                return;
            }

            TextFrame f = new TextFrame(args[0], width, height);
            f.setVisible(true);
        }
    }
}