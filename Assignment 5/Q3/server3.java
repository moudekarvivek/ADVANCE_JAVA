import java.net.*;
import java.io.*;
import java.util.*; 

class server3
{
	public static boolean palindrom_check(String str)
	{	
		String reverse="";
		for(int i=str.length()-1;i>=0;i--)
		{
			reverse=reverse+str.charAt(i);
		}
		if(reverse.equals(str))
			return true;
		return false;
		
	} 
	public static void main(String args[])throws UnknownHostException,IOException
	{	
		ServerSocket ss=new ServerSocket(50710);
		System.out.println("Server started , waiting for client connection.....");
		Socket s=ss.accept();
		System.out.println("Client connected");
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintStream ps=new PrintStream(s.getOutputStream());
		String str=br.readLine();
		
		
		Boolean ans=palindrom_check(str);
		if(ans)
		{
			ps.println("The given string "+str+" is palindrome");
		}
		else
		{
			ps.println("The given string "+str+" is not palindrome");
			
		}
		
		System.out.println("Server closed");
				
		s.close();
		

	}	
}
