package com.altran.model.test;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.altran.model.Movie;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :MovieTest.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 24, 2020
Author                     :GR_Ritchie_Java_02
Description                :Test Class to test all methods of MovieTest
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 24, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/
/**
 * Test Class to test all getters and setters of MovieTest
 * 
 * @see MovieTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class MovieTest {
	// movie object reference
	private Movie movie;

	/**
	 * This method initializes movie object reference and test setters
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("Chapak");
		movie.setMovieReleaseDate(Date.valueOf("2020-02-20"));
		movie.setMovieSynopsis("This is a great movie");
		movie.setMovieDuration("2.3");
		movie.setSliderImagePath("C:\\Users\\gur57588\\Pictures\\Wallpaper.jpg");
		movie.setPosterImagePath("C:\\Users\\gur57588\\Pictures\\Wallpaper.jpg");
	}

	/**
	 * This method test getters method
	 */
	@Test
	public void testMovieGetters() {
		assertEquals(1, movie.getMovieId());
		assertEquals("Chapak", movie.getMovieName());
		assertEquals(Date.valueOf("2020-02-20"), movie.getMovieReleaseDate());
		assertEquals("This is a great movie", movie.getMovieSynopsis());
		assertEquals("2.3", movie.getMovieDuration());
		assertEquals("C:\\Users\\gur57588\\Pictures\\Wallpaper.jpg", movie.getSliderImagePath());
		assertEquals("C:\\Users\\gur57588\\Pictures\\Wallpaper.jpg", movie.getPosterImagePath());
	}

	/**
	 * This method set initializes movie to null
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		movie = null;
	}

}
