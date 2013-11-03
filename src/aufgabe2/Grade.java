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
 * @version 2013-11-03
 */
public class Grade {
	
	private Student student;
	private int examinationResult;
	
	public Grade(Student student, int examinationResult){
		this.student = student;
		this.examinationResult = examinationResult;
	}
	
	public Student getStudent(){
		return student;
	}
	
	public int getExaminationResult(){
		return examinationResult;
	}

}
