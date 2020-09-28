package de.dhbwka.java.exercise.threads.search;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * SearchEngine
 */
public class SearchEngine {
    static Thread runner;
    static int NTHREADS = 3;

    public static void main(String[] args) throws IOException {
        List<PageLoader> pageLoader = java.nio.file.Files.readAllLines(Paths.get("io/urls.txt")).stream()
                .map(u -> new PageLoader(u)).collect(Collectors.toList());

        ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

        pageLoader.forEach(exec::execute);

        while (pageLoader.size() > 0) {
            for (int i = pageLoader.size() - 1; i >= 0; i--) {
                if (pageLoader.get(i).pageLoaded()) {
                    System.out.printf("%.20s: %.140s \r\n", pageLoader.get(i).getUrl(),
                    pageLoader.get(i).getPageContent());
                    pageLoader.remove(i);
                }
            }
        }

    }
}