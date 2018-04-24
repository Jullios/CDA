package cda;

import java.util.LinkedList;

import pessoas.Paciente;
import pessoas.Components_p;

public class Component {
	
	private String component;
	private LinkedList<String> itens;
	
	private Section section = new Section();
	
	
	public String createComponent(Components_p comp){
		
		component = "<component>\n";
		component = component + "<section>\n" + "<title>" + comp.getTitle() + "</title>\n";
		component = component + "<text>\n" + "<list>\n";
		itens = comp.getItens();
		for(int i = 0; i < itens.size(); i++)
		{
			component = component + "<item>\n" + "<content>" + itens.get(i) + "</content>\n" + "<item>\n";
			
		}
		component = component + "</list>\n" + "</text>\n" + "</section>\n";
		
		return component + "</component>\n";
	}

}
