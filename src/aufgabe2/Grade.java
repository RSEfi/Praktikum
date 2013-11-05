/**
 * 
 */
package aufgabe2;

/**
 * Grade.<p>
 * 
 * Class to create an matriculation number.<p>
 * Implements NumberGenerator.
 *
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-05
 */
public class Grade {
	
	private Student student;
	private int examinationResult;
	
	/**
	 * Grade.<p>
	 * 
	 * Constructor to create the grade
	 * 
	 * @param student reference to the student
	 * @param examinationResult reference to the result
	 */
	public Grade(Student student, int examinationResult){
		this.student = student;
		this.examinationResult = examinationResult;
	}
	
	/**
	 * 
	 * @return the student
	 */
	public Student getStudent(){
		return student;
	}
	
	/**
	 * 
	 * @return the examination result
	 */
	public int getExaminationResult(){
		return examinationResult;
	}

}
