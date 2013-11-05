/**
 * 
 */
package aufgabe2;

import java.util.*;

/**
 * Students.<p>
 * 
 * Class to enroll students, determine number of enrolled students and checks if students are enrolled.<p>
 *
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-05
 */
public class Students {
	
	ArrayList<Student> registeredStudents = new ArrayList<Student>();
	
	/**
	 * Student enrolStudent.<p>
	 * 
	 * Method to create an list with enrolled students
	 * 
	 * @param fistName first of the student
	 * @param surname surname of the student
	 * @return the full name of the enrolled student
	 */
	public Student enrollStudent (String firstName, String surname) {
		
		Student stud = new Student(firstName, surname);
		registeredStudents.add(stud);
		return stud;		
	}
	
	/**
	 * 
	 * @return the number of enrolled students
	 */
	public int getNumberOfStudents () {
		
		return registeredStudents.size();
	}
	
	/**
	 * isStudentEnrolled.<p>
	 * 
	 * Method to check if student is enrolled
	 * 
	 * @return true or false
	 */
	public boolean isStudentEnrolled (Student student) {
		for (Student student_in_list : registeredStudents){
			if (student_in_list.equals(student))
				return true;
			 }
		return false;	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Collections.sort(registeredStudents);
		String toString = "Enrolled students:\n";
		for (int i = 0; i < registeredStudents.size(); i++){
			toString = toString + registeredStudents.get(i).getMatriculationNumber();
			toString = toString + (", ");
			toString = toString + registeredStudents.get(i).getSurname().toString();
			toString = toString + (", ");
			toString = toString + registeredStudents.get(i).getFirstName().toString();
			toString = toString + ("\n");
			}
		return toString;
	}
	
}
