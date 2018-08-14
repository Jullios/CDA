package cda;

import pessoas.PacienteCda;

public class RecordTarget {
	private String recordtarget;
	private PatientRole patientrole = new PatientRole();
	
	public String createRecortTarget(PacienteCda pacienteCda){
		recordtarget = "<recordTarget>" + "\n";
		recordtarget = recordtarget + patientrole.createPatientRole(pacienteCda);
		recordtarget = recordtarget + "</recordTarget>";
		return recordtarget + "\n";
	}
}
