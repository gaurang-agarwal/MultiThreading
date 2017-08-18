package hackerearth;

import java.util.Scanner;

public class MonkVisitsCoderland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++)
		{
			int N = sc.nextInt();
			
			int C[]=  new int [N];
			int L[]=new int [N];
			for(int i=0;i<N;i++)
			{
				C[i] = sc.nextInt();
			}
			for(int i=0;i<N;i++)
			{
				L[i] = sc.nextInt();
			}
			int currentMin=C[0];
			int currentCost=0;
			for(int i=0;i<N;i++)
			{
				
				if(currentMin > C[i])
				{
					currentMin=C[i];
				}
				
				currentCost=currentCost+L[i]*currentMin;
			}
			System.out.println(currentCost);
		}
		
		
	}
	


	private static int[] convert(String x){
     String[] val = x.split(" ");
     int[] arr = new int[val.length];
     for (int i = 0; i < val.length; ++i){
          arr[i] = Integer.parseInt(val[i]);
     }
     return arr;
}



}
