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
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket s = null;
        PrintStream output;
        BufferedReader pesan;
        DataInputStream input;
        
        String info_login;

        try {
            s = new Socket("127.0.0.1", 212); //IPServer tujuan dan portnya
            output = new PrintStream(s.getOutputStream());
            pesan = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("-LOGIN-");
            
            //memasukkan username
            System.out.println("Username: ");
            output.println(pesan.readLine());
            
            //memasukkan password
            System.out.println("Password: ");
            output.println(pesan.readLine());
            
            //menerima input dr server
            input = new DataInputStream(s.getInputStream());
            
            info_login = input.readLine();
            System.out.println("notifikasi: " +info_login);

            input.close();
            output.close();
            s.close();
            
        } catch (IOException e) {
        }
    }

}
