package com.altran.exception;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :PasswordMisMatchException.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 19, 2020
Author                     :GR_Ritchie_Java_02
Description                :Test Class to test all methods of Company class.
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 19, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/
/**
 * Test Class to test all getters and setters of Company class.
 * 
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class InvalidPasswordException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String message) {
		super(message);
	}
}
