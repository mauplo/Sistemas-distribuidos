package multicast;

import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class MulticastReceiver {
    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            // Specify the multicast group IP address (228.5.6.7) and port (6789)
            InetAddress mcastaddr = InetAddress.getByName("228.5.6.7");
            InetSocketAddress group = new InetSocketAddress(mcastaddr, 6789);

            // Retrieve all network interfaces available on the machine
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            // Loop through all network interfaces to list their details
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println(networkInterface);

                // Loop through the IP addresses
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress address = inetAddresses.nextElement();
                    System.out.println("    " + address);
                }
            }

            // Specify the network interface to use for sending multicast messages
            // Replace "10.11.14.121" with the actual name of a valid network interface on your system
            NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getByName("10.11.14.121"));
            System.out.println(netIf.getDisplayName());

            // Initialize a multicast socket bound to port 6789
            socket = new MulticastSocket(6789);

            // Join the specified multicast group using the selected network interface
            socket.joinGroup(new InetSocketAddress(mcastaddr, 0), netIf);

            // Create a buffer to receive a message
            byte[] buffer = new byte[1000];
            DatagramPacket message = new DatagramPacket(buffer, buffer.length);
            System.out.println("Receiver waiting for messages");
            socket.receive(message);

            // Convert the message from bytes into a String object
            String myMessage = new String(message.getData()).trim();
            System.out.printf(myMessage);

            // Leave the multicast group
            socket.leaveGroup(group, netIf);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            if (socket != null) socket.close();
        }
    }
}