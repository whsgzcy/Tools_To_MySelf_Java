package t;

public class Static2NoStatic {
		
	
	public static void main(String[] args) {
		
	  int a = 1;
	  int b = 2;
	  
	  boolean is;
	  // - + 
	  is = (a<b) && (a >b);
	  System.out.println(is);
	  // - - 
	  is = (a>b) &&(b>3);
	  System.out.println(is);
	}

}
