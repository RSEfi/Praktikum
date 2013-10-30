package aufgabe2;
/**
 * Stub to simulate the generator in JUnit-tests. 
 * @author Lehmann
 * @version 2013-10-14
 */

public class NumberGeneratorStub implements NumberGenerator {
	
	private long matriculationNumber;
	
	@Override
	public long createNumber() {
		return matriculationNumber;
	}
	/**
	 * Set the matriculation number to the given value. Used for testing.
	 * @param fakeMatriculationNumber number that will be returned on further generation requests.
	 */
	public void backdoorSetMatriculationNumber( long fakeMatriculationNumber ){
		matriculationNumber = fakeMatriculationNumber;
	}
}
