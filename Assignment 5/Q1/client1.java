import java.io.*;
import java.net.*;
import java.util.*;

class client1 {
	public static void main(String args[]) throws IOException, UnknownHostException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Socket s = new Socket("localhost", 3552);
		OutputStream i = s.getOutputStream();
		DataOutputStream d = new DataOutputStream(i);
		String msg = "";

		System.out.println("\nEnter a message");

		while(!msg.equals("END")) {
			msg = br.readLine();
			d.writeUTF(msg);
		}
		d.close();
		System.out.println("\nClient is closed.");
		s.close();
	}
}
