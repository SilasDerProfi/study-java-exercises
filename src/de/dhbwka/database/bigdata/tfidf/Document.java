package de.dhbwka.database.bigdata.tfidf;

import java.util.*;

/**
 * A Document with tokens (Terms)
 */
public class Document {
    private final String name;
    private final Map<String, Integer> termCount = new HashMap<>();
    private int vocabularyCount = 0;

    public Document(String name) {
        this.name = name;
    }

    public void addTerm(String term) {
        termCount.merge(term, 1, Integer::sum);
        vocabularyCount++;
    }

    /**
     * Normalized term frequency for term in the document
     */
    public double getTermFrequency(String term) {
        if (vocabularyCount == 0)
            return 0;

        return (double) termCount.getOrDefault(term, 0) / vocabularyCount;
    }

    public String getName() {
        return name;
    }

    public boolean contains(String term) {
        return termCount.containsKey(term);
    }
}
