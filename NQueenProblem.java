import java.util.Arrays;

class NQueenProblem
{
	public int iterations=0;
	static int x;
	static int[][] board;
	
	NQueenProblem(String arr)
	{
		//initializing array
		x=Integer.parseInt(arr);
		board=new int[x][x];
	}
	
	boolean isQueenProtected(int row,int col)
	{
		// Check side columns of same row
        for (int i = col-1; i >=0; i--)
            if (board[row][i] == 1)
			{
				System.out.println("false");
				return false;
			}
 
        // Check upper diagonal on left side 
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
            {
				System.out.println("false");
				return false;
			}
 
         //Check lower diagonal on left side 
        for (int i=row+1, j=col-1; j>=0 && i<x; i++, j--)
            if (board[i][j] == 1)
            {
				System.out.println("false");
				return false;
			}
		
		System.out.println("true");		
        return true;
	}
	
	boolean solution(int col)
    {
        // If all queens are placed
        if (col >= x)
            return true;
 
       System.out.println("column="+col);
        for (int i = 0; i < x; i++)
        {
            if (isQueenProtected(i, col))
            {
                // if queen is safe Place this queen in board[i][col]			
                board[i][col] = 1;
				
                // test for all columns
                if (solution(col + 1) == true)
                    return true;
 
                // If placing queen in board[i][col] doesn't lead to a solution then backtrack
                board[i][col] = 0;
            }
			
			printboard();
        }
		return false;
	}
	
	public void printboard()
	{
		System.out.println("Iteration "+(iterations++)+": \n");
		
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<x;j++)
			{
				if(board[i][j]==1)
					System.out.print("x ");

				else
					System.out.print("o ");
			}
			System.out.println("");
		}
	}
	
	//Main Function
	public static void main(String args[])
	{
		//initializing array
		x=Integer.parseInt(args[0]);
		board=new int[x][x];
		//Arrays.fill(board,0);

		NQueenProblem n=new NQueenProblem(args[0]);
		n.printboard();
		
        if (n.solution(0) == false)
        {
            System.out.print("Solution does not exist");
        }
		n.printboard();
	}
	
	
}