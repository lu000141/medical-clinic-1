/* File Name: Appointment.java
* Course Name:CST8284
* Lab Section:313
* Student Name:Wenzhe Lu
* Date:2018-10-08
*/

package assign1;

/*
 * Class to capture clinic doctors
 * */

public class Appointment {

	private Doctor doctor;
	private Patient patient;
	private OurDate date;

	/*
	 * Default constructor
	 * */
	public Appointment() {
		doctor = null;
		patient = null;
		date = null;
	}
	
	/*
	 * Initial constructor
	 * */
	public Appointment(Doctor doc, Patient pat, OurDate date) {
		this.doctor = doc;
		this.patient = pat;
		this.date = date;
	}

	/*
	 * Returns the associated doctor of this appointment
	 * */
	public Doctor getDoctor() {
		return doctor;

	}

	/*
	 * Associate this appointment to a doctor
	 * */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/*
	 * Returns the associated patient of this appointment
	 * */
	public Patient getPatient() {
		return patient;

	}
	
	/*
	 * Associate this appointment to a patient
	 * */
	public void setDate(OurDate date) {
		this.date = date;
	}

	/*
	 * Returns the associated date of this appointment
	 * */
	public OurDate getDate() {
		return date;

	}

	/*
	 * Set the date of this appointment
	 * */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/*
	 * Return this appointment
	 * */
	public Appointment getAppointment() {
		return this;

	}

	/*
	 * Set this appointment the same as a given appointment
	 * 
	 * The prototype of this method is given in assignment UML
	 * The intention of this method is unclear.
	 * 
	 * I implemented this method similar to a copy constructor
	 * */
	public void setAppointment(Appointment app) {
		this.doctor = app.doctor;
		this.patient = app.patient;
		this.date = app.date;
	}

	/*
	 * Override class object toString() method
	 * */
	@Override
	public String toString() {
		return String.format("[appointment=%s, doctor=%s, patient=%s]", 
				date, doctor, patient);

	}

}
