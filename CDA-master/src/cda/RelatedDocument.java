package cda;

import pessoas.Paciente;

/*
 * <relatedDocument typeCode="RPLC">
	<parentDocument>
		<id extension="a123" root="2.16.840.1.113883.3.933"/>
		<setId extension="BB35" root="2.16.840.1.113883.3.933"/>
		<versionNumber value="1"/>
	 </parentDocument>
	</relatedDocument>
*/
public class RelatedDocument {
	private String relateddocument;
	
	public String createRelatedDocument(Paciente paciente){
		
		relateddocument = "<relatedDocument typeCode=\"RPLC\">" + "\n";
		relateddocument = relateddocument + "<parentDocument>" + "\n";
		relateddocument = relateddocument + "<id extension=" + "\"" + paciente.getId() + "\"" + " root=\"2.16.840.1.113883.3.933\"/>" + "\n";
		relateddocument = relateddocument + "<setId extension=\"BB35\" root=\"2.16.840.1.113883.3.933\"/>" + "\n"; //essa extensão não sei.
		relateddocument = relateddocument +	"<versionNumber value=\"1\"/>" + "\n";	
		relateddocument = relateddocument + "</parentDocument>" + "\n";
		relateddocument = relateddocument + "</relatedDocument>";
		
		return this.relateddocument + "\n";
	}
}
