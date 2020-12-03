package com.altran.service;

import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.altran.model.MovieTimings;
import com.altran.serviceimpl.MovieTimingInfo;

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
Module Name                   :Online Movie Ticket Booking System
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
public interface MovieTiming {
	/**
	 * 
	 * This method is used to get list of theater Id
	 *
	 * @return list of theaters
	 * @throws SQLException
	 */
	public List<String> getTheatreId() throws SQLException;

	/**
	 * 
	 * This method is used to get list of movie id
	 *
	 * @return list of movie id
	 * @throws SQLException
	 */
	public List<String> getMovieId() throws SQLException;

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
			throws URISyntaxException, SQLException;

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
	public List<MovieTimings> getTiming(String theaterId, String date) throws SQLException;

	/**
	 * This method delete the movie timing record
	 * 
	 * @param movieTimingId
	 *            : movie Timing to be deleted
	 * @return record deleted or not
	 * @throws SQLException
	 */
	public int deleteMovieTimings(String movieTimingId) throws SQLException;

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
			int ticketBooked, String movieTimingId) throws NumberFormatException, SQLException;

	/**
	 * This method is used to fetch timings of movies
	 * 
	 * @return list of timings
	 * @throws SQLException
	 */
	public List<String> getTime() throws SQLException;

	/**
	 * This method is used to fetch cities
	 * 
	 * @return list of cities
	 * @throws SQLException
	 */
	public List<String> getCity() throws SQLException;

	/**
	 * This method is used to fetch timing of a particular movie
	 * 
	 * @param movieTimeId
	 * @return MovieTimings object reference
	 * @throws SQLException
	 */
	public MovieTimings getMovieTimings(int movieTimeId) throws SQLException;

	/**
	 * This method is used to fetch timings of movies
	 * 
	 * @return timings of movies
	 * @throws SQLException
	 */
	public List<MovieTimings> getTiming() throws SQLException;

}
