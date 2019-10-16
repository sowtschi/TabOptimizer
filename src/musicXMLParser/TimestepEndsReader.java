package musicXMLParser;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TimestepEndsReader {

	private NodeList technicalElements;
	private int chordCounter=0;
	private int stringCounter = 0;
	private ArrayList<Integer> numberOfTonesPerTimestep = new ArrayList<Integer>();

	public TimestepEndsReader(NodeList technicalElements) {
		this.technicalElements = technicalElements;
	}

	public ArrayList<Integer> findEndsOfTimesteps() {
		for (int i=0; i<technicalElements.getLength(); i++) {
			Node p= technicalElements.item(i);
			
			if (p.getNodeType()== Node.ELEMENT_NODE) {
				Element note = (Element) p;
				NodeList notes2 = note.getChildNodes();
				
				for (int k=0; k<notes2.getLength(); k++) {
					Node p3= notes2.item(k);
					
					if (p3.getNodeType()== Node.ELEMENT_NODE) {
						Element note3 = (Element) p3;

						if (note3.getTagName().equals("notations"))  {
							reactOnNotation();
						}
						
						if (note3.getTagName().equals("chord")) {
							chordCounter++;	
						}	
					}
				}
			}
		}
		return numberOfTonesPerTimestep;
	}

	private void reactOnNotation() {
		if (stringCounter > chordCounter) {	
			numberOfTonesPerTimestep.add(stringCounter);
			chordCounter=0;
			stringCounter=0;
		}
		stringCounter++;
	}

	
	public void findChordElements() {
		
	}

}
