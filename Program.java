package cz.itnetwork.ZaverecnaPrace;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        ControlInsureds controlInsureds = new ControlInsureds();
        String resume = "";

        //hlavni cyklus
        while (!resume.equals("4")) {

            //vypis uvodniho menu
            System.out.printf(
                    "*************************%n" +
                            "   Evidence pojištěnců%n" +
                            "*************************%n%n" +
                            "Máte možnost:%n" +
                            "1 - Přidat nového pojištěnce%n" +
                            "2 - Výpis všech pojištěnců%n" +
                            "3 - Vyhledat pojištěnce%n" +
                            "4 - Konec%n%n" +
                            "Vyberte si akci: ");

            //nacteni volby
            resume = scanner.nextLine();
            System.out.println();

            //reakce na volbu
            switch (resume) {
                case "1" -> controlInsureds.insertPerson();
                case "2" -> controlInsureds.printPersons();
                case "3" -> controlInsureds.findPerson();
                case "4" -> resume = "4";
                default -> System.out.println("Neplatná volba.");
            }

            //pauza po vypisu vysledku
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }

            //odradkovani nove hlavicky
            System.out.printf("%n%n%n%n");
        }

    }
}