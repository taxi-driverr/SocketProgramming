package org.example;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() throws IOException {
        String text = "some text";
        int count = 0;
        do{
            System.out.println("Received message from client "+text);
            count++;
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                System.out.println("Thread Interrupted"+ex.getMessage());
            }
            System.out.println("Thanks");
        }while(count<=5);
        socket.close();
    }
}
