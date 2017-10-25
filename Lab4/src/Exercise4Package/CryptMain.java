package Exercise4Package;


public class CryptMain {
    public static void main(String[] arg)
    {
        ROT11 r = new ROT11();
        System.out.println(r.decrypt(r.crypt("abcdefghijklmnopqrtsuvwxyz")));
    }
}
