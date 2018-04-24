package cda;
import pessoas.Paciente;

/*<legalAuthenticator>
	<time value="20171003"/>
	<signatureCode code="S"/>
	<assignedEntity>
		<id extension="CRM456546" root="2.16.840.1.113883.3.933"/>
		<representedOrganization>
			<name> ESC- ufal </name>
		</representedOrganization>
	</assignedEntity>
  </legalAuthenticator>
*/
public class LegalAuthenticator {
	private String legalauthenticator;
	
	public String createLegalAuthenticator(Paciente paciente){
		legalauthenticator = "<legalAuthenticator>" + "\n";
		legalauthenticator = legalauthenticator + "<time value=" + "\"" + "data de criação" + "\"" + "/>" + "\n";
		legalauthenticator = legalauthenticator + "<signatureCode code=\"S\"/>" + "\n";
		legalauthenticator = legalauthenticator + "<assignedEntity>" + "\n";
		legalauthenticator = legalauthenticator + "<id extension=" + "\"" + paciente.getAplicacao() + "\"" 
							 + " root=\"2.16.840.1.113883.3.933\"/>" + "\n";
		legalauthenticator = legalauthenticator + "<representedOrganization>" + "\n";
		legalauthenticator = legalauthenticator + "<name>" + paciente.getNomelab() + "</name>" + "\n";
		legalauthenticator = legalauthenticator + "</representedOrganization>" + "\n";
		legalauthenticator = legalauthenticator + "</assignedEntity>" + "\n";
		legalauthenticator = legalauthenticator + "</legalAuthenticator>";
	
		return this.legalauthenticator + "\n";
	}
}
