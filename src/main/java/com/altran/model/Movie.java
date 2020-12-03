package com.altran.model;

import java.sql.Date;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :Movie.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 2:45:41 PM
Author                        :GR_Ritchie_Java_02
Description                   :Store details about movie

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class store details of movie such as movie id, movie name, movie
 * synopsis, movie release date, movie duration, slider image path,poster image
 * path and provide getter and setter methods
 * 
 * @see Movie
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class Movie {
	// instance variable to store movie id
	private int movieId;
	// instance variable to store movie movie name
	private String movieName;
	// instance variable to store movie synopsis
	private String movieSynopsis;
	// instance variable to store movie release date
	private Date movieReleaseDate;
	// instance variable to store movie duration
	private String movieDuration;
	// instance variable to store slider image path
	private String sliderImagePath;
	// instance variable to store poster image path
	private String posterImagePath;

	/**
	 * This method is used to get the movieId
	 *
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * This method is used to set the movieId
	 *
	 * @param movieId
	 *            the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * This method is used to get the movieName
	 *
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * This method is used to set the movieName
	 *
	 * @param movieName
	 *            the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * This method is used to get the movieSynopsis
	 *
	 * @return the movieSynopsis
	 */
	public String getMovieSynopsis() {
		return movieSynopsis;
	}

	/**
	 * This method is used to set the movieSynopsis
	 *
	 * @param movieSynopsis
	 *            the movieSynopsis to set
	 */
	public void setMovieSynopsis(String movieSynopsis) {
		this.movieSynopsis = movieSynopsis;
	}

	/**
	 * This method is used to get the movieReleaseDate
	 *
	 * @return the movieReleaseDate
	 */
	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	/**
	 * This method is used to set the movieReleaseDate
	 *
	 * @param movieReleaseDate
	 *            the movieReleaseDate to set
	 */
	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	/**
	 * This method is used to get the movieDuration
	 *
	 * @return the movieDuration
	 */
	public String getMovieDuration() {
		return movieDuration;
	}

	/**
	 * This method is used to set the movieDuration
	 *
	 * @param movieDuration
	 *            the movieDuration to set
	 */
	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	/**
	 * This method is used to get the sliderImagePath
	 *
	 * @return the sliderImagePath
	 */
	public String getSliderImagePath() {
		return sliderImagePath;
	}

	/**
	 * This method is used to set the sliderImagePath
	 *
	 * @param sliderImagePath
	 *            the sliderImagePath to set
	 */
	public void setSliderImagePath(String sliderImagePath) {
		this.sliderImagePath = sliderImagePath;
	}

	/**
	 * This method is used to get the posterImagePath
	 *
	 * @return the posterImagePath
	 */
	public String getPosterImagePath() {
		return posterImagePath;
	}

	/**
	 * This method is used to set the posterImagePath
	 *
	 * @param posterImagePath
	 *            the posterImagePath to set
	 */
	public void setPosterImagePath(String posterImagePath) {
		this.posterImagePath = posterImagePath;
	}
}
