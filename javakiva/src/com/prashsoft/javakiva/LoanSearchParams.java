/*
 * LoanSearchParams.java: The Loan Search Params File
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

public class LoanSearchParams {

    /* Country Code */
    private String countryCode;

    /* Gender */
    private String gender;

    /* Page Num */
    private Integer pageNum;

    /* Partner */
    private String partner;

    /* Q */
    private String q;

    /* Region */
    private String region;

    /* Sector */
    private String sector;

    /* Sort By */
    private String sortBy;

    /* Status */
    private String status;

    /**
     * Default Constructor
     */
    public LoanSearchParams() {

    }

    /**
     * Parameterized Constructor
     */
    public LoanSearchParams(String q, String status, String gender, String sector, String region, String countryCode,
            String partner, String sortBy, Integer pageNum) {
        this.q = q;
        this.status = status;
        this.gender = gender;
        this.sector = sector;
        this.region = region;
        this.countryCode = countryCode;
        this.partner = partner;
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
     * Get Gender
     * 
     * @return gender - Gender - String
     * @see String
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Get Page Num
     * 
     * @return pageNum - Page Num - Integer
     * @see Integer
     */
    public Integer getPageNum() {
        return (this.pageNum == null ? new Integer(0) : this.pageNum);
    }

    public String getParamString() {

        String params = "";

        if (q != null)
            params = "q=" + q;

        if (status != null)
            params += (params.equals("") ? "" : "&") + "status=" + status;

        if (gender != null)
            params += (params.equals("") ? "" : "&") + "gender=" + gender;

        if (sector != null)
            params += (params.equals("") ? "" : "&") + "sector=" + sector;

        if (region != null)
            params += (params.equals("") ? "" : "&") + "region=" + region;

        if (countryCode != null)
            params += (params.equals("") ? "" : "&") + "country_code=" + countryCode;

        if (partner != null)
            params += (params.equals("") ? "" : "&") + "partner=" + partner;

        if (sortBy != null)
            params += (params.equals("") ? "" : "&") + "sort_by=" + sortBy;

        params += (params.equals("") ? "" : "&") + "page=" + pageNum;

        return params;

    }

    /**
     * Get Partner
     * 
     * @return partner - Partner - String
     * @see String
     */
    public String getPartner() {
        return this.partner;
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
     * Get Region
     * 
     * @return region - Region - String
     * @see String
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * Get Sector
     * 
     * @return sector - Sector - String
     * @see String
     */
    public String getSector() {
        return this.sector;
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
     * Get Status
     * 
     * @return status - Status - String
     * @see String
     */
    public String getStatus() {
        return this.status;
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
     * Set Partner
     * 
     * @param partner
     *            - Partner - String
     * @see String
     */
    public void setPartner(String partner) {
        this.partner = partner;
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
     * Set Region
     * 
     * @param region
     *            - Region - String
     * @see String
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Set Sector
     * 
     * @param sector
     *            - Sector - String
     * @see String
     */
    public void setSector(String sector) {
        this.sector = sector;
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
     * Set Status
     * 
     * @param status
     *            - Status - String
     * @see String
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * To String
     * 
     * @return toString Of Attributes
     * @see String
     */
    @Override
    public String toString() {
        return "" + " Q: " + (q == null ? "" : q) + "\n";

    }

}