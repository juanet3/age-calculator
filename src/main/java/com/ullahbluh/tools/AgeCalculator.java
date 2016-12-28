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

		Date birthdayDate = parseStringToDate(birthday);
		if (null != birthdayDate) {
			LocalDate birthLocalDate = LocalDate.parse(sdf.format(birthdayDate)); 
			Period period = Period.between(birthLocalDate, now);
			age = String.valueOf(period.getYears());
		}

		return age;
	}

	private void setNow(Date referenceDate) {
		now = LocalDate.parse(sdf.format(referenceDate));
	}
	
	private Date parseStringToDate(String referenceStringDate) {
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
