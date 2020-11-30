package de.dhbwka.database.bigdata.tfidf;

import java.io.IOException;

public class TermFrequencyTest {

    public static void main(String[] args) {

        var manager = new Manager();

        try {
            manager.loadDocuments();
        } catch (IOException e) {
            System.err.println("An exception occurred while reading the documents");
            System.err.printf("Exception: %s %n", e);
        }

        manager.search("frowning");
        manager.search("wonder");
        manager.search("pale house");
        manager.search("Off with her head");
    }
}
