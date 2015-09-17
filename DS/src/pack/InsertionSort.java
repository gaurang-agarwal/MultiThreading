package pack;

import java.util.Arrays;

public class InsertionSort {

public static void main(String [] args){
	int a[]={4,1,2,5,3};
	new InsertionSort().sort(a);
	System.out.println("\n\nResult:::"+Arrays.toString(a));
	//new InsertionSort().sort(a);
	//System.out.println("\t\tResult:::"+Arrays.toString(a));
	
}

void sort(int a[]){
	int j=0;
	int temp;
	for(int i=1;i<a.length;i++){
		j=i-1;
		temp=a[i];
		while(j>=0&&temp<a[j]){
			a[j+1]=a[j--];
		}
		
	a[j+1]=temp;
	
}
}

void rightShift(int a[],int i,int j){
for(int pos=i;pos>j;pos--){
	a[pos]=a[pos-1];
}
}
void reverseSort(int a[]){

	int j=0;
	int temp;
	for(int i=1;i<a.length;i++){
		j=0;
		temp=a[i];
		while(j<i&&temp<a[j]){
			j++;
		}
		System.out.println("a[i]:"+a[i]+"  "+"i:"+i+"  "+"j:"+j);
		System.out.println("Before shiting :"+Arrays.toString(a));
		rightShift(a, i, j);
		System.out.println("After shiting :"+Arrays.toString(a));
	a[j]=temp;
	
}
	
}

void oppSort(int a[]){
	
	int j=0;
	int temp;
	for(int i=a.length-2;i>=0;i--){
		j=a.length-1;
		temp=a[i];
		while(j>i&&temp<a[j]){
			j--;
		}
		System.out.println("a[i]:"+a[i]+"  "+"i:"+i+"  "+"j:"+j);
		System.out.println("Before shiting :"+Arrays.toString(a));
		leftShift(a, i, j);
		System.out.println("After shiting :"+Arrays.toString(a));
	a[j]=temp;
	
}
}


void leftShift(int a[],int i,int j){
	for(int pos=i;pos<j;pos++)
	{
		a[pos]=a[pos+1];
	}
}
}
