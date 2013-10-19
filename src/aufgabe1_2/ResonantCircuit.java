package aufgabe1_2;
import aufgabe1_1.Complex;	// Imports the Complex.class from the package "aufgabe1_1"

/**
 * ResonantCircuit.<p>
 * 
 * Represents a series resonant circuit RLC<br>
 * with resistor = 10 ohm, inductor = 10 mH,<br>
 * capacitor = 10 nF.<br> 
 * Returns the voltage over the resistor<br>
 * The output of the voltage is in a range of<br>
 * 10 kHz to 100 kHz in steps of 10 kHz.
 * 
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-10-16
 */
public class ResonantCircuit {
	public static final double resistor = 10.0;
	public static final double inductor = 0.01;
	public static final double capacitor = 0.00000001;
	public static final double voltage0 = 1;
	double[] frequency = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
	double[] omega = new double[10];
	double[] voltage = new double[10];
	
	public ResonantCircuit() {
		// calculates an array with omega
		for (int i = 0 ; i < frequency.length ; i++){
			omega[i] = 2 * Math.PI * frequency[i];
		}		
	}
	
	/**
	 * voltageOverResistor.<p>
	 * 
	 * Calculates the voltage over the resistor (Ur)<br>
	 * with the help of the methods of Complex class
	 * 
	 * @param omega angular frequency
	 * @return polar[][] the voltage over resistor in polar form
	 */	
	public static double[] [] voltageOverResistor(double[] omega){
		Complex[] impedanceLC = new Complex[10];
		Complex[] impedanceC = new Complex[10];
		Complex[] voltageOverResistor = new Complex[10];
		double[] [] polar = new double[10][2];
						
		for (int i = 0 ; i < impedanceLC.length ; i++){
			Complex z1 = new Complex(1.0 , 0.0);
			Complex zc = new Complex(0 , omega[i] * capacitor);
			Complex zl = new Complex(0 , omega[i] * inductor);
		
			impedanceC[i] = Complex.div(z1, zc);	// calculates impedance of the capacitor
			impedanceLC[i] = Complex.add(zl, impedanceC[i]);	// calculates impedance of capacitor and inductor
		}
		
		for (int i = 0 ; i < voltageOverResistor.length ; i++){
			Complex numerator = new Complex(resistor * voltage0, 0);	// calculates the numerator
			Complex denominator = new Complex(resistor, impedanceLC[i].getImag());	// calculates the denominator
						
			voltageOverResistor[i] = Complex.div(numerator, denominator); // calculates the voltage over resistor
			
			polar[i] [0] = voltageOverResistor[i].getAbs();	// fills the column with the amount of Ur
			polar[i] [1] = (voltageOverResistor[i].getPhase()) * 360 / (2 * Math.PI);	// fills the column with the phase of Ur
		}
		
		return polar;
	}
	
	// 
	public static void main(String[] args) {
		ResonantCircuit rlc = new ResonantCircuit();
		
		double[][] polar = ResonantCircuit.voltageOverResistor(rlc.omega);
		
		System.out.println("Voltage over resistor in polar form");	// Output of headline
		System.out.println("");	// just a blank line
		System.out.println("Frequency" + " amount" + "                 phase");
		
		for (int j = 0 ; j < polar.length ; j++){
			// Output a table with frequency, amount and phase
			System.out.println(rlc.frequency[j] +"   " + polar[j][0] + "    " + polar[j][1]);
		}		

	}

}
