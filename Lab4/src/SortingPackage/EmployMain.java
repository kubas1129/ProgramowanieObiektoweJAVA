package SortingPackage;


/**
 * Created by kubas on 20.10.2017.
 */
public class EmployMain {
    public static void main(String[] arg)
    {
        EmployList list = new EmployList();
        list.AddElement(new Employ(12));
        list.AddElement(new Employ(90));
        list.AddElement(new Employ(199));

        System.out.println(list.getElement(0));
    }

}
