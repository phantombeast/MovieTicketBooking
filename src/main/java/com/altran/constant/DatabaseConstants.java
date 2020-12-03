package com.altran.constant;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :DatabaseConstants.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 2:29:22 PM
Author                        :GR_Ritchie_Java_02
Description                   :Constant to store database url, username and password

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This interface defines Constants to store database url, username and password
 * 
 * @see DatabaseConstants
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */

public interface DatabaseConstants {
	// Constant to store driver
	String DRIVER = "com.mysql.jdbc.Driver";
	// Constant to store url of mysql database
	String URL = "jdbc:mysql://localhost:3306/test";
	// Constant to store user name
	String USERNAME = "root";
	// Constant to store password
	String PASSWORD = "root";
}
