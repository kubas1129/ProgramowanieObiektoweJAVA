package Exercise2Package;

/**
 * Created by kubas on 27.10.2017.
 */
public class Student extends Pracownik {

    public Student(int pes, double wyn, double pod) { super(pes,wyn,pod);}
    public Student(int pes) { super(pes);}

    public double netto()
    {
        return wynagrodzenie * (100-podatek) + 460;
    }
}
