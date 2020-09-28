package de.dhbwka.java.exercise.xml;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Grid
 */
public class Grid {

    public static void main(String[] args) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.newDocument();
        Element kml = doc.createElementNS("http://earth.google.com/kml/2.2", "kml");
        Element document = doc.createElement("Document");
        
        double lat = 49.006557;
        double lng = 8.365608;
        double offSet = 0.01;
        for(int i = 0; i < 25; i++)
        {
            Element placemark = doc.createElement("Placemark");

            Element name = doc.createElement("name");
            name.setTextContent((i+ 1)+"");
            placemark.appendChild(name);

            Element description = doc.createElement("description");
            description.setTextContent("Das ist ein Punkt");
            placemark.appendChild(description);
            
            Element coordinates = doc.createElement("coordinates");
            coordinates.setTextContent((lng + offSet * (i % 5)) + ", " + (lat + offSet * (i / 5)));
            Element point = doc.createElement("Point");

            point.appendChild(coordinates);
            placemark.appendChild(point);
            document.appendChild(placemark);
        }
        
        kml.appendChild(document);
        doc.appendChild(kml);

        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            tr.transform(new DOMSource(doc), 
                                 new StreamResult(new FileOutputStream("io/ka_grid_ssn.kml")));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}