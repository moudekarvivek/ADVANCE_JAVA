import java.io.*;
import java.net.*;

class client2
{
	public static void main(String[] args) throws IOException,UnknownHostException
	{
			Socket s = new Socket("localhost",50710);

            System.out.println("Client Connected"); 

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //accept file and pass it to the server
            System.out.println("Enter Filename :"); 
            String fname = br.readLine();

			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(fname);

			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			System.out.println(dis.readUTF());

            dos.close();
            dis.close();
			System.out.println("Client closed");            
			s.close();
    }
}
