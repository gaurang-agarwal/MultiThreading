package puzzles;

import java.util.Arrays;

public class KnapSack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Item items[] = new Item[]{
				new Item(1, 1),
				new Item(4, 3),
				new Item(5, 4),
				new Item(7, 5)
		};
		int totalWeight=7;
		int valueMatrix[][] = new int[items.length+1][totalWeight+1];
		for(int i=1;i<=items.length;i++)
		{
			for(int j =1;j<=totalWeight;j++)
			{
				if(items[i-1].w <= j)
				{
				
					valueMatrix[i][j]=Math.max(items[i-1].v + valueMatrix[i-1][j-items[i-1].w], valueMatrix[i-1][j]);
				}
				else
				{
					valueMatrix[i][j]=valueMatrix[i-1][j];
				}
			}
		}
		for(int v[] :valueMatrix )
		{
			System.out.println(Arrays.toString(v));
		}
	}

	
	static class Item
	{
		int w;
		int v;
		public Item(int v,int w) {
			this.w=w;
			this.v=v;
		}
	}
}
