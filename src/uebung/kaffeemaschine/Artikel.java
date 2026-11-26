package uebung.kaffeemaschine;

public class Artikel {

	private int id;
	private int bohnen;
	private int milch;
	private int wasser;
	private String name;
	private double preis;
	
	public Artikel(int id, int bohnen, int milch, int wasser, double preis, String name) {
		 
		this.id = id;
		this.bohnen = bohnen;
		this.milch = milch;
		this.wasser = wasser;
		this.preis = preis;
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public int getBohnen() {
		return bohnen;
	}
	public void setBohnen(int bohnen) {
		this.bohnen = bohnen;
	}
	public int getMilch() {
		return milch;
	}
	public void setMilch(int milch) {
		this.milch = milch;
	}
	public int getWasser() {
		return wasser;
	}
	public void setWasser(int wasser) {
		this.wasser = wasser;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	
	
}
