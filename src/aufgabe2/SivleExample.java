/**
 * 
 */
package aufgabe2;

/**
 * SivleExapmle.<p>
 * 
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-12
 */
public class SivleExample {
	
	public static void main (String[] args) {
	
		long matrNumber1 = 2010;
		long matrNumber2 = 0;
		NumberGeneratorLinear number = new NumberGeneratorLinear(matrNumber1);
		
		matrNumber1 = number.createNumber();
		matrNumber2 = number.createNumber();
		
		System.out.printf("%d, %d\n\n", matrNumber1, matrNumber2);

	//Test Person
		Person pers1 = new Person ("Max", "Mustermann");
		
		System.out.printf("Nachname: %s, Vorname: %s\n\n", pers1.getSurname(), pers1.getFirstName());

	//Test Student
		Student stud1 = new Student ("Alfred", "Dissimo");
		stud1.setMatrNumberGenerator(number);
		Student stud2 = new Student ("Heiner", "Lauterbach");
		Student stud3 = new Student ("Fridrich", "Ebert");
		Student stud4 = new Student ("Ruhige", "Kugel");
		Student stud5 = new Student ("Mario", "Nette");
		Student stud6 = new Student ("Bernhard", "Diener");
		Student stud7 = new Student ("Rudi", "Mentär");
		Student stud8 = new Student ("Rainer", "Zufall");
		
		String toString = stud1.toString();		
		System.out.printf("Nachname: %s, Vorname: %s, Matrikelnummer: %d \n", stud1.getSurname(), stud1.getFirstName(), stud1.getMatriculationNumber());
		System.out.printf("%s\n\n", toString);
	
		
	//Test Lecturer
		Lecturer lect1 = new Lecturer ("Moin", "Moin");
		Lecturer lect2 = new Lecturer ("Stefan", "Raab", "Prof. Doktor");
		toString = lect1.toString();		
		System.out.printf("Nachname: %s, Vorname: %s, Titel: %s \n", lect1.getSurname(), lect1.getFirstName(), lect1.getTitle());
		System.out.printf("%s\n", toString);
		toString = lect2.toString();	
		System.out.printf("Nachname: %s, Vorname: %s, Titel: %s \n", lect2.getSurname(), lect2.getFirstName(), lect2.getTitle());
		System.out.printf("%s\n\n", toString);
		
	//Test Students
		Students listStud = new Students();
		listStud.enrollStudent(stud1.getFirstName(), stud1.getSurname());
		listStud.enrollStudent("Sebastian", "Veddel");
		listStud.enrollStudent("Never", "Mind");
		toString = listStud.toString();
		System.out.printf("%s\n\n", toString);
		
	//Test Grade
		Grade gradeList = new Grade(stud1, 10);
		Grade [] grade_array = new Grade[10];
		System.out.printf ("%s, %d\n\n\n", gradeList.getStudent(),gradeList.getExaminationResult());

	//Test Course
		Course oop = new Course("OP-E3a", lect2);
		Course oop2 = new Course ("OP-E3b", lect1);
		int[] gradeStatistic = new int [16];
		int i = 0;
		
		oop.registerStudent(stud1);
		oop.registerStudent(stud2);
		oop.registerStudent(stud4);
		oop.registerStudent(stud5);
		oop.registerStudent(stud6);
		oop.registerStudent(stud7);
		
		
		//System.out.printf("Debug: %d\n" , oop.getRegisteredStudents().length);
		
		oop.addGrade(stud1, 5);
		oop.addGrade(stud7, 12);
		oop.addGrade(stud3, 15);
		oop.addGrade(stud2, 8);
		oop.addGrade(stud4, 11);
		oop.addGrade(stud5, 7);
		oop.addGrade(stud6, 13);
		
		System.out.printf("%s\n" , toString);
		
		oop2.registerStudent(stud1);
		oop2.registerStudent(stud2);
		oop2.registerStudent(stud3);
		oop2.registerStudent(stud4);
		oop2.registerStudent(stud8);

		oop2.addGrade(stud1, 5);
		oop2.addGrade(stud2, 12);
		oop2.addGrade(stud3, 15);
		oop2.addGrade(stud4, 8);

		toString = oop2.getGradeString();
		System.out.printf("%s\n" , toString);
		
		toString = oop.toString();
		System.out.printf("%s\n" , toString);
		toString = oop2.toString();
		System.out.printf("%s\n\n" , toString);
		
		gradeStatistic = oop.getGradeStatistic();
		for (int grade: gradeStatistic ){
			System.out.printf("Die Note %d gab es %d mal\n", i++, grade);
		}
		grade_array = oop.getGradeArray();
	}

}
