import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ChefPrime{
	
    static int semiprime(int num) 
    { 
        int cnt = 0,i; 
		List<Integer> list = new ArrayList<>();
      
        for (i = 2; cnt < 2 &&  i * i <= num; ++i) 
		{			
            while (num % i == 0)
			{ 
                num /= i;  
                ++cnt; 
				list.add(num);
				list.add(i);
            }
		}			
        if (num > 1) 
		{
			++cnt; 
		}
	
		if(list.size()>=2)
		{
			if(cnt==2 && list.get(0)!=list.get(1))
			{
				return 1;
			}
			
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
    }
	
	static int sumcheck(int num)
	{
		int i,j;
		for(i=1;i<=num/2;i++)
		{
			j=num-i;
			if(semiprime(i)==1 && semiprime(j)==1)
				return 1;
			
		}
		
		return 0;
	}
      
    public static void main(String[] args) 
    { 
        Scanner in= new Scanner(System.in);
		int n=in.nextInt();
		int y;
		for(int i=0;i<n;i++)
		{
			y=in.nextInt();
			if(sumcheck(y)==1)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
    } 
} 