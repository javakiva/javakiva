/*
 * Payment.java: The Payment Object
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

import java.util.Date;

public class Payment {

    /* Amount */
    private Double amount;

    /* Comment */
    private String comment;

    /* Local Amount */
    private Double localAmount;

    /* Payment Id */
    private Integer paymentId;

    /* Processed Date */
    private Date processedDate;

    /* Rounded Local Amount */
    private Double roundedLocalAmount;

    /* Settlement Date */
    private Date settlementDate;

    /**
     * Default Constructor
     */
    public Payment() {

    }

    /**
     * Get Amount
     * 
     * @return amount - Amount - Double
     * @see Double
     */
    public Double getAmount() {
        return this.amount;
    }

    /**
     * Get Comment
     * 
     * @return comment - Comment - String
     * @see String
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Get Local Amount
     * 
     * @return localAmount - Local Amount - Double
     * @see Double
     */
    public Double getLocalAmount() {
        return this.localAmount;
    }

    /**
     * Get Payment Id
     * 
     * @return paymentId - Payment Id - Integer
     * @see Integer
     */
    public Integer getPaymentId() {
        return this.paymentId;
    }

    /**
     * Get Processed Date
     * 
     * @return processedDate - Processed Date - Date
     * @see Date
     */
    public Date getProcessedDate() {
        return this.processedDate;
    }

    /**
     * Get Rounded Local Amount
     * 
     * @return roundedLocalAmount - Rounded Local Amount - Double
     * @see Double
     */
    public Double getRoundedLocalAmount() {
        return this.roundedLocalAmount;
    }

    /**
     * Get Settlement Date
     * 
     * @return settlementDate - Settlement Date - Date
     * @see Date
     */
    public Date getSettlementDate() {
        return this.settlementDate;
    }

    /**
     * Set Amount
     * 
     * @param amount
     *            - Amount - Double
     * @see Double
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Set Comment
     * 
     * @param comment
     *            - Comment - String
     * @see String
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Set Local Amount
     * 
     * @param localAmount
     *            - Local Amount - Double
     * @see Double
     */
    public void setLocalAmount(Double localAmount) {
        this.localAmount = localAmount;
    }

    /**
     * Set Payment Id
     * 
     * @param paymentId
     *            - Payment Id - Integer
     * @see Integer
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Set Processed Date
     * 
     * @param processedDate
     *            - Processed Date - Date
     * @see Date
     */
    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }

    /**
     * Set Rounded Local Amount
     * 
     * @param roundedLocalAmount
     *            - Rounded Local Amount - Double
     * @see Double
     */
    public void setRoundedLocalAmount(Double roundedLocalAmount) {
        this.roundedLocalAmount = roundedLocalAmount;
    }

    /**
     * Set Settlement Date
     * 
     * @param settlementDate
     *            - Settlement Date - Date
     * @see Date
     */
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * To String
     * 
     * @return toString Of Attributes
     * @see String
     */
    @Override
    public String toString() {
        return "" + " Payment Amount: " + (amount == null ? "" : amount) + "\n" + " Payment Comment: "
                + (comment == null ? "" : comment) + "\n" + " Payment Local Amount: "
                + (localAmount == null ? "" : localAmount) + "\n" + " Payment Id: "
                + (paymentId == null ? "" : paymentId) + "\n" + " Payment Processed Date: "
                + (processedDate == null ? "" : processedDate) + "\n" + " Payment Rounded Local Amount: "
                + (roundedLocalAmount == null ? "" : roundedLocalAmount) + "\n" + " Payment Settlement Date: "
                + (settlementDate == null ? "" : settlementDate) + "\n";

    }

}