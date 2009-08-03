/*
 * LoanUpdate: The Loan Update Object
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

public class LoanUpdate {

    /* Journal Entry */
    JournalEntry journalEntry;

    /* Payment */
    Payment payment;

    /* Update Type */
    String updateType;

    /**
     * Get journalEntry
     * 
     * @return journalEntry - journalEntry - JournalEntry
     * @see JournalEntry
     */
    public JournalEntry getJournalEntry() {
        return journalEntry;
    }

    /**
     * Get payment
     * 
     * @return payment - payment - Payment
     * @see Payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Get updateType
     * 
     * @return updateType - updateType - String
     * @see String
     */
    public String getUpdateType() {
        return updateType;
    }

    /**
     * Set journalEntry
     * 
     * @param journalEntry
     *            - journalEntry - JournalEntry
     * @see JournalEntry
     */
    public void setJournalEntry(JournalEntry journalEntry) {
        this.journalEntry = journalEntry;
    }

    /**
     * Set payment
     * 
     * @param payment
     *            - payment - Payment
     * @see Payment
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Set updateType
     * 
     * @param updateType
     *            - updateType - String
     * @see String
     */
    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    /**
     * To String
     * 
     * @return toString Of Attributes
     * @see String
     */
    @Override
    public String toString() {
        return (journalEntry == null ? "" : journalEntry.toString()) + "\n" + "Update Type: "
                + (updateType == null ? "" : updateType) + "\n" + (payment == null ? "" : payment.toString());

    }

}