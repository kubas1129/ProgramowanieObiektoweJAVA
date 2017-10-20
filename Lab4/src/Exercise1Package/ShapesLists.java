package Exercise1Package;

import java.util.LinkedList;
import ShapePackage.*;

/**
 * Created by kubas on 20.10.2017.
 */
public class ShapesLists
{
    public LinkedList<Shape> list = new LinkedList<Shape>();

    public Shape getElement(int index){
        if(index < 0 || index  > list.size())
        {
            return null;
        }
        else
        {
            return list.get(index);
        }
    }

    public void AddElement(Shape shape)
    {
        list.add(shape);
    }

    public boolean RemoveElement(Shape shape)
    {
        if(list.contains(shape))
        {
            list.remove(shape);
            return true;
        }
        else
        {
            return false;
        }
    }
}

