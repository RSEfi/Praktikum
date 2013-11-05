package aufgabe2;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

/** JUnit Test for class Students
 * 
 * @author Lehmann
 * @version 2013-10-14
 */
public class StudentsTest {
	@Test
	public void testStudents() {
		Students studentsList = new Students();
		assertTrue( 0 == studentsList.getNumberOfStudents() );
	}

	@Test
	public void testEnrollStudent() {
		Students studentsList = new Students();

		assertEquals(0, studentsList.getNumberOfStudents());

		Student knuth    = studentsList.enrollStudent("Donald", "Knuth");
		assertEquals(1, studentsList.getNumberOfStudents());

		Student torvalds = studentsList.enrollStudent("Linus", "Torvalds");
		assertEquals(2, studentsList.getNumberOfStudents());
		// test on list creation by querries
		assertTrue( studentsList.isStudentEnrolled(knuth) );
		assertTrue( studentsList.isStudentEnrolled(torvalds) );
	}

	@Test
	public void testCheckEnrollmentLong() {
		Students studentsList = new Students();
		NumberGenerator generator = new NumberGeneratorLinear(1000001);
		Student.setMatrNumberGenerator(generator);

		assertEquals(0, studentsList.getNumberOfStudents());

		Student knuth    = studentsList.enrollStudent("Donald", "Knuth");
		assertEquals(1, studentsList.getNumberOfStudents());
		assertEquals("Knuth", knuth.getSurname());
		assertEquals("Donald", knuth.getFirstName());
		assertEquals(1000001, knuth.getMatriculationNumber() );

		Student torvalds = studentsList.enrollStudent("Linus", "Torvalds");
		assertEquals(2, studentsList.getNumberOfStudents());
		assertEquals("Torvalds", torvalds.getSurname());
		assertEquals("Linus", torvalds.getFirstName());
		assertEquals(1000002, torvalds.getMatriculationNumber() );
		
		assertTrue( studentsList.isStudentEnrolled(knuth) );
		assertTrue( studentsList.isStudentEnrolled(torvalds) );
	}
	@Test
	public void testToString() {
		Students studentsList = new Students();
		NumberGeneratorStub generator = new NumberGeneratorStub();
		Student.setMatrNumberGenerator(generator);


		generator.backdoorSetMatriculationNumber(1000003);
		Student knuth    = studentsList.enrollStudent("Donald", "Knuth");

		generator.backdoorSetMatriculationNumber(1000001);
		Student torvalds = studentsList.enrollStudent("Linus", "Torvalds");

		generator.backdoorSetMatriculationNumber(1000002);
		Student lamport = studentsList.enrollStudent("Leslie", "Lamport");

		System.out.println( studentsList);
		assertEquals( "Enrolled students:\n1000001, Torvalds, Linus\n1000002, Lamport, Leslie\n1000003, Knuth, Donald\n", studentsList.toString());
	}
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(StudentsTest.class);
	}
}
