package interview;

public class MaxSubArray {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		new MaxSubArray().maxSubArray(new int []{1,-2,1,4,-3,-1,4,-2,6});
		
	}
	/*
	 * Here approach is to find the sub array of all the sizes then calculate the sum of all these sub-arrays
	 */
	public void maxSubArray(int []arr){
		int maxSum=0;
		for(int i=1;i<=arr.length;i++)//denotes the size of sub arrays
		{
			int sum=0;
			for(int j=0;j<=arr.length-i;j++) // loop that will generate all the sub-arrays of size i
			{
				sum=getArraySum(arr, j, i);
				System.out.println("Current Sum:"+sum+" i"+i+" j"+j);
				if(sum>maxSum)
				{
					maxSum=sum;
					System.out.println("Current Max:-------------:::::::"+maxSum);
				}
				
			}
			
		}
		
		
		
	}

	// Complexity O(n^2)
	/*Approach is to first First find the sum of all sub Array starting from 0th Index (ie. of all the sizes)
	 * At any point we already have the sum of all previous elements, therefore we don't need an extra loop
	 * just to calculate the sum
	 * 
	 */
	public void maxSubArraySol2(int []arr){
		int maxSum=0;
		for(int i=0;i<=arr.length;i++)
		{
			int sum=0;
			for(int j=i;j<arr.length;j++)
			{
				sum=sum+arr[j];
				System.out.println("Current Sum:"+sum+" i"+i+" j"+j);
				if(sum>maxSum)
				{
					maxSum=sum;
					System.out.println("Current Max:-------------:::::::"+maxSum);
				}
				
			}
			
		}
		
		
		
	}

	
	public int getArraySum(int arr[],int start,int count){
		int sum=0;
		for(int i=0;i<count;i++)
					sum+=arr[start++];
		
		return sum;
	}
	
	//Kande's solution gives linear time approach.
	//One Limitation of this approach is that if all the numbers are negative then it will give the max sum as 0
	//For this, we can first scan the array to find atleast one positive number
	
	public void maxSubArrayKandeSolution(int arr[]){
		int start=0;
		int end=-1;
		int maxStart=0;
		int previousMax=0;
		int currentSum=0;
		for(int i=0;i<arr.length;i++){
			currentSum=currentSum+arr[i];
			if(currentSum>previousMax)
			{
				previousMax=currentSum;
				end=i;
				maxStart=start;
			}
			if(currentSum<0){
				start=i+1;
				currentSum=0;
			}
		}
		
	System.out.println("Max Sum:::::::::::::::"+previousMax+" starting from "+maxStart+" to "+end);	
		
		
		
		
		
	}
	

}
