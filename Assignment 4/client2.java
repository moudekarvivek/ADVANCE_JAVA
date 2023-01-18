import java.io.*;
import java.net.*;

class client2 {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s= new Socket("localhost", 50710);
		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		System.out.println("\nData "+dis.readUTF());
		dis.close();
		System.out.println("Client closed\n");
		s.close();
	}
}
