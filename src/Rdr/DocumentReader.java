package Rdr;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import pessoas.Components_p;
import pessoas.PacienteCda;

public class DocumentReader {

	public static void main(String[] args) {
		
		Patient patient = new Patient();
		PacienteCda pacienteCda = new PacienteCda();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		
			DocumentBuilder builder;
			try {
			
				builder = factory.newDocumentBuilder();
				Document doc = builder.parse("C:\\Users\\julio\\Desktop\\Eng.comp\\p5\\predi\\teste\\teste.txt");
				
				pacienteCda = patient.createPaciente(doc);
				
				System.out.println(pacienteCda.getNome() + " " + pacienteCda.getSobrenome());
				System.out.println(pacienteCda.getId());
				System.out.println(pacienteCda.getEndereco());
				System.out.println(pacienteCda.getNumero());
				System.out.println(pacienteCda.getGenero());
				
				
				LinkedList <Components_p> cp = new LinkedList<Components_p>();
				cp = pacienteCda.getComponents();
				System.out.println(cp.size());
				for(int i = 0; i < cp.size(); i++)
				{
					Components_p cp1 = cp.get(i);
					if(cp1.getTitle() != null)
					System.out.println("title " + cp1.getTitle());
					
					if(cp1.getItens() != null)
					{
						LinkedList<String> itens = cp1.getItens();
						for(int j = 0; j < itens.size(); j++)
						{
							System.out.println(itens.get(j));
						}
					}
					
					
				}
			
			
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
			catch (SAXException | IOException e) {
				e.printStackTrace();
			}
			
		
		
	}

}
