package puzzles;
//http://practice.geeksforgeeks.org/problems/trapping-rain-water/0
public class TrapRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int []{3,0,0,2,0,4};

	    int low=0, high=arr.length-1, left_max=0, right_max=0,water=0;
	    while(low<high)
	    {
	        if(arr[low]<arr[high])
	        {
	            if(arr[low]>left_max)
	             left_max=arr[low];
	            else
	            {
	                water+=left_max-arr[low];
	            }
	            low++;
	        }
	        else
	        {
	            if(arr[high]>right_max)
	             right_max=arr[high];
	            else
	             water+=right_max-arr[high];
	           high--;  
	        }

	    }
	    System.out.println(water);
	    }

}
