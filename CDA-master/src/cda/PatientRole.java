package cda;

import pessoas.Paciente;

public class PatientRole {
		private String patientrole;
		/*
		   <id extension="123" root="2.16.840.1.113883.3.933"/>
		   <addr>rua ufal, n 465</addr>
		   <telecom value="+55(81)99954684"/>
		*/
		private Patient patient = new Patient();
	public String createPatientRole(Paciente paciente){
		
		patientrole = "<patientRole>" + "\n";
		patientrole = patientrole + "<id extension=" + "\""+ paciente.getId() + "\""  +  " root=\"2.16.840.1.113883.3.933\"/>" + "\n";
		
		if(paciente.getEndereco() != null){
			patientrole = patientrole + "<addr>" + paciente.getEndereco() + "</addr>" + "\n";
		}else{
			patientrole = patientrole + "<addr nullFlavor = \"UNK\">" + "\n";
		}
		if(paciente.getNumero() != null){
			patientrole = patientrole + "<telecom value=\"+55";
			if(paciente.getDdd() != null){
				patientrole = patientrole + "(" + paciente.getDdd() + ")"; 
			}
			patientrole = patientrole + paciente.getNumero() + "\"/>" + "\n";
		}else{
			patientrole = patientrole + "<telecom nullFlavor = \"UNK\">" + "\n";
		}
		return patientrole + patient.createPatient(paciente) + "</patientRole>" + "\n";
	}
}
