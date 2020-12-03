package com.altran.serviceimpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.altran.daoimpl.MovieDataInfo;
import com.altran.model.Movie;

/**
**********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieInfo.java 
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
 * This class provide methods to update,delete,fetch movie details and also
 * provide method to book ticket
 * 
 * @see MovieInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class MovieInfo {

	// logger constant
	private static Logger logger = Logger.getLogger(MovieInfo.class.getName());

	// MovieData object reference
	MovieDataInfo movieDataInfo;

	/**
	 * Constructor for MovieInfo
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public MovieInfo() throws ClassNotFoundException, SQLException {
		movieDataInfo = new MovieDataInfo();
	}

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
			throws SQLException {
		logger.info("*****inside add Movie******");
		// Movie object reference
		Movie movie = new Movie();
		movie.setMovieName(movieName);
		movie.setMovieSynopsis(movieSynopsis);
		movie.setMovieReleaseDate(movieReleaseDate);
		movie.setMovieDuration(movieDuration);
		logger.info("******exiting from add Movie*******");

		return movieDataInfo.addMovie(movie);
	}

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
			String movieDuration) throws SQLException {
		// Movie object reference
		Movie movie = new Movie();
		logger.info("*****inside update Movie*******");
		movie.setMovieId(Integer.parseInt(movieId));
		movie.setMovieName(movieName);
		movie.setMovieSynopsis(movieSynopsis);
		movie.setMovieReleaseDate(movieReleaseDate);
		movie.setMovieDuration(movieDuration);
		logger.info("******exiting from update Movie*****");
		return movieDataInfo.updateMovie(movie);
	}

	/**
	 * 
	 * This method add slider path for a movie
	 *
	 * @param path
	 *            : slider path to be saved
	 * @return added or not
	 * @throws SQLException
	 */
	public int addSliderPath(String path) throws SQLException {
		logger.info("******inside add Slider Path******");
		logger.info("******exiting from add Slider Path******");
		return movieDataInfo.addSliderPath(path);
	}

	/**
	 * 
	 * This method add poster path for a movie
	 *
	 * @param path
	 *            : poster path to be saved
	 * @return added or not
	 * @throws SQLException
	 */
	public int addPosterPath(String path) throws SQLException {
		logger.info("******inside add Poster Path******");
		logger.info("******exiting from add Poster Path******");
		return movieDataInfo.addPosterPath(path);
	}

	/**
	 * 
	 * This method is used to get list of movie
	 *
	 * @return list of movies
	 * @throws SQLException
	 */

	public List<Movie> getMovie() throws SQLException {
		logger.info("******inside get Movie******");
		// ResultSet to store movie list
		ResultSet rs = movieDataInfo.getMovie();
		// list to store movies
		List<Movie> movies = new ArrayList<>();
		while (rs.next()) {
			// Movie object reference
			Movie movie = new Movie();
			movie.setMovieId(rs.getInt(1));
			movie.setMovieName(rs.getString(2));
			movie.setMovieSynopsis(rs.getString(3));
			movie.setMovieReleaseDate(rs.getDate(4));
			movie.setMovieDuration(String.valueOf(rs.getFloat(5)));
			movie.setSliderImagePath(rs.getString(6));
			movie.setPosterImagePath(rs.getString(7));
			movies.add(movie);

		}
		logger.info("*****exiting from get Movie******");
		return movies;
	}

	/**
	 * 
	 * This method is used to get a particular movie based on the movie id
	 *
	 * @param movieId
	 *            : movie to be returned
	 * @return Movie object reference
	 * @throws SQLException
	 */
	public Movie getIndividualMovie(String movieId) throws SQLException {
		logger.info("******inside get Individual Movie******");

		// ResultSet to store movie details
		ResultSet rs = movieDataInfo.getIndividualMovie(Integer.parseInt(movieId));
		Movie movie = new Movie();
		// if records are not empty
		if (rs.next()) {
			// Movie object reference
			movie.setMovieId(rs.getInt(1));
			movie.setMovieName(rs.getString(2));
			movie.setMovieSynopsis(rs.getString(3));
			movie.setMovieReleaseDate(rs.getDate(4));
			movie.setMovieDuration(rs.getString(5));
			movie.setPosterImagePath(rs.getString(6));
			movie.setSliderImagePath(rs.getString(7));
		}

		logger.info("******exiting from get Individual Movie******");
		return movie;
	}

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
	public int deleteMovie(String movieId) throws NumberFormatException, SQLException {
		logger.info("******inside delete Movie*****");
		logger.info("******exiting from delete Movie******");
		return movieDataInfo.deleteMovie(Integer.parseInt(movieId));
	}

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
	public int bookTicket(int movieTimeId, int totalTicket) throws SQLException {
		logger.info("******inside book Ticket******");
		logger.info("******exiting from  book Ticket******");
		return movieDataInfo.bookTicket(movieTimeId, totalTicket);
	}

	/**
	 * This method is used to get details of a movie
	 * 
	 * @param movieName
	 *            : details of movie to be fetch
	 * @return movie object reference
	 * @throws SQLException
	 */
	public Movie getMovie(String movieName) throws SQLException {
		logger.info("******inside get Movie******");
		// Result Set to store movie record
		ResultSet rs = null;
		rs = movieDataInfo.getMovie(movieName);
		// if records are not empty
		if (rs.next()) {
			// Movie Object reference
			Movie movie = new Movie();
			movie.setMovieId(rs.getInt(1));
			movie.setMovieName(rs.getString(2));
			movie.setMovieSynopsis(rs.getString(3));
			movie.setMovieReleaseDate(rs.getDate(4));
			movie.setMovieDuration(rs.getString(5));
			movie.setPosterImagePath(rs.getString(6));
			movie.setSliderImagePath(rs.getString(7));
			return movie;
		}
		logger.info("*****exiting from get Movie******");
		return null;
	}

	/**
	 * This method is used to get movies list in a city
	 * 
	 * @param city
	 *            : city to be searched
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Movie> getMovieByCity(String city) throws SQLException {
		logger.info("******inside getMovieByCity*****");
		// ResultSet to store movie record
		ResultSet rs = movieDataInfo.getMovieByCity(city);
		// list to store movies
		List<Movie> movies = new ArrayList<>();
		while (rs.next()) {
			// Movie object reference
			Movie movie = new Movie();
			movie.setMovieId(rs.getInt(1));
			movie.setMovieName(rs.getString(2));
			movie.setMovieSynopsis(rs.getString(3));
			movie.setMovieReleaseDate(rs.getDate(4));
			movie.setMovieDuration(String.valueOf(rs.getFloat(5)));
			movie.setSliderImagePath(rs.getString(6));
			movie.setPosterImagePath(rs.getString(7));
			movies.add(movie);
		}
		logger.info("*****exiting from getMovieByCity*****");
		return movies;
	}

	/**
	 * This method is used to get movies list at a particular time slot
	 * 
	 * @param time
	 *            : time to be searched
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Movie> getMovieByTime(String time) throws SQLException {
		logger.info("*****inside get Movie By Time*****");
		// ResultSet to store movie record
		ResultSet rs = movieDataInfo.getMovieByTime(time);
		// list to store movies
		List<Movie> movies = new ArrayList<>();
		while (rs.next()) {
			// Movie object reference
			Movie movie = new Movie();
			movie.setMovieId(rs.getInt(1));
			movie.setMovieName(rs.getString(2));
			movie.setMovieSynopsis(rs.getString(3));
			movie.setMovieReleaseDate(rs.getDate(4));
			movie.setMovieDuration(String.valueOf(rs.getFloat(5)));
			movie.setSliderImagePath(rs.getString(6));
			movie.setPosterImagePath(rs.getString(7));
			movies.add(movie);
		}
		logger.info("*****exiting from get Movie By*****");
		return movies;
	}
}
