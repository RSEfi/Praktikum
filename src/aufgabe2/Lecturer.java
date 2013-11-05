/**
 * 
 */
package aufgabe2;

/**
 * Lecturer.<p>
 * 
 * Class to create a lecturer with an title.<p>
 * extends Person<p>
 *
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-05
 */
public class Lecturer extends Person {
	
	private String title;		// Instance variable

	/**
	 * Lecturer.<p>
	 * 
	 * Constructor to create an lecturer with title
	 * 
	 * @param fisrtName first name of the lecturer
	 * @param surname surname of the lecturer
	 * @param title title of the lecturer
	 */
	public Lecturer(String firstName, String surname, String title) {
		super(firstName, surname);
		this.title = title;
	}
	
	/** Constructor to create an lecturer without title
	*
	 * @param fisrtName first name of the lecturer
	 * @param surname surname of the lecturer
	*/
	public Lecturer (String firstName, String surname){
		super(firstName, surname);		
	}

	/**
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
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

		Lecturer other = (Lecturer) obj;
		if ( (getFirstName() != other.getFirstName()) && (getSurname() != other.getSurname()) && (getTitle() != other.getTitle()) )
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (getTitle() != null)
			return getTitle() + " " + getSurname() + ", " + getFirstName();
		else
			return getSurname() + ", " + getFirstName();
	}
		
}
