/**
 * 
 */
package aufgabe2;

/**
 * Person.<p>
 * 
 * Class to create a person with first name and surname.
 *
 * @author Jendrik Baggendorf, Daniel Dahmer
 * @version 2013-11-03
 */
public class Person {
	// Instance variables
	private String firstName;
	private String surname;
	
	/**
	 * Person.<p>
	 * 
	 * Constructor to create an startNumber
	 * 
	 * @param firstName first name of the person
	 * @param surname surname of the person
	 */
	public Person(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	/**
	 * getFirstName.<p>
	 * 
	 * @return the first name of the person
	 */
	public String getFirstName() { return firstName; }

	/**
	 * getSurname.<p>
	 * 
	 * @return the surname of the person
	 */
	public String getSurname() { return surname; }

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		/*
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
			*/
		Person other = (Person) obj;
		if ((!getFirstName().equals(other.getFirstName())) && (!getSurname().equals(other.getSurname())))
			return false;		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getSurname() + ", " + getFirstName();
	}

}
