package uebung.kaffeemaschine;

public class Main {

	public static void main(String[] args) {

		if (ConsoleHelper.readChar("Einschalten? (j/n)", 'j', 'n') == 'j') {
			Kaffeemaschine k = new Kaffeemaschine();
			k.run();
		} else {
			System.out.println("Auf Wiedersehen");
		}
	}

}
