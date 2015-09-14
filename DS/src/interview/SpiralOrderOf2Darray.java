package interview;

import java.util.Arrays;

public class SpiralOrderOf2Darray {

	enum Direction {RIGHT,BOTTOM,LEFT,TOP}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		int arr[][]= new int [n][n];
		int counter=1;
		for(int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				arr[i][j]=counter++;
			}
		}

		for(int i=0;i<n;i++)
		{
			
				System.out.println(Arrays.toString(arr[i]));
			
		}
		
		int L=0;int R=n-1;int T=0; int B=n-1; // Defining the four limits LEFT RIGHT TOP BOTTOM

		Direction dir=Direction.RIGHT;
		while(L<=R && T<=B){
		switch (dir) {
		
		case RIGHT:

			for(int i=L;i<=R;i++)
			{
				System.out.print(arr[T][i]+">");
			}
			T++;
			dir=Direction.BOTTOM;
			break;

		case BOTTOM:
			for(int i=T;i<=B;i++)
			{
				System.out.print(arr[i][R]+">");
			}
			R--;
			dir=Direction.LEFT;
			break;
		case LEFT:
			for(int i=R;i>=L;i--)
			{
				System.out.print(arr[B][i]+">");
			}
			B--;
			dir=Direction.TOP;
			break;
		case TOP:
			for(int i=B;i>=T;i--)
			{
				System.out.print(arr[i][L]+">");
			}
			L++;
			dir=Direction.RIGHT;
			break;
		}
		}

	}

}
