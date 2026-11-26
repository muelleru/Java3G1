package uebung.kaffeemaschine;

import java.util.ArrayList;
import java.util.List;

public class ConsolePanel implements IPanel {

	public void printMessage(String s) {

		System.out.println(s);

	}

	@Override
	public void printMenu(List<MenuItem> mlist) {

		for (MenuItem mi : mlist) {
			System.out.printf("%s) %s\n", mi.getKey(), mi.getText());
		}

	}

	private List<Character> getKeys(List<MenuItem> menu) {

		ArrayList<Character> l = new ArrayList<Character>();
		for (MenuItem mi : menu) {
			l.add(mi.getKey());
		}
		return l;

	}

	@Override
	public MenuItem readInput(List<MenuItem> mlist) {
		char c = ConsoleHelper.readChar("Auswahl", getKeys(mlist));
		for (MenuItem mi : mlist) {
			if (mi.getKey() == c)
				return mi;
		}
		return null;
	}

	@Override
	public void geldEinwurf(double betrag) {
		double einwurf;
		double rest = betrag;
		do {
			einwurf = ConsoleHelper.readDouble(String.format("Bitte werfen Sie %.2f € ein", rest));
			if (einwurf < 0.0) {
				einwurf = 0.0;
				sleep(1000);
				System.out.println("Du bist ein Scherzkeks ... ");
			}
			rest-=einwurf;
			rest = Math.round(rest*100)/100.0;
		} while (rest > 0.0);
		if(rest < 0) {
			sleep(500);
			System.out.printf("Sie bekommen %.2f € Restgeld\n",-rest);
		}
	}

	@Override
	public String readString(String prompt) {
		 
		return ConsoleHelper.readString(prompt);
		
	}

	public   void sleep(int ms) {
		try {
			java.lang.Thread.sleep(ms);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public   void progressbar(int ms, char c) {
		try {
			for (int i = 1; i < 10; i++) {
				java.lang.Thread.sleep(ms / 10);
				System.out.print(c);
			}
			System.out.println();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
