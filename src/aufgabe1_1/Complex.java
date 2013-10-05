package aufgabe1_1;
/**
 * Complex.<p>
 * 
 * Represents a complex number z = a + i*b with real part
 * Re(z) = a and imaginary part Im(z) = b.
 *  
 * @author RSEfi
 * @version 2013-10-05
 */
public class Complex {

	private double real;	// requirement 1
	private double imag;	// requirement 1
	private double abs;	// requirement 6
	private double phase;	// requirement 7
	
	// requirement 2
	public Complex(){
		real = 0.0;
		imag = 0.0;		
	}
	
	// requirement 3
	public Complex(double real, double imag) {
		this();
		this.real = real;
		this.imag = imag;
	}
	
	// requirement 4
	public double getReal() {
		return real;
	}

	// requirement 4
	public double getImag() {
		return imag;
	}
	
	// requirement 6
	public double getAbs() {
		abs = Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
		return abs;
	}
	
	// requirement 7
	public double getPhase() {
		phase = Math.atan2(imag, real);
		return phase;
	}

	/**
	 * Addition with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 + z2 = (a + i*b) + (c + i*d) = (a + c) + i * (b + d)
	 * 
	 * @param z Complex number to add with
	 * @return reference of this object after addition
	 */
	// requirement 5
	public Complex add(Complex z){
		this.real = (this.real + z.real);
		this.imag = (this.imag + z.imag);
		return this;
	}
	
	/**
	 * Subtraction with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 - z2 = (a + i*b) - (c + i*d) = (a - c) + i * (b - d)
	 * 
	 * @param z Complex number to subtract with
	 * @return reference of this object after subtraction
	 */
	// requirement 5
	public Complex sub(Complex z){
		this.real = (this.real - z.real);
		this.imag = (this.imag - z.imag);
		return this;
	}
	
	/**
	 * Multiply with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 * z2 = (a + i*b) * (c + i*d) = (ac - bd) + i * (ad + bc)
	 * 
	 * @param z Complex number to multiply with
	 * @return reference of this object after multiplication
	 */
	// requirement 5
	public Complex mul(Complex z){
		this.real = ((this.real * z.real) - (this.imag * z.imag));
		this.imag = ((this.real * z.imag) + (this.imag * z.real));
		return this;
	}
	
	/**
	 * Division with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 / z2 = [(ac + bd) / (c² + d²)] + i * [(cb - ad) / (c² + d²)]
	 * 
	 * @param z Complex number to divide with
	 * @return reference of this object after division
	 */	
	// requirement 5
	public Complex div(Complex z){
		this.real = ((this.real * z.real) + (this.imag * z.imag)) / (Math.pow(z.real, 2) + Math.pow(z.imag, 2));
		this.imag = ((z.real * this.imag) - (this.real * z.imag)) / (Math.pow(z.real, 2) + Math.pow(z.imag, 2));		
		return this;
	}
	
	/**
	 * Addition with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 + z2 = (a + i*b) + (c + i*d) = (a + c) + i * (b + d)
	 * 
	 * @param z1 Complex number to add with
	 * @param z2 Complex number to add with
	 * @return reference of this object after addition
	 */
	// requirement 8
	public static Complex add(Complex z1, Complex z2){
		Complex Z = new Complex();
		Z.real = (z1.real + z2.real);
		Z.imag = (z1.imag + z2.imag);
		return Z;
	}
	
	/**
	 * Subtraction with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 - z2 = (a + i*b) - (c + i*d) = (a - c) + i * (b - d)
	 * 
	 * @param z1 Complex number to subtract with
	 * @param z2 Complex number to subtract with
	 * @return reference of this object after subtraction
	 */
	// requirement 8
	public static Complex sub(Complex z1, Complex z2){
		Complex Z = new Complex();
		Z.real = (z1.real - z2.real);
		Z.imag = (z1.imag - z2.imag);
		return Z;
	}
	
	/**
	 * Multiply with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 * z2 = (a + i*b) * (c + i*d) = (ac - bd) + i * (ad + bc)
	 * 
	 * @param z1 Complex number to multiply with
	 * @param z2 Complex number to multiply with
	 * @return reference of this object after multiplication
	 */
	// requirement 8
	public static Complex mul(Complex z1, Complex z2){
		Complex Z = new Complex();
		Z.real = ((z1.real * z2.real) - (z1.imag * z2.imag));
		Z.imag = ((z1.real * z2.imag) + (z1.imag * z2.real));
		return Z;
	}
	
	/**
	 * Division with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 / z2 = [(ac + bd) / (c² + d²)] + i * [(cb - ad) / (c² + d²)]
	 * 
	 * @param z1 Complex number to divide with
	 * @param z2 Complex number to devide with
	 * @return reference of this object after division
	 */	
	// requirement 8
	public static Complex div(Complex z1, Complex z2){
		Complex Z = new Complex();
		Z.real = ((z1.real * z2.real) + (z1.imag * z2.imag)) / (Math.pow(z2.real, 2) + Math.pow(z2.imag, 2));
		Z.imag = ((z2.real * z1.imag) - (z1.real * z2.imag)) / (Math.pow(z2.real, 2) + Math.pow(z2.imag, 2));
		return Z;
	}

	/** 
	 * toString method.<p>
	 * 
	 * Checks the sign from <imag> and change the format to a string. 
	 * 
	 * @return (real + imag *j) or (real - imag *j)
	 */
	// requirement 9
	@Override
	public String toString() {
		if (imag >= 0){
			return "(" + real + " + " + imag + " * j)";
		} else {
			return "(" + real + " - " + imag + " * j)"; 
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	// requirement 10
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complex other = (Complex) obj;
		if (Double.doubleToLongBits(imag) != Double
				.doubleToLongBits(other.imag))
			return false;
		if (Double.doubleToLongBits(real) != Double
				.doubleToLongBits(other.real))
			return false;
		return true;
	}
	
	
}
