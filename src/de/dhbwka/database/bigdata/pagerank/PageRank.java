package de.dhbwka.database.bigdata.pagerank;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.*;

public class PageRank {
	private static final int ITERATION_COUNT = 10;
	public static final String DIRNAME = "io/pagerank/";

	public static final String INPUTFILE = "example1.rdf";
	public static final String OTHER_INPUTFILE = "example2.rdf";

	public static final double ALPHA = 0;
	public static final double OTHER_ALPHA = 0.15;

	public static void main(String args[]) {
		try (InputStream input = new FileInputStream(DIRNAME + INPUTFILE)) {
			Model model = Rio.parse(input, "", RDFFormat.NQUADS);
			System.out.println("Model loaded");

			// Collect subjects, objects and links from our pages into a hashmap
			Map<String, WebPage> pageMap = new HashMap<>();

			for (var st : model) {
				var objectString = st.getObject().stringValue();
				var subjectString = st.getSubject().stringValue();
				var subject = pageMap.computeIfAbsent(subjectString, WebPage::new);
				var object = pageMap.computeIfAbsent(objectString, WebPage::new);
				subject.addLinkTo(object);
			}
			System.out.println("Found " + pageMap.size() + " web pages");

			// Put our pages into an array, so we can index them with an integer
			// Sort array to make matrix dumps look as in example
			var pageArray = pageMap.values().stream().sorted(Comparator.comparing(WebPage::getIrl))
					.toArray(WebPage[]::new);
			System.out.println();

			int pageCount = pageMap.size();
			// Create the matrix for iteration
			var matrix = new SquareMatrix(pageCount);
			for (int i = 0; i < matrix.totalSize(); i++) {
				var rowIndex = i / pageCount;
				var rowPage = pageArray[rowIndex];
				var columnIndex = i % pageCount;
				var columnPage = pageArray[columnIndex];

				if (columnPage.islinkedTo(rowPage))
					matrix.set(rowIndex, columnIndex, 1. / columnPage.getLinkCount());
			}
			// Apply ALPHA and dump
			matrix.multiply(1 - ALPHA);
			matrix.print();
			System.out.println();

			// Create the vector for iteration
			var vector = new Vector(pageCount, 1. / pageCount);
			vector.print();
			System.out.println();

			// Run some iterations
			for (int i = 0; i < ITERATION_COUNT; i++) {
				vector = matrix.multiply(vector);
				vector.addScalar(ALPHA / pageCount);
				vector.print();
			}
			System.out.println();

			// Print results
			for (int i = 0; i < pageCount; i++)
				System.out.printf("%4.1f %s%n", 100 * vector.get(i), pageArray[i].getIrl());

		} catch (IOException e) {
			System.err.println("An exception occurred while reading the documents");
			System.err.printf("Exception: %s %n", e);
		}
	}
}
