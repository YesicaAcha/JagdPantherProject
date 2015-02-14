package framework.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {

	public Map<String, String> getConfigurationData() {

		File fXmlFile = new File("C:\\Users\\Yesica Acha\\workspace\\JagdPanther\\configurationFile.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Map<String, String> map = new HashMap<String, String>();
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("FrameworkInformation");
			Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				map.put("USER_MAIL", eElement.getElementsByTagName("USER_MAIL").item(0).getTextContent());
				map.put("BROWSER", eElement.getElementsByTagName("BROWSER").item(0).getTextContent());
				map.put("PASSWORD", eElement.getElementsByTagName("PASSWORD").item(0).getTextContent());
				map.put("URL", eElement.getElementsByTagName("URL").item(0).getTextContent());
			}

			nList = doc.getElementsByTagName("DBInformation");
			nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;	
				map.put("DB_URL", eElement.getElementsByTagName("DB_URL").item(0).getTextContent());
				map.put("DB_USER", eElement.getElementsByTagName("DB_USER").item(0).getTextContent());
				map.put("DB_PASSWORD", eElement.getElementsByTagName("DB_PASSWORD").item(0).getTextContent());
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return map;
		
		
	}
	
	public String getData(String node, String tag) {

		File fXmlFile = new File("C:\\Users\\Yesica Acha\\workspace\\JagdPanther\\configurationFile.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		String value = "";
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(node);
			Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				value = eElement.getElementsByTagName(tag).item(0).getTextContent();	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return value;
	}
	
}
