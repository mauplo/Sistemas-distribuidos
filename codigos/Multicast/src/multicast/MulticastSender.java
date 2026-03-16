package multicast;

import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


public class MulticastSender {
    public static void main(String[] args) {
        MulticastSocket socket = null;

        try {

            //System.setProperty("java.net.preferIPv4Stack", "true");
            String myMessage = "Hello";

            // Specify the multicast group IP address (228.5.6.7) and port (6789)
            InetAddress mcastaddr = InetAddress.getByName("228.5.6.7");
            InetSocketAddress group = new InetSocketAddress(mcastaddr, 6789);

            // Retrieve all network interfaces available on the machine
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            // Loop through all network interfaces to list their details
            while(interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println(networkInterface);

                // Loop through the IP addresses
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while(inetAddresses.hasMoreElements()) {
                    InetAddress address = inetAddresses.nextElement();
                    System.out.println("    "+ address);
                }
            }

            // Specify the network interface to use for sending multicast messages
            // Replace "10.11.14.121" with the actual name of a valid network interface on your system
            NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getByName("10.11.14.121"));
            // System.out.println(netIf.getDisplayName());

            // Initialize a multicast socket bound to port 6789
            socket = new MulticastSocket(6789);
            //socket.setTimeToLive(32);

            // Join the specified multicast group using the selected network interface
            socket.joinGroup(new InetSocketAddress(mcastaddr, 17747), netIf);

            // Convert the message into bytes to send over the network
            byte[] msgBytes = myMessage.getBytes();
            DatagramPacket message  = new DatagramPacket(msgBytes, msgBytes.length, group);
            socket.send(message);
            System.out.println("The multicast message has been sent");

            // Leave the multicast group
            socket.leaveGroup(group, netIf);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            if (socket != null) socket.close();
        }
    }
}
