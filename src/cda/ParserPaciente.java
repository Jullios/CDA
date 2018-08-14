package cda;

import java.util.LinkedList;

import pessoas.Components_p;
import pessoas.Paciente;
import pessoas.PacienteCda;

public class ParserPaciente {
		
	public PacienteCda parser(Paciente paciente){
		PacienteCda atual = new PacienteCda();
		atual.setId(Integer.toString(paciente.getId()));
		atual.setNome(paciente.getNome());
		atual.setGenero(paciente.getSexo());
		atual.setAplicacao("MyPred");
		atual.setEnderecolab("ufal");
		atual.setNomelab("ESC");
		
		String idade = paciente.getNascimento();
		String auxiliar[] = idade.split("//");
		
		atual.setN_dia(auxiliar[0]);
		atual.setN_mes(auxiliar[1]);
		atual.setN_ano(auxiliar[2]);
		
		Components_p medidas = new Components_p();
		medidas.setTitle("Medidas");
		
		LinkedList<String> med = new LinkedList();
		med.add("Circunferencia: " + Double.toString(paciente.getCircunferencia()) + " cm\n");
		med.add("Peso: " + Double.toString(paciente.getPeso()) + " Kg\n");
		med.add("Altura: " + Double.toString(paciente.getAltura()) + " m\n");
		med.add("IMC: " + Double.toString(paciente.getImc()) + "\n");
		
		medidas.setItens(med);
		
		Components_p laboratorio = new Components_p();
		laboratorio.setTitle("Exames laboratoriais");
		
		
		LinkedList<String> lab = new LinkedList();
		
		lab.add("Glicose em jejum: " + Double.toString(paciente.getGlicosejejum()) + " mg/dL\n");
		lab.add("Glicose depois de 75g: " + Double.toString(paciente.getGlicose75g()) + " mg/dL\n");
		lab.add("Hemoglobina glicolisada: " + Double.toString(paciente.getHemoglobinaGlicolisada()) + "%\n");
		
		laboratorio.setItens(lab);
		
		atual.setComponents(medidas);
		atual.setComponents(laboratorio);
		
		return atual;
	}
}
