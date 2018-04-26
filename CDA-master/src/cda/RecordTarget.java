package cda;

import pessoas.Paciente;

public class RecordTarget {
	private String recordtarget;
	private PatientRole patientrole = new PatientRole();
	
	public String createRecortTarget(Paciente paciente){
		recordtarget = "<recordTarget>" + "\n";
		recordtarget = recordtarget + patientrole.createPatientRole(paciente);
		recordtarget = recordtarget + "</recordTarget>";
		return recordtarget + "\n";
	}
}
