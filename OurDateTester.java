/* File Name: OurDateTester.java
* Course Name:CST8284
* Lab Section:313
* Student Name:Wenzhe Lu
* Date: 2018-10-08
*/

package assign1test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assign1.OurDate;

class OurDateTester {

	@org.junit.jupiter.api.Test

	public void testDefaultConstructorForYear() {
		OurDate date = new OurDate();
		assertEquals(0, date.getYear());
	}

	@org.junit.jupiter.api.Test

	public void testDefaultConstructorForMonth() {
		OurDate date = new OurDate();
		assertEquals(0, date.getMonth());
	}

	@org.junit.jupiter.api.Test

	public void testDefaultConstructorForDay() {
		OurDate date = new OurDate();
		assertEquals(0, date.getDay());
	}


	@org.junit.jupiter.api.Test

	public void testOverloadedConstructorForYear() {
		OurDate date = new OurDate(4, 10, 2018);
		assertEquals(2018, date.getYear());
	}

	@org.junit.jupiter.api.Test

	public void testOverloadedConstructorForMonth() {
		OurDate date = new OurDate(4, 10, 2018);
		assertEquals(10, date.getMonth());
	}

	@org.junit.jupiter.api.Test

	public void testOverloadedConstructorForDay() {
		OurDate date = new OurDate(4, 10, 2018);
		assertEquals(4, date.getDay());
	}
}