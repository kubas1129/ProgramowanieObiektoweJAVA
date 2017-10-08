/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginHasloPackage;

import java.io.*;
/**
 *
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv){
      Login log = new Login ("ala", "makota");
	  try{
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(rd);

        System.out.println("Login: ");
		String login = bfr.readLine();
		System.out.println("Haslo: ");
        String haslo = bfr.readLine();

        System.out.println("Dane poprawne: " + log.check(login,haslo));

	  }catch(IOException e){e.printStackTrace();}

    }
}
