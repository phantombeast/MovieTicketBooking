package com.altran.serviceimpl;

import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.altran.daoimpl.MovieTimingsDataInfo;
import com.altran.model.MovieTimings;
import com.altran.service.MovieTiming;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieTimingInfo.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Movie Timing
Date of First Release         :Feb 19, 2020 12:39:10 PM
Author                        :GR_Ritchie_Java_02
Description                   :Add , update , fetch or delete timings of theaters 

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class provides method to Add , update , fetch or delete timings of
 * theaters
 * 
 * @see MovieTimingInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class MovieTimingInfo implements MovieTiming {
	// MovieTimingsData object reference
	MovieTimingsDataInfo timingInfo;

	// logger constant
	private static Logger logger = Logger.getLogger(MovieTimingInfo.class.getName());

	public MovieTimingInfo() throws ClassNotFoundException, SQLException {
		timingInfo = new MovieTimingsDataInfo();
	}

	/**
	 * 
	 * This method is used to get list of theater Id
	 *
	 * @return list of theaters
	 * @throws SQLException
	 */
	public List<String> getTheatreId() throws SQLException {
		logger.info("*****inside getTheatreId******");
		// List to store theater Id
		List<String> theatreId = new ArrayList<>();
		// ResultSet to store theater Id
		ResultSet rs = timingInfo.getTheatreId();
		while (rs.next()) {
			theatreId.add(rs.getString(1) + " " + rs.getString(2));
		}
		logger.info("******exiting from getTheatreId******");
		return theatreId;
	}

	/**
	 * 
	 * This method is used to get list of movie id
	 *
	 * @return list of movie id
	 * @throws SQLException
	 */
	public List<String> getMovieId() throws SQLException {
		logger.info("*****inside getMovieId  ******");
		// list of movie id
		List<String> movieId = new ArrayList<>();
		// Result set to store lost of movie id
		ResultSet rs = timingInfo.getMovieId();
		while (rs.next()) {
			movieId.add(rs.getString(1) + " " + rs.getString(2));
		}
		logger.info("*****exiting from getMovieId  ******");
		return movieId;
	}

	/**
	 * 
	 * This method
	 *
	 * @param theatreId
	 *            is used to add a new movie timing
	 * @param movieId
	 *            : movieId to be saved
	 * @param movieDate
	 *            : movieDate to be saved
	 * @param movieTime
	 *            : movieTime to be saved
	 * @param ticketCost
	 *            : ticketCost to be saved
	 * @return added or not
	 * @throws URISyntaxException
	 * @throws SQLException
	 */
	public int movieTimings(String theatreId, String movieId, String movieDate, String movieTime, Double ticketCost)
			throws URISyntaxException, SQLException {
		logger.info("*****inside movieTimings  ******");
		// MovieTimings object reference
		MovieTimings movieTiming = new MovieTimings();
		// Array to store theater id and theater name
		String theatreId1[] = theatreId.split(" ");
		movieTiming.setTheatreId(theatreId1[0]);
		// Array to store movie id and theater name
		String movieId1[] = movieId.split(" ");
		movieTiming.setMovieId(movieId1[0]);
		movieTiming.setMovieDate(movieDate);
		movieTiming.setMovieTiming(movieTime);
		movieTiming.setMovieTicketCost(ticketCost);
		logger.info("*****exiting from movieTimings  ******");
		return timingInfo.addMovieTimings(movieTiming);

	}

	/**
	 * 
	 * This method is used to get timing of a theater
	 *
	 * @param theaterId
	 *            : theater id to be checked
	 * @param date
	 *            : date to be checked
	 * @return List of timings
	 * @throws SQLException
	 */
	public List<MovieTimings> getTiming(String theaterId, String date) throws SQLException {

		logger.info("*****inside getTiming ******");
		// ResultSet to store timings of a theater
		ResultSet rs = timingInfo.getTiming(theaterId, date);
		// List to store timings of a theater
		List<MovieTimings> timings = new ArrayList<>();

		while (rs.next()) {
			// MovieTimings object reference
			MovieTimings movieTimings = new MovieTimings();
			movieTimings.setMovieTimingId(rs.getInt(1));
			movieTimings.setMovieId(rs.getString(3));
			movieTimings.setTheatreId(rs.getString(2));
			movieTimings.setMovieTiming(rs.getString(5));
			movieTimings.setMovieTicketCost(rs.getDouble(6));
			movieTimings.setMovieDate(rs.getString(4));
			movieTimings.setTicketBooked(rs.getInt(7));
			timings.add(movieTimings);
		}
		logger.info("*****exiting from getTiming ******");
		return timings;
	}

	/**
	 * This method is used to fetch timings of movies
	 * 
	 * @return timings of movies
	 * @throws SQLException
	 */
	public List<MovieTimings> getTiming() throws SQLException {

		logger.info("*****inside getTiming ******");
		// ResultSet to store timings of a theater
		ResultSet rs = timingInfo.getTiming();
		// List to store timings of a theater
		List<MovieTimings> timings = new ArrayList<>();
		while (rs.next()) {
			// MovieTimings object reference
			MovieTimings movieTimings = new MovieTimings();
			movieTimings.setMovieTimingId(rs.getInt(1));
			movieTimings.setMovieId(rs.getString(3));
			movieTimings.setTheatreId(rs.getString(2));
			movieTimings.setMovieTiming(rs.getString(5));
			movieTimings.setMovieTicketCost(rs.getDouble(6));
			movieTimings.setMovieDate(rs.getString(4));
			movieTimings.setTicketBooked(rs.getInt(7));
			timings.add(movieTimings);
		}
		logger.info("*****exiting from getTiming ******");
		return timings;
	}

	/**
	 * This method is used to fetch timing of a particular movie
	 * 
	 * @param movieTimeId
	 * @return MovieTimings object reference
	 * @throws SQLException
	 */
	public MovieTimings getMovieTimings(int movieTimeId) throws SQLException {
		logger.info("*****inside getMovieTimings ******");
		// ResultSet to store record of MovieTimings
		ResultSet rs = timingInfo.getMovieTimings(movieTimeId);
		rs.next();
		// MovieTimings object reference
		MovieTimings movieTimings = new MovieTimings();
		movieTimings.setMovieTimingId(rs.getInt(1));
		movieTimings.setMovieId(rs.getString(3));
		movieTimings.setTheatreId(rs.getString(2));
		movieTimings.setMovieTiming(rs.getString(5));
		movieTimings.setMovieTicketCost(rs.getDouble(6));
		movieTimings.setMovieDate(rs.getString(4));
		movieTimings.setTicketBooked(rs.getInt(7));
		logger.info("*****exiting from getMovieTimings ******");
		return movieTimings;
	}

	/**
	 * This method is used to fetch cities
	 * 
	 * @return list of cities
	 * @throws SQLException
	 */
	public List<String> getCity() throws SQLException {
		logger.info("*****inside getCity ******");
		// List to store cities
		List<String> city = new ArrayList<>();
		// Result set to store record of cities
		ResultSet rs = timingInfo.getCity();
		while (rs.next()) {
			city.add(rs.getString("city"));
		}
		logger.info("*****exiting from getCity ******");
		return city;
	}

	/**
	 * This method is used to fetch timings of movies
	 * 
	 * @return list of timings
	 * @throws SQLException
	 */
	public List<String> getTime() throws SQLException {
		logger.info("*****inside getTime ******");
		// List to store timings
		List<String> time = new ArrayList<>();
		// Result set to store timing record
		ResultSet rs = timingInfo.getTime();
		while (rs.next()) {
			time.add(rs.getString("movietime"));
		}
		logger.info("*****exiting from getTime ******");
		return time;
	}

	/**
	 * This method is used to update the movie timings
	 * 
	 * @param theatreId
	 *            : theater id to be updated
	 * @param movieId
	 *            : movie id to be updated
	 * @param movieDate
	 *            : movie date to be updated
	 * @param movieTime
	 *            : movie time to be updated
	 * @param ticketCost
	 *            : ticket cost to be updated
	 * @param ticketBooked
	 *            : ticket booking count to be updated
	 * @param movieTimingId
	 *            : Movie timing Id to be updated
	 * @return record updated or not
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public int updateMovieTimings(String theatreId, String movieId, Date movieDate, String movieTime, Double ticketCost,
			int ticketBooked, String movieTimingId) throws NumberFormatException, SQLException {
		logger.info("*****inside updateMovieTimings ******");
		// Array to store theater id and theater name
		String theaterId[] = theatreId.split(" ");
		// Array to store movie id and movie name
		String movieId1[] = movieId.split(" ");
		logger.info("*****exiting from updateMovieTimings ******");
		return timingInfo.updateMovieTimings(theaterId[0], movieId1[0], movieDate, movieTime, ticketCost, ticketBooked,
				movieTimingId);
	}

	/**
	 * This method delete the movie timing record
	 * 
	 * @param movieTimingId
	 *            : movie Timing to be deleted
	 * @return record deleted or not
	 * @throws SQLException
	 */
	public int deleteMovieTimings(String movieTimingId) throws SQLException {
		logger.info("*****inside deleteMovieTimings ******");
		logger.info("*****exiting from deleteMovieTimings ******");
		return timingInfo.deleteMovieTimings(movieTimingId);
	}
}
