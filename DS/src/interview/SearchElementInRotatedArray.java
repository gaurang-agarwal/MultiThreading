package interview;

public class SearchElementInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SearchElementInRotatedArray().searchInCircularySortedArray(new int[]{5,6},6);
		
		
	}

	/*
	 * Case 1: If element at low is less than high then index of low is the times array is rotated
	 * Case 2:Check if the element is pivot, ie, the element in the left and at the right is greater than this element
	 * Pivot element is the first element if elements of arrays are shifted to normal position
	 * Pivot element is the minimum element in the array
	 * If the element at mid is less than the element at start then array between mid and starting is sorted
	 * Case 3 : Indicates that array in the right of mid element is sorted, hence pivot can not be in right.
	 * Case 4: Indicates that array in the left of mid element is sorted, hence pivot can not be in left.
	 
	 */
	public void timesArrayIsRotated(int arr[]){
		int low=0;
		int high=arr.length-1;
		int pos=-1;
		while(low<high){
			if(arr[low]<=arr[high]) //Case 1
			{
			 pos=low;
			 break;
			}
			int mid=(high+low)/2;
			if(mid==0){
				pos=high;
				break;
			}
			if(arr[mid]<=arr[mid-1] && arr[mid]<=arr[mid+1]){
				pos=mid;
				break;
			}
			if(arr[mid]<=arr[high]){
				high=mid-1;
			}
			if(arr[mid]>=arr[low]){
				low=mid+1;
			}
		}
		
		System.out.println(pos);
		
	}

	public void searchInCircularySortedArray(int arr[],int n){
		int low=0;
		int high=arr.length-1;
		int pos=-1;
		while(low<=high){
			int mid=(high+low)/2;
			System.out.println("Start : "+low+" End: "+high+" Mid::"+mid +" arr[mid]:"+arr[mid]);
			if(arr[mid]==n) //Case 1
			{
			 pos=mid;
			 System.out.println("Pos:"+pos);
			 break;
			}
			if(arr[mid]<=arr[high]){
				if(n>arr[mid] && n<=arr[high]){
					low=mid+1;
				}
				else {
					high=mid-1;
				}
			}
			if(arr[mid]>=arr[low]){
				if(n>=arr[low] && n<arr[mid]){
					high=mid-1;
				}
				else {
					low=mid+1;
				}
			}
		}
		
		System.out.println(pos);
		
	}
	
}
