package cda;

import pessoas.PacienteCda;

public class PatientRole {
		private String patientrole;
		/*
		   <id extension="123" root="2.16.840.1.113883.3.933"/>
		   <addr>rua ufal, n 465</addr>
		   <telecom value="+55(81)99954684"/>
		*/
		private Patient patient = new Patient();
	public String createPatientRole(PacienteCda pacienteCda){
		
		patientrole = "<patientRole>" + "\n";
		patientrole = patientrole + "<id extension=" + "\""+ pacienteCda.getId() + "\""  +  " root=\"2.16.840.1.113883.3.933\"/>" + "\n";
		
		if(pacienteCda.getEndereco() != null){
			patientrole = patientrole + "<addr>" + pacienteCda.getEndereco() + "</addr>" + "\n";
		}else{
			patientrole = patientrole + "<addr nullFlavor = \"UNK\"/>" + "\n";
		}
		if(pacienteCda.getNumero() != null){
			patientrole = patientrole + "<telecom value=\"+55";
			if(pacienteCda.getDdd() != null){
				patientrole = patientrole + "(" + pacienteCda.getDdd() + ")"; 
			}
			patientrole = patientrole + pacienteCda.getNumero() + "\"/>" + "\n";
		}else{
			patientrole = patientrole + "<telecom nullFlavor = \"UNK\"/>" + "\n";
		}
		patientrole = patientrole +  patient.createPatient(pacienteCda);
		return patientrole + "<providerOrganization>" + "\n" + "<id extension=" + "\"MPred\"" + 
				   " root=" + "\"2.16.840.1.113883.3.933\"" + "/>" +"\n" +"</providerOrganization>" + "\n" + "</patientRole>" + "\n";
	}
}
