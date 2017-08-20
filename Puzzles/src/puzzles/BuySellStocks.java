package puzzles;


public class BuySellStocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[] = {2, 30, 90, 10, 8, 25, 80};
    	
		//int price[] = {30,50,1,40};
		
		BuySellStocks bss = new BuySellStocks();
		bss.oneTransactionAllowed(price);
		bss.twoTransactions(price);
		bss.nTransactionAllowed(price);
		
		
		
	}

	/*
	 * We can do this O(n) using following Efficient Solution. The idea is to store maximum possible profit of every subarray and solve the problem in following two phases.

	1) Create a table profit[0..n-1] and initialize all values in it 0.

	2) Traverse price[] from right to left and update profit[i] such that profit[i] stores maximum profit achievable from one transaction in subarray price[i..n-1]

	3) Traverse price[] from left to right and update profit[i] such that profit[i] stores maximum profit such that profit[i] contains maximum achievable profit from two transactions in subarray price[0..i].

	4) Return profit[n-1]

	To do step 1, we need to keep track of maximum price from right to left side and 
	to do step 2, we need to keep track of minimum price from left to right. 
	Why we traverse in reverse directions? 
	The idea is to save space, in second step,we use same array for both purposes, 
	maximum with 1 transaction and maximum with 2 transactions. 
	After an iteration i, the array profit[0..i] contains maximum profit with 2 transactions 
	and profit[i+1..n-1] contains profit with two transactions.
	 */

	
	public void twoTransactions(int []price)
	{
	    
        int profit [] = new int[price.length];
        int maxPrice = price[price.length-1];
        //Max Profit for 1 transaction
		for(int i=price.length-2;i>=0;i--)
		{
			if(price[i]>maxPrice)
				maxPrice=price[i];
			
			profit[i]= Math.max(profit[i+1], maxPrice-price[i]);
		}
		
        int minPrice =price[0]; 
		for(int i=1;i<price.length;i++)
		{
			if(minPrice>price[i])
				minPrice=price[i];
			
			profit[i] = Math.max(profit[i-1], profit[i]+price[i]-minPrice);
			
		}
		
		System.out.println("Max profit after 2 Transaction "+profit[profit.length-1]);
	}
	
	
	public void oneTransactionAllowed(int price[])
	{
		
		
		int maxProfit = 0;
        int maxPrice = price[price.length-1];
        //Max Profit for 1 transaction
		for(int i=price.length-2;i>=0;i--)
		{
			if(price[i]>maxPrice)
				maxPrice=price[i];
			
			maxProfit= Math.max(maxProfit, maxPrice-price[i]);
		}
		
		System.out.println("Max profit after 1 Transaction "+maxProfit);
	}
	
	
	public void nTransactionAllowed(int price[])
	{
	
		int profit = 0;
        int maxPrice = price[price.length-1];
        //Max Profit for 1 transaction
		for(int i=price.length-2;i>=0;i--)
		{
			if(price[i]>maxPrice)
				maxPrice=price[i];
			profit= profit+ maxPrice-price[i];
		}
		
		System.out.println("Max profit after n Transaction "+profit);
		
	}
	
}
