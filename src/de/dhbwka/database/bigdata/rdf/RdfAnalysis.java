package de.dhbwka.database.bigdata.rdf;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import org.eclipse.rdf4j.model.*;
import org.eclipse.rdf4j.model.impl.*;
import org.eclipse.rdf4j.rio.*;

public class RdfAnalysis {
    private static final String WEB_CRAWLER_FILE_PATH = "io/web-crawler-0001.rdf";
    private static final String TEST_URL = "http://data.linkedmdb.org/resource/film/7129";

    public static void main(String[] args) throws IOException {
        var testPage = SimpleValueFactory.getInstance().createIRI(TEST_URL);
        Model model;
        try (InputStream input = new FileInputStream(WEB_CRAWLER_FILE_PATH)) {
            model = Rio.parse(input, "", RDFFormat.NQUADS);
        }

        printLinksFromPage(model, testPage);
        printLinksToPage(model, testPage);
        printMostLinkedPage(model);
        printExternalLinkCount(model);
    }

    /**
     * Print links where Page is linker (where page is subject)
     */
    private static void printLinksFromPage(Model model, IRI page) {
        model.filter(page, null, null).forEach(st -> Rio.write(st, System.out, RDFFormat.TURTLE));
    }

    /**
     * Print links where Page is target (where page is object)
     */
    private static void printLinksToPage(Model model, IRI page) {
        model.filter(null, null, page).forEach(st -> Rio.write(st, System.out, RDFFormat.TURTLE));
    }

    private static void printMostLinkedPage(Model model) {
        Map<IRI, Integer> linkCount = new HashMap<>();
        var maxCount = 0;
        IRI maxCountURl = null;

        for (var st : model) {
            if ((st.getObject() instanceof IRI)) {
                // increment link count in hashmap
                int count = linkCount.merge((IRI) st.getObject(), 1, Integer::sum);
                if (count > maxCount) {
                    maxCount = count;
                    maxCountURl = (IRI) st.getObject();
                }
            }
        }
        System.out.printf("Max link count: %d für %s\r\n", maxCount, maxCountURl);
    }

    private static void printExternalLinkCount(Model model) {
        long countExtLinks = model.stream().filter(st -> isExternDomain(st.getSubject(), st.getObject()).orElse(false))
                .count();
        System.out.printf("Number of external links: %d\r\n", countExtLinks);
    }

    private static Optional<Boolean> isExternDomain(Value subject, Value object) {
        try {
            var aHost = new URL(((IRI) subject).toString()).getHost();
            var bHost = new URL(((IRI) object).toString()).getHost();
            return Optional.of(!aHost.equals(bHost));
        } catch (MalformedURLException | NullPointerException | ClassCastException e) {
            return Optional.of(false);
        }
    }
}
