import java.io.*;
import java.net.*;

class server1 {
	public static void main(String args[]) throws UnknownHostException, IOException {
		ServerSocket ss = new ServerSocket(50710);
		System.out.println("\nServer started waiting for client to connect \n");
		Socket s = ss.accept();
		System.out.println("Server closed\n");
		System.out.println("Client closed\n");
		s.close();
	}
}
