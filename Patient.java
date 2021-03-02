/* File Name:  Patient.java
* Course Name: CST8284
* Lab Section: 313
* Student Name: Wenzhe Lu
* Date: 2018-10-08
*/

package assign1;


/*
 * Class to capture a clinic patient
 * */
public class Patient {

	private String firstName;
	private String lastName;
	private int healthCardNumber;
	private OurDate birthDate;
	private Appointment appointment;

	/*
	 * Default constructor
	 * */
	public Patient() {
		firstName = null;
		lastName = null;
		healthCardNumber = 0;
		birthDate = null;
		appointment = null;
	}

	/*
	 * Initial constructor
	 * */
	public Patient(String firstName, String lastName, int healthCardNumber, OurDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.healthCardNumber = healthCardNumber;
		this.birthDate = birthDate;
		this.appointment = null;
	}

	/*
	 * Return the first name of this patient
	 * */
	public String getFirstName() {
		return firstName;

	}

	/*
	 * Set the first name of this patient
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	/*
	 * Return the last name of this patient
	 * */
	public String getLastName() {
		return lastName;

	}

	/*
	 * Set the last name of this patient
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * Return the health card number of this patient
	 * */
	public int getHealthCardNumber() {
		return healthCardNumber;
	}

	/*
	 * Set the health card number of this patient
	 * */
	public void setHealthCardNumber(int healthCardNumber) {
		this.healthCardNumber = healthCardNumber;
	}

	/*
	 * Return the birth date of this patient
	 * */
	public OurDate getBirthDate() {
		return birthDate;
	}

	/*
	 * Set the birth date of this patient
	 * */
	public void setBirthDate(OurDate birthDate) {
		this.birthDate = birthDate;
	}

	/*
	 * Return the appointment scheduled for this patient
	 * */
	public Appointment getAppointment() {
		return appointment;
	}

	/*
	 * Record an appointment for this patient
	 * */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	/*
	 * Override the toString() method
	 * */
	@Override
	public String toString() {
		return String.format("Patient[firstName=%s, lastName=%s, birthDate=%s, healthCardNumber=%d]", firstName,
				lastName, birthDate, healthCardNumber);

	}
	
}

