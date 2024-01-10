package cz.itnetwork.ZaverecnaPrace;

public class InsurePerson {

    private String firstName;   //krestni jmeno
    private String lastName;    //prijmeni
    private int agePerson;      //vek
    private int phoneNumber;    //telefon

    //definovani osoby
    public InsurePerson(String firstName, String lastName, int agePerson, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.agePerson = agePerson;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAgePerson() {
        return agePerson;
    }

    public void setAgePerson(int agePerson) {
        this.agePerson = agePerson;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //format vypisu pojistence
    @Override
    public String toString() {
        return String.format("%-20s\t%-20s\t%-5d\t%d", firstName, lastName, agePerson, phoneNumber);
    }
}
