package Exercise2Package;

/**
 * Created by kubas on 27.10.2017.
 */
abstract public class Pracownik{

    public Pracownik(int pes, double wyn, double pod) { pesel = pes; wynagrodzenie = wyn; podatek = pod;}
    public Pracownik(int pes) {pesel = pes; }

    public int pesel;
    public double wynagrodzenie = 1200;
    public double podatek = 13.06;

    public double netto(){
        return wynagrodzenie = wynagrodzenie * (100-podatek);
    }

}
