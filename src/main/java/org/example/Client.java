package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 8090;
        try(Socket socket = new Socket(hostname, port)){

            //initiate communication with server
            //send message
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello server");

            //receive and read message
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            System.out.println("Server response : "+response);

        }catch(UnknownHostException ex){
            System.out.println("UnknownHostException "+ex.getMessage());
        }catch(IOException ex){
            System.out.println("IOException "+ex.getMessage());
        }
    }
}
