package hackerearth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerearth.com/challenge/hiring/thoughtworks-women-application-developer-hiring-challenge/algorithm/eat-or-not-22/
public class EatOrNot {

	private static HashMap<String, Set<Set<Fruit>>> allPairFruits = new HashMap<>();
	static 
	{
		allPairFruits.put("V", new HashSet<>());
		allPairFruits.put("C", new HashSet<>());
		allPairFruits.put("P", new HashSet<>());
		allPairFruits.put("D", new HashSet<>());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		long targetV = sc.nextLong();
		long targetC = sc.nextLong();
		long targetP = sc.nextLong();
		long targetD = sc.nextLong();
		int N = sc.nextInt();
		Fruit [] fruitPresent = new Fruit[N];
		for(int i=0;i<N;i++)
		{
			fruitPresent[i] = new Fruit(sc.nextLong(), sc.nextLong(), sc.nextLong(), sc.nextLong());
		}
		
	allFruitCombination(fruitPresent, 0, targetV, 0, "V",new HashSet<>());
	allFruitCombination(fruitPresent, 0, targetC, 0, "C",new HashSet<>());
	allFruitCombination(fruitPresent, 0, targetP, 0, "P",new HashSet<>());
	allFruitCombination(fruitPresent, 0, targetD, 0, "D",new HashSet<>());
	
	Set<Set<Fruit>> V = allPairFruits.get("V");
	V.retainAll(allPairFruits.get("C"));
	V.retainAll(allPairFruits.get("P"));
	V.retainAll(allPairFruits.get("D"));
	if(V.size()>0)
		System.out.println("YES");
	else
		System.out.println("NO");
	}
	
public static void allFruitCombination(Fruit [] f,int index,long target,long sum,String type,Set<Fruit> fruitList)
{
	
	if(index>=f.length)
	{
		if(target==sum)
		{
			Set<Set<Fruit>> list=allPairFruits.get(type); 
			list.add(fruitList);
		}
		return;
	}
	
	allFruitCombination(f, index+1, target, sum, type, new HashSet<>(fruitList));
	
	Set<Fruit> includeList = new HashSet<>(fruitList);
	includeList.add(f[index]);
	allFruitCombination(f, index+1, target, sum+getValue(f[index], type), type, includeList);
	
}

private static long getValue(Fruit f,String value)
{
	if("V".equals(value))
		return f.V;
	else if("C".equals(value))
		return f.C;
	else if("P".equals(value))
			return f.P;
	else
		return f.D;
}
	
	static class Fruit
	{
		public long V = 0;
		public long C = 0;
		public long P = 0;
		public long D = 0;
		
		public Fruit(long V,long C,long P,long D) {
			this.V=V;
			this.C=C;
			this.P=P;
			this.D=D;
		}
		@Override
		public boolean equals(Object obj) 
		{
		Fruit f =(Fruit)obj;	
			return f.V==V  && f.C==C && f.P==P && f.D==D;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "V:"+V+" C:"+C+" P:"+P+" D:"+D;
		}
	}
	
}
