
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Typing
{
	public static int timeCalculate(String[] arrays)
	{
		int[] timer=new int[arrays.length];
		int flag=1,j;
		int timer_count=0;
		for(int i=0;i<arrays.length;i++)
		{
			flag=1;
			j=i-1;
			while(j>=0)
			{
				if(arrays[i].equals(arrays[j]))
				{
					timer[i]=timer[j]/2;
					timer_count+=timer[i];
					flag=0;
					break;
				}
				j--;
			}
			
		
			if(flag!=0)
			{
				timer[i]=timer(arrays[i]);
				timer_count+=timer[i];
			}
			
			//System.out.println("timer="+timer[i]);
		}
		
		return timer_count;
		
	}
	
	static int timer(String s)
	{
		int timer=2;
		for (int i = 1; i < s.length(); i++) 
		{
			if(s.charAt(i-1)=='d'||s.charAt(i-1)=='f')
			{
				if(s.charAt(i)=='d'||s.charAt(i)=='f')
				{
					timer+=4;
				}
				
				else if(s.charAt(i)=='k'||s.charAt(i)=='j')
				{
					timer+=2;
				}
			}
			
			else if(s.charAt(i-1)=='k'||s.charAt(i-1)=='j')
			{
				if(s.charAt(i)=='k'||s.charAt(i)=='j')
				{
					timer+=4;
				}
				
				else if(s.charAt(i)=='d'||s.charAt(i)=='f')
				{
					timer+=2;
				}
			}
		}
		
		return timer;
	}

	public static void main(String[] args) throws IOException
    {
		BufferedReader ab = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt (ab.readLine());
		
		if(n<1||n>100)
		{
			return;
		}
		int res;
		int arraysize;
		String[] arrays;
		String regex="[kjdf]*";
		Pattern pattern = Pattern.compile(regex);
		
		
		for(int i=0;i<n;i++)
		{
			arraysize=Integer.parseInt (ab.readLine());
			if(arraysize<1||arraysize>100)
			{
				return;
			}
			arrays = new String[arraysize];
			int c=0;
			for(int j=0;j<arraysize;j++)
			{
				arrays[j] = ab.readLine();
				Matcher matcher = pattern.matcher(arrays[j]);
				if(!matcher.matches())
				{
					return;
				}
				
				if(arrays[j].length()>20)
				{
					return;
				}
			}  
			res=timeCalculate(arrays);
			System.out.println(res);
		}
	}
}