package SortingPackage;

import java.util.Comparator;
import java.util.LinkedList;


/**
 * Created by kubas on 20.10.2017.
 */
public class EmployList implements Comparator<Employ> {

    public LinkedList<Employ> list = new LinkedList<Employ>();

    public Employ getElement(int index){
        if(index < 0 || index  > list.size())
        {
            return null;
        }
        else
        {
            return list.get(index);
        }
    }

    public void AddElement(Employ employ)
    {
        list.add(employ);
    }

    public boolean RemoveElement(Employ employ)
    {
        if(list.contains(employ))
        {
            list.remove(employ);
            return true;
        }
        else
        {
            return false;
        }
    }


    @Override
    public int compare(Employ employ, Employ t1)
    {
        if(employ.reveneu > t1.reveneu)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
