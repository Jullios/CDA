package cda;

import pessoas.Paciente;

public class RecordTarget {
	private String recordtarget;
	private PatientRole patientrole = new PatientRole();
	
	public String createRecortTarget(Paciente paciente){
		recordtarget = "<recordTarget>" + "\n";
		recordtarget = recordtarget + patientrole.createPatientRole(paciente);
		recordtarget = recordtarget + "<providerOrganization>" + "\n" + "<id extension=" + "\"MPred\"" + 
					   " root=" + "\"2.16.840.1.113883.3.933\"" + "/>" +"\n" +"</providerOrganization>" + "\n";	
		recordtarget = recordtarget + "</recordTarget>";
		return recordtarget + "\n";
	}
}
