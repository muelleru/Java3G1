package uebung.kaffeemaschine;

import java.util.ArrayList;
import java.util.List;

public class Kaffeemaschine {

	private static final int MAX_BOHNEN = 5000;
	private static final int MAX_WASSER = 10000;
	private static final int MAX_MILCH = 3000;

	private int bohnen;
	private int milch;
	private int wasser;
	private double geld;
	private String passwort;

	private IPanel panel;
	private ArrayList<Artikel> artikel;
	private ArrayList<MenuItem> mainMenu;
	private ArrayList<MenuItem> adminMenu;

	public Kaffeemaschine() {
		this.passwort = "admin";
		this.bohnen = MAX_BOHNEN;
		this.milch = MAX_MILCH;
		this.wasser = MAX_WASSER;
		this.geld = 0;
		panel = new ConsolePanel();
		artikel = new ArrayList<Artikel>(List.of(new Artikel(1, 50, 100, 20, 1.5, "Kleiner Kaffee"),
				new Artikel(2, 100, 250, 50, 2.5, "Großer Kaffee"), new Artikel(3, 250, 75, 10, 2.0, "Espresso"),
				new Artikel(4, 100, 100, 100, 2.5, "Milchkaffee"), new Artikel(5, 200, 200, 200, 4, "Big Coffee")));

		mainMenu = new ArrayList<MenuItem>();
		adminMenu = new ArrayList<MenuItem>();

		char k = 'a';
		for (Artikel a : artikel) {
			mainMenu.add(new MenuItem(k++, a.getName(), a));
		}
		mainMenu.add(new MenuItem(k++, "Wartungsbereich", "ADMIN"));
		mainMenu.add(new MenuItem(k++, "Programm verlassen", "VERLASSEN"));

		k = 'a';
		adminMenu.add(new MenuItem(k++, "Füllstände", "STATUS"));
		adminMenu.add(new MenuItem(k++, "Bohnen auffüllen", "BOHNEN"));
		adminMenu.add(new MenuItem(k++, "Wasser auffüllen", "WASSER"));
		adminMenu.add(new MenuItem(k++, "Milch auffüllen", "MILCH"));
		adminMenu.add(new MenuItem(k++, "Geld abheben", "GELD"));
		adminMenu.add(new MenuItem(k++, "Passwort ändern", "PASSWORT"));
		adminMenu.add(new MenuItem(k++, "Adminbereich verlassen", "VERLASSEN"));

	}

	public void run() {
		boolean ok = true;
		while (ok) {
			panel.printMenu(mainMenu);
			try {
				MenuItem menuItem = panel.readInput(mainMenu);
				if (menuItem.istArtikel()) {
					Artikel a = (Artikel) menuItem.getArtikel();
					macheKaffee(a);

				} else if (menuItem.istAdmin()) {
					// panel.printMessage("ADMINBEREICH NICHT IMPLEMENTIERT");
					adminBereich();
				} else if (menuItem.istVerlassen()) {
					panel.printMessage("Maschine wird ausgeschaltet");
					ok = false;
					break;
				}
			} catch (Exception ex) {
				panel.printMessage("\\u26A0 FATALER FEHLER");
			}
		}

	}

	public boolean passwortAbfragen() {

		panel.printMessage("Bitte geben Sie das Admin-Passwort ein");
		String pw = panel.readString("Passwort");
		if (pw.equals(passwort)) {
			return true;
		} else {
			panel.printMessage("\u2139 Dummerle, Dein Passwort lautet: " + passwort);
			return false;
		}
	}

	public void passwortÄndern() {

		panel.printMessage("Admin-Passwort ändern");
		String pw1 = panel.readString("Neues Passwort");
		String pw2 = panel.readString("Wiederholung Neues Passwort");
		if (pw1.equals(pw2)) {
			panel.printMessage("\u2705 Admin-Passwort wurde geändert");
			passwort = pw1;

		} else {
			panel.printMessage("\u26A0 Keine Übereinstimmung!!!");
			panel.printMessage("\u26A0 Probieren Sie es später nochmal!!!");
		}

	}

	public String getStatus() {

		return String.format("*** STATUS ***\n" + "Geld:  %.2f €\n" + "Wasser: %6d ml\n" + "Bohnen: %6d g\n"
				+ "Milch:  %6d ml\n" + "****************", geld, wasser, bohnen, milch);

	}

	public void adminBereich() {
		boolean ok = true;
		if (passwortAbfragen()) {
			while (ok) {
				panel.printMenu(adminMenu);
				try {
					MenuItem menuItem = panel.readInput(adminMenu);
					if (menuItem.istVerlassen()) {
						panel.printMessage("Adminbereich verlassen");
						ok = false;
						break;
					} else if (menuItem.istString()) {
						switch (menuItem.getBefehl()) {
						case "STATUS":
							panel.printMessage(getStatus());
							break;
						case "BOHNEN":
							bohnen = MAX_BOHNEN;
							panel.printMessage("\u2705 BOHNEN AUFGEFÜLLT");
							panel.printMessage(getStatus());
							break;
						case "WASSER":
							wasser = MAX_WASSER;
							panel.printMessage("\u2705 WASSER AUFGEFÜLLT");
							panel.printMessage(getStatus());
							break;
						case "MILCH":
							milch = MAX_MILCH;
							panel.printMessage("\u2705 MILCH AUFGEFÜLLT");
							panel.printMessage(getStatus());
							break;
						case "GELD":
							geld = 0;
							panel.printMessage("\u2705 GELD ENTNOMMEN");
							panel.printMessage(getStatus());
							break;
						case "PASSWORT":
							passwortÄndern();
							break;
						case "VERLASSEN":
							ok = false;
							break;
						default:
							break;
						}
					}
				} catch (Exception ex) {
					panel.printMessage("\u26A0 FATALER FEHLER");
				}
			}
		} else {
			panel.printMessage("\u26A0 FALSCHES PASSWORT!!!");
		}
	}

	public boolean istKaffeeMöglich(Artikel k) {

		return (k.getBohnen() < getBohnen() && k.getWasser() < getWasser() && k.getMilch() < getMilch());

	}

	public void macheKaffee(Artikel k) {

		if (istKaffeeMöglich(k)) {

			panel.geldEinwurf(k.getPreis());
			panel.printMessage(k.getName() + " wird zubereitet");
			panel.progressbar(2000, '\u2615');
			bohnen -= k.getBohnen();
			wasser -= k.getWasser();
			milch -= k.getMilch();
			geld += k.getPreis();
			panel.printMessage(k.getName() + " wurde ausgegeben. Bitte Tasse entnehmen. \u2705");
			panel.sleep(1000);
		} else {
			panel.printMessage("Nicht genügend Ressourcen verfügbar \u26A0");
		}

	}

	public int getBohnen() {
		return bohnen;
	}

	public int getMilch() {
		return milch;
	}

	public int getWasser() {
		return wasser;
	}

	public double getGeld() {
		return geld;
	}

}
