package de.dhbwka.database.bigdata.tfidf;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class Manager {
	public static final String DIRNAME = "io/alice/";
	public static final String TERM_PATTERN = "[a-zA-Z]+";
	private final List<Document> documents = new ArrayList<>();
	private final Vocabulary vocabulary = new Vocabulary();

	void loadDocuments() throws IOException {
		vocabulary.loadIgnoreWords();

		loadDocument("ch01.txt");
		loadDocument("ch02.txt");
		loadDocument("ch03.txt");
		loadDocument("ch04.txt");
		loadDocument("ch05.txt");
		loadDocument("ch06.txt");
		loadDocument("ch07.txt");
		loadDocument("ch08.txt");
		loadDocument("ch09.txt");
		loadDocument("ch10.txt");
		loadDocument("ch11.txt");
		loadDocument("ch12.txt");
	}

	private void loadDocument(String fileName) throws IOException {
		System.out.printf("Loading %s %n", fileName);
		var doc = new Document(fileName);
		documents.add(doc);

		var fileBytes = java.nio.file.Files.readAllBytes(Paths.get(Manager.DIRNAME, fileName));
		var fileContent = new String(fileBytes);

		try (var sc = new Scanner(fileContent)) {
			sc.findAll(TERM_PATTERN).map(MatchResult::group).filter(term -> !vocabulary.isIgnored(term))
					.forEach(doc::addTerm);
		}

	}

	void search(String query) {
		List<String> terms;
		try (var sc = new Scanner(query)) {
			terms = sc.findAll(TERM_PATTERN).map(MatchResult::group).collect(Collectors.toList());
		}

		for (var doc : documents) {
			// sum the weightened term frequency
			// Rarely occurring terms are weighted higher by the Inverse Document Frequency
			double relevance = terms.stream()
					.mapToDouble(term -> doc.getTermFrequency(term) * getInverseDocumentFrequency(term)).sum();

			final Double RELEVANCE_TOLERANCE = 1E-7;
			if (relevance > RELEVANCE_TOLERANCE) {
				System.out.printf("Relevance for %s in %s: %.6f%n", query, doc.getName(), relevance);
			}
		}
	}

	/**
	 * Defines a weighting for a term
	 * 
	 * Rarely occurring terms are weighted higher than common words.
	 * 
	 * The total number of documents is considered in relation to the number of
	 * documents in which the term is at least once occurs
	 */
	private double getInverseDocumentFrequency(String term) {
		int containingDocsCount = (int) documents.stream().filter(d -> d.contains(term)).count();

		if (containingDocsCount == 0)
			return 0;

		double allDocsCount = documents.size();
		return Math.log(allDocsCount / containingDocsCount);
	}
}