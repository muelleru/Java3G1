package uebung.kaffeemaschine;

public class MenuItem {

	 
	private String text;
	private char key;
	private Object anhang;
	
	
	public MenuItem(char key, String text, Object anhang) {
		this.text = text;
		this.key = key;
		this.anhang = anhang;
	}

	public String getBefehl() {
		if( (anhang instanceof String) )
			return (String) anhang;
		else
			return "";
		
	}
	 
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public char getKey() {
		return key;
	}
	public void setKey(char key) {
		this.key = key;
	}
	
	public boolean istVerlassen() {
		
		return (anhang instanceof String) && ((String)anhang).equals("VERLASSEN");
		
	}
	
	public boolean istString() {
		
		return (anhang instanceof String);
		
	}
	
	public boolean istAdmin() {
		
		return (anhang instanceof String) && ((String)anhang).equals("ADMIN");
		
	}
	
	public boolean istArtikel() {
		
		return (anhang instanceof Artikel);
		
	}
	
	public Object getArtikel() {
		return anhang;
	}
	
}
