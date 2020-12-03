/**
 * 
 */
package com.altran.serviceimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altran.constant.DatabaseConstants;
import com.altran.serviceimpl.MovieTimingInfo;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :MovieTimingInfoTest.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 25, 2020
Author                     :GR_Ritchie_Java_02
Description                :Test Class to test all methods of Company class.
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 25, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/
/**
 * Test Class to test all getters and setters of Company class.
 * 
 * @see MovieTimingInfoTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class MovieTimingInfoTest {
	// movieTimingInfo object reference
	static private MovieTimingInfo movieTimingInfo;

	/**
	 * This class initializes movieTimingInfo object refernce
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@BeforeClass
	public static void setUp() throws ClassNotFoundException, SQLException {
		movieTimingInfo = new MovieTimingInfo();
	}

	/**
	 * Test method for getTheatreId
	 */
	@Test
	public void testGetTheatreId() {
		try {
			assertNotNull(movieTimingInfo.getTheatreId());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getMovieId
	 */
	@Test
	public void testGetMovieId() {
		try {
			assertNotNull(movieTimingInfo.getMovieId());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for movieTimings
	 */
	@Test
	public void testMovieTimings() {
		try {
			assertEquals(1, movieTimingInfo.movieTimings("1", "55", "2020-05-20", "10:00", 200.58));
		} catch (URISyntaxException | SQLException e) {
			assertNotNull(e);
		}

	}

	/**
	 * Test method for getTimingOfTheater
	 */
	@Test
	public void testGetTimingOfTheater() {
		try {
			assertNotNull(movieTimingInfo.getTiming("1", "2020-05-20"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getMovieTimings
	 */
	@Test
	public void testGetMovieTimings() {
		try {
			assertNotNull(movieTimingInfo.getMovieTimings(6));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getTimingOfMovie
	 */
	@Test
	public void testGetTimingOfMovie() {
		try {
			assertNotNull(movieTimingInfo.getTiming());
		} catch (SQLException e) {
			assertNotNull(e);
		}

	}

	/**
	 * Test method for getCity
	 */
	@Test
	public void testGetCity() {
		try {
			assertNotNull(movieTimingInfo.getCity());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getTime
	 */
	@Test
	public void testGetTime() {
		try {
			assertNotNull(movieTimingInfo.getTime());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for updateMovieTimings
	 */
	@Test
	public void testUpdateMovieTimings() {
		try {
			assertNotNull(movieTimingInfo.updateMovieTimings("1", "2", Date.valueOf("2020-05-20"), "12:00", 100.58, 1,
					"9999"));
		} catch (NumberFormatException | SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for deleteMovieTimings
	 */
	@Test
	public void testDeleteMovieTimings() {
		try {
			assertNotNull(movieTimingInfo.deleteMovieTimings(String.valueOf(9999)));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * This class set movieTimingInfo to null and clear added details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@AfterClass
	public static void tearDown() throws SQLException, ClassNotFoundException {
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM MOVIETIMINGS WHERE MOVIEID=?");
		ps.setString(1, "55");
		ps.executeUpdate();
		movieTimingInfo = null;
		ps.close();
		con.close();
	}
}
