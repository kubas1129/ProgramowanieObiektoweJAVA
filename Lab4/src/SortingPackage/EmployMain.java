package SortingPackage;

import java.util.*;

/**
 * Created by kubas on 20.10.2017.
 */
public class EmployMain {
    public static void main(String[] arg)
    {
        EmployList employes = new EmployList();
        employes.AddElement(new Employ(12,"Lucy"));
        employes.AddElement(new Employ(90,"Mark"));
        employes.AddElement(new Employ(8,"Jasmine"));

        employes.ShowEmployes();
        System.out.println("");
        Collections.sort(employes.list);
        System.out.println("");
        employes.ShowEmployes();
    }

}
