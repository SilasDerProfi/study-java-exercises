package de.dhbwka.java.exercise.xml;

import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Gazetteer
 */
public class Gazetteer {

    public static void main(String[] args) {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder parser = factory.newDocumentBuilder();
            String url = "https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml";
            Document doc = parser.parse(url);

            System.out.println("Adresse:   " + doc.getElementsByTagName("formatted_address").item(0).getTextContent());
            System.out.println("Long Name: " + doc.getElementsByTagName("long_name").item(0).getTextContent());

            NodeList lat = doc.getElementsByTagName("lat");
            NodeList lng = doc.getElementsByTagName("lng");

            System.out.printf("Location:  (latitude=%s, longitude=%s)\r\n", lat.item(0).getTextContent(), lng.item(0).getTextContent());
            System.out.printf("Bounds:    (east=%s, north=%s, west=%s, south=%s)\r\n", lng.item(4).getTextContent(),
                    lat.item(4).getTextContent(), lng.item(3).getTextContent(), lat.item(3).getTextContent());

        } catch (ParserConfigurationException | SAXException | IOException | DOMException ex) {
            System.err.println(ex.getMessage());
        }
    }
}