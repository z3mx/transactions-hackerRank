package com.hackerrank.exercises.transactions;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Test
	void SolutionsTest() throws ParseException {
		int[] amounts = {1000,-100,-100,-250};
		String[] dates = {"2022-01-31","2022-02-05","2022-02-15","2022-03-09"};
		int response = DemoApplication.Solutions(amounts, dates);
		assertEquals(540, response);
	}
	
	@Test
	void SolutionsTest2() throws ParseException {
		int[] amounts2 = {800,-22,100,-150};
		String[] dates2 = {"2022-01-31","2022-02-05","2022-02-15","2022-03-09"};
		int response2 = DemoApplication.Solutions(amounts2, dates2);
		assertEquals(718, response2);
	}
	
	@Test
	void SolutionsTest3() throws ParseException {
		int[] amounts = {1000,-100,-100,-250,500};
		String[] dates = {"2022-01-31","2022-02-05","2022-02-15","2022-03-09","2022-04-09"};
		int response = DemoApplication.Solutions(amounts, dates);
		assertEquals(1040, response);
	}
	
	@Test
	void SolutionsTestDepositAndCardpaymentInAMonth() throws ParseException {
		int[] amounts = {1000,-100,-100,-250,500,-100};
		String[] dates = {"2022-01-31","2022-02-05","2022-02-15","2022-03-09","2022-04-09","2022-04-20"};
		int response = DemoApplication.Solutions(amounts, dates);
		assertEquals(940, response);
	}
}
