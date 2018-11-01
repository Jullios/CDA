package Rdr;

import java.util.LinkedList;

import pessoas.Components_p;
import pessoas.Paciente;
import pessoas.PacienteCda;

public class PatientBuild {

	public static Paciente build(PacienteCda pacienteCda){
		Paciente patient = new Paciente();
		
		patient.setNome(pacienteCda.getNome());
		patient.setId(Integer.parseInt(pacienteCda.getId()));
		patient.setSexo(pacienteCda.getGenero());
		
		LinkedList <Components_p> comp = pacienteCda.getComponents();
		LinkedList <String> itens = null;
		
		System.out.println(comp.size());
		
		for(int i = 0; i < comp.size(); i++)
		{
			Components_p cmp = new Components_p();
			
			cmp = comp.get(i);
			if(cmp.getTitle() == null)
			{
				continue;
			}
			String item = null;
			switch(cmp.getTitle()){			//EXC
			
			case"Medidas":
				itens = cmp.getItens();
				for(int j = 0; j < itens.size(); j++)
				{
					item = itens.get(j);
					if(item.isEmpty())
					{
						continue;		//CHECARR
					}
					else{
						String[] parts = item.split(" ");
						if(parts[0].equals("Circunferencia:"))
						{
							patient.setCircunferencia(Double.parseDouble(parts[1]));
						}
						else if(parts[0].equals("Peso:"))
						{
							patient.setPeso(Double.parseDouble(parts[1]));
						}
						else if(parts[0].equals("Altura:"))
						{
							patient.setAltura(Double.parseDouble(parts[1]));
						}
						else if(parts[0].equals("IMC:"))
						{
							patient.setImc(Double.parseDouble(parts[1]));
						}
					}
					
				}
				break;
			case"Exames laboratoriais":
				itens = cmp.getItens();
				for(int j = 0; j < itens.size(); j++)
				{
					item = itens.get(j);
					
					if(item.isEmpty()){
						continue;
					}
					else{
						String[] exams = item.split(" ");
						if(exams[1].equals("em"))
						{
							patient.setGlicosejejum(Double.parseDouble(exams[3]));
						}
						else if(exams[1].equals("depois"))
						{
							patient.setGlicose75g(Double.parseDouble(exams[4]));
						}
						else if(exams[0].equals("Hemoglobina"))
						{
							patient.setHemoglobinaGlicolisada(Double.parseDouble(exams[2]));
						}
						else if(exams[0].equals("Colesterol "))
						{
							patient.setColesterol(Double.parseDouble(exams[2]));
						}
						
					}
					
				}
				break;
			
			}
		}
		
		return patient;
	}
	
	
	
	
}
