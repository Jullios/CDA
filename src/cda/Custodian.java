package cda;

import pessoas.PacienteCda;

public class Custodian {
		
	private String custodian;
	
	public String createCustodian (PacienteCda pacienteCda){
		custodian = "<custodian>" + "\n";
		custodian = custodian + "<assignedCustodian>" + "\n" + 
					"<representedCustodianOrganization>" + "\n";
		custodian = custodian + "<id extension=" + "\"MPred\"" +" root=" +
					"\"2.16.840.1.113883.3.933\"" + "/>" + "\n";
		custodian = custodian + "<name>MyPred</name>" + "\n";
		custodian = custodian + "</representedCustodianOrganization>" + "\n" + "</assignedCustodian>" 
		 + "\n";
		return custodian + "</custodian>" + "\n";
	}
}
