package polynomial;

/**
 * 
 * This class represent a polynomial, 
 * 
 */
public class Polynomial {
	protected int[] coefficients;
	protected int degree;
	
	public Polynomial() {
		// Default polynomial is 0
		coefficients = new int[] {0};
		degree = 0;
	}
		
	/* Construct the polynomial given it's coefficients */ 
	public Polynomial(int[] coeffs) {
		//TO DO
		//System.out.println("look here------");
		//For loop to iterate through the array to find the highest index which should be the degree of the polynomial
		for(int i =0; i < coeffs.length; i++) {
			if(coeffs[i] != 0) {
				degree = i;
			}
		}
		
		coefficients = new int[coeffs.length]; 
		// For loop to grab each coefficient of the polynomial.
		for(int i = 0; i < coeffs.length; i++) {
			coefficients[i] = coeffs[i];
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		//For loop iterates through each coefficients and multiplies it by factor.
		for (int i = 0; i<= degree; i++) {
			coefficients[i] *= factor; 
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(degree, p.degree);
		int[] newCoefficients = new int[maxDegree+1];// come back to this one
		
		for(int i = 0; i <= this.degree;i++) {
			newCoefficients[i] = this.coefficients[i];
		}
		
		for (int i = 0; i <= p.degree; i++) {
			newCoefficients[i] += p.coefficients[i];
		}
		this.coefficients = newCoefficients;
		this.degree = maxDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(degree, p.degree);
		int[] newCoefficients = new int[maxDegree+1];
		
		for(int i = 0; i <= this.degree; i++) {
			newCoefficients[i] = this.coefficients[i];
		}
		
		for(int i = 0; i <= p.degree; i++) {
			newCoefficients[i] -= p.coefficients[i];
		}
		
		this.coefficients = newCoefficients;
		this.degree = maxDegree;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		if(this.degree == 0) {
			return new Polynomial(new int[] {0});
		}
		
		int[] derivativeCoeffs = new int[this.degree];
		
		for (int i = 1 ; i <= this.degree; i++) {
			derivativeCoeffs[i-1] = i*this.coefficients[i];
		}
		return new Polynomial(derivativeCoeffs);
		
		//STUB
	}
	
	/* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public float atPoint(float arg) {
		//TO DO
		float result = 0;
				//for loop goes through all coefficients
		for(int i = 0; i<= this.degree; i++) {
			// calculate the value of the current term
			float term = this.coefficients[i]*(float) Math.pow(arg, i);
			result += term; //adds term to the result 
		}
		return result; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		String result = "";
		for(int i = this.degree; i>=0; i--) {
			int coeff = this.coefficients[i];
			
			if(coeff == 0) continue;
			
			if(!result.isEmpty() && coeff >0) {
				result += " + ";
			}else if (coeff <0) {
				result += " - ";
				coeff = -coeff;
			}
			
			if(i == 0) {
				result += coeff;
			
			} else if (i==1) {
				result += coeff + "x";
			} else {
				result += coeff + "x" + i;
			}
			
		}
		
		if(result.isEmpty()) {
			return "0";
		}
		return result; //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public float[] solve() {
		return null;
	}
	
}
