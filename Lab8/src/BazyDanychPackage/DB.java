package BazyDanychPackage;

import java.sql.*;

/**
 * Created by kubas on 01.12.2017.
 */
public class DB {

    private Connection conn = null;
    private Statement stat = null;
    private ResultSet res = null;

    private String login = "";
    private String pass = "";

    public DB(String username, String password)
    {
        login  =username;
        pass = password;
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
        }
        catch (Exception e) {e.printStackTrace();}
    }


    public void listNames()
    {
        try
        {
            connect();
            stat = conn.createStatement();

            res = stat.executeQuery("SELECT title FROM books");

            while(res.next())
            {
                System.out.println(res.getString(1));
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

    }




}
