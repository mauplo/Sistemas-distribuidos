package client;

import java.net.*;
import java.io.*;
import java.util.Random;

public class ClientThread extends Thread {
    private int clientId;
    private int numRequests;
    private String serverAddress;
    private int serverPort;
    private Random random;

    public ClientThread(int clientId, int numRequests, String serverAddress, int serverPort) {
        this.clientId = clientId;
        this.numRequests = numRequests;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < numRequests; i++) {
            Socket s = null;
            try {
                s = new Socket(serverAddress, serverPort);
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());

                // Generar un número aleatorio del 0 al 4
                int randomId = random.nextInt(5);

                // Enviar el ID (int) al servidor
                out.writeInt(randomId);

                // Recibir el nombre (UTF) del servidor
                String name = in.readUTF();

            } catch (UnknownHostException e) {
                System.out.println("Cliente " + clientId + " - Sock: " + e.getMessage());
            } catch (EOFException e) {
                System.out.println("Cliente " + clientId + " - EOF: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Cliente " + clientId + " - IO: " + e.getMessage());
            } finally {
                if (s != null) {
                    try {
                        s.close();
                    } catch (IOException e) {
                        System.out.println("Cliente " + clientId + " - close: " + e.getMessage());
                    }
                }
            }
        }
        System.out.println("Cliente " + clientId + " completó " + numRequests + " solicitudes");
    }
}