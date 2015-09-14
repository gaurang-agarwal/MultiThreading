package interview;

public class OccurenceUsingBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new OccurenceUsingBinarySearch().firstOccurence(new int []{1,2,2,2,2,2,2,4,4,6,8,10},4);
		new OccurenceUsingBinarySearch().lastOccurence(new int []{1,2,2,2,2,2,2,4,4,4,6,8,10},4);
		//No of times repeated = first-last+1

	}
	
	public void firstOccurence(int arr[],int n){
		int start=0;
		int end=arr.length;
		int occurence=-1;
		while(start<end){
			int mid=(start+end)/2;
			System.out.println("Start : "+start+" End: "+end+" Mid::"+mid +" arr[mid]:"+arr[mid]);
			if(arr[mid]==n)
			{
				occurence=mid;
				end=mid;
			}
			else if(arr[mid]<n)
			{
				start=mid+1;
			}
			else 
			{
				end=mid;	
			}
			
			
		}
		
System.out.println("First Occurence Found at:"+occurence);		
}
	
	public void lastOccurence(int arr[],int n){
		int start=0;
		int end=arr.length;
		int occurence=-1;
		while(start<end){
			int mid=(start+end)/2;
			System.out.println("Start1 : "+start+" End: "+end+" Mid::"+mid +" arr[mid]:"+arr[mid]);
			if(arr[mid]==n)
			{
				occurence=mid;
				start=mid+1;
			}
			else if(arr[mid]<n)
			{
				start=mid+1;
			}
			else 
			{
				end=mid;	
			}
			
			
		}
		
System.out.println("Last Occurence Found at:"+occurence);		
}
	
	

}
