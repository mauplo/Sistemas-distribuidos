package client;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void main(String args[]) {
        String serverAddress = "localhost";
        int serverPort = 49152;

        // Configuraciones de prueba
        int[] clientCounts = {1, 50, 100, 150, 200, 250, 300};
        int[] requestCounts = {1, 1000, 2000};

        System.out.println("-------------------------");
        System.out.println("PRUEBAS DE CONCURRENCIA");
        System.out.println("-------------------------\n");

        // Pruebas con diferentes configuraciones
        for (int numClients : clientCounts) {
            for (int numRequests : requestCounts) {
                runTest(numClients, numRequests, serverAddress, serverPort);
            }
        }

        System.out.println("\n-------------------------");
        System.out.println("PRUEBAS COMPLETADAS");
        System.out.println("-------------------------");
    }

    private static void runTest(int numClients, int numRequests, String serverAddress, int serverPort) {
        System.out.println("\n-------------------------------------------------");
        System.out.println("PRUEBA: " + numClients + " clientes, " + numRequests + " solicitudes cada uno");
        System.out.println("Total de solicitudes: " + (numClients * numRequests));
        System.out.println("-------------------------------------------------");

        List<ClientThread> clients = new ArrayList<>();

        // Iniciar cronómetro
        long startTime = System.currentTimeMillis();

        // Crear y lanzar todos los hilos de clientes
        for (int i = 0; i < numClients; i++) {
            ClientThread client = new ClientThread(i + 1, numRequests, serverAddress, serverPort);
            clients.add(client);
            client.start();
        }

        // Esperar a que todos los clientes terminen
        for (ClientThread client : clients) {
            try {
                client.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Calcular tiempo transcurrido
        long spentTime = System.currentTimeMillis() - startTime;

        System.out.println("\n>>> RESULTADOS:");
        System.out.println("    Clientes: " + numClients);
        System.out.println("    Solicitudes por cliente: " + numRequests);
        System.out.println("    Total de solicitudes: " + (numClients * numRequests));
        System.out.println("    Tiempo total: " + spentTime + " ms");
        System.out.println("    Tiempo promedio por solicitud: " +
                String.format("%.2f", (double)spentTime / (numClients * numRequests)) + " ms");
        System.out.println("    Solicitudes por segundo: " +
                String.format("%.2f", (numClients * numRequests * 1000.0) / spentTime));
    }
}