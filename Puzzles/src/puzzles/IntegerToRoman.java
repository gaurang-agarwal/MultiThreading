package puzzles;

public class IntegerToRoman {

	
	private static RomanSymbols [] table= {
			new RomanSymbols(1, "I"),
			new RomanSymbols(4, "IV"),
			new RomanSymbols(5, "V"),
			new RomanSymbols(9, "IX"),
			new RomanSymbols(10, "X"),
			new RomanSymbols(40, "XL"),
			new RomanSymbols(50, "L"),
			new RomanSymbols(90, "XC"),
			new RomanSymbols(100, "C"),
			new RomanSymbols(400, "CD"),
			new RomanSymbols(500, "D"),
			new RomanSymbols(900, "CM"),
			new RomanSymbols(1000, "M"),
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num=99;
		int times;
			for(int i=table.length-1;i>=0;i--)
			{
				times=num/table[i].value;
				num = num%table[i].value;
				while(times-->0)
				System.out.print(table[i].symbol);
				if(num==0)
					break;
			}
		
		
	}

	
	private static class RomanSymbols
	{
		int value;
		String symbol;
		public RomanSymbols(int value,String symbol) {
			this.value=value;
			this.symbol=symbol;
		}
		
		public int getValue() {
			return value;
		}
		public String getSymbol() {
			return symbol;
		}
	}
	
}
