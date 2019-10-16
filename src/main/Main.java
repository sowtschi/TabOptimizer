package main;

import javax.swing.text.StyleConstants.ColorConstants;

import org.w3c.dom.Document;

import musicXMLParser.MusicXMLParser;
import musicXMLParser.TimestepCreator;

public class Main {
	
	public final static int NUMBER_OF_STRINGS = 6;
	public static int TAB_NUMBER=-1;

    public static void main(String[] args){
    	MusicXMLParser musicXMLParser = new MusicXMLParser("EliminateTest.xml");
    	Document musicXmlDocument = musicXMLParser.readXMLFile();
    	
    	TimestepCreator timestepCreator = new TimestepCreator();
    	timestepCreator.createTimesteps(musicXmlDocument);
    	
    	
    }
	
}
