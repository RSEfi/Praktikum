/**
 * 
 */
package aufgabe2;

/**
 * @author Daniel
 *
 */
public class NumberGeneratorLinear implements NumberGenerator {
	private long startNumber;
		
	public NumberGeneratorLinear(long startNumber) { this.startNumber = startNumber; }

	public long createNumber() {
		long counter = startNumber;
		startNumber++;
				
		return counter;
		}
		
}


