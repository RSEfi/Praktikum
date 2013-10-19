/**
 * 
 */
package aufgabe1_1;

/**
 * @author RSEfi
 * @version 2013-10-05
 */
public class ExampleComplex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		Complex add = new Complex(10, 0.0);
		Complex sub = new Complex(0, -963.2309);
		Complex mul = new Complex(80.2, 100.0);
		Complex div = new Complex(80.2, 100.0);
		Complex abs = new Complex(80.2, 100.0);
		Complex phase = new Complex(80.2, 100.0);

		// static addition
		//System.out.println("Additon (static): " + Complex.add(add, sub));
		// static subtraction
		//System.out.println("Subtraction (static): " + Complex.sub(add, sub));
		// static multiplication
		//System.out.println("Multiplication (static): " + Complex.mul(add, sub));
		// static division
		System.out.println("Division (static): " + Complex.div(add, sub));
		// addition
		//System.out.println("Addition: " + add.add(sub).toString());
		// subtraction
		//sub.sub(sub);
		//System.out.println("Subtraction: " + sub.sub(add).toString());
		// multiplication
		//mul.mul(mul);
		//System.out.println("Multiplication: " + mul.toString());
		// division
		//div.div(div);
		//System.out.println("Division: " + div.toString());
		// value
		System.out.println("Value: " + abs.getAbs());
		// phase
		System.out.println("Phase: " + phase.getPhase());
		// equals
		//System.out.println("Equals: " + add.equals(add));
	}

}
