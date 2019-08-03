package com.library.search.publisher;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class DataBaseManager {

    public ArrayList<Publisher> repoReader () {
        ArrayList<Publisher> publisherArrayList = new ArrayList<Publisher>();

        try {
            String fXmlFile = "src/main/webapp/WEB-INF/publishers.xml";
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("publisher");


            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    Publisher publisher = new Publisher();
                    publisher.setPublisherName(eElement.getElementsByTagName("publishername").item(0).getTextContent());
                    publisher.setPublishingCompany(eElement.getElementsByTagName("publishingcompany").item(0).getTextContent());
                    publisher.setAddress(eElement.getElementsByTagName("address").item(0).getTextContent());
                    publisherArrayList.add(publisher);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return publisherArrayList;
    }
}

