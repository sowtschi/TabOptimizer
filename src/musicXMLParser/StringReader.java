package musicXMLParser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StringReader {

	private NodeList stringElements;
	
	public StringReader(NodeList stringElements) {
		this.stringElements = stringElements;
	}
	
	public ArrayList<Integer> readStrings() {
		ArrayList<Integer> strings = new ArrayList<Integer>();
		for (int j=0; j<stringElements.getLength(); j++) {		
			Node stringElementsItem= stringElements.item(j);		
			if (stringElementsItem.getNodeType()== Node.ELEMENT_NODE) {		
				Element stringElement = (Element) stringElementsItem;			
				    try {
				    	if (stringElement.getNodeName().equals("string")) {
				    		if (Integer.parseInt(stringElement.getTextContent())>6)
				    			throw new Error("Die maximale Anzahl von 6 Saiten wird in der eingelesenen Tabulatur nicht beruecksichtigt.");
							strings.add(Integer.parseInt(stringElement.getTextContent()));
				    	}	
				    } catch (NumberFormatException e) {
						System.out.println("Fehler! Ein String Element ist nicht korrekt definiert.");
						System.exit(1); // stop
				    }
			}
		}
		return strings;

	}

}
