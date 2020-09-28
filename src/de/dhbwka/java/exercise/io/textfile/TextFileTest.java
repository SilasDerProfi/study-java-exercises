package de.dhbwka.java.exercise.io.textfile;

/**
 * TextFileTest
 */
public class TextFileTest {

    private static final String path = "io/bla.txt";

    public static void main(String[] args) {

        try (TextFile tf = new TextFile(path)) {

            for (String s : tf.getLines())
                System.out.println(s);

            
            tf.replaceAll("meine", "unsre");
            for (String s : tf.getLines())
                System.out.println(s);

        }
    }
}