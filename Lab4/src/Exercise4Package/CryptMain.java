package Exercise4Package;


import java.util.Scanner;

public class CryptMain {
    public static void main(String[] arg)
    {

        boolean exit = false;
        while(!exit)
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Crypt File");
            System.out.println("2. Decrypt File");
            System.out.println("3. Exit");

            int option = Integer.parseInt(sc.nextLine());

            if(option == 1 || option == 2) {
                System.out.println("1. ROT11 method");
                System.out.println("2. Polibius method");
                int method = Integer.parseInt(sc.nextLine());
                if (method == 1 || method == 2)
                {
                    if(option == 1 && method == 1)
                        Cryptographer.cryptfile(arg[1], arg[2], new ROT11());
                    if(option == 1 && method == 2)
                        Cryptographer.decryptfile(arg[1], arg[2], new Polibius());
                    if(option == 2 && method == 1)
                        Cryptographer.cryptfile(arg[1],arg[2], new ROT11());
                    if(option == 2 && method == 2)
                        Cryptographer.decryptfile(arg[1], arg[2], new Polibius());
                }
                else
                    exit = true;
            }
            else
                exit = true;
        }
    }
}
