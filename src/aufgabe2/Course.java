/**
 * 
 */
package aufgabe2;

import java.util.*;

/**
 * Course.<p>
 * 
 * Class to create a 
 *
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-12
 */
public class Course{
	
	private String name;
	private Lecturer lecturer;
	private ArrayList<Student> registeredStudents = new ArrayList<Student>();
	private ArrayList<Grade> gradeList = new ArrayList<Grade>();
	
	/**
	 * Course.<p>
	 * 
	 * Constructor to create an course
	 * 
	 * @param name name of the course
	 * @param lecturer name of the lecturer
	 */
	public Course (String name, Lecturer lecturer){
		this.name = name;
		this.lecturer = lecturer;	
	}
	
	/** 
	*
	* @return the course name
	*/
	public String getName(){
		return name;
	}
	
	/** 
	*
	* @return the the lecturer
	*/
	public Lecturer getLecturer(){
		return lecturer;
	}
	
	/**
	 * registeredStudent.<p>
	 * 
	 * Registered an student to the course
	 * 
	 * @param participant the student
	 */
	public void registerStudent(Student participant){
		
		for (int i = 0; i < registeredStudents.size(); i++){
			if (participant.equals(registeredStudents.get(i))){
				//System.out.printf("test : i=%d %s" , i, registeredStudents.get(i));
				return;
			}
		}
		registeredStudents.add(participant);
		participant.bookCourse(this);
	}
	
	/**
	 * getRegisteredStudents.<p>
	 * 
	 * Calls an array with registered students
	 * 
	 * @return the array with registered students
	 */
	public Student[] getRegisteredStudents(){
		Collections.sort(registeredStudents);
		return (registeredStudents.toArray(new Student[0]));
	}

	/**
	 * addGrade.<p>
	 * 
	 * Adds the result to the student
	 * 
	 * @param student the student
	 * @param result result of the student
	 */
	public void addGrade (Student student, int result){
		for (int i = 0; i < gradeList.size(); i++){
			if (student.equals(gradeList.get(i).getStudent())){
			}
		}
		for (int i = 0; i < registeredStudents.size(); i++){
			if (student.equals(registeredStudents.get(i))){
				 Grade grade = new Grade(student, result);
				 gradeList.add(grade);
			}
		}
	}
	
	/**
	 * getGradeArray.<p>
	 * 
	 * Calls an array with the results
	 * 
	 * @return the array with the results
	 */
	public Grade[] getGradeArray(){
		return gradeList.toArray(new Grade[0]);
	}

	/**
	 * getGradeString.<p>
	 * 
	 * Transforms the result list to a string
	 * 
	 * @return string with the results
	 */
	public String getGradeString(){
		String gradeString = this.toString() + "\n";
		for (int i = 0; i < gradeList.size(); i++){
			gradeString = gradeString + gradeList.get(i).getExaminationResult()+", "+gradeList.get(i).getStudent()+"\n";
		}
		return gradeString;
	}
	
	/**
	 * getGradeStatistic.<p>
	 * 
	 * Create an array with the result statistic
	 * 
	 * @return array with the result statistic
	 */
	public int[] getGradeStatistic(){
		int [] gradeStatistics = new int [16];
		for (Grade grade : gradeList){
			gradeStatistics[grade.getExaminationResult()]++;
		}
		return (gradeStatistics);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course "+this.getName()+", Lecturer: "+this.getLecturer();
	}

}
