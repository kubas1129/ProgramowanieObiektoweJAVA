package SortingPackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by kubas on 20.10.2017.
 */
public class EmployList{

    public List<Employ> list = new ArrayList<Employ>();

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

    public void ShowEmployes()
    {
        for(Employ em : list)
        {
            System.out.println(em.name + " : " + em.reveneu);
        }
    }


}
