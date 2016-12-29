package com.ullahbluh.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class AgeCalculator {

	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	LocalDate now;
	
	public AgeCalculator() {
		setNow(new Date());
	}

	public AgeCalculator(Date referenceDate) {
		setNow(referenceDate);
	}
	
	public AgeCalculator(LocalDate referenceDate) {
		now = referenceDate;
	}
	
	public AgeCalculator(String referenceDate) {
		setNow(parseStringToDate(referenceDate));
	}
	
	public String calculateAge(String birthday) {
		String age = null;
		if (null != birthday) {
			Date birthdayDate = parseStringToDate(birthday);
			age = calculateAge(birthdayDate);
		}
		return age;
	}

	public String calculateAge(Date birthday) {
		String age = null;
		if (null != birthday) {
			LocalDate birthLocalDate = LocalDate.parse(sdf.format(birthday)); 
			age = calculateAge(birthLocalDate);
		}
		return age;
	}
	
	public String calculateAge(LocalDate birthday) {
		String age = null;
		if (null != birthday) {
			Period period = Period.between(birthday, now);
			age = String.valueOf(period.getYears());	
		}
		return age;
	}
	
	private void setNow(Date referenceDate) {
		now = LocalDate.parse(sdf.format(referenceDate));
	}
	
	public static Date parseStringToDate(String referenceStringDate) {
		Date referenceDate = null;
		
		if (null != referenceStringDate) {
			try {
				referenceDate = sdf.parse(referenceStringDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return referenceDate;
	}

}
