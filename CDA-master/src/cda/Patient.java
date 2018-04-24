package cda;

import pessoas.Paciente;

public class Patient {
		
	private String patient;
	
	public String createPatient(Paciente paciente){
		
		patient = "<patient>\n";
		patient = patient + "<name>" + "\n" + "<given>" + paciente.getNome() + "</given>" + "\n" + "<family>" + paciente.getSobrenome() + "</family>" + "\n" + "</name>" + "\n";
		patient = patient + "<administrativeGenderCode code=" + "\"" +paciente.getGenero() +"\"" + " codeSystem=\"" + "2.16.840.1.113883.5.1" + "\"/>" + "\n";
		
		if(paciente.getN_ano() != null){
			patient = patient + "<birthtime value=" + "\"" + paciente.getN_ano() + paciente.getN_mes() + paciente.getN_dia() + "\"/>" + "\n";
		}
		else {
			patient = patient + "<birthtime value=" + "\"UNK\"/>" + "\n";
		}
		
		patient = patient + "<maritalStatusCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<religiousAffiliationCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<raceCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<ethnicGroupCode nullFlavor=" + "\"UNK\"/>" + "\n";
		
		if(paciente.getLocalnascimento() != null){
			patient = patient + "<birthplace>" + "\n" + "<addr>" + paciente.getLocalnascimento() + "</addr>" + "\n" + "</birthplace>" + "\n";
		}else{
			patient = patient + "<birthplace nullFlavor = \"UNK\">"+ "\n";
		}	
		return patient + "</patient>" + "\n";
	}
	
}
 