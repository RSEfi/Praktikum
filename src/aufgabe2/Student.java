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
 * @version 2013-11-03
 */
public class Student extends Person implements Comparable<Student>{
	
	private static NumberGenerator generator;	// Class variable
	private long matrNumber;					// Instance variable
		
	/**
	 * getMatrNumber.<p>
	 * 
	 * @return the matrNumber
	 */
	public long getMatrNumber() { return matrNumber; }

	/**
	 * MatrNumber.<p>
	 * 
	 * keine Ahnung was ich hier mache !?
	 * 
	 * @param student ???
	 * @return the matrNumber
	 */
	public long MatrNumber (Student student){
		return this.MatrNumber(student);		
	}
	
	/**
	 * Student.<p>
	 * 
	 * Constructor who calls the names from parent class
	 * 
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
	 * @param generator ???
	 */
	public static void setMatrNumberGenerator (NumberGenerator generator) {
		Student.generator = generator;
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
		if ( ( getFirstName() != other.getFirstName() ) && ( getSurname() != other.getSurname() ) && ( getMatrNumber() != other.getMatrNumber() ) )
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getMatrNumber() + ", " + getSurname() + ", " + getFirstName();
	}

	@Override
	public int compareTo(Student other) {
		if(getMatrNumber() < other.getMatrNumber())
			return (-1); 
		else if(getMatrNumber() > other.getMatrNumber())
			return (1); 
		else
			return (0);
	}

}
