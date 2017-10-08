/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginHasloPackage;
/**
 *
 * @author Szymon
 */
public class Login {
    private String login;
    private String password;

    public Login(String _login, String _password){
        login = _login;
        password = _password;
    }

    public boolean check(String _login, String _password){
        if(_login.equals(login) && _password.equals(password))
            return true;
        else
            return false;
    }

}
