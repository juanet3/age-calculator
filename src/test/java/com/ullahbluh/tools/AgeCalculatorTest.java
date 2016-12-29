package com.ullahbluh.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;

public class AgeCalculatorTest {

	private static final String NOW = "2016-12-27";
	private static final String FOO_BIRTHDAY = "1974-11-20";
	private static final String FOO_AGE = "42";
	
	@Test
	public void calculateAge() {
		AgeCalculator ageCalculator = new AgeCalculator();
		assertEquals(FOO_AGE, ageCalculator.calculateAge(FOO_BIRTHDAY));
	}
	
	@Test
	public void calculateAgeFailure() {
		AgeCalculator ageCalculator = new AgeCalculator();
		String birthday = null;
		assertNull(ageCalculator.calculateAge(birthday));
	}
	
	@Test
	public void calculateAgeFromLocalDate() {
		LocalDate referenceDate = LocalDate.parse(NOW);
		LocalDate birthDay = LocalDate.parse(FOO_BIRTHDAY);
		AgeCalculator ageCalculator = new AgeCalculator(referenceDate);
		assertEquals(FOO_AGE, ageCalculator.calculateAge(birthDay));
	}
	
	@Test
	public void calculateAgeFromDate() {
		Date referenceDate = AgeCalculator.parseStringToDate(NOW);
		Date birthDay = AgeCalculator.parseStringToDate(FOO_BIRTHDAY);
		AgeCalculator ageCalculator = new AgeCalculator(referenceDate);
		assertEquals(FOO_AGE, ageCalculator.calculateAge(birthDay));
	}
	
	@Test
	public void calculateAgeFromStringDate() {
		AgeCalculator ageCalculator = new AgeCalculator(NOW);
		assertEquals(FOO_AGE, ageCalculator.calculateAge(FOO_BIRTHDAY));
	}	
	
}
