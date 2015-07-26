package pack;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a[]={0,1,2,3,4,5,6,7,8,9};
		new RotateArray().leftShift(a, 3);
		System.out.println(Arrays.toString(a));
	}
	void leftShift(int a[],int pos)
	{
		
		int tempArray []= new int[pos];
		for(int i=0;i<pos;i++){
			tempArray[i]=a[i];
		}
		int mod;
		int i;
		for(i=0;i<a.length-pos;i++)
		{
			mod=(i+pos)%a.length;
			a[i]=a[mod];
		}
		int counter=0;
		while(i<a.length){
			a[i++]=tempArray[counter++];
		}
	}
		
}
