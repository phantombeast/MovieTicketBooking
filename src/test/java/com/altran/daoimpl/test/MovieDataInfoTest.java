package com.altran.daoimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.altran.constant.DatabaseConstants;
import com.altran.dao.MovieData;
import com.altran.daoimpl.MovieDataInfo;
import com.altran.model.Movie;

/**
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieDataInfoTest.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 24, 2020 2:38:38 PM
Author                        :GR_Ritchie_Java_02
Description                   :Test class to test methods of MovieDataInfo

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 24, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class test methods of MovieDataInfo
 * 
 * @see MovieDataInfoTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 24, 2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieDataInfoTest {
	// movie data object reference
	static private MovieData movieData;
	// movie object reference
	static private Movie movie;

	/**
	 * This method initializes movie data and set movie object
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		movieData = new MovieDataInfo();
		movie = new Movie();
		movie.setMovieName("abc");
		movie.setMovieReleaseDate(Date.valueOf("2020-12-09"));
		movie.setMovieSynopsis("xyz");
		movie.setMovieDuration("5");
	}

	/**
	 * This method initializes movie and movie data to null and delete the value
	 * added
	 *
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		// connection object reference
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		// prepared object reference
		PreparedStatement ps = con.prepareStatement("DELETE FROM MOVIE WHERE MOVIENAME=?");
		ps.setString(1, "abc");
		ps.executeUpdate();
		movieData = null;
		movie = null;
		ps.close();
		con.close();
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#addMovie(com.altran.model.Movie)}.
	 */
	@Test
	public void testAddMovie() {
		try {
			assertEquals(1, movieData.addMovie(movie));
			assertEquals(0, movieData.addMovie(movie));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#updateMovie(com.altran.model.Movie)}.
	 */
	@Test
	public void testUpdateMovie() {
		try {
			movie.setMovieId(9999);
			assertNotNull(movieData.updateMovie(movie));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for {@link com.altran.daoimpl.MovieDataInfo#getMovie()}.
	 */
	@Test
	public void testGetMovie() {
		try {
			assertNotNull(movieData.getMovie());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#addSliderPath(java.lang.String)}.
	 */
	@Test
	public void testAddSliderPath() {
		try {
			assertNotNull(movieData.addSliderPath("test.jpg"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#addPosterPath(java.lang.String)}.
	 */
	@Test
	public void testAddPosterPath() {
		try {
			assertNotNull(movieData.addPosterPath("test.jpg"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#getIndividualMovie(int)}.
	 */
	@Test
	public void testGetIndividualMovie() {
		try {
			assertNotNull(movieData.getIndividualMovie(1));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for {@link com.altran.daoimpl.MovieDataInfo#deleteMovie(int)}.
	 */
	@Test
	public void testDeleteMovie() {
		try {
			assertNotNull(movieData.deleteMovie(9999));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#bookTicket(int, int)}.
	 */
	@Test
	public void testBookTicket() {
		try {
			assertEquals(1, movieData.bookTicket(2, 0));
			assertEquals(0, movieData.bookTicket(2, 100000));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#getMovie(java.lang.String)}.
	 */
	@Test
	public void testGetMovieString() {
		try {
			assertNotNull(movieData.getMovie("malang"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#getMovieByCity(java.lang.String)}.
	 */
	@Test
	public void testGetMovieByCity() {
		try {
			assertNotNull(movieData.getMovieByCity("noida"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.MovieDataInfo#getMovieByTime(java.lang.String)}.
	 */
	@Test
	public void testGetMovieByTime() {
		try {
			assertNotNull(movieData.getMovieByTime("10:45"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}
}
