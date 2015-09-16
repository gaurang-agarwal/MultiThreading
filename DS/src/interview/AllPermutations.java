package interview;

import java.util.Arrays;

public class AllPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
permute("QWER".toCharArray(), 0);
		
		
	}

	public static void permute(char []array,int k){
		if(k==array.length){
			System.out.println(Arrays.toString(array));
		}
		for(int i=k;i<array.length;i++){
			char temp=array[k];
			array[k]=array[i];
			array[i]=temp;
			permute(array, k+1);
			temp=array[k];
			array[k]=array[i];
			array[i]=temp;
		}
		
		
		
	}
	
	
}
