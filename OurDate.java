/* File Name: OurDate.java
* Course Name:CST8284
* Lab Section:313
* Student Name:Wenzhe Lu
* Date: 2018-10-08
*/

package assign1;

/*
 * Class to capture date info
 * */
public class OurDate {

	private int day;
	private int month;
	private int year;

	/*
	 * default constructor
	 * */
	public OurDate() {
		day = 0;
		month = 0;
		year = 0;
	}

	/*
	 * initial constructor
	 * */
	public OurDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/*
	 * Return the day of a month
	 * */
	public int getDay() {
		return day;

	}

	/*
	 * Set the day of a month
	 * */
	public void setDay(int day) {
		this.day = day;
	}

	/*
	 * Return the month of a year
	 * */
	public int getMonth() {
		return month;

	}

	/*
	 * Set the month of a year
	 * */
	public void setMonth(int month) {
		this.month = month;
	}

	/*
	 * Return the year value
	 * */
	public int getYear() {
		return year;

	}

	/*
	 * Set the year value
	 * */
	public void setYear(int year) {
		this.year = year;
	}

	/*
	 * Override the toString() method
	 * */
	@Override
	public String toString() {
		return String.format("day=%d, month=%d, year=%d", day, month, year);

	}
	
	/*
	 * Helper function to determine if two days are the same
	 * 
	 * NOT using method override
	 * */
	public boolean equals(OurDate date) {
		return ((this.day == date.day) && 
				(this.month == date.month) && 
				(this.year == date.year));
	}

}
