package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8090;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("server is listening at port : "+ port);
            while(true){
                Socket socket = serverSocket.accept(); //waits for client connection

                System.out.println("new client connected");

                try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    out.println("echo from server ");
                    String clientMessage = in.readLine();
                    System.out.println("Message from client :"+clientMessage);

                }

            }

        }catch(IOException ex){
            System.out.println("server exception : "+ ex.getMessage());
            ex.printStackTrace();
        }
    }
}
