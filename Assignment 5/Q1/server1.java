import java.io.*;
import java.net.*;
import java.util.*;

class server1 {
	public static void main(String args[]) throws IOException, UnknownHostException {
		ServerSocket ss = new ServerSocket(3552);
		System.out.println("Server started working for client on connect\n");
		Socket s = ss.accept();
		InputStream i = s.getInputStream();
		DataInputStream d = new DataInputStream(i);
		String msg;

		while(!(msg=d.readUTF()).equals("END")) {
			System.out.println(msg);
		}
		i.close();
		d.close();
	}
}
