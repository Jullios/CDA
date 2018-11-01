package cda;

import pessoas.Paciente;
import pessoas.PacienteCda;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class ClinicalDocument {
	private String cda = "<?xml version=" + "\"1.0\"" + " encoding="+ "\"UTF-8\"?>" + "\n" + 
				"<ClinicalDocument classCode=\"DOCCLIN\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"urn:hl7-org:v3\">" 
				+ "\n";
	//MUDANDO LEITURA DE BYTES
	
	
	//-<ClinicalDocument classCode="DOCCLIN" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="urn:hl7-org:v3">
	private RecordTarget RecordTarget = new RecordTarget();
	private Custodian Custodian = new Custodian();
	private Author autor = new Author();
	private LegalAuthenticator LegalAuthenticator = new LegalAuthenticator();
	private RelatedDocument RelatedDocument = new RelatedDocument();
	private StructuredBody StructBody = new StructuredBody();
	
	public String CreateCda(Paciente paciente){
		
		Date d = new Date(System.currentTimeMillis());
		String s = d.toString();
		s = s.replaceAll("-", "");
		ParserPaciente parser = new ParserPaciente();
		PacienteCda pacienteCda = parser.parser(paciente);
		cda = cda + "<realmCode code=" + "'UV'" + "/>" + "\n";
		cda = cda + "<typeId root='2.16.840.1.113883.1.3' extension='ESC_MPD1'/>" + "\n";
		cda = cda + "<templateId root='2.16.840.1.113883.10.20.1'/>" + "\n";
		cda = cda + "<id root='M345' extension='2.16.840.1.113883.3.933'/>" + "\n";
		cda = cda + "<code code='410.9' displayName='Diagnostico utilizando " + pacienteCda.getAplicacao() +
				"' codeSystem='2.16.840.1.113883.6.103' codeSystemName='ICD-9-CM'/>" + "\n";
		cda = cda + "<effectiveTime value=\"" + s + "\"/>" + "\n"; //mudar para pegar a data do sistema.
		cda = cda + "<confidentialityCode code=\"N\" displayName='Normal' "
				+ "codeSystem='2.16.840.1.113883.5.25' codeSystemName='Confidentiality'/>" + "\n";
		cda = cda + "<setId extension=\"MM1\" root=\"2.16.840.1.113883.3.933\"/>" + "\n";
		cda = cda + "<versionNumber value=\"1\"/>" + "\n";
	//	cda = cda + "<copyTime value='20171003'/>" + "\n"; //pegar data do sistema.
		
		cda = cda + RecordTarget.createRecortTarget(pacienteCda);
		cda = cda + autor.createAuthor(pacienteCda);
		cda = cda + Custodian.createCustodian(pacienteCda);		//checar se pode retirar
		cda = cda + LegalAuthenticator.createLegalAuthenticator(pacienteCda);
		cda = cda + RelatedDocument.createRelatedDocument(pacienteCda);		//checar
		//checar como vai ficar a sess�o 'componentOf'
		cda = cda + StructBody.createBody(pacienteCda);
		cda = cda + "</ClinicalDocument>";
		
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(new File(pacienteCda.getId() + ".xml"));
			arquivo.write(cda);
			arquivo.close();
			System.out.println("Arquivo criado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cda;
	}
}
