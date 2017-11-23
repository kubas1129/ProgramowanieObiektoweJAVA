package DziedziczeniePackage;

public class Person {
    private String fullName;
    private int phone;
    private int pesel;

    public Person(String fullName, int phone, int pesel) {
        this.fullName = fullName;
        this.phone = phone;
        this.pesel = pesel;
    }


    public String getFullName() {
        return fullName;
    }

    public int getPhone() {
        return phone;
    }

    public int getPesel() {
        return pesel;
    }
}
