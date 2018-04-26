package cda;


import java.util.LinkedList;

import pessoas.Components_p;
import pessoas.Paciente;

public class StructuredBody {
	
	private String structurebody;
	private Component c = new Component();
	
	
	public String createBody(Paciente paciente){
	
		LinkedList<Components_p> pacientComponent = paciente.getComponents();
		structurebody = "<component>\n" + "<structuredBody>\n" + "<languageCode code=\"pt-BR\"/>\n";
		if(!pacientComponent.isEmpty())
		{
			for(int i = 0; i < pacientComponent.size(); i++){
				structurebody = structurebody + c.createComponent(pacientComponent.get(i));
			}
		
		}
	
		structurebody = structurebody + "</structuredBody>\n";
		return structurebody + "</component>\n";
	}

}
