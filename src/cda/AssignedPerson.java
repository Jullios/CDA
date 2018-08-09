package cda;

public class AssignedPerson {
	
	private String nome, sobrenome;
	
	private String asw;
	
	
	public String assignedPerson(){
		
		asw = "<name>" +"\n";
		asw = asw + "<given>" +this.getNome()+ "</given>" + "\n";
		asw = asw + "</name>" + "\n" + "</assignedPerson>";
		return asw;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	

}
