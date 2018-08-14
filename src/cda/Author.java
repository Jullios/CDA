package cda;

import pessoas.PacienteCda;

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
	public String createAuthor(PacienteCda pacienteCda){
		author = "<author>" + "\n";
		author = author + "<time value=" + "\"" + "20180425"  + "\"" + "/>" + "\n"; //pegar data do sistema.
		author = author + "<assignedAuthor>" + "\n" + "<id root='2.16.840.1.113883.3.933' extension='" 
				 + pacienteCda.getAplicacao() + "'/>";
		author = author + "<assignedAuthoringDevice>" + "\n";
		author = author + "<softwareName>" + pacienteCda.getAplicacao() + "</softwareName>" + "\n";
		author = author + "</assignedAuthoringDevice>" + "\n" + "</assignedAuthor>" + "\n";
		author = author + "</author>";
		return this.author + "\n";
	}
}
