import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FractionClaculatorAdvanced {
	
	private static String[] getWholeOperation(Scanner s) {
		String[] sSubString = {"","",""};
		boolean validation = false;
		while(!validation) {
			
			int x=0;
			System.out.print("Enter an operation (Q to quit): ");
			String input = s.nextLine();
			if (input.contains("q") || input.contains("Q")) {break; }
			sSubString = input.split(" ");
			if (sSubString.length!= 3) {
				System.out.println("Invalid operation. Must be \"[FRAC] [OPERATION] [FRAC]\".");
			}
			else {
				for (int i = 0; i<sSubString.length; i++) {
					if (sSubString[0].charAt(0) == '-') {x=1;}
					if (i==x || i==(x+2)) {
						if (!validFraction(sSubString[i])) {
							System.out.println("Invalid operation. Must be \"[FRAC] [OPERATION] [FRAC]\".");
							break;
						}
					}
					else {
						if (!validOperation(sSubString[i])) {
							
							System.out.println("Invalid operation. Must be \"[FRAC] [OPERATION] [FRAC]\".");
							break;
						}
					}
					validation = true;
				}
			}
		}
		return sSubString;
	}
	
	
	
	private static boolean validOperation(String s) {
		Set<String> operation = new HashSet<String>();
		operation.add("+");
		operation.add("-");
		operation.add("*");
		operation.add("/");
		operation.add("=");
		operation.add("q");
		operation.add("Q");
		
		if (operation.contains(s)) { return true; }
		return false;
	}
	
	
	private static boolean validFraction(String input) {

		int x=0;
		if(input.charAt(0) == '-') {
			x=1;
		}
		if (input.contains("/")) {

			int index = input.indexOf("/");
		
			
			return isNumber(input.substring(x,index)) && isNumber(input.substring(index+1,input.length()));
		}

			
		return isNumber(input.substring(x,input.length()));
	}
	
	public static boolean isNumber(String input) {
		int count = 0;
		if(input.length()==0) {
			return false;
		}
		for (int i = 0; i<input.length();i++) {
			if ((int)input.charAt(i) < 58 && (int)input.charAt(i)>47) {
				count++;
			}
		}
		return count==input.length();
	}
	
	
	static int[] fractionNumDen (String input) {
		int[] result = {0,0};
		int x = 0;
		int index = input.indexOf('/');

		if(input.charAt(0) == '-') {
			x=1;
		}
		if ( index >= 0) {
			result[0] = Integer.parseInt(input.substring(x,index));
			result[1] = Integer.parseInt(input.substring(index+1,input.length()));
		}
		else {
			result[0] = Integer.parseInt(input.substring(x,input.length()));
			result[1] = 1;
		}
		if (x==1)
			result[0]*=(-1);
		return result;
	}
	
	
	public static void main(String args[]) {
		System.out.println("This program is a fraction calculator\n"
				+ "it will add, subtract, multiply, and divide fractions until you type Q to quit.\n"
				+ "Valid operations are of the form \"[FRAC] [OPERATION] [FRAC]\".\n"
				+ "[FRAC] can be either a single integer or two integers separated by \"/\".\n"
				+ "[OPERATION] can be +,-,*,/, or =.\n"
				+ "-------------------------------------------------------------------------------");
		String[] operation = {" ","",""};
		Scanner scanner = new Scanner(System.in);
		
		while (!operation[0].equalsIgnoreCase("Q") && operation[0].length() != 0) {
			operation = getWholeOperation(scanner);	
			if (!operation[0].equalsIgnoreCase("Q") && operation[0].length() != 0) {
				List<Fraction> fracList = new ArrayList<Fraction>();

				for (int i=0;i<operation.length;i++) {
					int[] number = fractionNumDen(operation[i]);
					Fraction frac = new Fraction(number[0],number[1]);
					fracList.add(frac);
					i++;
				}
				
				Fraction result = new Fraction();
				String resultTrue = " false";
				System.out.print(fracList.get(0).toString() + " " + operation[1] + " " + fracList.get(1).toString() + " = ");
				switch (operation[1]){
					case "+":
						result = fracList.get(0).add(fracList.get(1));
						result.toLowestTerms();
						System.out.println(result.toString());
						break;
						
					case "-":
						result = fracList.get(0).subtract(fracList.get(1));
						result.toLowestTerms();
						System.out.println(result.toString());
						break;
						
					case "*":
						result = fracList.get(0).multiply(fracList.get(1));
						result.toLowestTerms();
						System.out.println(result.toString());
						break;
						
					case "/":
						result = fracList.get(0).divide(fracList.get(1));
						result.toLowestTerms();
						System.out.println(result.toString());
						break;
						
					case "=":
						if (fracList.get(0).equals(fracList.get(1))){
							resultTrue = "true";
						}
						System.out.println(resultTrue);
						break;
						
					default:
						break;
				}
				System.out.println("-------------------------------------------------------------------------------");
				
			}
		}
	}
}

	
