package musicXMLParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLFileReader {

	
	public Document readXMLFile(String pathToXMLFile) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			InputStream inputStream;
	        inputStream = new FileInputStream(pathToXMLFile);
	        Reader reader = new InputStreamReader(inputStream,"UTF-8");
	        InputSource is = new InputSource(reader);

	        is.setEncoding("UTF-8"); 
				
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is); 
			
			return doc;
		} catch (FileNotFoundException e) {
			System.out.println("File is not available.");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("Error while parsing the XML file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading the XML file.");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			System.out.println("Error: Parser config is wrong.");
			e.printStackTrace();
		}
		
		throw new Error("Parsing not possible.");

	}
}
