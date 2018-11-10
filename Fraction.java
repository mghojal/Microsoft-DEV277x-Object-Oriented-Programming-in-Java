import java.util.Scanner;
import java.lang.IllegalArgumentException;


public class Fraction {
	
	//Attributes
	private int nominator;
	private int denominator;
	// ******************************
	// Constructors
	public Fraction(int n, int d) throws IllegalArgumentException{
		super();
		if (d<0) {
			d*=(-1);
			n*=(-1);
		}
		this.nominator = n;
		this.denominator = d;
	}
	public Fraction(int n) {
		super();
		this.nominator = n;
		this.denominator = 1;
	}
	public Fraction() {
		super();
		this.nominator = 0;
		this.denominator = 1;
	}
	// **************************************
	// Methods
	public int getNumerator() {
		return this.nominator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	public String toString() {
		String s;
		if (this.denominator == 1)
			s = Integer.toString(this.nominator);
		else
			s = this.nominator + "/" + this.denominator;
		return s;
	}
	
	public double toDouble() {
		return (double) (this.nominator/this.denominator);
	}
	
	public Fraction add(Fraction other) {
		int n =  (this.nominator * other.denominator) + (other.nominator * this.denominator) ;
		int d =  other.denominator * this.denominator;
		Fraction frac = new Fraction(n,d);
		return frac;
	}
	
	public Fraction subtract(Fraction other) {
		
		int n =  (this.nominator * other.denominator) - (other.nominator * this.denominator) ;
		int d =  other.denominator * this.denominator;
		Fraction frac = new Fraction(n,d);
		return frac;
	} 
	
	public Fraction multiply(Fraction other) {
		int n =  other.nominator * this.nominator;
		int d =  other.denominator * this.denominator;
		Fraction frac = new Fraction(n,d);
		return frac;
	}
	
	public Fraction divide(Fraction other) {
		int n =  other.denominator * this.nominator;
		int d =  other.nominator * this.denominator;
		Fraction frac;
		if (n%d == 0)
		frac = new Fraction(n/d);
		else
		frac = new Fraction(n,d);
		return frac;
	}
	
	public boolean equals(Fraction obj) {
		int n,n1,d,d1;
		d = obj.denominator;
		d1 = this.denominator;
		n = obj.nominator;
		n1 = this.nominator;
		
		if (this.denominator > obj.denominator) {
			d = this.denominator;
			d1 = obj.denominator;
			n = this.nominator;
			n1 = obj.nominator;
		}
		else if (this.denominator == obj.denominator) {
			if ( this.nominator == obj.nominator) { return true;}
		}

		int divDe = d/d1;
		int divRe = d%d1;
		if (divRe == 0) {
			if(divDe == n/n1) {
				return true;
			}
		}
		return false;
	}
	
	
	public void toLowestTerms() {
		int factor = gcd(this.nominator,this.denominator);
		this.nominator/=factor;
		this.denominator/=factor; 
	}
	
	private static int gcd (int num, int den){
		while (num!=0 && den !=0) {
			int rem = num%den;
			num = den;
			den = rem;
		}
		return num;
	}
	
}
