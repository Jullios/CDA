package cda;

import pessoas.Paciente;

public class ClinicalDocument {
	private String cda = "<?xml version=" + "\"1.0\"" + " encoding="+ "\"UTF-8\"?>" + "\n" + 
				"<ClinicalDocument classCode=\"DOCCLIN\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"urn:hl7-org:v3\"" 
				+ "\n";
	
	
	//-<ClinicalDocument classCode="DOCCLIN" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="urn:hl7-org:v3">
	private RecordTarget RecordTarget = new RecordTarget();
	private Custodian Custodian = new Custodian();
	private Author autor = new Author();
	private LegalAuthenticator LegalAuthenticator = new LegalAuthenticator();
	private RelatedDocument RelatedDocument = new RelatedDocument();
	private StructuredBody StructBody = new StructuredBody();
	
	public String CreateCda(Paciente paciente){
		cda = cda + "\n";
		cda = cda + RecordTarget.createRecortTarget(paciente);
		cda = cda + autor.createAuthor(paciente);
		cda = cda + Custodian.createCustodian(paciente);		//checar se pode retirar
		cda = cda + LegalAuthenticator.createLegalAuthenticator(paciente);
		cda = cda + RelatedDocument.createRelatedDocument(paciente);		//checar
		//checar como vai ficar a sessão 'componentOf'
		cda = cda + StructBody.createBody(paciente);
		cda = cda + "</ClinicalDocument>";
		return cda;
	}
}
