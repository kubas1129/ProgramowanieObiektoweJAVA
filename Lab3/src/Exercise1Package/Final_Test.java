package Exercise1Package;

import java.util.LinkedList;

public class Final_Test {
    final double var = 10.0f;

    public void ChangeVarValue()
    {
        //Nie mozna zmienic wartosci, poniewaz jest stala
        //var = 20.0f;
    }

    public void AddToList(final LinkedList<Double> list)
    {
        //Mozemy dodawac/usuwac elementy bo nie modyfikuja one
        //adresu listy, tylko jedynie jej wartosci
        list.add(new Double(10.0f));
    }
}
