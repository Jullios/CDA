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
		
		paciente.setId("143");
		paciente.setNome("joao");
		paciente.setSobrenome("meubom");
		paciente.setEndereco("rua ufal");
		paciente.setDdd("82");
		paciente.setNumero("99248985");
		paciente.setGenero("M");
		paciente.setN_ano("1995");
		paciente.setN_mes("05");
		paciente.setN_dia("02");
		paciente.setLocalnascimento("makina");
		paciente.setAplicacao("MyPred");
		paciente.setEnderecolab("ufal");
		paciente.setNomelab("ESC");
		
		Components_p comp1 = new Components_p();
		comp1.setTitle("Remedios");
		
		LinkedList<String> l1 = new LinkedList();
		l1.add("café");
		l1.add("chá");
		comp1.setItens(l1);
		
		Components_p comp2 = new Components_p();
		comp2.setTitle("Exercicios");
		
		LinkedList<String> l2 = new LinkedList();
		l2.add("Caminhada por dez minutos");
		l2.add("Flexões");
		comp2.setItens(l2);
		
		paciente.setComponents(comp1);
		paciente.setComponents(comp2);
		
		System.out.println(cda.CreateCda(paciente));
	}

}
