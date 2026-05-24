package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8090;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("server is listening at port : "+ port);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("new client connected");
                new ClientHandler(socket).run();
            }

        }catch(IOException ex){
            System.out.println("server exception : "+ ex.getMessage());
            ex.printStackTrace();
        }
    }
}
