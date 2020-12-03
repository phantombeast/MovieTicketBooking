package com.altran.model.test;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.altran.model.MovieTimings;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :MovieTimingsTest.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 24, 2020
Author                     :GR_Ritchie_Java_02
Description                :Test Class to test all methods of MovieTimings
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 24, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/
/**
 * Test Class to test all getters and setters of MovieTimings
 * 
 * @see MovieTimingsTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class MovieTimingsTest {
	// movie timings object reference
	private MovieTimings movieTimings;

	/**
	 * This method initializes movie timings object reference and test setters
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		movieTimings = new MovieTimings();
		movieTimings.setMovieTimingId(1);
		movieTimings.setMovieId(String.valueOf(1));
		movieTimings.setTheatreId(String.valueOf(1));
		movieTimings.setMovieDate("2020-02-19");
		movieTimings.setMovieTicketCost(200);
		movieTimings.setMovieTiming("10:00-01:00");
		movieTimings.setTicketBooked(2);
	}

	/**
	 * This method test setters method
	 */
	@Test
	public void testMovieTimings() {
		assertEquals(1, movieTimings.getMovieTimingId());
		assertEquals(String.valueOf(1), movieTimings.getMovieId());
		assertEquals(String.valueOf(1), movieTimings.getTheatreId());
		assertEquals("2020-02-19", movieTimings.getMovieDate());
		assertEquals(200, movieTimings.getMovieTicketCost(), 1);
		assertEquals("10:00-01:00", movieTimings.getMovieTiming());
		assertEquals(2, movieTimings.getTicketBooked());

	}

	/**
	 * This method initializes movie timing to null
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		movieTimings = null;
	}
}
