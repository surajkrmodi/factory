
public class MemoryJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Strings are immutable
		  String s1 = "ram"; // String pool 
		  String s2 = "ram";
		  System.out.println(s1==s2);
		  System.out.println(s2);
		  String s3 = s2.concat("Kumar");
		  System.out.println(s3);
		 
		
		
			/*
			 * String s1 = "ram"; 
			 * String s2 = new String("ram"); 
			 * System.out.println(s1==s2);
			 * s2.concat("Kumar");
			 */
		 
	}

}
