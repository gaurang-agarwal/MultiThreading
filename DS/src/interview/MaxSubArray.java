package interview;

public class MaxSubArray {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		new MaxSubArray().maxSubArray(new int []{1,-2,4,-1,4,-7,6});
		
	}
	public void maxSubArray(int []arr){
		int maxSum=0;
		int maxArr[];
		for(int i=1;i<=arr.length;i++)
		{
			int sum=0;
			for(int j=0;j<=arr.length-i;j++)
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
	
	
	public int getArraySum(int arr[],int start,int count){
		int sum=0;
		for(int i=0;i<count;i++)
					sum+=arr[start++];
		
		return sum;
	}
	

}
