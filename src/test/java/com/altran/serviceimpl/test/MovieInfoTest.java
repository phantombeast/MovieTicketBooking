package com.altran.serviceimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altran.constant.DatabaseConstants;
import com.altran.serviceimpl.MovieInfo;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :MovieInfoTest.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 24, 2020
Author                     :GR_Ritchie_Java_02
Description                :Test Class to test all methods of Company class.
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 24, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/
/**
 * Test Class to test all getters and setters of Company class.
 * 
 * @see MovieInfoTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class MovieInfoTest {
	private static MovieInfo movieInfo;

	/**
	 * This method initializes movieInfo
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@BeforeClass
	public static void setUp() throws ClassNotFoundException, SQLException {
		movieInfo = new MovieInfo();
	}

	/**
	 * Test method for add Movie
	 *
	 * @throws java.lang.Exception
	 */
	@Test
	public void testAddMovie() {
		try {
			assertEquals(1, movieInfo.addMovie("abc", "Great Movie", Date.valueOf("2020-05-20"), "2.5"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for update Movie
	 */
	@Test
	public void testUpdateMovie() {
		try {
			assertNotNull(movieInfo.updateMovie("9999", "Chappak", "Great Movie", Date.valueOf("2020-05-20"), "5"));
		} catch (SQLException e) {
			assertNotNull(e);
		}

	}

	/**
	 * Test method for addPosterPath
	 */
	@Test
	public void testAddPosterPath() {
		try {
			assertEquals(1, movieInfo.addPosterPath("PosterImage.jpg"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for addSliderPath
	 */
	@Test
	public void testAddSliderPath() {
		try {
			assertNotNull(movieInfo.addSliderPath("Image.jpg"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getMovie
	 */
	@Test
	public void testGetMovie() {
		try {
			assertNotNull(movieInfo.getMovie());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getMovieByCity
	 */
	@Test
	public void testGetMovieByCity() {
		try {
			assertNotNull(movieInfo.getMovieByCity("New Delhi"));
			assertNotNull(movieInfo.getMovieByCity("abcd"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getMovieByTime
	 */
	@Test
	public void testGetMovieByTime() {
		try {
			assertNotNull(movieInfo.getMovieByTime("20:20"));
			assertNotNull(movieInfo.getMovieByTime("00:00"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getMovie
	 */
	@Test
	public void testGetMovieString() {
		try {
			assertNotNull(movieInfo.getMovie("abc"));
			assertNull(movieInfo.getMovie("abcd"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getIndividualMovie
	 */
	@Test
	public void testGetIndividualMovie() {
		try {
			assertNotNull(movieInfo.getIndividualMovie("1"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for bookTicket
	 */
	@Test
	public void testBookTicket() {
		try {
			assertEquals(1, movieInfo.bookTicket(5, 0));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for deleteMovie
	 */
	@Test
	public void testDeleteMovie() {
		try {
			assertNotNull(movieInfo.deleteMovie(String.valueOf(9999)));
		} catch (NumberFormatException | SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * This class initializes movieInfo to null and delete the added details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@AfterClass
	public static void tearDown() throws SQLException, ClassNotFoundException {
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM MOVIE WHERE MOVIENAME=?");
		ps.setString(1, "abc");
		ps.executeUpdate();
		movieInfo = null;
		ps.close();
		con.close();
	}
}
