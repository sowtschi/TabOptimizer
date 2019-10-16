package musicXMLParser;

import java.awt.List;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import models.Timestep;
import models.TimestepObjects;

public class TimestepCreator {
	
	private ArrayList<Integer> strings = new ArrayList<Integer>();
	private ArrayList<Integer> frets = new ArrayList<Integer>();
	private ArrayList<Integer> numberOfFretsPerTimestep;
	private ArrayList<Timestep> timesteps = new ArrayList<Timestep>();
	
	public ArrayList<Timestep> createTimesteps(Document musicXmlDocument) {
		NodeList stringElements = musicXmlDocument.getElementsByTagName("string");
		NodeList fretElements = musicXmlDocument.getElementsByTagName("fret");
		NodeList noteElements = musicXmlDocument.getElementsByTagName("note");
		
		StringReader stringReader = new StringReader(stringElements);
		FretReader fretReader = new FretReader(fretElements);
		TimestepEndsReader timestepEndsReader = new TimestepEndsReader(noteElements);
		
		this.strings = stringReader.readStrings();
		this.frets = fretReader.readFrets(); 
		
		checkStringsAndFretsSize();
		
		this.numberOfFretsPerTimestep = timestepEndsReader.findEndsOfTimesteps();
		
		TimestepObjectsBuilder timestepObjectsBuilder = new TimestepObjectsBuilder(strings, frets, numberOfFretsPerTimestep);
		timesteps = timestepObjectsBuilder.createTimestepObjects();
		
		TimestepObjects timestepObjects = new TimestepObjects(timesteps);
		timestepObjects.printTimesteps();
		
		return timesteps;
	}

	private void checkStringsAndFretsSize() throws Error {
		if (this.strings.size() != this.frets.size())
				throw new Error("Error: There is something wrong with you MusicXml File.");
	}


	

}
