package puzzles;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr []= new int []{ 1,2,3,4,5,6,7,8,9,10}; 
		int finalsum =100;
		int currentSum=arr[0];
		int start=0;
		int end =0;
		for(int i=1;i<arr.length;i++)
		{
			if(currentSum==finalsum)
				break;
			if(currentSum<finalsum)
			{
				currentSum=currentSum+arr[i];
				end++;
			}
			else 
			{
				currentSum=currentSum-arr[start];
				start++;
			}
		}
		if(start<=end && currentSum==finalsum)
		{
		System.out.println(start+" to "+end);
		}
		else
		{
			System.out.println(start+"NoSum Exists" + end);
		}
	}

}
