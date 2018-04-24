package cda;

import pessoas.Paciente;

/*
 * <author>
   <time value="20171003"/>
   <assignedAuthor>
     	 <id root='2.16.840.1.113883.3.933' extension='CRM456546'/>
	 <assignedAuthoringDevice>
		<softwareName>…</softwareName>
	 </assignedAuthoringDevice>
    </assignedAuthor>	
  </author> 
 * */
public class Author {
		
	private String author;
	public String createAuthor(Paciente paciente){
		author = "<author>" + "\n";
		author = author + "<time value=" + "\"" + "data da criação"  + "\"" + "/>" + "\n";
		author = author + "<assignedAuthor>" + "\n" + "<id root='2.16.840.1.113883.3.933' extension='" 
				 + paciente.getAplicacao() + "'/>";
		author = author + "<assignedAuthoringDevice>" + "\n";
		author = author + "<softwareName>" + paciente.getAplicacao() + "</softwareName>" + "\n";
		author = author + "</assignedAuthoringDevice>" + "\n" + "</assignedAuthor>" + "\n";
		author = author + "</author>";
		return this.author + "\n";
	}
}
