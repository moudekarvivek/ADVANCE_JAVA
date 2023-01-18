import java.net.*;
import java.io.*;

class client3
{
	public static void main(String args[])throws UnknownHostException,IOException
	{
		Socket s=new Socket("localhost",50710);
		System.out.println("Client connected...");
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps=new PrintStream(s.getOutputStream());
		String str;
		System.out.println("Enter the string to check whether it is a palindrome:");
		str=br1.readLine();
		
		ps.println(str);
		System.out.println(br.readLine());
		
		System.out.println("Client closed");
		ps.close();		
		s.close();	
	}
}
