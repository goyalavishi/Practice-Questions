import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Chefs
{	 
    public static void main(String[] args) 
    { 
        Scanner in= new Scanner(System.in);
		int n=in.nextInt();
		int i,j,flag;
		int N;
		List<Integer> list1=new ArrayList<>();
		List<Integer> list2=new ArrayList<>();
	
		for(i=0;i<n;i++)
		{
			N=in.nextInt();
			
			for(j=0;j<N;j++)
			list1.add(in.nextInt());
		
			for(j=0;j<N;j++)
			list2.add(in.nextInt());
		
			flag=1;
			for(j=0;j<N-2;)
			{
				if(list2.get(j)<list1.get(j)) 
				{
					flag=0;
					break;
				}
				
				else if(list2.get(j)==list1.get(j))
				{
						j+=1;
				}
				
				else
				{
					list2.set(j,list2.get(j)-1);
					list2.set(j+1,list2.get(j+1)-2);
					list2.set(j+2,list2.get(j+2)-3);
					
					if((list2.get(j+1)==list1.get(j+1)&&(list2.get(j)!=list1.get(j)))||((list2.get(j+2)==list1.get(j+2))&&((list2.get(j)!=list1.get(j))||(list2.get(j+1)!=list1.get(j+1)))))
					{
						flag=0;
						break;
					}
						
					else if(list2.get(j)==list1.get(j)&& list2.get(j+1)==list1.get(j+1) && list2.get(j+2)==list1.get(j+2))
					{
						j+=3;
					}
					
					else if(list2.get(j)==list1.get(j)&& list2.get(j+1)==list1.get(j+1))
					{
						j+=2;
					}
				}		
			}
			
			if( list2.get(N-2)!=list1.get(N-2) || list2.get(N-1)!=list1.get(N-1))
			{
				flag=0;
			}
			
			if(flag==0)
			{
				System.out.println("NIE");
			}
			else
			{
				System.out.println("TAK");
			}
			
			list1.clear();
			list2.clear();
		}
    } 
} 