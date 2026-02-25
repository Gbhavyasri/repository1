package practicedatadriventesting;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
//        Choose a character random from this String
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
//		Create StringBuffer size of AlphaNumericString
		StringBuilder sb=new StringBuilder(n);
		
		for(int i=0;i<n;i++) {
//			Generate a random number between 0 to AlphaNumericString variable length
			int index=(int)(AlphaNumericString.length()*Math.random());
			
//			add Character one by one in the end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.println(sb);
	}

}
