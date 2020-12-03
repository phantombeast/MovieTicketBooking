package com.altran.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.altran.model.Movie;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieData.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 4:48:09 PM
Author                        :GR_Ritchie_Java_02
Description                   :add movie, update movie, delete movie, book movie

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This interface add provide methods to add movie, update movie, delete movie,
 * book movie
 * 
 * @see MovieData
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public interface MovieData {
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
	public int addMovie(Movie movie) throws SQLException;

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
	public int updateMovie(Movie movie) throws SQLException;

	/**
	 * 
	 * This method is used to get list of movie
	 *
	 * @return movie record
	 * @throws SQLException
	 */
	public ResultSet getMovie() throws SQLException;

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
	 * This method is used to get a particular movie based on the movie id
	 *
	 * @param movieId
	 *            : movie to be returned
	 * @return Movie object reference
	 * @throws SQLException
	 */
	public ResultSet getIndividualMovie(int movieId) throws SQLException;

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
	public int deleteMovie(int movieId) throws SQLException;

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
	public int bookTicket(int movieTimeId, int totalTicket) throws SQLException;

	/**
	 * This method is used to get details of a movie
	 * 
	 * @param movieName
	 *            : details of movie to be fetch
	 * @return movie record
	 */
	public ResultSet getMovie(String movieName) throws SQLException;

	/**
	 * This method is used to get movies list in a city
	 * 
	 * @param city
	 *            : city to be searched
	 * @return movie record
	 * @throws SQLException
	 */
	public ResultSet getMovieByCity(String city) throws SQLException;

	/**
	 * This method is used to get movies list at a particular time slot
	 * 
	 * @param time
	 *            : time to be searched
	 * @return movies record
	 * @throws SQLException
	 */
	public ResultSet getMovieByTime(String time) throws SQLException;
}
