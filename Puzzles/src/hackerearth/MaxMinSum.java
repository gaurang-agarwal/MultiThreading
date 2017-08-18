package hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMinSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long []list = new long[n];
		for(int i=0;i<n;i++)
		{
			list[i]=sc.nextLong();
		}
		Arrays.sort(list);
		long sum =0;
		for(int i=0;i<list.length;i++)
		{
			sum=sum+list[i];
		}
		
		System.out.println((sum-list[n-1])+" "+(sum-list[0]));
		
	}

}
