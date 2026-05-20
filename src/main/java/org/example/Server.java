package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8090;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("server is listening at port : "+ port);

        }catch(IOException ex){
            System.out.println("server exception : "+ ex.getMessage());
            ex.printStackTrace();
        }
    }
}
