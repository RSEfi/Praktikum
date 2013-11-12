/**
 * 
 */
package aufgabe2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-12
 */
public class CourseTestExtension {

	@Test
	public void test() {
		// Create the main students enrollment list.
		Students studentsList = new Students();
		
		// Create course and its lecturer.
		Lecturer lecturer1 = new Lecturer("Stefan","Lehmann", "Prof. Dr.");
		Course UUT = new Course("OP", lecturer1 );
		//Lecturer lecturer2 = new Lecturer("Bj�rn Ingo","Lange", "Prof. Dr.");
		//Course OOT = new Course("NS", lecturer2 );
		
		// Enroll the students.
		Student knuth    = studentsList.enrollStudent("Donald", "Knuth");
		Student alf    = studentsList.enrollStudent("M�ller", "Alf");
		
		// Register student -> course
		knuth.bookCourse(UUT);
		Student[] registeredStudent = UUT.getRegisteredStudents();
		Student[] referenceStudent = {knuth};
		assertArrayEquals( referenceStudent, registeredStudent);
		
		// Register course -> student		
		UUT.registerStudent(alf);
		Course[] bookedCourses = alf.getBookedCourses();
		Course[] referenceCourses = {UUT};
		assertArrayEquals(referenceCourses, bookedCourses);
	}

}
