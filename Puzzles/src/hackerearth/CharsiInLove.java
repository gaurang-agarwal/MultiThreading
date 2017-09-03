package hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/charsi-in-love/
public class CharsiInLove {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		long n= sc.nextLong();
		long num1=0;
		long sum=0;
		long count=1;
		ArrayList<Long> result = new ArrayList<>();
		while(sum<=n)
		{
			num1=sum;
			sum=sum+count++;
			result.add(num1);
		}
		int index = result.size()-1;
		System.out.println(result);
		while(index>=0)
		{
			long remainder = n-result.get(index);
			if(search(result, remainder) !=-1)
			{
				System.out.println(result.get(index)+" "+remainder);
				System.out.println("YES");
				return;
			}
			index--;
		}
		System.out.println("NO");
	}
	
	private static int search(List<Long> arr,long n)
	{
		int closest =-1;
		int start = 0;
		int end = arr.size();
		while(start<end)
		{
			int mid = start+(end-start)/2;
			if(arr.get(mid)==n)
			{
				closest=mid;
				break;
			}
			if(arr.get(mid)< n)
				{
					start = mid+1;
				}
			else
			{
				end=mid;
			}
			
		}
		return closest;
	}

}