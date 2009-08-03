/*
 * Borrower.java: The Borrower Object
 * 
 * Copyright (C) 2009 prashsoft.com
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation:
 * http://www.gnu.org/licenses/gpl-2.0.html
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License version 2 for more details:
 * http://www.gnu.org/licenses/gpl-2.0.html
 * 
 * You should have received a copy of the GNU General Public License
 * version 2 along with this program; if not, write to the
 * Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301, USA. 
 */

package com.prashsoft.javakiva;

/**
 * The Borrower Data Object
 * 
 * @author
 */
public class Borrower {

    /* First Name */
    private String firstName;

    /* Gender */
    private String gender;

    /* Id */
    private String id;

    /* Last Name */
    private String lastName;

    /* Pictured */
    private boolean pictured;

    /**
     * Default Constructor
     */
    public Borrower() {

    }

    /**
     * Get First Name
     * 
     * @return firstName - First Name - String
     * @see String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get Gender
     * 
     * @return gender - Gender - String
     * @see String
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Get Id
     * 
     * @return id - Id - String
     * @see String
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get Last Name
     * 
     * @return lastName - Last Name - String
     * @see String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Get Pictured
     * 
     * @return pictured - Pictured - boolean
     */
    public boolean getPictured() {
        return this.pictured;
    }

    /**
     * Set First Name
     * 
     * @param firstName
     *            - First Name - String
     * @see String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set Gender
     * 
     * @param gender
     *            - Gender - String
     * @see String
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Set Id
     * 
     * @param id
     *            - Id - String
     * @see String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set Last Name
     * 
     * @param lastName
     *            - Last Name - String
     * @see String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set Pictured
     * 
     * @param pictured
     *            - Pictured - boolean
     */
    public void setPictured(boolean pictured) {
        this.pictured = pictured;
    }

    /**
     * To String
     * 
     * @return toString Of Attributes
     * @see String
     */
    @Override
    public String toString() {
        return "";

    }

}