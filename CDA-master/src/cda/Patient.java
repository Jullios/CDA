package cda;

import pessoas.Paciente;

public class Patient {
		
	private String patient;
	
	public String createPatient(Paciente paciente){
		
		patient = "<patient>\n";
		patient = patient + "<name>" + "\n" + "<given>" + paciente.getNome() + "</given>" + "\n" + "<family>" + paciente.getSobrenome() + "</family>" + "\n" + "</name>" + "\n";
		patient = patient + "<administrativeGenderCode code=" + "\"" +paciente.getGenero() +"\"" + " codeSystem=\"" + "2.16.840.1.113883.5.1" + "\"/>" + "\n";
		
		
		
		patient = patient + "<maritalStatusCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<religiousAffiliationCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<raceCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<ethnicGroupCode nullFlavor=" + "\"UNK\"/>" + "\n";
		
		
		return patient + "</patient>" + "\n";
	}
	
}
 