/**
 * 
 */
package aufgabe2;

/**
 * @author Daniel
 *
 */
public class Student extends Person implements Comparable{
	
	NumberGenerator student;		//Instanzvariable
	private static long matrNumber;	//Klassenvariable
		
	/**
	 * @return the matrNumber
	 */
	public long getMatrNumber() {
		return matrNumber;
	}

	public long MatrNumber (Student student){
		return this.MatrNumber(student);		
	}
	
	public Student (String firstName, String surname) {
		super(firstName, surname);
	}
	
	public static void setMatrNumberGenerator (NumberGenerator generator) {
		matrNumber = generator.createNumber();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (!student.equals(other.student))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Student.matrNumber + ", " + Student.this.getSurname() + ", " + Student.this.getFirstName();
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
