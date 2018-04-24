package pessoas;

import java.util.LinkedList;

public class Components_p {
	private String title;	
	private LinkedList <String> itens = new LinkedList();
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LinkedList<String> getItens() {
		return itens;
	}
	public void setItens(LinkedList<String> itens) {
		this.itens = itens;
	}
}