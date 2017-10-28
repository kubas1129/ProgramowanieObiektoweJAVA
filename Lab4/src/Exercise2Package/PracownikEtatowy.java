package Exercise2Package;

/**
 * Created by kubas on 27.10.2017.
 */
public class PracownikEtatowy extends Pracownik {

    public PracownikEtatowy(int pes, double wyn, double pod) { super(pes,wyn,pod); }
    public PracownikEtatowy(int pes) { super(pes);}

    public double netto()
    {
        return wynagrodzenie * (100 - podatek) - 187;
    }
}
