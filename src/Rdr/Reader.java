package Rdr;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import pessoas.Paciente;
import pessoas.PacienteCda;

public class Reader {
	
	public static Paciente documentReader(){
		
		Patient patient = new Patient();
		Paciente paciente = new Paciente();
		PacienteCda pacienteCda = new PacienteCda();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder;
		
		try {
			builder = factory.newDocumentBuilder();		
			Document doc = builder.parse("C:\\Users\\julio\\Desktop\\Eng.comp\\p5\\predi\\teste\\teste.txt");
			pacienteCda = patient.createPaciente(doc);
			paciente = PatientBuild.build(pacienteCda);
			
			
			
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return paciente;
		
	}

}
