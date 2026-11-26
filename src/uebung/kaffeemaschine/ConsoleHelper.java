package uebung.kaffeemaschine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {

	public static int readInt(String prompt) {
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(prompt + ": ");
				String eingabe = s.nextLine();
				int zahl = Integer.parseInt(eingabe);
				return zahl;
			} catch (Exception ex) {
				System.out.println("Bitte eine Zahl eingeben!!");
			}
		}
	}

	public static double readDouble(String prompt) {
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(prompt + ": ");
				String eingabe = s.nextLine();
				double zahl = Double.parseDouble(eingabe);
				return zahl;
			} catch (Exception ex) {
				System.out.println("Bitte eine Zahl eingeben!!");
			}
		}
	}

	private static boolean IsIn(char c, char[] cliste) {
		for (char x : cliste) {
			if (x == c)
				return true;
		}
		return false;
	}

	private static boolean IsIn(char c, List<Character> cliste) {
		for (char x : cliste) {
			if (x == c)
				return true;
		}
		return false;
	}

	public static char readChar(String prompt, List<Character> gueltig) {
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(prompt + ": ");
				String eingabe = s.nextLine();
				char c = eingabe.charAt(0);
				if (IsIn(c, gueltig))
					return c;
				else
					System.out.println("Bitte eine gueltiges Zeichen eingeben "
							+ String.join(", ", gueltig.stream().map((Character x) -> x.toString()).toList()));
			} catch (Exception ex) {
				System.out.println("Bitte eine Zeichen eingeben!!");
			}
		}
	}

	public static char readChar(String prompt, char... gueltig) {
		ArrayList<Character> al = new ArrayList<Character>();
		for (char c : gueltig) {
			al.add(c);
		}
		return readChar(prompt, al);
	}

	public static String readString(String prompt) {
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(prompt + ": ");
				String eingabe = s.nextLine();
				if (eingabe != null && eingabe.length() > 0)
					return eingabe;
				else
					System.out.println("Bitte etwas eingeben!");
			} catch (Exception ex) {
				System.out.println("Bitte einen Text eingeben!!");
			}
		}
	}

	public static void printChar(char c, int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(c);
		}
	}

	public static void printlnChar(char c, int n) {
		printChar(c, n);
		System.out.println();
	}

	

}
