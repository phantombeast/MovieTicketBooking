package com.altran.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.altran.model.Theater;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :TheaterTest.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 24, 2020
Author                     :GR_Ritchie_Java_02
Description                :Test Class to test all methods of Theater
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 24, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/
/**
 * Test Class to test all getters and setters of Theater
 * 
 * @see TheaterTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class TheaterTest {
	// Theater object reference
	private Theater theater;

	/**
	 * This method initializes theater object reference and test setters
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		theater = new Theater();
		theater.setTheaterId("T001");
		theater.setTheaterName("SVCineMax");
		theater.setAddressLine1("Sector-38");
		theater.setAddressLine2("Islampur");
		theater.setCity("Gurgaon");
		theater.setRegion("Haryana");
		theater.setPinCode(122001l);
		theater.setTotalSeats(40);
	}

	/**
	 * This method test getter methods
	 */
	@Test
	public void testTheaterGetters() {
		assertEquals("T001", theater.getTheaterId());
		assertEquals("SVCineMax", theater.getTheaterName());
		assertEquals("Sector-38", theater.getAddressLine1());
		assertEquals("Islampur", theater.getAddressLine2());
		assertEquals("Gurgaon", theater.getCity());
		assertEquals("Haryana", theater.getRegion());
		assertEquals(122001l, theater.getPinCode(), 1);
		assertEquals(40, theater.getTotalSeats());
	}

	/**
	 * This method set theater object to null
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		theater = null;
	}
}
