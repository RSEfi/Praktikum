/**
 * 
 */
package aufgabe2;

import java.util.*;

/**
 * Student.<p>
 * 
 * Class to create a student with an matriculation number.<p>
 * extends Person<p>
 * implements Comparable
 *
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-12
 */
public class Student extends Person implements Comparable<Student>{
	
	private static NumberGenerator generator;	// Class variable
	private long matrNumber;					// Instance variable
	private ArrayList<Course> registeredCourse = new ArrayList<Course>();
		
	/**
	 * 
	 * @return the matriculation number
	 */
	public long getMatriculationNumber() { return matrNumber; }

	/**
	 * Student.<p>
	 * 
	 * Constructor who calls the names from parent class
	 * 
	 * @param first name
	 * @param surname
	 */
	public Student (String firstName, String surname) {
		super(firstName, surname);
		if(generator != null){
			matrNumber = generator.createNumber();
		}else
			matrNumber = 0;
	}
	
	/**
	 * setMatrNumberGenerator.<p>
	 * 
	 * Set the matriculation number.
	 * 
	 * @param generator
	 */
	public static void setMatrNumberGenerator (NumberGenerator generator) {
		Student.generator = generator;
	}
	
	/**
	 * bookCourse.<p>
	 * 
	 * Enrolling in course.
	 * 
	 * @param course enrolled course 
	 */
	public void bookCourse(Course course){
		
		for (int i = 0; i < registeredCourse.size();i++){
			if (course.equals(registeredCourse.get(i))){
				return;				
			}
		}
		registeredCourse.add(course);
		course.registerStudent(this);
	}
	
	/**
	 * getBookedCourse.<p>
	 * 
	 * @return array with booked courses
	 */
	public Course[] getBookedCourses(){
		return registeredCourse.toArray(new Course[0]);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Student other = (Student) obj;
		if ( ( getFirstName() == other.getFirstName() ) && ( getSurname() == other.getSurname() ) && ( getMatriculationNumber() == other.getMatriculationNumber() ) )
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getMatriculationNumber() + ", " + getSurname() + ", " + getFirstName();
	}

	@Override
	public int compareTo(Student other) {
		if(getMatriculationNumber() < other.getMatriculationNumber())
			return (-1); 
		else if(getMatriculationNumber() > other.getMatriculationNumber())
			return (1); 
		else
			return (0);
	}

}
