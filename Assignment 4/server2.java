import java.io.*;
import java.net.*;
import java.util.*;

class server2 {
	public static void main(String args[]) throws UnknownHostException, IOException {
		ServerSocket ss = new ServerSocket(50710);
		System.out.println("\nServer started waiting for client connect\n");
		Socket s= ss.accept();

		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		Date d = new Date();
		dos.writeUTF(d.toString());
	
		System.out.println("Server closed\n");
		s.close();
	}
}
