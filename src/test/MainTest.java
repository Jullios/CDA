package test;

import java.util.LinkedList;

import cda.ClinicalDocument;
import pessoas.PacienteCda;
import pessoas.Components_p;
import pessoas.Paciente;



public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClinicalDocument cda = new ClinicalDocument();
		Paciente paciente = new Paciente();
		
		paciente.setId(2056);
		paciente.setNome("joao silva");
		paciente.setNascimento("20//01//1998");
		paciente.setSexo("M");
		
	//	paciente.setAltura(1.80);
		paciente.setCircunferencia(150);
		paciente.setPeso(70.6);
		paciente.setImc(26.2);
		paciente.setColesterol(0);
		paciente.setGlicose75g(89.2);
	//	paciente.setGlicosejejum(80);
		paciente.setHemoglobinaGlicolisada(42.2);
		
		
		
		cda.CreateCda(paciente);
	}

}
