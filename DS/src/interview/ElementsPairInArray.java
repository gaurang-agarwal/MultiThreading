package interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ElementsPairInArray {

	//Given an element n find all elements {i,k}such that a[i]-a[k]=n
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printAllPairs(new int[]{0,1,2,3,4,5,6,7,8,9}, 5);
		
		
	}


	private static void printAllPairs(int []arr,int n){
		Map <Integer,Integer>valueMap = new HashMap<Integer, Integer>();
		for (int i=0;i<arr.length;i++)
		{
			valueMap.put(arr[i], i);
		}
		
		
		Iterator<Integer> it = valueMap.keySet().iterator();
		Integer value;
		while(it.hasNext()){
			value=it.next();
		if(valueMap.get(value-n)!=null)
		{
			System.out.println("{"+valueMap.get(value)+","+valueMap.get(value-n)+"}");
		}
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	
}


