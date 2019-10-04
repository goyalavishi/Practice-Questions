import java.util.*;
import java.io.*;
import java.lang.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num_hosts = Integer.parseInt(br.readLine());
		
		String s[] = br.readLine().split(" ");
		int hub_x = Integer.parseInt(s[0]);
		int hub_y = Integer.parseInt(s[1]);
		
		HashSet<Double> hs = new HashSet<>();

		for(int  i = 1 ; i <= num_hosts ; i++)
		{
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			double slope = (y- hub_y)/(x-hub_x);
			if(!hs.contains(slope)) hs.add(slope);
		}	
		
		System.out.println(hs.size());

	}
}
