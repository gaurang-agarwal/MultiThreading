package puzzles;
//http://practice.geeksforgeeks.org/problems/trapping-rain-water/0
public class TrapRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int []{3,0,0,2,0,4};
		int largest = arr[0];
		int sum=0;
		int zeroCount=0;
		for(int i=1;i<arr.length;i++)
		{
			while(i<arr.length &&  largest>=arr[i])
			{
				if(arr[i]!=0)
				{
					sum = sum+largest-arr[i];
					sum=sum+largest*zeroCount;
					zeroCount=0;
				}
				else
				{
					zeroCount++;
				}
				i++;
			}
			if(i<arr.length)
			{
			sum=sum+largest*zeroCount;
			largest=arr[i];
			zeroCount=0;
			}
		}
		System.out.println(sum);
		
	}

}
