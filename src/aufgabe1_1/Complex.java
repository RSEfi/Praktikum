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

	private double real;
	private double imag;
	private double abs;
	private double phase;
		
	public Complex(){
		real = 0.0;
		imag = 0.0;		
	}
	
	public Complex(double real, double imag) {
		this();
		this.real = real;
		this.imag = imag;
	}
	
	public double getReal() {
		return real;
	}

	public double getImag() {
		return imag;
	}
	
	public double getAbs() {
		abs = Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
		return abs;
	}

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
	public Complex div(Complex z){
		this.real = ((this.real * z.real) - (this.imag * z.imag));
		this.imag = ((this.real * z.imag) + (this.imag * z.real));		
		return this;
	}
}
