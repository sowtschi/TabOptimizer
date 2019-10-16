package musicXMLParser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import main.Main;

public class FretReader {

	private NodeList fretElements;
	
	public FretReader(NodeList fretElements) {
		this.fretElements = fretElements;
	}
	
	public ArrayList<Integer> readFrets() {
		ArrayList<Integer> frets = new ArrayList<Integer>();
		for (int j=0; j<fretElements.getLength(); j++) {		
			Node fretElementsItem= fretElements.item(j);		
			if (fretElementsItem.getNodeType()== Node.ELEMENT_NODE) {		
				Element fretElement = (Element) fretElementsItem;			
				    try {
				    	if (fretElement.getNodeName().equals("fret")) {	
							frets.add(Integer.parseInt(fretElement.getTextContent()));
				    	}	
				    } catch (NumberFormatException e) {
						System.out.println("Error: There is something wrong with your musicXML file.");
						System.exit(1); // stop
				    }
			}
		}
		return frets;
	}

}
