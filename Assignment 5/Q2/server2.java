import java.io.*;
import java.net.*;
import java.util.*;

class server2 
{
    public static void main(String[] args) throws IOException,UnknownHostException
    {
        ServerSocket ss = new ServerSocket(50710);
		System.out.println("Server waiting for client ");

		Socket s = ss.accept();
		System.out.println("Client connected ");

		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		String fname = dis.readUTF();
		StringBuffer sb = new StringBuffer();

		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		String line;

		if(!fname.endsWith(".txt"))
			dos.writeUTF("File is not with extention .txt");
		else {
			try {
				File f = new File(fname);
				Scanner sc = new Scanner(f);
				while(sc.hasNext()) {
					sb.append(sc.nextLine());
					sb.append("\n");
				} 
				dos.writeUTF(sb.toString());
			} catch(FileNotFoundException e) {
				dos.writeUTF("File does not exist");
			}
		}

		dis.close();
		dos.close();
		System.out.println("Server closed");
		s.close();
	}
}
