package interview;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new ReverseString().recursivelyReverse("Hello World"));
		
	}

	public String recursivelyReverse(String str){
		if(str.length()<2)
			return str;
		
		return recursivelyReverse(str.substring(1))+str.charAt(0);
		
	}
	
	
}
