package puzzles;

import java.util.Arrays;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String []s1="zxabcdezy".split("");
		String []s2="yzabcdezx".split("");

		int resultMatrix [][] = new int[s1.length+1][s2.length+1];
		/*for(int i=0;i<resultMatrix.length;i++){
			resultMatrix[i][0]=0;
		}
		for(int i=0;i<resultMatrix[0].length;i++){
			resultMatrix[0][i]=0;
		}*/

		for(int i=1;i<resultMatrix.length;i++){
			for(int j=1;j<resultMatrix[i].length;j++){
				if(s1[i-1].equals(s2[j-1])){
					resultMatrix[i][j]=resultMatrix[i-1][j-1]+1;
				}
				else{
					resultMatrix[i][j]=Math.max(resultMatrix[i-1][j], resultMatrix[i][j-1]);
				}
			}
		}
		for( int arr[] : resultMatrix){
			System.out.println(Arrays.toString(arr));
		}

		StringBuilder lcs =new StringBuilder();
		int i = resultMatrix.length-1;
		int j = resultMatrix[i].length-1;
		while(i>0 && j>0){
			if(resultMatrix[i][j] == (resultMatrix[i][j-1])){
				j--;
			}
			else if(resultMatrix[i][j] == (resultMatrix[i-1][j])){
				i--;
			}
			else if(resultMatrix[i][j] == (resultMatrix[i-1][j-1]+1)){
				lcs.append(s1[i-1]);
				i--;j--;
			}
		}

		System.out.println(lcs.reverse());
	}
}
