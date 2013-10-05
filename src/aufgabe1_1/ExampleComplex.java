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
				
		Complex add = new Complex(80.2, 100.0);
		Complex sub = new Complex(80.2, 100.0);
		Complex mul = new Complex(80.2, 100.0);
		Complex div = new Complex(80.2, 100.0);
		Complex abs = new Complex(80.2, 100.0);
		Complex phase = new Complex(80.2, 100.0);

		// static
		System.out.println("Static: " + Complex.add(add, sub));
		// addition
		add.add(add);
		System.out.println("Add: " + add.toString());
		// subtraction
		sub.sub(sub);
		System.out.println("Sub: " + sub.toString());
		// multiplication
		mul.mul(mul);
		System.out.println("Mul: " + mul.toString());
		// division
		div.div(div);
		System.out.println("Div: " + div.toString());
		// Betrag
		System.out.println("Betrag: " + abs.getAbs());
		// Phase
		System.out.println("Phase: " + phase.getPhase());
	}

}
