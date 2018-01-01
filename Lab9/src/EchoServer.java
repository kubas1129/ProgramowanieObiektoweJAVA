import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum NETSTATE{
    WAITING_NONLOGIN,
    WAITING_LOGIN
}

class UserInfo{
    public int id_key;
    public String login;
    UserInfo(int key, String log)
    {
        id_key = key;
        login = log;
    }
}



public class EchoServer {
    public static void main(String[] args) throws IOException {

        NETSTATE netstate = NETSTATE.WAITING_NONLOGIN;
        LinkedList<UserInfo> userinfo = new LinkedList<UserInfo>();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            out.println(ExecuteCommand(inputLine,userinfo));
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static String ExecuteCommand(String command, LinkedList<UserInfo> UI)
    {
        String mainCommand="";

        int index=0;
        for(char c: command.toCharArray())
        {
            if(c != ' ')
            {
                mainCommand += c;
                index++;
            }
            else
            {
                index++;
                break;
            }

        }

        mainCommand.toUpperCase();

        switch (mainCommand)
        {
            case "LOGIN":
                return CommandLOGIN(command.substring(index, command.length()),UI);

        }

        return mainCommand;
    }

    public static String CommandLOGIN(String command, LinkedList<UserInfo> UI)
    {
        if(command.length() > 0)
        {
            String login="";
            String pass="";
            System.out.println(command);
            Pattern pattern = Pattern.compile("(.*);(.*)");
            Matcher matcher = pattern.matcher(command);
            if(matcher.find())
            {
                login = matcher.group(1);
                pass = matcher.group(2);
            }
            else
            {
                return "NULL";
            }

            try
            {
                BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\dict.txt"));
                String line;



                while ((line = br.readLine()) != null) {
                    if(line.equals(login + "/" + pass))
                    {
                        Random r = new Random();
                        int id = r.nextInt((99999-10000)+1)+10000;
                        UI.add(new UserInfo(id,login));
                        return ("ID="+String.valueOf(id));
                    }
                }
            } catch(IOException e) {e.printStackTrace();}

            return "User not found";
        }
        else
            return "No command property found!";
    }
}