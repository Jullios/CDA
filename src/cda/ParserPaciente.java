package cda;

import java.util.LinkedList;

import pessoas.Components_p;
import pessoas.Paciente;
import pessoas.PacienteCda;

public class ParserPaciente {
		
	public PacienteCda parser(Paciente paciente){
		PacienteCda atual = new PacienteCda();
		if(paciente.getId() != -1)
		atual.setId(Integer.toString(paciente.getId()));
		if(paciente.getNome() != null)
		atual.setNome(paciente.getNome());
		if(paciente.getSexo() != null)
		atual.setGenero(paciente.getSexo());
		atual.setAplicacao("MyPred Application");			//ALTERAR
		atual.setEnderecolab("UFAL");
	//	atual.setNomelab("ESC");
		
		if(paciente.getNascimento() != null)
		{
			String idade = paciente.getNascimento();		
			String auxiliar[] = idade.split("//");			
			atual.setN_dia(auxiliar[0]);
			atual.setN_mes(auxiliar[1]);
			atual.setN_ano(auxiliar[2]);
		}
		
		boolean k = false;
		Components_p medidas = new Components_p();
		LinkedList<String> med = new LinkedList();
		if(paciente.getCircunferencia() != -1)
		{
			med.add("Circunferencia: " + Double.toString(paciente.getCircunferencia()) + " cm\n");
			k = true;
		}
		if(paciente.getPeso() != -1)
		{
			med.add("Peso: " + Double.toString(paciente.getPeso()) + " Kg\n");
			k = true;
		}
		if(paciente.getAltura() != -1)
		{
			med.add("Altura: " + Double.toString(paciente.getAltura()) + " m\n");
			k = true;
		}
		if(paciente.getImc() != -1)
		{
			med.add("IMC: " + Double.toString(paciente.getImc()) + "\n");
			k = true;
		}
		if(k = true){
			medidas.setTitle("Medidas");
			medidas.setItens(med);
			atual.setComponents(medidas);
		}
			
			
		Components_p laboratorio = new Components_p();
		LinkedList<String> lab = new LinkedList();
		boolean k1 = false;
		
		if(paciente.getGlicosejejum() != -1)
		{
			lab.add("Glicose em jejum: " + Double.toString(paciente.getGlicosejejum()) + " mg/dL\n");
			k1 = true;
		}
		if(paciente.getHemoglobinaGlicolisada() != -1)
		{
			lab.add("Hemoglobina glicolisada: " + Double.toString(paciente.getHemoglobinaGlicolisada()) + " %\n");
			k1 = true;
		}
		if(paciente.getGlicose75g() != -1)
		{
			lab.add("Glicose depois de 75g: " + Double.toString(paciente.getGlicose75g()) + " mg/dL\n");
			k1 = true;
		}
		if(paciente.getColesterol() != -1)
		{
			lab.add("Colesterol: "+ Double.toString(paciente.getColesterol()) + " mg/dL\n");
			k1 = true;
		}
		if(k1 = true)
		{
			laboratorio.setTitle("Exames laboratoriais");
			laboratorio.setItens(lab);
			atual.setComponents(laboratorio);
		}
			
		return atual;
	}
}
