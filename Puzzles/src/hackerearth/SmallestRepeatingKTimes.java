package hackerearth;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SmallestRepeatingKTimes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<Integer,Integer> countMap = new TreeMap<>();
		for(int i=0;i<N;i++)
		{
			int e = sc.nextInt();
			Integer f =countMap.get(e);
				if(f==null)
				{
					f=0;
				}
				f++;
				countMap.put(e, f);
			
		}
		int k = sc.nextInt();
		countMap.entrySet().stream().filter(e-> e.getValue().equals(k)).limit(1).forEach(e-> System.out.print(e.getKey()));
		
	}

}
