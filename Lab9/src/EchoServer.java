import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoServer {

    static LinkedList<UserInfo> userinfo = new LinkedList<UserInfo>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true){
            final Socket socket = serverSocket.accept();
            Runnable connection = new Runnable() {
                @Override
                public void run() {

                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        String line = bufferedReader.readLine();
                        while (!line.equals("exit")){
                            bufferedWriter.write(ExecuteCommand(line,userinfo));
                            bufferedWriter.write("\n");
                            bufferedWriter.flush();
                            line = bufferedReader.readLine();
                        }
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            executorService.submit(connection);
        }
    }

    public static String ExecuteCommand(String command, LinkedList<UserInfo> userinfo)
    {
        String mainCommand="";
        String parameters = "";

        Pattern pt = Pattern.compile("(.*) (.*)");
        Matcher mt = pt.matcher(command);
        if(mt.find())
        {
            mainCommand = mt.group(1);
            parameters = mt.group(2);
        }

        mainCommand = mainCommand.toUpperCase();
        System.out.println(mainCommand);

        switch (mainCommand)
        {
            case "LOGIN":
                return CommandLOGIN(parameters,userinfo);
            case "LOGOUT":
                return CommandLOGOUT(parameters,userinfo);
            case "LS":
                if(parameters.equals("USERS"))
                    return CommandWHO(userinfo);
                else
                    return CommandLS(parameters,userinfo);
            default:
                return "Nieznana komenda!";
        }
    }

    public static String CommandLOGIN(String command, LinkedList<UserInfo> UI)
    {
        if(command.length() > 0)
        {
            String login="";
            String pass="";
            //System.out.println(command);
            Pattern pattern = Pattern.compile("(.*);(.*)");
            Matcher matcher = pattern.matcher(command);
            if(matcher.find())
            {
                login = matcher.group(1);
                pass = matcher.group(2);
            }
            else
            {
                return "Nieznane parametry!";
            }

            try
            {
                BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\dict.txt"));
                String line;

                while ((line = br.readLine()) != null) {
                    if(line.equals(login + "/" + pass))
                    {
                        for(UserInfo ui : UI)
                        {
                            if(ui.login.equals(login))
                                return "Uzytkownik juz zalogowany";
                        }

                        Random r = new Random();
                        int id = r.nextInt((99999-10000)+1)+10000;
                        UI.add(new UserInfo(id,login));
                        return ("ID="+String.valueOf(id));
                    }
                }
            } catch(IOException e) {e.printStackTrace();}

            return "Uzytkownik nie znaleziony!";
        }
        else
            return "No command property found!";
    }

    public static String CommandLOGOUT(String command, LinkedList<UserInfo> UI)
    {
        if(command.length() > 0)
        {
            String id;
            Pattern pattern = Pattern.compile("([0-9]*)");
            Matcher matcher = pattern.matcher(command);
            if(matcher.find())
            {
                id = matcher.group(1);
            }
            else
                return "Nieznane parametry!";

            for(UserInfo ui : UI)
            {
                if(ui.id_key == Integer.valueOf(id))
                {
                    UserInfo tmp = new UserInfo(ui.id_key,ui.login);
                    UI.remove(tmp);
                    return "Wylogowano.";
                }
            }

            return "Nie znaleziono ID!";
        }
        else
        {
            return "No command property found!";
        }
    }

    public static String CommandWHO(LinkedList<UserInfo> UI)
    {
        String out="";
        for(UserInfo ui:UI)
        {
            out += ui.login + ",";
        }
        if(out.length() == 0)
            return "Brak zalogowanych uzytkowników!";
        return out;
    }

    public static String CommandLS(String command, LinkedList<UserInfo> UI)
    {
        if(command.length() == 0)
            return "Brak parametrów!";
        for(UserInfo ui:UI)
        {
            if(ui.id_key == Integer.valueOf(command))
            {
                File dir = new File(System.getProperty("user.dir"));
                File[] files = dir.listFiles();
                String out="";
                for(File fl:files)
                {
                    if(fl.isFile())
                        out+=fl.getName()+";";
                }
                return out;
            }
        }
        return "Nieznane ID";
    }

}