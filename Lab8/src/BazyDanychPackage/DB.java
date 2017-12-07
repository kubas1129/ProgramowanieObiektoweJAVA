package BazyDanychPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kubas on 01.12.2017.
 */
public class DB {

    private static Connection conn = null;
    private  static Statement stat = null;
    private static ResultSet res = null;

    private static String login = "";
    private static String pass = "";

    public static boolean connected = false;

    public DB(String username, String password)
    {
        login  =username;
        pass = password;
    }

    public static void ConnectToDB(String username, String password)
    {
        login  =username;
        pass = password;
        connect();
    }

    private static void connect()
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


    public static ArrayList<dataBaseStruct> listNames()
    {
        ArrayList<dataBaseStruct> ls = new ArrayList<dataBaseStruct>();
        try {
            connect();
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM books");

            while (res.next()) {
                ls.add(new dataBaseStruct(res.getString(2),res.getString(3),Integer.parseInt(res.getString(4))));
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



    public static ArrayList<dataBaseStruct> listFound(String name)
    {
        ArrayList<dataBaseStruct> ls = new ArrayList<dataBaseStruct>();
        try
        {
            connect();
            stat = conn.createStatement();

            res = stat.executeQuery("SELECT * FROM books WHERE author='" + name + "'");

            while(res.next())
            {
                ls.add(new dataBaseStruct(res.getString(2),res.getString(3),Integer.parseInt(res.getString(4))));
            }
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

        return ls;
    }



}


