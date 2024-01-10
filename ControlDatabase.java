package cz.itnetwork.ZaverecnaPrace;

import java.util.ArrayList;

public class ControlDatabase {

    private ArrayList<InsurePerson> persons;

    //vytvori seznam pojistencu
    public ControlDatabase() {
        persons = new ArrayList<>();
    }

    //prida pojistence do seznamu
    public void insertRegistration(String firstName, String lastName, int age, int phone) {
        persons.add(new InsurePerson(firstName, lastName, age, phone));
    }

    //vytvori pole vsech pojistencu nebo podle hledani pojistence
    public ArrayList<InsurePerson> findPerson(String firstName, String lastName, boolean all) {
        ArrayList<InsurePerson> finds = new ArrayList<>();
        boolean firstBlank = firstName.isEmpty();
        for (InsurePerson person : persons) {
            String first = person.getFirstName().toLowerCase();
            String last = person.getLastName().toLowerCase();
            //podminka pusti i bez krestniho jmena i pro kompletni vypis
            if ((all && first.startsWith(firstName) && last.startsWith(lastName)) ||
                    (!all && firstName.equals(lastName)) ||
                    (all && firstBlank && last.startsWith(lastName))) {
                finds.add(person);
            }
        }
        return finds;
    }

}
