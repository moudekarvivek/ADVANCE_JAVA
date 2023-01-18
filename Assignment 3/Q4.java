import java.util.*;
import java.io.*;

public class Q4
{
	public static void main(String args[]) throws IOException
  	{
    		String name;
    		double per;
    		int ch;

    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		Hashtable<String, Double> hs = new Hashtable<String, Double>();
    		do
    		{
      		    System.out.print("\n\n1. Add Student\n2. Display Details\n3. Search\n4. Exit\nEnter your choice: ");
      		    ch=Integer.parseInt(br.readLine());
      		    switch(ch)
      		    {
			    	case 1:	
			    		System.out.print("\nEnter student name: ");
			    		name=br.readLine();
			    		System.out.print("Enter percentage of student: ");
					while(true)
						{
						per = Double.parseDouble(br.readLine());
						if(per>0)
							break;
						else
							System.out.println("enter valid percentage:");
					}
			    		
			    		hs.put(name,per);
			    		break;
                
			    	case 2:
					if(!hs.isEmpty())
					{
			    			Enumeration keys=hs.keys();
			    			Enumeration values=hs.elements();
			    			System.out.print("\nName\tPercentage");
			    			while(keys.hasMoreElements() && values.hasMoreElements())
			    			{
		  	    				System.out.println("\n"+keys.nextElement()+"\t"+values.nextElement());
			    			}
					}
					else
						System.out.println("Table is empty");
			    		break;
                    
			    	case 3:
					if(!hs.isEmpty())
					{
				    		System.out.print("\nEnter name of the student to be searched: ");
				    		name=br.readLine();
			    						    		
				    		if(hs.containsKey(name))
				    		{
							System.out.print("\nName\tPercentage");
			  	    			System.out.println("\n"+name+"\t"+hs.get(name));
				    		}
					
			    			else
			    				System.out.println("\nStudent not found");
					}
					else
						System.out.println("Table is empty");
			    		break;
                    
			    	case 4: 
                    System.exit(0);			    		
                    break;
                    
      		    }
    		}while(ch<5);
  	}
}
