import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EscuchadorLogin extends Thread {

    private final int port;
    private final ServidorMonstruos server;

    /*
     * Crea el escuchador de login.
     * Entradas: port (puerto TCP), server (referencia al servidor central).
     * Rol: recibir conexiones de registro de jugadores.
     */
    public EscuchadorLogin(int port, ServidorMonstruos server) {
        this.port = port;
        this.server = server;
    }

    @Override
    /*
     * Abre el ServerSocket y atiende clientes de login en hilos separados.
     * Rol: puerta de entrada TCP para registrar jugadores.
     */
    public void run() {
        try (ServerSocket listenSocket = new ServerSocket(port)) {
            while (true) {
                // Cada cliente de login se delega para no bloquear nuevas conexiones.
                Socket clientSocket = listenSocket.accept();
                new LoginConnection(clientSocket, server).start();
            }
        } catch (IOException e) {
            System.out.println("Error en escuchadorLogin: " + e.getMessage());
        }
    }
}

class LoginConnection extends Thread {

    private final Socket clientSocket;
    private final ServidorMonstruos server;

    /*
     * Crea el manejador de una conexion individual de login.
     * Entradas: clientSocket (socket del cliente), server (servidor del juego).
     * Rol: procesar registro y responder parametros de juego.
     */
    public LoginConnection(Socket clientSocket, ServidorMonstruos server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    /*
     * Lee el nombre del jugador, lo registra y responde datos de conexion.
     * Entradas: flujo UTF por socket con playerName.
     * Salida: mensaje UTF con formato OK|TOPIC|PORTS.
     * Rol: completar el login inicial del cliente.
     */
    public void run() {
        try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

            // Recibe nombre del jugador para registro/login.
            String playerName = in.readUTF();
            server.registerPlayer(playerName);

            // Respuesta basica con puertos y topico para jugar.
                out.writeUTF("OK|TOPIC=" + ServidorMonstruos.TOPIC_NAME
                    + "|LOGIN_PORT=" + ServidorMonstruos.LOGIN_PORT
                    + "|HIT_PORT=" + ServidorMonstruos.HIT_PORT);

        } catch (EOFException e) {
            System.out.println("Login EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Login IO: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("No se pudo cerrar socket login: " + e.getMessage());
            }
        }
    }
}
