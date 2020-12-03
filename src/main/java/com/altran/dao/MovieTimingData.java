package com.altran.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.altran.model.MovieTimings;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieTimingData.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 4:01:38 PM
Author                        :GR_Ritchie_Java_02
Description                   :add movie timings,update movie timings, delete movie timings and fetch movie timings

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This interface provides method to add movie timings,update movie timings,
 * delete movie timings and fetch movie timings
 * 
 * @see MovieTimingData
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
public interface MovieTimingData {
	/**
	 * 
	 * This method a new movie timings into the database
	 *
	 * @param movieTime
	 *            : MovieTime object reference
	 * @return added in the database or not
	 * @throws SQLException
	 */
	public int addMovieTimings(MovieTimings movieTime) throws SQLException;

	/**
	 * 
	 * This method is used to get timing of movies of a particular theater id
	 *
	 * @param theaterId
	 * @param date
	 * @return movie timings record
	 * @throws SQLException
	 */

	public ResultSet getTiming(String theaterId, String date) throws SQLException;

	/**
	 * 
	 * This method is used to get list of theater Id and theater name
	 *
	 * @return Theater detail record
	 * @throws SQLException
	 */
	public ResultSet getTheatreId() throws SQLException;

	/**
	 * 
	 * This method is used to fetch list get movie id and movie name
	 *
	 * @return movie record
	 * @throws SQLException
	 */
	public ResultSet getMovieId() throws SQLException;

	/**
	 * 
	 * This method is used to get list of movie timings
	 *
	 * @return movie timings record
	 * @throws SQLException
	 */
	public ResultSet getMovieTimings() throws SQLException;

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
	 * This method is used to get list of timings
	 * 
	 * @return MovieTimings record
	 * @throws SQLException
	 */

	public ResultSet getTiming() throws SQLException;

	/**
	 * This method is used to fetch timings of movies
	 * 
	 * @return timings record
	 * @throws SQLException
	 */

	public ResultSet getTime() throws SQLException;

	/**
	 * This method is used to fetch cities
	 * 
	 * @return cities record
	 * @throws SQLException
	 */
	public ResultSet getCity() throws SQLException;
}
