/**
 * 
 */
package aufgabe2;

/**
 * @author Daniel
 *
 */
public class Lecturer extends Person {
	
	private String title;

	public Lecturer(String firstName, String surname, String title) {
		super(firstName, surname);
		this.title = title;
	}

	/**
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lecturer other = (Lecturer) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.title + Lecturer.this.getSurname() + ", " + Lecturer.this.getFirstName();
	}
	

	
}
