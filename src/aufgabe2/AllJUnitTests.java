package aufgabe2;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllJUnitTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for sivle");
		//$JUnit-BEGIN$
		suite.addTest(StudentsTest.suite());
		suite.addTest(CourseTest.suite());
		//$JUnit-END$
		return suite;
	}

}
