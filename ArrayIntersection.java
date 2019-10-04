package lecture5;

import java.util.Scanner;

public class ArrayIntersection {
	public static Scanner s = new Scanner(System.in);

	public static int[] takeInput() {
		int n= s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)  {
			arr[i]=s.nextInt();
		}
		return arr;
	}

	public static void printIntersection(int[] arr1,int[] arr2)  {
		for(int i=0;i<arr1.length;i++)  {
			for(int j=0;j<arr2.length;j++)  {
				if(arr1[i]==arr2[j])  {
					System.out.print(arr1[i] + " ");
				}
				else continue;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = takeInput();
		int[] arr2 = takeInput();
		printIntersection(arr1, arr2);
	}

}
