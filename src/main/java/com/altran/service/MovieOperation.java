package com.altran.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.altran.model.Movie;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieOperation.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 1:17:28 PM
Author                        :GR_Ritchie_Java_02
Description                   :update,delete,fetch movie details and also book ticket

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This interface provide methods to update,delete,fetch movie details and also
 * provide method to book ticket
 * 
 * @see MovieOperation
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public interface MovieOperation {
	/**
	 * 
	 * This method add a new movie
	 *
	 * @param movieName
	 *            : movie name to be added
	 * @param movieSynopsis
	 *            : movie synopsis to be added
	 * @param movieReleaseDate
	 *            : movie release date to be added
	 * @param movieDuration
	 *            : movie duration to be added
	 * @return movie added or not
	 * @throws SQLException
	 */
	public int addMovie(String movieName, String movieSynopsis, Date movieReleaseDate, String movieDuration)
			throws SQLException;

	/**
	 * 
	 * This method update a movie
	 *
	 * @param movieId
	 *            : movieId to be updated
	 * @param movieName
	 *            : movie name to be updated
	 * @param movieSynopsis
	 *            : movieSynopsis to be updated
	 * @param movieReleaseDate
	 *            : movieReleaseDate to be updated
	 * @param movieDuration
	 *            : movieDuration to be updated
	 * @return movie updated or not
	 * @throws SQLException
	 */
	public int updateMovie(String movieId, String movieName, String movieSynopsis, Date movieReleaseDate,
			String movieDuration) throws SQLException;

	/**
	 * 
	 * This method add slider path for a movie
	 *
	 * @param path
	 *            : slider path to be saved
	 * @return added or not
	 * @throws SQLException
	 */
	public int addSliderPath(String path) throws SQLException;

	/**
	 * 
	 * This method add poster path for a movie
	 *
	 * @param path
	 *            : poster path to be saved
	 * @return added or not
	 * @throws SQLException
	 */
	public int addPosterPath(String path) throws SQLException;

	/**
	 * 
	 * This method update poster path for a movie
	 *
	 * @param path
	 *            : poster path to be saved
	 * @return updated or not
	 * @throws SQLException
	 */
	public int updatePosterPath(String path, String movieId) throws SQLException;

	/**
	 * 
	 * This method is used to get list of movie
	 *
	 * @return list of movies
	 * @throws SQLException
	 */

	public List<Movie> getMovie() throws SQLException;

	/**
	 * 
	 * This method is used to get a particular movie based on the movie id
	 *
	 * @param movieId
	 *            : movie to be returned
	 * @return Movie object reference
	 * @throws SQLException
	 */
	public Movie getIndividualMovie(String movieId) throws SQLException;

	/**
	 * 
	 * This method delete a movie
	 *
	 * @param movieId
	 *            : movie to be deleted
	 * @return deleted or not
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public int deleteMovie(String movieId) throws NumberFormatException, SQLException;

	/**
	 * 
	 * This method is used to book a ticket
	 *
	 * @param movieId
	 *            : movie id to be booked
	 * @param date
	 *            : date on which movie to be booked
	 * @param movieTime
	 *            : show time for which movie is to be booked
	 * @param theaterId
	 *            : theater at which movie is to be booked
	 * @param totalTicket
	 *            : total number of ticket
	 * @param cost
	 *            : cost of 1 ticket
	 * @return booked or not
	 * @throws SQLException
	 */
	public int bookTicket(int movieId, Date date, String movieTime, int theaterId, int totalTicket, String cost)
			throws SQLException;

	/**
	 * This method is used to get movies list at a particular time slot
	 * 
	 * @param time
	 *            : time to be searched
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Movie> getMovieByTime(String time) throws SQLException;

	/**
	 * This method is used to get movies list in a city
	 * 
	 * @param city
	 *            : city to be searched
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Movie> getMovieByCity(String city) throws SQLException;

	/**
	 * This method is used to get details of a movie
	 * 
	 * @param movieName
	 *            : details of movie to be fetch
	 * @return movie object reference
	 */
	public Movie getMovie(String movieName);

}
