/* File Name:  Doctor.java
* Course Name: CST8284
* Lab Section: 313
* Student Name:Wenzhe Lu
* Date: 2018-10-08
*/

package assign1;

/*
 * Class to capture clinic doctors
 * */
public class Doctor {
	private String firstName;
	private String lastName;
	private String specialty;

	/*
	 * Default constructor
	 * */
	public Doctor() {
		firstName = null;
		lastName = null;
		specialty = null;
	}

	/*
	 * Initial constructor
	 * */
	public Doctor(String firstName, String lastName, String specialty) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
	}

	/*
	 * Return this doctor's first name
	 * */
	public String getFirstName() {
		return firstName;

	}

	/*
	 * Set this doctor's first name
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	/*
	 * Return this doctor's last name
	 * */
	public String getLastName() {
		return lastName;

	}

	/*
	 * Set this doctor's last name
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * Return this doctor's specialty
	 * */
	public String getSpecialty() {
		return specialty;

	}

	/*
	 * Set this doctor's specialty
	 * */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;

	}

	/*
	 * Override the toString() method
	 * */
	@Override
	public String toString() {
		return String.format("%s, %s, %s", lastName, firstName, specialty);

	}
	
	/*
	 * Helper function to determine if the same doctor is referred to
	 * 
	 * NOT using method override
	 * */
	public boolean equals(Doctor doc) {
		return ((this.firstName == doc.firstName) && 
				(this.lastName == doc.lastName) && 
				(this.specialty == doc.specialty));
	}

}
