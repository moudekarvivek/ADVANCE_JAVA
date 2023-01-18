import java.io.*;
import java.util.*;

class Q2
{
    public static void main(String[] args) throws IOException
    {
        SortedSet<String> ss = new TreeSet<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter number of color's to add : ");
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0;i<n;i++)
        {
            System.out.println("Enter color : ");
            ss.add(br.readLine().toLowerCase());
        }
        
        Iterator<String> itr = ss.iterator();
        System.out.println("\nAll Unique Colors are : ");
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
