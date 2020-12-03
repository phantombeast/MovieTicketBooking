package com.altran.model;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :User.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 2:56:50 PM
Author                        :GR_Ritchie_Java_02
Description                   :Store details about user

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class store details about user such as first name,last name, user name,
 * email,contact number,password and provide getter and setter methods
 * 
 * @see User
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class User {
	// instance variable to store first name
	private String firstName;
	// instance variable to store last name
	private String lastName;
	// instance variable to store user name
	private String username;
	// instance variable to store email
	private String email;
	// instance variable to store contact number
	private Long contactNumber;
	// instance variable to store password
	private String password;

	/**
	 * This method is used to get the firstName
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method is used to set the firstName
	 *
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method is used to get the lastName
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method is used to set the lastName
	 *
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method is used to get the username
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method is used to set the username
	 *
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method is used to get the email
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method is used to set the email
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method is used to get the contactNumber
	 *
	 * @return the contactNumber
	 */
	public Long getContactNumber() {
		return contactNumber;
	}

	/**
	 * This method is used to set the contactNumber
	 *
	 * @param contactNumber
	 *            the contactNumber to set
	 */
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * This method is used to get the password
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method is used to set the password
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
