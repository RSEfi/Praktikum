/**
 * 
 */
package aufgabe2;

/**
 * NumberGeneratorLinear.<p>
 * 
 * Class to create an matriculation number.<p>
 * Implements NumberGenerator.
 *
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-03
 */
public class NumberGeneratorLinear implements NumberGenerator {
	
	private long counter = 0;
	
	/**
	 * NumberGeneratorLinear.<p>
	 * 
	 * Constructor to create an startNumber
	 * 
	 * @param startnumber to started from
	 */
	public NumberGeneratorLinear(long startNumber) { counter = startNumber; }

	/**
	 * createNumber().<p>
	 * 
	 * Method to create an matriculation number and increment this number after return
	 * 
	 * @return actual matriculation number
	 */
	public long createNumber() { return counter++; }
		
}


