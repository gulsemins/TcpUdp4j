import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPserver {
    public static void main(String[] args) throws IOException {

        String username = "test";
        String password = "1234";

        ServerSocket ss=new ServerSocket(5000);
        Socket s=ss.accept();
        System.out.println("client connected");

        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        String receivedUsername = bf.readLine();
        String receivedPassword = bf.readLine();

        if(receivedUsername.equals(username) && receivedPassword.equals(password)){
            pr.println("Welcome!");
        } else {
            pr.println("Invalid credentials!");
        }


        String message = bf.readLine();
        System.out.println("client: " + message);


        s.close();
        ss.close();



    }
}
