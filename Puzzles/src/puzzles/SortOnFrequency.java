package puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SortOnFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]={2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
		Map<Integer,Data> map = new HashMap<>();
		for(int a :arr)
		{
			if(map.containsKey(a))
			{
				map.get(a).incrementFrequency();
			}
			else
			{
				map.put(a, new Data(a));
			}
		}
		
		
		
		Set<Data> sortedData = new TreeSet<>(map.values());
		List<Integer> result = new ArrayList<>();
		for(Data d : sortedData)
		{
			for(int i=0;i<d.frequency;i++)
				result.add(d.number);
		}
		System.out.println(result);
	}
	
	
	private static class Data implements Comparable<Data>
	{

		private int number;
		private int frequency;
		public Data(int number) {
			this.number=number;
			frequency=1;
		}
		public void incrementFrequency()
		{
			frequency++;
		}
		@Override
		public int compareTo(Data o) {
			return this.frequency < o.frequency ? 1 :  this.frequency > o.frequency ?-1 :this.number > o.number ? 1:this.number< o.number ? -1:0;
		}
		
		
		
	}

}
