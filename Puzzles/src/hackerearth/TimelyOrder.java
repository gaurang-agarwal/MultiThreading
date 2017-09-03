package hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimelyOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TimelyOrder to = new TimelyOrder();
		
		Scanner sc = new Scanner(System.in);
		int query  = sc.nextInt();
		List<Order> orderList = new ArrayList<Order>(query);
		int totalOrders = 0;
		while(0<query--)
		{
			int queryType = sc.nextInt();
			if(queryType==1)
			{
				totalOrders++;
				orderList.add(new Order(sc.nextLong(), sc.nextLong()));
			}
			else
			{
				to.processResult(orderList,sc.nextInt(),sc.nextInt(),totalOrders);
			}
			
			
		}
	}

	

	private void processResult(List<Order> arr, int K, int T,int end) 
	{
		int startTime = closestGreaterThanN(arr, T-K,end);
		int endTime = closestLessThanN(arr, T,end);
		System.out.println("StartTime : "+arr.get(startTime)+"--"+arr.get(endTime));
		long result = 0;
		if(startTime!=-1 && endTime !=-1)
		{
		for(int i=startTime;i<=endTime;i++)
		{
			result=result+arr.get(i).weight;
		}
		}
		System.out.println(result);
		
	}



	private int closestLessThanN(List<Order> arr,int n,int end)
	{
		int closest =-1;
		int start = 0;
		while(start<end)
		{
			int mid = start+(end-start)/2;
			if(arr.get(mid).time <= n)
				{
					closest=mid;
					if(arr.get(mid).time==n)
						break;
					start = mid+1;
					
				}
			else
			{
				end=mid;
			}
			
		}
		return closest;
	}
	
	private int closestGreaterThanN(List<Order> arr,int n,int end)
	{
		int closest =-1;
		int start = 0;
		while(start<end)
		{
			int mid = start+(end-start)/2;
			if(arr.get(mid).time < n)
				{
					start = mid+1;
				}
			else
			{
				closest=mid;
				if(arr.get(mid).time==n)
					break;
				
				end=mid;
			}
			
		}
		return closest;
	}
	
	
	static class Order
	{
		long time;
		long weight;
		public Order(long wight,long time) 
		{
		this.time=time;
		this.weight=wight;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return weight+" "+time;
		}
	}
	
}
