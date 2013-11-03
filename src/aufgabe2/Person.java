/**
 * 
 */
package aufgabe2;

/**
 * @author Daniel
 *
 */
public class Person {
	private String firstName;
	private String surname;
	
	public Person(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
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
		Person other = (Person) obj;
		if (!firstName.equals(other.firstName))
			return false;		
		if (!surname.equals(other.surname))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return surname + ", " + firstName;
	}

}
