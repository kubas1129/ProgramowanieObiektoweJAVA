package Exercise2Package;

import java.util.LinkedList;

/**
 * Created by kubas on 27.10.2017.
 */
public class Kadry {

    LinkedList<Pracownik> list = new LinkedList<Pracownik>();



    public void UsunPracownika(Pracownik p)
    {
        if(list.contains(p))
            list.remove(p);
    }




}
