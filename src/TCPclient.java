import java.io.*;
import java.net.Socket;

public class TCPclient  {
    public static void main(String[] args) throws IOException {

        Socket s=new Socket("localhost", 5000);

        //send message to server
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("hello from client");
        pr.flush();

        //read message from server
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server: " + str);


    }

}
