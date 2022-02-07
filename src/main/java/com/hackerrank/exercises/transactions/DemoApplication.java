package com.hackerrank.exercises.transactions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	private static int FEE = 5;
	
	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		try {
			System.out.println(Solutions(getAmounts(),getDates()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static String[] getDates() {
		String[] response = {"2022-01-31","2022-02-05","2022-02-15","2022-03-09"};
		return response;
	}

	private static int[] getAmounts() {
		int[] response = {1000,-100,-100,-250};
		return response;
	}

	/**
	 * This method helps to calculate balance from annual account
	 * For card payments there are a fee from 5 per month.
	 * in case of  if the customer gets deposits in a month there are not fees.
	 * 
	 * to use this method correctly the amounts and date it should be sorted by deposit 
	 * first and the card payments and also the dates it should sorted.
	 * 
	 * @param amounts int[].
	 * @param dates String[].
	 * @return balance.
	 * @throws ParseException
	 */
	public static int Solutions(int[]amounts, String[] dates) throws ParseException {
		
		int balance = 0;
		try {
		Set<Integer> months = getListMonths();
		int i = 0;
		for(int amount : amounts) {
			if (isCardPayment(amount)) {
				if(isDiscountedFee(dates[i],months)) {
					balance += amount - FEE;
				}else {
					balance += amount;
				}
				
			}else {
				balance += amount;
				if(isDiscountedFee(dates[i], months)) {
					System.out.println("This month there are not fee");
				}
			}
			i++;
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return balance;
	}
	
	private static boolean isDiscountedFee(String date, Set<Integer> months){
		if(months.contains(getMonth(date))) {
			months.remove(getMonth(date));
			return true;
		}else {
			return false;
		}
	}

	private static boolean isCardPayment(int amount) {
		return (amount < 0) ? true:false;
	}
	

	public static int getMonth(String date) {
		try {
			Date theDate = FORMAT.parse(date);
		
			Calendar myCal = new GregorianCalendar();
			myCal.setTime(theDate);
			return myCal.get(Calendar.MONTH) + 1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private static Set<Integer> getListMonths() {
		Set<Integer> list = new HashSet<Integer>();
		for(int i=1;i<=12;i++) {
			list.add(i);
		}
		return list;
	}
}
