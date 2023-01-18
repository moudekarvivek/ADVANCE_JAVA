import java.util.*;
import java.io.*;

class Q1
{
    	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ds = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		do 
		{
			System.out.println("\n1. ArrayList\n2. LinkedList\n3. Exit\nSelect  operation:");
		    	ds = Integer.parseInt(br.readLine());
		    	switch (ds)             
			{
		        case 1: 
		            	int arrCh=0;
		            	do 
		            	{
					int pos=0;
					int element=0;
				      System.out.println("\n1. add(Object o)\n2. add(int index,Object element)\n3. addAll(int index,Collection c)\n4. remove(Object o)");
					System.out.println("5. Display\n6. Exit\nSelect operation:");
				        arrCh = Integer.parseInt(br.readLine());
				        switch(arrCh)
		                	{
				            	case 1: 
				                	System.out.println("Enter element to add : ");
				                	al.add(Integer.parseInt(br.readLine()));
				            		break;
		                    
				            	case 2:
				                	System.out.println("Enter position:");
							pos = Integer.parseInt(br.readLine());
							System.out.println("Enter element to add :");
							element = Integer.parseInt(br.readLine());
				                	al.add(pos,element);
				            		break;

				            	case 3: 
							System.out.println("Enter position:");
							pos = Integer.parseInt(br.readLine());
							
							Collection c = new ArrayList<Integer>();
							c.add("238476");
							c.add("34687");

							al.addAll(pos,c);
				            		break;
					
						case 4:	
							System.out.println("Enter element to remove : ");
							element = Integer.parseInt(br.readLine());
							if(al.contains(element))
					                	al.remove(Integer.valueOf(element));
							else
								System.out.println("No such element found:");
							break;
						
						case 5: 
							System.out.println("Array List : "+al);
							break;
					
						case 6:	
							break;

		                    		default:
		                        		System.out.println("Please enter valid choice...");
		                    			break;
                        		}

                    		}while (arrCh < 6);
                		break;
                
		        case 2:
		            	int llCh=0;
		            	do 
		            	{
		                	System.out.println("\n1. add(Object o)\n2. addFirst(Object o)\n3. addLast(Object o)");
					System.out.println("\n4. remove(Object o)\n5. removeFirst()\n6. removeLast()");
					System.out.println("\n7. Display\n8.Exit\nSelect operation:");

		                	llCh = Integer.parseInt(br.readLine());
		                	switch (llCh)
		                	{
		                    		case 1: 
		                        		System.out.println("Enter element to add:");
		                        		ll.add(Integer.parseInt(br.readLine()));
		                    			break;
		                    
						case 2: 
							System.out.println("Enter element to add at first pos:");
		                        		ll.addFirst(Integer.parseInt(br.readLine()));
							break;

						case 3: 
							System.out.println("Enter element to add at last pos:");
		                        		ll.addLast(Integer.parseInt(br.readLine()));
							break;
							
		                    		case 4: 
							if(!ll.isEmpty())
							{
								System.out.println("Enter element to remove: ");
								int element = Integer.parseInt(br.readLine());
								if(ll.contains(element))
					                		ll.remove(Integer.valueOf(element));
								else
									System.out.println("No such element found:");
							}
							else
							{
								System.out.println("list is empty");
		                        		}	
		                    			break;

						case 5:
							if(!ll.isEmpty())
							{						
                   						System.out.println("Last element: "+ll.removeFirst());
							}
							else
								System.out.println("No such element found:");
							break;

						case 6:
							if(!ll.isEmpty())
							{						
                   						System.out.println("Last element: "+ll.removeLast());
							}
							else
								System.out.println("No such element found:");
							break;
							
		                    		case 7: 
		                        		System.out.println("Linked List : "+ll);
		                    			break;
		                
		                    		case 8:		             
		                    			break;
		                
		                    		default:
		                        		System.out.println("Please enter valid choice...");
		                    			break;
                        		}
                    
                    		}while (llCh < 8);
                		break;

                	default:
                		break;
            	    }
        	} while (ds < 3);
    	}
}
