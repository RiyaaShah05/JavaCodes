package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xml5 {

	public static void main(String args[]) throws IOException, SAXException, ParserConfigurationException {

		InputStream input =null;
		Properties prop = new Properties();
		input = new FileInputStream("C:\\Users\\SHrill\\eclipse-workspace\\example\\File\\Deletefiles1.properties");
		prop.load(input);

		String xml = prop.getProperty("xml");
		File dir = new File(xml);
		File[] file = dir.listFiles();
		Xml5 obj = new Xml5();
		obj.xmlReader(file);
	}

	private void xmlReader(File[] file) throws SAXException, IOException, ParserConfigurationException {

		for(File f:file) {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);
			doc.getDocumentElement().normalize();
			System.out.println("----------------------------");
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Icd10CmCode");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				HashMap<String, Integer> map = new HashMap<String, Integer>();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					NodeList n = eElement.getElementsByTagName("code");
					for (int i = 0; i < n.getLength(); i++) {
						Node node = n.item(i);
						System.out.println("Element :" + node.getNodeName());

						if (node.getNodeType() == Node.ELEMENT_NODE) {
							Element e = (Element) node;
							System.out.println("value : "  + e.getAttribute("value"));
							System.out.println("rank : "  + e.getAttribute("rank"));

							String v = e.getAttribute("value");
							int r = Integer.parseInt(e.getAttribute("rank"));
							map.put(v,r);
						}
					}
				}

				int maxValueInMap = Collections.max(map.values());  
				for (Entry<String, Integer> entry : map.entrySet()) {  
					if (entry.getValue()==maxValueInMap) {
						System.out.println("----------------------------");
						System.out.println("Max Rank:" +maxValueInMap+"\t"+"Value: "+entry.getKey());     
					}

				}
			}

		}
	}
}
