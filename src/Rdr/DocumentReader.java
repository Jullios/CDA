package Rdr;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import pessoas.Components_p;
import pessoas.Paciente;
import pessoas.PacienteCda;

public class DocumentReader {

	public static void main(String[] args) {
		
		Paciente paciente = new Paciente();
		paciente = Reader.documentReader();
		
	}

}
