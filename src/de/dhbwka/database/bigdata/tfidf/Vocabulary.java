package de.dhbwka.database.bigdata.tfidf;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class Vocabulary {
	private static final String IGNORE_WORDS_FILE_NAME = "ignore_words.txt";
	private Set<String> ignoreWords = new HashSet<>();

	public boolean isIgnored(String term) {
		return ignoreWords.contains(term);
	}

	public void loadIgnoreWords() throws IOException {
		var fileBytes = java.nio.file.Files.readAllBytes(Paths.get(Manager.DIRNAME, IGNORE_WORDS_FILE_NAME));
		var fileContent = new String(Arrays.toString(fileBytes));

		try (var scanner = new Scanner(fileContent)) {
			ignoreWords = scanner.findAll(Manager.TERM_PATTERN).map(MatchResult::group).collect(Collectors.toSet());
		}
	}
}
