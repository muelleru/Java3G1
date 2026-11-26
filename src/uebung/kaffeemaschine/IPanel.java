package uebung.kaffeemaschine;

import java.util.List;

public interface IPanel {
	public void printMenu(List<MenuItem> mlist);
	public void printMessage(String s);
	public MenuItem readInput(List<MenuItem> mlist);
	public void geldEinwurf(double betrag);
	public String readString(String prompt);
	public void sleep(int ms);

	public void progressbar(int ms, char c); 
}
