package puzzles;

import java.util.Arrays;

public class MatrixMaxSumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][]matrix = new int [][]{{1,2,3},{4,8,2},{1,5,3}};
		int sum = findMaxSumPath(matrix);
		System.out.println(sum);
		sum=findMinSumPath(matrix);
		System.out.println(sum);
	}
	
	
	private static int findMaxSumPath(int [][]matrix)
	{
		int result[][] = new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(i==0 && j==0)
					result [i][j]=matrix[i][j];
				else if(i==0)
					result[i][j]= result[i][j-1]+matrix[i][j];
				else if(j==0)
					result[i][j]= result[i-1][j]+matrix[i][j];
				else
					result[i][j] = Math.max(result[i-1][j], result[i][j-1])+matrix[i][j];
			}
		}
		
		
		return 	result[2][2];
	}
	
	
	private static int findMinSumPath(int [][]matrix)
	{
		int result[][] = new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(i==0 && j==0)
					result [i][j]=matrix[i][j];
				else if(i==0)
					result[i][j]= result[i][j-1]+matrix[i][j];
				else if(j==0)
					result[i][j]= result[i-1][j]+matrix[i][j];
				else
					result[i][j] = Math.min(Math.min(result[i-1][j], result[i][j-1]),result[i-1][j-1])+matrix[i][j];
			}
		}
		
		
		return 	result[2][2];
	}
	
	
}
