package com.linkedin.commomUtil;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class readXMLfile {

	@org.testng.annotations.Test
	public void getTestData() {

		try {
			File inputFile = new File("/home/amit/git/CodeOfCritical/u/src/main/java/data/data1.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName().trim());

			NodeList nList = doc.getElementsByTagName("jobSeeker");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					// System.out.println("First Name: " + eElement.getAttribute("Fname"));
					System.out
							.println("First Name: " + eElement.getElementsByTagName("Fname").item(0).getTextContent());
					System.out
							.println("Last Name : " + eElement.getElementsByTagName("Lname").item(0).getTextContent());
					System.out
							.println("jobName : " + eElement.getElementsByTagName("jobName").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}