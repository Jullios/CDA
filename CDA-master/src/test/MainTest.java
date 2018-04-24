package test;

import java.util.LinkedList;

import cda.ClinicalDocument;
import pessoas.Paciente;
import pessoas.Components_p;



public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClinicalDocument cda = new ClinicalDocument();
		Paciente paciente = new Paciente();
		
		paciente.setId("123");
		paciente.setNome("joao");
		paciente.setSobrenome("meubom");
		paciente.setEndereco("huehue");
		paciente.setDdd("082");
		paciente.setNumero("9924");
		paciente.setGenero("woman");
		paciente.setN_ano("1995");
		paciente.setN_mes("maio");
		paciente.setN_dia("02");
		paciente.setLocalnascimento("makina");
		paciente.setAplicacao("qual?");
		paciente.setEnderecolab("q lab?");
		paciente.setNomelab("wtf");
		
		Components_p comp1 = new Components_p();
		comp1.setTitle("comp1");
		
		LinkedList<String> l1 = new LinkedList();
		l1.add("tomar remedio oi");
		l1.add("tentar nao morrer");
		comp1.setItens(l1);
		
		Components_p comp2 = new Components_p();
		comp2.setTitle("comp2");
		
		LinkedList<String> l2 = new LinkedList();
		l2.add("nao tomar remedio");
		l2.add("testar depois");
		comp2.setItens(l2);
		
		paciente.setComponents(comp1);
		paciente.setComponents(comp2);
		
		System.out.println(cda.CreateCda(paciente));
	}

}
