package com.altran.controller.test;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altran.constant.DatabaseConstants;
import com.altran.controller.MovieController;
import com.altran.daoimpl.MovieDataInfo;

/*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieDataInfo.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 4:48:09 PM
Author                        :GR_Ritchie_Java_02
Description                   :Test Methods of MovieController 

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class Test Method of MovieController
 * 
 * @see MovieDataInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */

public class MovieControllerTest {
	// logger constant
	private static Logger logger = Logger.getLogger(MovieControllerTest.class.getName());
	// MovieController object reference
	private static MovieController movieController;
	// Response object reference
	private static Response response;

	/**
	 * 
	 * This method initializes movieController and response object reference
	 *
	 */
	@BeforeClass
	public static void setUp() {
		movieController = new MovieController();
	}

	/**
	 * 
	 * Test method for adding the movie
	 *
	 */
	@Test
	public void testAddMovie() {
		try {
			response = movieController.addMovie("TEST", "Inspirational Movie", Date.valueOf("2020-02-15"), "2.3");
			response = movieController.addMovie(
					"Chapak Indian Hindi-language drama film directed by Meghna Gulzar and produced by Deepika Padukone and Meghna Gulzar in collaboration with Fox Star Studios",
					"Inspirational Movie ", Date.valueOf("2020-02-15"), "2.3");

		} catch (URISyntaxException e) {
			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * 
	 * This method test update movie
	 *
	 */
	@Test
	public void testUpdateMovie() {

		try {
			response = movieController.updateMovie("9999", "Love AajKal", "Romantic Movie", Date.valueOf("2020-02-10"),
					"2.5");
			response = movieController.updateMovie("sss",
					"Love AajKal Indian Hindi-language romantic comedy-drama film starring Saif Ali Khan and Deepika Padukone in lead roles ",
					"Romantic Movie ", Date.valueOf("2020-02-10"), "2.5");

		} catch (URISyntaxException e) {
			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * 
	 * This method test add movie timing
	 *
	 */
	@Test
	public void testAddMovieTiming() {
		try {
			response = movieController.addMovieTiming("2", "2", "2020-02-10", "20:20", 400.00);
			response = movieController.addMovieTiming("2", "2", "2020-15-15", "20:20", 400.00);
		} catch (URISyntaxException e) {
			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * 
	 * This method test delete theater
	 *
	 */
	@Test
	public void testDeleteTheater() {
		try {
			response = movieController.deleteMovie("9999");
			response = movieController.deleteMovie("54789799646464646461436131313654646");
			response = movieController.deleteMovie("A");
		} catch (URISyntaxException e) {
			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());

	}

	/**
	 * 
	 * This method test update movie timings
	 *
	 */
	@Test
	public void testUpdateMovieTimings() {
		try {
			response = movieController.updateMovieTimings("1", "1", Date.valueOf("2020-02-10"), "20:20", 500.00, 2,
					"4");
			response = movieController.updateMovieTimings("1", "54789799646464646461436131313654646",
					Date.valueOf("2020-02-10"), "20:20", 500.00, 2, "4");
			response = movieController.updateMovieTimings("A", "54789799646464646461436131313654646",
					Date.valueOf("2020-02-10"), "20:20", 500.00, 2, "4");

		} catch (URISyntaxException e) {
			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * 
	 * This method test delete movie timings
	 *
	 */
	@Test
	public void testDeleteMovieTimings() {
		try {
			response = movieController.deleteMovieTimings("999");
			response = movieController.deleteMovieTimings("54789799646464646461436131313654646");
			response = movieController.deleteMovieTimings("A");
		} catch (URISyntaxException e) {
			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * 
	 * This method test book ticket
	 *
	 */
	@Test
	public void testBookTicket() {
		try {
			response = movieController.bookTicket(3, 1);
			response = movieController.bookTicket(3, 2000);
			response = movieController.bookTicket(3, 2000);
		} catch (URISyntaxException e) {
			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * 
	 * This method initializes the movie controller object to null and delete the
	 * added value
	 *
	 */
	@AfterClass
	public static void tearDown() {
		movieController = null;
		try {
			Class.forName(DatabaseConstants.DRIVER);
			Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
					DatabaseConstants.PASSWORD);
			PreparedStatement ps = con.prepareStatement("DELETE FROM MOVIE WHERE MOVIENAME =?");
			ps.setString(1, "TEST");
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
