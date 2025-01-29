import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {
    public static void main(String[] args) throws IOException {

        ServerSocket ss=new ServerSocket(5000);
        Socket s=ss.accept();
        System.out.println("client connected");

        //read message from client
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("client: " + str);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("hello from server");
        pr.flush();



    }
}
