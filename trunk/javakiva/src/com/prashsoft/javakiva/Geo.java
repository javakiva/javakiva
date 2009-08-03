/*
 * Geo.java: The Geo Object
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

public class Geo {

    /* Level */
    private String level;

    /* Pairs */
    private String pairs;

    /* Type */
    private String type;

    /**
     * Default Constructor
     */
    public Geo() {

    }

    /**
     * Get Level
     * 
     * @return level - Level - String
     * @see String
     */
    public String getLevel() {
        return this.level;
    }

    /**
     * Get Pairs
     * 
     * @return pairs - Pairs - String
     * @see String
     */
    public String getPairs() {
        return this.pairs;
    }

    /**
     * Get Type
     * 
     * @return type - Type - String
     * @see String
     */
    public String getType() {
        return this.type;
    }

    /**
     * Set Level
     * 
     * @param level
     *            - Level - String
     * @see String
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Set Pairs
     * 
     * @param pairs
     *            - Pairs - String
     * @see String
     */
    public void setPairs(String pairs) {
        this.pairs = pairs;
    }

    /**
     * Set Type
     * 
     * @param type
     *            - Type - String
     * @see String
     */
    public void setType(String type) {
        this.type = type;
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
