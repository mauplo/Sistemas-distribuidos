package server;

import java.net.*;
import java.io.*;

public class TCPServer {

    public static void main(String args[]) {
        try {
            int serverPort = 49152;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Servidor iniciado en puerto: " + serverPort);

            while (true) {
                System.out.println("Esperando conexiones...");
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
                c.start();
            }
        } catch (IOException e) {
            System.out.println("Listen: " + e.getMessage());
        }
    }
}

class Connection extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;
    private static AddressBook addressBook = new AddressBook();

    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Connection: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            // Recibir el ID del cliente (int)
            int key = in.readInt();

            System.out.println("Solicitud recibida de: " + clientSocket.getRemoteSocketAddress() +
                    " - ID solicitado: " + key);

            // Obtener el nombre correspondiente de la agenda
            String name = addressBook.getRecord(key).getName();

            // Enviar respuesta (UTF)
            out.writeUTF(name);

            System.out.println("Respuesta enviada: " + name);

        } catch (EOFException e) {
            System.out.println("EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}