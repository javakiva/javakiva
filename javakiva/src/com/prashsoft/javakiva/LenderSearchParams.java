/*
 * LenderSearchParams.java: The Lender Search Params Object
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

public class LenderSearchParams {

    /* Country Code */
    private String countryCode;

    /* Occupation */
    private String occupation;

    /* Page Num */
    private Integer pageNum;

    /* Q */
    private String q;

    /* Sort By */
    private String sortBy;

    /**
     * Default Constructor
     */
    public LenderSearchParams() {

    }

    /**
     * Parameterized Constructor
     */
    public LenderSearchParams(String q, String occupation, String countryCode, String sortBy, Integer pageNum) {
        this.q = q;
        this.occupation = occupation;
        this.countryCode = countryCode;
        this.sortBy = sortBy;
        this.pageNum = pageNum;
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
     * Get Occupation
     * 
     * @return occupation - Occupation - String
     * @see String
     */
    public String getOccupation() {
        return this.occupation;
    }

    /**
     * Get Page Num
     * 
     * @return pageNum - Page Num - Integer
     */
    public Integer getPageNum() {
        return this.pageNum;
    }

    public String getParamString() {

        String params = "";

        if (q != null)
            params = "q=" + q;
        else if (occupation != null)
            params = "occupation=" + occupation;

        if (countryCode != null)
            params += (params.equals("") ? "" : "&") + "country_code=" + countryCode;

        if (sortBy != null)
            params += (params.equals("") ? "" : "&") + "sort_by=" + sortBy;

        params += (params.equals("") ? "" : "&") + "page=" + pageNum;

        return params;

    }

    /**
     * Get Q
     * 
     * @return q - Q - String
     * @see String
     */
    public String getQ() {
        return this.q;
    }

    /**
     * Get Sort By
     * 
     * @return sortBy - Sort By - String
     * @see String
     */
    public String getSortBy() {
        return this.sortBy;
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
     * Set Occupation
     * 
     * @param occupation
     *            - Occupation - String
     * @see String
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * Set Page Num
     * 
     * @param pageNum
     *            - Page Num - Integer
     * @see Integer
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * Set Q
     * 
     * @param q
     *            - Q - String
     * @see String
     */
    public void setQ(String q) {
        this.q = q;
    }

    /**
     * Set Sort By
     * 
     * @param sortBy
     *            - Sort By - String
     * @see String
     */
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * To String
     * 
     * @return toString Of Attributes
     * @see String
     */
    @Override
    public String toString() {
        return "" + " Country Code: " + countryCode + " Occupation: " + occupation + " Page: " + pageNum + " Q: " + q
                + " Sort By: " + sortBy;

    }

}