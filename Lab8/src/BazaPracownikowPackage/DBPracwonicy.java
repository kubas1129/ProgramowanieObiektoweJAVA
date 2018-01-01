package BazaPracownikowPackage;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by kubas on 08.12.2017.
 */
public class DBPracwonicy {

    private static Connection conn = null;
    private  static Statement stat = null;
    private static ResultSet res = null;

    private static String login = "japalka";
    private static String pass = "b0MSik9rM8YJW9bB";

    public static boolean connected = false;

    public DBPracwonicy() {connect();}

    public DBPracwonicy(String username, String password)
    {
        login  =username;
        pass = password;
    }

    public void ConnectToDB(String username, String password)
    {
        login  =username;
        pass = password;
        connect();
    }

    public void connect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/japalka",login,pass);
        }
        catch (SQLException ex)
        {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            connected = false;
            return;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            connected = false;
            return;
        }
        connected =true;
    }


    public ArrayList<dataBaseStruct> listNames()
    {
        ArrayList<dataBaseStruct> ls = new ArrayList<dataBaseStruct>();
        try {
            connect();
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM pracownicy");

            while (res.next()) {
                try {

                    ls.add(new dataBaseStruct(res.getString(1),res.getString(2),res.getString(3)));
                }catch (NumberFormatException ex) {ex.printStackTrace();}
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException sqex) {
                    sqex.printStackTrace();
                }
                res = null;
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException sx) {
                    sx.printStackTrace();
                }
                stat = null;
            }
        }
        return ls;
    }



    public void InsertPool(String fname,String sname, String pesel)
    {
        try
        {
            connect();
            stat = conn.createStatement();
            String xd = "INSERT INTO pracownicy VALUES ('" + fname + "','" + sname + "','" + pesel + "')";
            res = stat.executeQuery(xd);

        } catch (SQLException ex) {ex.printStackTrace();}

        finally {
            if(res != null)
            {
                try
                {
                    res.close();
                } catch (SQLException sqex) { sqex.printStackTrace();}
                res=null;
            }

            if(stat != null)
            {
                try
                {
                    stat.close();
                } catch (SQLException sx) {sx.printStackTrace();}
                stat = null;
            }
        }
    }
}
