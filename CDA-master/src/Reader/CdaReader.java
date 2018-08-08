package Reader;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pessoas.Paciente;

public class CdaReader {

	public static void main(String[] args) {
		
		Paciente patient = new Paciente();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:\\Users\\julio\\Desktop\\Eng.comp\\p5\\predi\\teste\\143.xml");
			
			NodeList RecordTarget = doc.getElementsByTagName("recordTarget");	//LISTA DE RECORD TARGET
			
			Node atual = RecordTarget.item(0);
			
			if(atual.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) atual;
				System.out.println(element.getTagName());	//RECORD TARGET
				NodeList filhos = element.getChildNodes();
				
				int len = filhos.getLength();
				
				System.out.println(len);	//3
				
				for(int i = 0; i < len; i++)
				{
					Node f = filhos.item(i);
					
					if(f.getNodeType() == Node.ELEMENT_NODE)
					{
						Element elementf = (Element) f;
						System.out.println(elementf.getTagName());	//PATIENT ROLE
						switch(elementf.getTagName()){
						case "patientRole":
							NodeList ffl = elementf.getChildNodes();
							for(int k =0; k < ffl.getLength(); k++)
							{
								Node ffa = ffl.item(k);
								if(ffa.getNodeType() == Node.ELEMENT_NODE)
								{
									Element ff = (Element) ffa;
									System.out.println(ff.getTagName() + " " + ff.getTextContent());
									
								}
							}
							break;
						case "providerOrganization":
							NodeList ffl1 = elementf.getChildNodes();
							for(int k = 0; k < ffl1.getLength(); k++)
							{
								Node ffa1 = ffl1.item(k);
								if(ffa1.getNodeType() == Node.ELEMENT_NODE)
								{
									Element ff = (Element) ffa1;
									System.out.println(ff.getTagName() + " " + ff.getTextContent());
								}
							}
							break;
						}
					}
					
				}
			
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
