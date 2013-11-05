/**
 * 
 */
package aufgabe2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Daniel
 *
 */
public class CourseTestExtension {

	@Test
	public void test() {
		// Create the main students enrollment list.
		Students studentsList = new Students();
		
		// Create course and its lecturer.
		Lecturer lecturer = new Lecturer("Stefan","Lehmann", "Prof. Dr.");
		Course UUT = new Course("OP", lecturer );

		// Enroll one student.
		Student knuth    = studentsList.enrollStudent("Donald", "Knuth");
		Student alf    = studentsList.enrollStudent("Muller", "Alf");

		// Register student -> course
		knuth.bookCourse(UUT);
		Student[] registeredStudent = UUT.getRegisteredStudents();
		Student[] referenceStudent = {knuth};
		assertArrayEquals( referenceStudent, registeredStudent);
		
		// Register course -> student
		UUT.registerStudent(alf);
		Course[] bookedCourses = alf.getBookedCourses();
		Course[] referenceCourses = {UUT};
		assertArrayEquals( referenceCourses, bookedCourses);
		
	}

}
