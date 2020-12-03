package com.altran.exception;

/**
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :DuplicateUserException.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 3:04:20 PM
Author                        :GR_Ritchie_Java_02
Description                   :Handles exception when duplicate user found

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class handles exception when duplicate user found
 * 
 * @see DuplicateUserException
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class DuplicateUserException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructor for DuplicateUserException
	 *
	 * @param message
	 */
	public DuplicateUserException(String message) {
		super(message);
	}
}
