package PointPackage;

import java.util.LinkedList;

/**
 * Created by kubas on 13.10.2017.
 */
public class Test {

    public static LinkedList<Point3D> points = new LinkedList<Point3D>();

    public static void main(String[] arg)
    {

        boolean exit = false;
        while(exit == false)
        {
            System.out.println("1. Wczytaj punkt 3D");
            System.out.println("2. Wyswietl wszystkie punkty");
            System.out.println("3. Oblicz odleglosc");
            System.out.println("4. Zakoncz");

            int choosedOption = 4;
            switch (Integer.parseInt(JIn.GetInput()))
            {
                case 1:
                    LoadPoint3D();
                    break;
                case 2:
                    ShowPoints3D();
                    break;
                case 3:
                    ComputeDistance();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    exit = true;
                    break;

            }
        }
    }


    public static void LoadPoint3D()
    {
        System.out.println("");

        double x,y,z;
        System.out.print("Podaj x: ");
        x = Integer.parseInt(JIn.GetInput());
        System.out.print("Podaj y: ");
        y = Integer.parseInt(JIn.GetInput());
        System.out.print("Podaj z: ");
        z = Integer.parseInt(JIn.GetInput());

        points.add(new Point3D(x,y,z));

        System.out.println("");


    }

    public static void ShowPoints3D()
    {
        System.out.println("");

        int number = 0;
        for(Point3D point : points)
        {
            System.out.println("#POINT_" + String.valueOf(number) + "# " + "{" + point.GetX() + "," + point.GetY() + "," + point.GetZ() + "}");
            number++;
        }

        System.out.println("");
    }

    public static void ComputeDistance()
    {
        System.out.println("");

        ShowPoints3D();

        int p1,p2;
        System.out.print("Podaj numer pierwszego punktu: ");
        p1 = Integer.parseInt(JIn.GetInput());
        System.out.print("Podaj numer drugiego punktu: ");
        p2 = Integer.parseInt(JIn.GetInput());

        double dist;

        if(p1 < 0 || p2 < 0 || p1 > points.size() || p2 > points.size())
        {
            System.out.println("Nieprawidlowe dane!");
        }
        else
        {
            System.out.println("Distance: " + points.get(p1).Distance(points.get(p2)));
        }
    }

}
