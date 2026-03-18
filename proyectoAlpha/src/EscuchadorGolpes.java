import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EscuchadorGolpes extends Thread {

    private final int port;
    private final ServidorMonstruos server;

    /*
     * Crea el escuchador de golpes.
     * Entradas: port (puerto TCP), server (servidor central).
     * Rol: aceptar conexiones para reportar golpes.
     */
    public EscuchadorGolpes(int port, ServidorMonstruos server) {
        this.port = port;
        this.server = server;
    }

    @Override
    /*
     * Abre el ServerSocket y delega cada cliente de golpes a un hilo.
     * Rol: recibir trafico de golpes sin bloquear el servidor principal.
     */
    public void run() {
        try (ServerSocket listenSocket = new ServerSocket(port)) {
            while (true) {
                // Se crea un manejador por conexion para mantener concurrencia.
                Socket clientSocket = listenSocket.accept();
                new HitConnection(clientSocket, server).start();
            }
        } catch (IOException e) {
            System.out.println("Error en escuchadorGolpes: " + e.getMessage());
        }
    }
}

class HitConnection extends Thread {

    private final Socket clientSocket;
    private final ServidorMonstruos server;

    /*
     * Crea el manejador de una conexion de golpes.
     * Entradas: clientSocket (socket del cliente), server (servidor del juego).
     * Rol: procesar golpes de un cliente sobre una conexion persistente.
     */
    public HitConnection(Socket clientSocket, ServidorMonstruos server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    /*
     * Lee nombres de jugador, intenta registrar el golpe y devuelve ACK.
     * Entradas: playerName por UTF en el socket.
     * Salida: UTF "HIT_OK" o "HIT_REJECTED" por cada intento.
     * Rol: enlace de accion inmediata entre clientes y logica de puntaje.
     */
    public void run() {
        try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

            // Reutiliza la misma conexion para recibir multiples golpes del mismo jugador.
            while (true) {
                String playerName = in.readUTF();
                boolean accepted = server.tryHit(playerName);

                // Respuesta simple para que el cliente sepa si conto el golpe.
                out.writeUTF(accepted ? "HIT_OK" : "HIT_REJECTED");
                out.flush();
            }

        } catch (EOFException e) {
            System.out.println("Cliente de golpes desconectado.");
        } catch (IOException e) {
            System.out.println("Golpes IO: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("No se pudo cerrar socket golpes: " + e.getMessage());
            }
        }
    }
}
