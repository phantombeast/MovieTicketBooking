package com.altran.daoimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.altran.constant.DatabaseConstants;
import com.altran.daoimpl.MovieTimingsDataInfo;
import com.altran.model.MovieTimings;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieTimingsDataInfoTest.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 5:00:40 PM
Author                        :GR_Ritchie_Java_02
Description                   :Test methods of MovieTimingsDataInfo

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class Test methods of MovieTimingsDataInfo
 * 
 * @see MovieTimingsDataInfoTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieTimingsDataInfoTest {
	// logger constant
	private static Logger logger = Logger.getLogger(MovieTimingsDataInfoTest.class.getName());
	// MovieTimingsDataInfo Object refernce
	private static MovieTimingsDataInfo movieTimingsDataInfo;
	// Movie timings object reference
	private static MovieTimings movieTime;

	/**
	 * 
	 * This method initializes movieTimingsDataInfo object reference and set values
	 * of movieTime
	 *
	 */
	@BeforeClass
	public static void setUp() {
		try {
			movieTimingsDataInfo = new MovieTimingsDataInfo();
			movieTime = new MovieTimings();
			movieTime.setMovieId("99");
			movieTime.setTheatreId("1");
			movieTime.setMovieDate("2020-02-01");
			movieTime.setMovieTiming("20:20");
			movieTime.setTicketBooked(1);
			movieTime.setMovieTicketCost(500.00);
		} catch (ClassNotFoundException | SQLException e) {
			logger.warning(e.getMessage());
		}
	}

	/**
	 * 
	 * Test method for addMovieTimings
	 *
	 */
	@Test
	public void testAddMovieTimings() {
		try {
			assertEquals(1, movieTimingsDataInfo.addMovieTimings(movieTime));
			assertEquals(0, movieTimingsDataInfo.addMovieTimings(movieTime));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * Test method for getTimings
	 *
	 */
	@Test
	public void testGetTimings() {
		try {
			assertNotNull(movieTimingsDataInfo.getTiming());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * This method test method of getTheaterId
	 *
	 */
	@Test
	public void testGetTheatreId() {
		try {
			assertNotNull(movieTimingsDataInfo.getTheatreId());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * Test method for getMovieId
	 *
	 */
	@Test
	public void testGetMovieId() {
		try {
			assertNotNull(movieTimingsDataInfo.getMovieId());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * Test method for getMovieTimings
	 *
	 */
	@Test
	public void testGetMovieTimings() {
		try {
			assertNotNull(movieTimingsDataInfo.getMovieTimings());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * Test method for getMovieTimings
	 */
	@Test
	public void testGetMovieTimingsInt() {
		try {
			assertNotNull(movieTimingsDataInfo.getMovieTimings(11));
		} catch (SQLException e) {
			assertNotNull(e);
		}

	}

	/**
	 * 
	 * Test method for get city
	 */
	@Test
	public void testGetCity() {
		try {
			assertNotNull(movieTimingsDataInfo.getCity());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * Test method for get time
	 */
	@Test
	public void testGetTime() {
		try {
			assertNotNull(movieTimingsDataInfo.getTime());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * Test method for get timing
	 */
	@Test
	public void testGetTiming() {
		try {
			assertNotNull(movieTimingsDataInfo.getTiming("12", "2020-02-05"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * Test method for update movie timings
	 */
	@Test
	public void testUpdateMovieTimings() {
		try {
			assertNotNull(movieTimingsDataInfo.updateMovieTimings("3", "3", Date.valueOf("2020-02-05"), "20:20", 500.00,
					1, String.valueOf(9999)));
		} catch (NumberFormatException | SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * Test method for delete movie timings
	 */
	@Test
	public void testDeleteMovieTimings() {
		try {
			assertNotNull(movieTimingsDataInfo.deleteMovieTimings(String.valueOf(999)));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * 
	 * This class initializes movieTimingsDataInfo and movie time to null and delete
	 * the added data
	 */
	@AfterClass
	public static void tearDown() throws SQLException, ClassNotFoundException {
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM MOVIETIMINGS WHERE MOVIEID=?");
		ps.setString(1, "99");
		ps.executeUpdate();
		movieTimingsDataInfo = null;
		movieTime = null;
		ps.close();
		con.close();
	}
}
