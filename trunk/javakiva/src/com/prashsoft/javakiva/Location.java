/*
 * Location.java: The Location Object
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

public class Location {

    /* Country */
    private String country;

    /* Country Code */
    private String countryCode;

    /* Geo */
    private Geo geo;

    /* Town */
    private String town;

    /**
     * Default Constructor
     */
    public Location() {

    }

    /**
     * Get Country
     * 
     * @return country - Country - String
     * @see String
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Get Country Code
     * 
     * @return countryCode - Country Code - String
     * @see String
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Get Geo
     * 
     * @return geo - Geo - Geo
     * @see Geo
     */
    public Geo getGeo() {
        return this.geo;
    }

    /**
     * Get Town
     * 
     * @return town - Town - String
     * @see String
     */
    public String getTown() {
        return this.town;
    }

    /**
     * Set Country
     * 
     * @param country
     *            - Country - String
     * @see String
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Set Country Code
     * 
     * @param countryCode
     *            - Country Code - String
     * @see String
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Set Geo
     * 
     * @param geo
     *            - Geo - Geo
     * @see Geo
     */
    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    /**
     * Set Town
     * 
     * @param town
     *            - Town - String
     * @see String
     */
    public void setTown(String town) {
        this.town = town;
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