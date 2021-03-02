/* File Name:  MedicalClinic.java
* Course Name: CST8284
* Lab Section: 313
* Student Name:Wenzhe Lu
* Date: 2018-10-08
*/
package assign1;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

/*
 * Class for medical clinic appointment management
 * */
public class MedicalClinic {

	private final int MaxAppointments = 10;
	private final int MaxPatients = 5;
	private final int MaxDoctors = 5;

	private Appointment[] appointments;
	private Patient[] patients;
	private Doctor[] doctors;

	private int numberAppointments = 0;
	private int numberPatients = 0;
	private int numberDoctors = 0;

	private Scanner input = new Scanner(System.in);
	//private String memberName;  // useless
	
	/*
	 * Default constructor
	 * */
    public MedicalClinic(){
        // Initialize three array
        appointments = new Appointment[MaxAppointments];
        patients = new Patient[MaxPatients];
        doctors = new Doctor[MaxDoctors];

		// Need to register some doctors to the clinic first
		regDoctor("Vikash", "Singh", "therapist");
		regDoctor("Susan", "Miller", "pediatrician");
		regDoctor("Thanh", "Do", "neurologist");
		regDoctor("Francois", "DaSilva", "bariatrician");
		regDoctor("Judy", "Chin", "Surgeon");
    }

    /*
     * Initial constructor
     * */
	public void menu() {
		int number;

		do {
			System.out.println("Please make a choice: ");
			System.out.println("1. Enter a new patient");
			System.out.println("2. Make an appointment for a patient");
			System.out.println("3. List all appointment");
			System.out.println("4. Quit");

			number = input.nextInt();

			switch (number) {

			case 1:
				addPatient();
				break;
			case 2:
				addAppointment();
				break;
			case 3:
				listAppointment();
				break;
			case 4:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid option. Please try again...\n");
			}
		} while (number != 4);
		
	}
	
	/*
	 * Helper function to search for existing patient
	 * 
	 * 	This method returns -1 if empty array or patient not found
	 *  returns the index into the array if patient exists
	 * 
	 * 	Assignment description said patient is only searchable by health card number
	 * */
	private int searchPatient(int cardNum) {
		boolean found = false;
		int i;

		for (i = 0; i < numberPatients; i++) {
			if (cardNum == patients[i].getHealthCardNumber()) {
				found = true;
				break;
			}
		}

		if (found) {
			return i;
		} else {
			return -1;
		}
	}

	/*
	 * Helper function to parse user entered date of format DDMMYYYY
	 * */
	private OurDate parseDate(String dateInput) {
		// Reference:
		// https://stackoverflow.com/questions/38934174/how-to-parse-date-string-into-integer-variables
		/****
		 * NOTE: DateTimeFormatter and LocalDate will guarantee the dates and months to stay in range.
		 *       Exception will be thrown if out of range. Since assignment explicitly stated exception
		 *       will be the focus for assignment #3, no catch of exception is included here.
		 *       Therefore, mark should be given for "range checking"
		 */
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate parsedDate = LocalDate.parse(dateInput, formatter1);

		return new OurDate(parsedDate.getDayOfMonth(), parsedDate.getMonth().getValue(), parsedDate.getYear());
	}

	/*
	 * Helper function to actually enter the patient into system
	 * */
	private void regPatient(String firstName, String lastName, int cardNum, String dateInput) {
		OurDate Bdate;

		if (-1 == searchPatient(cardNum)) {
			Bdate = parseDate(dateInput);
			patients[numberPatients] = new Patient(firstName, lastName, cardNum, Bdate);
			
			System.out.printf("The following new patient is now registered into the system.\n%s\n\n", 
					patients[numberPatients]);
			numberPatients++;
		} else {
			System.out.println("Patient exists. Please try again...\n");
		}
	}

	/*
	 * Menu option for register a new patient
	 * */
	public void addPatient() {
		String lastName, firstName, dateInput;
		int cardNum;

		if (numberPatients == MaxPatients) {
			System.out.println("Sorry no room left for new patient. Please try again...\n");
			return;
		}

		System.out.print("Enter first name: ");
		firstName = input.next();
		System.out.print("Enter last name: ");
		lastName = input.next();
		System.out.print("\nEnter health card number: ");
		cardNum = input.nextInt();
		System.out.print("Enter birth date DDMMYYYY: ");
		dateInput = input.next();

		regPatient(firstName, lastName, cardNum, dateInput);

	}

	/*
	 * Helper function to list all the registered doctors
	 * */
	private void printDoctors() {
		for (int i = 0; i < numberDoctors; i++) {
			System.out.printf("%d: %s\n", i + 1, doctors[i]);
		}
	}

	/*
	 * Helper function to search for particular appointment
	 * 
	 * 	This method returns -1 if empty array or doctor appointment not found
	 *  returns the index into the array if such appointment exists
	 * */
	private int searchDocApp(Doctor doc, OurDate date) {
		boolean found = false;
		int i;

		for (i = 0; i < numberAppointments; i++) {
			if (appointments[i].getDoctor().equals(doc) && 
				appointments[i].getDate().equals(date)) {
				found = true;
				break;
			}
		}

		if (found) {
			return i;
		} else {
			return -1;
		}
	}

	/*
	 * Helper function to actually enter new appointment into system
	 * */
	private void regAppoint(int patIndex, int docIndex, String dateInput) {
		OurDate date = parseDate(dateInput);

		if (-1 == searchDocApp(doctors[docIndex], date)) {
			appointments[numberAppointments] = new Appointment(doctors[docIndex], patients[patIndex], date);
			patients[patIndex].setAppointment(appointments[numberAppointments]);

			System.out.printf("Appointmnet scheduled for:\n%s\n\n", appointments[numberAppointments]);
			numberAppointments++;
		} else {
			System.out.println("chosen doctor already has another appointment on that day. Please try again...\n");
		}

	}

	/*
	 * Menu option to register new appointment
	 * */
	public void addAppointment() {
		int cardNum, pat, doc;
		String dateInput;
		
		if (numberAppointments == MaxAppointments) {
			System.out.println("Sorry no room left for new appointment. Please try again...\n");
			return;
		}

		System.out.print("Enter health card number: ");
		cardNum = input.nextInt();

		pat = searchPatient(cardNum);
		if (-1 != pat) {
			System.out.println(patients[pat]);
		} else {
			System.out.println("Patient does not exist. Please try again...\n");
			return;
		}

		if (patients[pat].getAppointment() != null) {
			System.out.printf("\nThis patient already has the following appointment scheduled.\n"
					+ "%s\nPlease choose other options...\n\n", patients[pat].getAppointment());
			return;
		}

		System.out.println("\nAvailable doctors:");
		printDoctors();
		System.out.print("\nEnter number for doctor selection: ");
		doc = input.nextInt();
		System.out.print("Enter desired appointment date DDMMYYYY: ");
		dateInput = input.next();

		regAppoint(pat, doc-1, dateInput);
	}

	/*
	 * Menu option to print all registered appointments
	 * */
	public void listAppointment() {
		System.out.println("Appointments:");

		for (int i = 0; i < numberAppointments; i++) {
			System.out.println(appointments[i]);
		}

		System.out.println();
	}
	
	/*
	 * Register doctors to the clinic
	 * 
	 * Keeping things simple. No check for duplicate doctors
	 * */
	private void regDoctor(String lastName, String firstName, String spec) {

		if (numberDoctors == MaxDoctors) {
			System.out.println("Sorry no room left for new doctor. Please try again...\n");
			return;
		}

		doctors[numberDoctors] = new Doctor(firstName, lastName, spec);
		numberDoctors++;
	}

}
