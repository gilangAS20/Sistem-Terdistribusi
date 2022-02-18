/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//tugas 2 sister
/**
 *
 * @author ACER
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    
    public static void main(String[] args) {
        ServerSocket ss;
        Socket s;
        DataInputStream input;
        
        String username = "admin";
        String password = "admin";
        String pesan1, pesan2;
        try {
            ss=new ServerSocket(212); //ini port
            System.out.println("Server siap...");
            
            s = ss.accept(); // ini menghub s dengan ss
            System.out.println("Ada client yang hadir...");
            
            //menerima input dr client
            input = new DataInputStream(s.getInputStream());
            
            //kirim output ke client
            PrintStream output = new PrintStream(s.getOutputStream());
            
            //notifikasi input username password dari Client
            pesan1 = input.readLine();
            System.out.println("Client input username: " +pesan1);
            
            pesan2 = input.readLine();
            System.out.println("Client input password: " +pesan2);
            
            //cek username password
            if(pesan1.equals(username) && pesan2.equals(password))
                {
                    output.println("username dan password sesuai, login berhasil");
            
                }
            else
                {
                    output.println("username atau password salah");
                }
            
            
            output.close();
            input.close();
            s.close();
            ss.close();
            
        } catch (IOException e) {
        }
    }
}