package SortingPackage;


import java.util.Comparator;

/**
 * Created by kubas on 20.10.2017.
 */
public class Employ implements Comparator<Employ>, Comparable<Employ>{

    public int reveneu = 0;
    public String name = "";

    public Employ(int rev, String name_) { reveneu = rev; name = name_;}


    @Override
    public int compare(Employ o1, Employ o2) {
        return o1.reveneu - o2.reveneu;
    }

    @Override
    public int compareTo(Employ o) {
        return this.reveneu - o.reveneu;
    }
}
