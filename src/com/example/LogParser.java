package com.example;

import java.util.Collection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.StringReader;
import java.util.*;
public class LogParser {
    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        List<Integer> myList = new ArrayList<Integer>();
        try {

	
        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xml));
           Document doc= builder.parse(is);
	doc.getDocumentElement().normalize();

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("entry");

	//System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		//System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			String text = eElement.getElementsByTagName("message").item(0).getTextContent();
			if(text.equalsIgnoreCase(message)){
                //myList.add(Integer.parseInt(eElement.getAttribute("id")));
                myList.add(Integer.parseInt(eElement.getAttribute("id")));
            }
			//System.out.println("Staff id : " + eElement.getAttribute("id"));
			//System.out.println("message : " + eElement.getElementsByTagName("message").item(0).getTextContent());

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }   
       return myList;
    }
    
    public static void main(String[] args) throws Exception {
        String xml = 
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<log>\n" + 
                "    <entry id=\"1\">\n" + 
                "        <message>Application started</message>\n" + 
                "    </entry>\n" + 
                "    <entry id=\"2\">\n" + 
                "        <message>Application ended</message>\n" + 
                "    </entry>\n" + 
                "</log>";
        
        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for(int id: ids)
            System.out.println(id); 
    }
}
