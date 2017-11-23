package DziedziczeniePackage;

import java.util.*;


public class dziedziczenieMain {
    public static void main(String[] args)
    {

        PersonTable person = new PersonTable();

        person.AddPerson(new Person("Mike",112,11223));
        person.AddPerson(new Person("James",342,11733));

        person.initInterface();

    }
}
