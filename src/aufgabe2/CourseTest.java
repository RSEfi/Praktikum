package aufgabe2;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class CourseTest {

	@Test
	public void testCourse() {
		Lecturer lecturer = new Lecturer("Stefan","Lehmann", "Prof. Dr.");
		Course UUT = new Course("OP", lecturer );
		
		assertEquals(lecturer, UUT.getLecturer());
		assertEquals("OP", UUT.getName());
	}

	@Test
	public void testRegister() {
		// Create the main students enrollment list.
		Students studentsList = new Students();
		NumberGeneratorStub generator = new NumberGeneratorStub();
		Student.setMatrNumberGenerator(generator);
		
		// Create course and its lecturer.
		Lecturer lecturer = new Lecturer("Stefan","Lehmann", "Prof. Dr.");
		Course UUT = new Course("OP", lecturer );

		// Enroll one student.
		generator.backdoorSetMatriculationNumber(1000003);
		Student knuth    = studentsList.enrollStudent("Donald", "Knuth");

		// Register student for course
		UUT.registerStudent(knuth);
		Student[] registeredStudent = UUT.getRegisteredStudents();
		Student[] referenceStudent = {knuth};
		assertArrayEquals( referenceStudent, registeredStudent);
		Course[] bookedCourses = knuth.getBookedCourses();
		Course[] referenceCourses = {UUT};
		assertArrayEquals(referenceCourses, bookedCourses);
		
		// Test sorting
		generator.backdoorSetMatriculationNumber(1000001);
		Student torvalds = studentsList.enrollStudent("Linus", "Torvalds");
		UUT.registerStudent(torvalds);

		generator.backdoorSetMatriculationNumber(1000002);
		Student lamport = studentsList.enrollStudent("Leslie", "Lamport");
		UUT.registerStudent(lamport);

		Student[] registeredStudents = UUT.getRegisteredStudents();
		Student[] referenceStudents = {torvalds,lamport,knuth};
		assertArrayEquals( referenceStudents, registeredStudents);
	}

	@Test
	public void testToString() {
		Lecturer lecturer = new Lecturer("Stefan","Lehmann", "Prof. Dr.");
		Course UUT = new Course("OP", lecturer );
		
		String representation = UUT.toString();
		assertEquals("Course OP, lecturer: Prof. Dr. Lehmann, Stefan", representation);
	}

	@Test
	public void testExaminationResults() {
		Lecturer lecturer = new Lecturer("Stefan","Lehmann", "Prof. Dr.");
		Course UUT = new Course("OP", lecturer );
		
		Students studentsList = new Students();
		NumberGeneratorStub generator = new NumberGeneratorStub();
		Student.setMatrNumberGenerator(generator);
		
		generator.backdoorSetMatriculationNumber(1000003);
		Student knuth    = studentsList.enrollStudent("Donald", "Knuth");
		UUT.registerStudent(knuth);
		UUT.addResult(knuth, 15);
		int[] referenceStatisticResult1 = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		assertArrayEquals(referenceStatisticResult1, UUT.getExaminationResultsStatistic());
		
		generator.backdoorSetMatriculationNumber(1000001);
		Student torvalds = studentsList.enrollStudent("Linus", "Torvalds");
		UUT.registerStudent(torvalds);
		UUT.addResult(torvalds, 0);
		int[] referenceStatisticResult2 = { 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		assertArrayEquals(referenceStatisticResult2, UUT.getExaminationResultsStatistic());
		
		generator.backdoorSetMatriculationNumber(1000002);
		Student lamport = studentsList.enrollStudent("Leslie", "Lamport");
		UUT.registerStudent(lamport);

		UUT.addResult(lamport, 15);
		int[] referenceStatisticResult3 = { 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
		assertArrayEquals(referenceStatisticResult3, UUT.getExaminationResultsStatistic());
		
		String resultList = UUT.getCourseExaminationResult();
		Grade[] marks = UUT.getExaminationResults();
		assertEquals("Course OP, lecturer: Prof. Dr. Lehmann, Stefan\n15 1000003, Knuth, Donald\n0 1000001, Torvalds, Linus\n15 1000002, Lamport, Leslie\n",resultList);
	}
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(CourseTest.class);
	}

}
