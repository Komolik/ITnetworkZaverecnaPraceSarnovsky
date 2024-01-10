package cz.itnetwork.ZaverecnaPrace;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class ControlInsureds {
    private static Scanner scanner = new Scanner(System.in, "UTF-8");

    private static ControlDatabase database;

    public ControlInsureds() {
        database = new ControlDatabase();
    }

    //zadani jmena/prijmeni
    private static String gateName(String whatName) {
        boolean correct = false;
        String name = null;
        while (!correct) {
            System.out.printf("Zadej %s: ", whatName);
            name = scanner.nextLine().trim();
            Predicate<String> jenPismena = (r) -> r.matches("[A-Za-záčďéěíóřšťúůýžÁČĎÉĚÍÓŘŠŤÚÝŽ]*");
            if ((jenPismena.test(name)) && (name.length() <= 20)) {
                correct = true;
            } else {
                System.out.printf("Nekorektní zadání. Použij maximálně 20 písmenných znaků.%n");
            }
        }
        return name;
    }

    //zadani veku
    private static int gateAge() {
        boolean correct = false;
        int age = 0;
        while (!correct) {
            System.out.print("Zadej věk: ");
            String ageStr = scanner.nextLine().trim();
            Predicate<String> cisla = (x) -> x.matches("[0-9]*");
            if (cisla.test(ageStr)) {
                age = Integer.parseInt(ageStr);
                if (age <= 130) {
                    correct = true;
                } else {
                    System.out.println("Věk musí být 0 - 130 let.");
                }
            } else {
                System.out.println("Nekorektní zadání. Použij jen číslice 0 - 9.");
            }
        }
        return age;
    }

    //zadani telefonu
    private static int gatePhone() {
        boolean correct = false;
        int phone = 0;
        while (!correct) {
            System.out.print("Zadej telefonní číslo: ");
            String phoneStr = scanner.nextLine().trim();
            Predicate<String> cisla = (x) -> x.matches("[0-9]*");
            if ((cisla.test(phoneStr)) && (phoneStr.length() == 9)) {
                phone = Integer.parseInt(phoneStr);
                correct = true;
            } else {
                System.out.println("Nekorektní zadání. Použij jen devět číslic z 0 - 9. Nezadávej provolbu.");
            }
        }
        return phone;
    }

    //pridani noveho pojistence
    public static void insertPerson() {
        String firstName = gateName("křestní jméno");
        String lastName = gateName("příjmení");
        if ((firstName.isEmpty()) || (lastName.isEmpty())) {
            System.out.println("Křestní jméno nebo příjmení nebylo vyplněno. Opakuj zadání.");
            insertPerson();
        } else {

            int age = gateAge();
            int phone = gatePhone();
            database.insertRegistration(firstName, lastName, age, phone);
            System.out.printf("%nNový pojištěnec byl uložen.%n");
        }
    }

    //zahlavi vypisu
    String title = String.format("Jméno               \tPříjmení            \tVěk  \tTelefon");

    //vypis vsech pojistencu
    public void printPersons() {
        System.out.println("Seznam pojištěnců: ");
        ArrayList<InsurePerson> completePersons = database.findPerson("x", "x", false);
        if (!completePersons.isEmpty()) {
            System.out.println(title);
            for (InsurePerson person : completePersons) {
                System.out.println(person);
            }
        } else {
            System.out.println("Žádný záznam nenalezen.");
        }
    }

    //vypis hledaneho pojistence
    public void findPerson() {
        String firstName = gateName("křestní jméno").toLowerCase();
        String lastName = gateName("příjmení").toLowerCase();
        ArrayList<InsurePerson> completePersons = database.findPerson(firstName, lastName, true);
        System.out.println("Nalezan tento pojištěnec: ");
        if (!completePersons.isEmpty()) {
            System.out.println(title);
            for (InsurePerson person : completePersons) {
                System.out.println(person);
            }
        } else {
            System.out.println("Žádný záznam nenalezen.");
        }
    }

}
