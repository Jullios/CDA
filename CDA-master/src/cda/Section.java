package cda;

public class Section {
	
	private String title;
	private String text;
	private String list;
	private String item;
	private String s_st;
	
	
	public String createSection(Section section){
		s_st = "<section>\n" + "<title>" + section.title + "</title>\n";
		s_st = s_st + "<text>\n" + "<list>\n" + "<item>\n" + "<content>" + section.item + "</content>\n" + "</item>" + "</list>" + "</text>" + "</section>";
		
		return s_st;
	}

}
