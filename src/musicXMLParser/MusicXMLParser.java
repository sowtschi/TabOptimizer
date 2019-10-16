package musicXMLParser;

import org.w3c.dom.Document;

public class MusicXMLParser {
	
	private String tabPath;

	public MusicXMLParser(String tabPath) {
		this.tabPath=tabPath;
	}
	
	public Document readXMLFile() {
		XMLFileReader xmlFileReader = new XMLFileReader();
		return xmlFileReader.readXMLFile(tabPath);
	}

}
