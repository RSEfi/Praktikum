/**
 * 
 */
package aufgabe1_2;
import aufgabe1_1.Complex;

/**
 * @author RSEfi
 * @version 2013-10-16
 */
public class ResonantCircuit {
	public static final double resistor = 10.0;
	public static final double inductor = 0.01;
	public static final double capacitance = 0.00000001;
	public static final double voltage0 = 1;
	double[] frequency = new double[10];
	double[] omega = new double[10];
	double[] voltage = new double[10];
	
	/**
	 * Constuctor.<p>
	 * 
	 * Erstellt ein Array für Frequenzen von 10kHz bis 100kHz in 10kHz schritten.
	 * Erstellt mit dem Frequnez-Array ein Array für die Kreisfrequez.
	 * omega=2*pi*f
	 */	
	public ResonantCircuit() {
		double[] frequency = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
		for (int i = 0 ; i < frequency.length ; i++){
			omega[i] = 2 * Math.PI * frequency[i];
		}		
	}
	/**
	 * Division with a complex number.<p>
	 * 
	 * For z1 = a + i*b and z2 = c + i*d:<br>
	 * z1 / z2 = [(ac + bd) / (c² + d²)] + i * [(cb - ad) / (c² + d²)]
	 * 
	 * @param omega[] Kreisfrequenz
	 * @return Z after division
	 */	
	public static double[] [] voltageOverResistor(double[] omega){
		Complex[] impedanceLC = new Complex[10];
		Complex[] impedanceC = new Complex[10];
		Complex[] voltageOverResistor = new Complex[10];
		double[] [] polar = new double[10][2];
		
				
		for (int i = 0 ; i < impedanceLC.length ; i++){
			//impedanceLC[i] = (omega[i] * inductor) + (1 / (omega[i] * capacitance));
			Complex z1 = new Complex(1.0 , 0.0);
			Complex zc = new Complex(0 , omega[i] * capacitance);
			Complex zl = new Complex(0 , omega[i] * inductor);
		
			impedanceC[i] = Complex.div(z1, zc);
			impedanceLC[i] = Complex.add(zl, impedanceC[i]);
			//System.out.println(impedanceLC[i].getReal() + "  " + impedanceLC[i].getImag());
						
		}
		
		for (int i = 0 ; i < voltageOverResistor.length ; i++){
			Complex numerator = new Complex(resistor * voltage0, 0);
			Complex denominator = new Complex(resistor, impedanceLC[i].getImag());
			
			//System.out.println("Zähler" + numerator.getReal() + "  LC" + numerator.getImag());
			//System.out.println("Nenner" + denominator.getReal() + "  LC" + denominator.getImag());
			
			voltageOverResistor[i] = Complex.div(numerator, denominator);
			//System.out.println("Real" + voltageOverResistor[i].getReal() + "Imag" + voltageOverResistor[i].getImag());
			
			//polar[i][0] = voltageOverResistor[i].getReal();
			//polar[i][1] = voltageOverResistor[i].getImag();
			
			
			polar[i] [0] = voltageOverResistor[i].getAbs();
			polar[i] [1] = (voltageOverResistor[i].getPhase()) *360/(2*Math.PI);
		}
		return polar;
	}
	public static void main(String[] args) {
		ResonantCircuit fifi = new ResonantCircuit();
		
		double[][] polar = ResonantCircuit.voltageOverResistor(fifi.omega);
		
		//for (int i = 0 ; i < polar[0].length ; i++){
			//System.out.println(polar[i]);	
		for (int j = 0 ; j < polar.length ; j++){
			System.out.println("Frequenz = " + fifi.frequency[j] +"  Betrag = " + polar[j][0] + "  Phase = " + polar[j][1]);
		}
			
		

	}

}
