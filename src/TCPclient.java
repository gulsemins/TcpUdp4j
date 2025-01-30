import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPclient  {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket("localhost", 5000);

        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

        Scanner sc = new Scanner(System.in); // Reading from System.in

        System.out.println("Enter a username: ");
        String name = sc.nextLine();
        pr.println(name);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a password: ");
        String sifre = sc.nextLine();
        pr.println(sifre);  // Şifreyi gönder

        // Sunucudan gelen yanıtı al
        String response = bf.readLine();
        System.out.println("Server: " + response);

        // Eğer giriş başarılıysa, mesaj gönder
        if ("Welcome!".equals(response)) {
            pr.println("Hello from client!");
        }

        s.close();
        sc.close();

    }

}
