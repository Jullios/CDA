package cda;

import pessoas.PacienteCda;

public class Patient {
		
	private String patient;
	
	public String createPatient(PacienteCda pacienteCda){
		
		patient = "<patient>\n";
		patient = patient + "<name>" + "\n"  + pacienteCda.getNome()+ "</name>" + "\n"; 
		//"</given>" + "</given>" + "\n" + "<family>" + pacienteCda.getSobrenome() + "</family>" + "\n". Pois o aplicativo não usa sobrenome.
		patient = patient + "<administrativeGenderCode code=" + "\"" +pacienteCda.getGenero() +"\"" + " codeSystem=\"" + "2.16.840.1.113883.5.1" + "\"/>" + "\n";
		
		
		
		patient = patient + "<maritalStatusCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<religiousAffiliationCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<raceCode nullFlavor=" + "\"UNK\"/>" + "\n";
		patient = patient + "<ethnicGroupCode nullFlavor=" + "\"UNK\"/>" + "\n";
		
		
		return patient + "</patient>" + "\n";
	}
	
}
 