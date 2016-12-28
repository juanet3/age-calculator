package com.ullahbluh.tools;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

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
	public void calculateAgeFromLocalDate() {
		LocalDate referenceDate = LocalDate.parse(NOW);
		AgeCalculator ageCalculator = new AgeCalculator(referenceDate);
		assertEquals(FOO_AGE, ageCalculator.calculateAge(FOO_BIRTHDAY));
	}
	
	@Test
	public void calculateAgeFromStringDate() {
		AgeCalculator ageCalculator = new AgeCalculator(NOW);
		assertEquals(FOO_AGE, ageCalculator.calculateAge(FOO_BIRTHDAY));
	}	
	
}
