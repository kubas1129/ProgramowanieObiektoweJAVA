package DziedziczeniePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonTable {
    private List<Person> people = new ArrayList<Person>();

    public void AddPerson(Person a)
    {
        if(!people.contains(a))
            people.add(a);
        else
            System.out.println("Person already exists!");
    }

    public void RemovePerson(Person a)
    {
        if(people.contains(a))
            people.remove(a);
        else
            System.out.println("Person doesn't exist in list!");
    }

    public void initInterface()
    {
        while(true)
        {
            System.out.println("1.Pokaz liste osob");
            System.out.println("2.Wyjdz");

            Scanner in = new Scanner(System.in);
            int option = Integer.parseInt(in.nextLine());

            switch (option)
            {
                case 1:
                    for(Person p : people)
                        System.out.println(p.getFullName() + "," + p.getPesel() + "," + p.getPhone());
                    System.out.println("");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Nierozpoznane polecenie!");
                    break;
            }
        }
    }

}
