import java.io.*;
import java.net.*;

class client1 {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s= new Socket("localhost", 50710);
	
		System.out.println("\nInet address associate with the socket = " + s.getInetAddress());
		System.out.println("\nPort to which socket is connected = " + s.getPort());
		System.out.println("\nLocal Port to which socket is connected = " + s.getLocalPort());
		System.out.println("\nClient closed");
		s.close();
	}
}
