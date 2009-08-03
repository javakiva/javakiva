/*
 * Loan.java: The Loan Object
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
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.util.DateUtil;

public class Loan {

    class Description {

        List<String> languages;
        Map<String, String> texts;

        /**
         * Get languages
         * 
         * @return languages - Languages - List
         * @see List
         */
        public List<String> getLanguages() {
            return languages;
        }

        /**
         * Get texts
         * 
         * @return texts - Texts - Map
         * @see Map
         */
        public Map<String, String> getTexts() {
            return texts;
        }

        /**
         * Set languages
         * 
         * @param languages
         *            - Languages - List
         * @see List
         */
        public void setLanguages(List<String> languages) {
            this.languages = languages;
        }

        /**
         * Set texts
         * 
         * @param texts
         *            - Texts - Map
         * @see Map
         */
        public void setTexts(Map<String, String> texts) {
            this.texts = texts;
        }

    }

    public class JournalTotals {

        /* Bulk Entries */
        private Integer bulkEntries;

        /* Entries */
        private Integer entries;

        /**
         * Default Constructor
         */
        public JournalTotals() {

        }

        /**
         * Get Bulk Entries
         * 
         * @return bulkEntries - Bulk Entries - Integer
         * @see Integer
         */
        public Integer getBulkEntries() {
            return this.bulkEntries;
        }

        /**
         * Get Entries
         * 
         * @return entries - Entries - Integer
         * @see Integer
         */
        public Integer getEntries() {
            return this.entries;
        }

        /**
         * Set Bulk Entries
         * 
         * @param bulkEntries
         *            - Bulk Entries - Integer
         * @see Integer
         */
        public void setBulkEntries(Integer bulkEntries) {
            this.bulkEntries = bulkEntries;
        }

        /**
         * Set Entries
         * 
         * @param entries
         *            - Entries - Integer
         * @see Integer
         */
        public void setEntries(Integer entries) {
            this.entries = entries;
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

    class Terms {

        class LossLiability {

            /* Currency Exchange */
            private String currencyExchange;

            /* Nonpayment */
            private String nonpayment;

            /**
             * Default Constructor
             */
            public LossLiability() {

            }

            /**
             * Get Currency Exchange
             * 
             * @return currencyExchange - Currency Exchange - String
             * @see String
             */
            public String getCurrencyExchange() {
                return this.currencyExchange;
            }

            /**
             * Get Nonpayment
             * 
             * @return nonpayment - Nonpayment - String
             * @see String
             */
            public String getNonpayment() {
                return this.nonpayment;
            }

            /**
             * Set Currency Exchange
             * 
             * @param currencyExchange
             *            - Currency Exchange - String
             * @see String
             */
            public void setCurrencyExchange(String currencyExchange) {
                this.currencyExchange = currencyExchange;
            }

            /**
             * Set Nonpayment
             * 
             * @param nonpayment
             *            - Nonpayment - String
             * @see String
             */
            public void setNonpayment(String nonpayment) {
                this.nonpayment = nonpayment;
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

        class TermsPayment {

            /* Amount */
            private Double amount;

            /* Due Date */
            private Date dueDate;

            /**
             * Default Constructor
             */
            public TermsPayment() {

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
             * Get Due Date
             * 
             * @return dueDate - Due Date - Date
             * @see Date
             */
            public Date getDueDate() {
                return this.dueDate;
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
             * Set Due Date
             * 
             * @param dueDate
             *            - Due Date - Date
             * @see Date
             */
            public void setDueDate(Date dueDate) {
                this.dueDate = dueDate;
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

        /* Disbursal Amount */
        private Double disbursalAmount;

        /* Disbursal Currency */
        private String disbursalCurrency;

        /* Disbursal Date */
        private Date disbursalDate;

        /* Loan Amount */
        private Double loanAmount;

        /* Local Payments */
        private List<TermsPayment> localPayments; // List of Payment objects

        /* Loss Liability */
        private LossLiability lossLiability;

        /* Scheduled Payments */
        private List<TermsPayment> scheduledPayments; // List of Payment objects

        /**
         * Default Constructor
         */
        public Terms() {

        }

        /**
         * Get Disbursal Amount
         * 
         * @return disbursalAmount - Disbursal Amount - Double
         * @see Double
         */
        public Double getDisbursalAmount() {
            return this.disbursalAmount;
        }

        /**
         * Get Disbursal Currency
         * 
         * @return disbursalCurrency - Disbursal Currency - String
         * @see String
         */
        public String getDisbursalCurrency() {
            return this.disbursalCurrency;
        }

        /**
         * Get Disbursal Date
         * 
         * @return disbursalDate - Disbursal Date - Date
         * @see Date
         */
        public Date getDisbursalDate() {
            return this.disbursalDate;
        }

        /**
         * Get Loan Amount
         * 
         * @return loanAmount - Loan Amount - Double
         * @see Double
         */
        public Double getLoanAmount() {
            return this.loanAmount;
        }

        /**
         * Get Local Payments
         * 
         * @return localPayments - Local Payments - List
         * @see List
         */
        public List<TermsPayment> getLocalPayments() {
            return this.localPayments;
        }

        /**
         * Get Loss Liability
         * 
         * @return lossLiability - Loss Liability - LossLiability
         * @see LossLiability
         */
        public LossLiability getLossLiability() {
            return this.lossLiability;
        }

        /**
         * Get Scheduled Payments
         * 
         * @return scheduledPayments - Scheduled Payments - List
         * @see List
         */
        public List<TermsPayment> getScheduledPayments() {
            return this.scheduledPayments;
        }

        /**
         * Set Disbursal Amount
         * 
         * @param disbursalAmount
         *            - Disbursal Amount - Double
         * @see Double
         */
        public void setDisbursalAmount(Double disbursalAmount) {
            this.disbursalAmount = disbursalAmount;
        }

        /**
         * Set Disbursal Currency
         * 
         * @param disbursalCurrency
         *            - Disbursal Currency - String
         * @see String
         */
        public void setDisbursalCurrency(String disbursalCurrency) {
            this.disbursalCurrency = disbursalCurrency;
        }

        /**
         * Set Disbursal Date
         * 
         * @param disbursalDate
         *            - Disbursal Date - Date
         * @see Date
         */
        public void setDisbursalDate(Date disbursalDate) {
            this.disbursalDate = disbursalDate;
        }

        /**
         * Set Loan Amount
         * 
         * @param loanAmount
         *            - Loan Amount - Double
         * @see Double
         */
        public void setLoanAmount(Double loanAmount) {
            this.loanAmount = loanAmount;
        }

        /**
         * Set Local Payments
         * 
         * @param localPayments
         *            - Local Payments - List
         * @see List
         */
        public void setLocalPayments(List<TermsPayment> localPayments) {
            this.localPayments = localPayments;
        }

        /**
         * Set Loss Liability
         * 
         * @param lossLiability
         *            - Loss Liability - LossLiability
         * @see LossLiability
         */
        public void setLossLiability(LossLiability lossLiability) {
            this.lossLiability = lossLiability;
        }

        /**
         * Set Scheduled Payments
         * 
         * @param scheduledPayments
         *            - Scheduled Payments - List
         * @see List
         */
        public void setScheduledPayments(List<TermsPayment> scheduledPayments) {
            this.scheduledPayments = scheduledPayments;
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

    /* Activity */
    private String activity;

    /* Basket Amount */
    private Double basketAmount;

    /* Borrowers */
    private List borrowers;

    /* Description */
    private Description description;

    /* Funded Amount */
    private Double fundedAmount;

    /* Funded Date */
    private Date fundedDate;

    /* Id */
    private int id;

    /* Image */
    private Image image;

    /* Journal Totals */
    private JournalTotals journalTotals;

    /* Loan Amount */
    private Double loanAmount;

    /* Location */
    private Location location;

    /* Name */
    private String name;

    /* Paid Amount */
    private Double paidAmount;

    /* Partner Id */
    private int partnerId;

    /* Payments */
    private List payments;

    /* Posted Date */
    private Date postedDate;

    /* Raised Amount */
    private Double raisedAmount;

    /* Sector */
    private String sector;

    /* Status */
    private String status;

    /* Terms */
    private Terms terms;

    /* Use */
    private String use;

    /**
     * Default Constructor
     */
    public Loan() {

    }

    /**
     * Get Activity
     * 
     * @return activity - Activity - String
     * @see String
     */
    public String getActivity() {
        return this.activity;
    }

    /**
     * Get Basket Amount
     * 
     * @return basketAmount - Basket Amount - Double
     * @see Double
     */
    public Double getBasketAmount() {
        return this.basketAmount;
    }

    /**
     * Get Borrowers
     * 
     * @return borrowers - Borrowers - List
     * @see List
     */
    public List getBorrowers() {
        return this.borrowers;
    }

    /**
     * Get Description
     * 
     * @return description - Description - Description
     * @see Description
     */
    public Description getDescription() {
        return this.description;
    }

    /**
     * Get Funded Amount
     * 
     * @return fundedAmount - Funded Amount - Double
     * @see Double
     */
    public Double getFundedAmount() {
        return this.fundedAmount;
    }

    /**
     * Get Funded Date
     * 
     * @return fundedDate - Funded Date - Date
     * @see Date
     */
    public Date getFundedDate() {
        return this.fundedDate;
    }

    /**
     * Get Id
     * 
     * @return id - Id - int
     * @see int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get Image
     * 
     * @return image - Image - Image
     * @see Image
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Get Journal Totals
     * 
     * @return journalTotals - Journal Totals - JournalTotals
     * @see JournalTotals
     */
    public JournalTotals getJournalTotals() {
        return this.journalTotals;
    }

    /**
     * Get Loan Amount
     * 
     * @return loanAmount - Loan Amount - Double
     * @see Double
     */
    public Double getLoanAmount() {
        return this.loanAmount;
    }

    /**
     * Get Location
     * 
     * @return location - Location - Location
     * @see Location
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Get Name
     * 
     * @return name - Name - String
     * @see String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get Paid Amount
     * 
     * @return paidAmount - Paid Amount - Double
     * @see Double
     */
    public Double getPaidAmount() {
        return this.paidAmount;
    }

    /**
     * Get Partner Id
     * 
     * @return partnerId - Partner Id - int
     * @see int
     */
    public int getPartnerId() {
        return this.partnerId;
    }

    /**
     * Get Payments
     * 
     * @return payments - Payments - List
     * @see List
     */
    public List getPayments() {
        return this.payments;
    }

    /**
     * Get Posted Date
     * 
     * @return postedDate - Posted Date - Date
     * @see Date
     */
    public Date getPostedDate() {
        return this.postedDate;
    }

    /**
     * Get Raised Amount
     * 
     * @return raisedAmount - Raised Amount - Double
     * @see Double
     */
    public Double getRaisedAmount() {
        return this.raisedAmount;
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
     * Get Status
     * 
     * @return status - Status - String
     * @see String
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Get Terms
     * 
     * @return terms - Terms - Terms
     * @see Terms
     */
    public Terms getTerms() {
        return this.terms;
    }

    /**
     * Get Use
     * 
     * @return use - Use - String
     * @see String
     */
    public String getUse() {
        return this.use;
    }

    /**
     * Set Activity
     * 
     * @param activity
     *            - Activity - String
     * @see String
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * Set Basket Amount
     * 
     * @param basketAmount
     *            - Basket Amount - Double
     * @see Double
     */
    public void setBasketAmount(Double basketAmount) {
        this.basketAmount = basketAmount;
    }

    /**
     * Set Borrowers
     * 
     * @param borrowers
     *            - Borrowers - List
     * @see List
     */
    public void setBorrowers(List borrowers) {
        this.borrowers = borrowers;
    }

    /**
     * Set Description
     * 
     * @param description
     *            - Description - Description
     * @see Description
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * Set Funded Amount
     * 
     * @param integer
     *            - Funded Amount - Double
     * @see Double
     */
    public void setFundedAmount(Double fundedAmount) {
        this.fundedAmount = fundedAmount;
    }

    /**
     * Set Funded Date
     * 
     * @param fundedDate
     *            - Funded Date - Date
     * @see Date
     */
    public void setFundedDate(Date fundedDate) {
        this.fundedDate = fundedDate;
    }

    /**
     * Set Id
     * 
     * @param id
     *            - Id - int
     * @see int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set Image
     * 
     * @param image
     *            - Image - Image
     * @see Image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Set Journal Totals
     * 
     * @param journalTotals
     *            - Journal Totals - JournalTotals
     * @see JournalTotals
     */
    public void setJournalTotals(JournalTotals journalTotals) {
        this.journalTotals = journalTotals;
    }

    /**
     * Set Loan Amount
     * 
     * @param loanAmount
     *            - Loan Amount - Double
     * @see Double
     */
    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Set Location
     * 
     * @param location
     *            - Location - Location
     * @see Location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Set Name
     * 
     * @param name
     *            - Name - String
     * @see String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set Paid Amount
     * 
     * @param paidAmount
     *            - Paid Amount - Double
     * @see Double
     */
    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * Set Partner Id
     * 
     * @param partnerId
     *            - Partner Id - int
     * @see int
     */
    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * Set Payments
     * 
     * @param payments
     *            - Payments - List
     * @see List
     */
    public void setPayments(List payments) {
        this.payments = payments;
    }

    /**
     * Set Posted Date
     * 
     * @param postedDate
     *            - Posted Date - Date
     * @see Date
     */
    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    /**
     * Set Raised Amount
     * 
     * @param raisedAmount
     *            - Raised Amount - Double
     * @see Double
     */
    public void setRaisedAmount(Double raisedAmount) {
        this.raisedAmount = raisedAmount;
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
     * Set Terms
     * 
     * @param terms
     *            - Terms - Terms
     * @see Terms
     */
    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    /**
     * Set Use
     * 
     * @param use
     *            - Use - String
     * @see String
     */
    public void setUse(String use) {
        this.use = use;
    }

    /**
     * To String
     * 
     * @return toString Of Attributes
     * @see String
     */
    @Override
    public String toString() {
        return "" + " Activity: "
                + (activity == null ? "" : activity)
                + "\n"
                + " Basket Amount: "
                + (basketAmount == null ? "" : basketAmount)
                + "\n"
                + " Funded Amount: "
                + (fundedAmount == null ? "" : fundedAmount)
                + "\n"
                + " Id: "
                + id
                + "\n"
                + " Image: "
                + (image == null ? "" : image.getImageUrl())
                + "\n"
                + " Loan Amount: "
                + (loanAmount == null ? "" : loanAmount)
                + "\n"
                + " Loan Description: "
                + (description == null ? "" : description.getTexts().get("en"))
                + "\n"
                + "Location: "
                + "\n"
                + (location == null ? ""
                        : ("Country Code: " + location.getCountryCode() + "\n" + "Country: " + location.getCountry()
                                + "\n" + "Town: " + location.getTown() + "\n" + (location.getGeo() == null ? ""
                                : ("Geo Level: " + location.getGeo().getLevel() + "\n" + "Geo Pairs: "
                                        + location.getGeo().getPairs() + "\n" + "Geo Type: "
                                        + location.getGeo().getType() + "\n"))))
                + "\n"
                + " Name: "
                + (name == null ? "" : name)
                + "\n"
                + " Paid Amount: "
                + (paidAmount == null ? "" : paidAmount)
                + "\n"
                + " Posted Date: "
                + (postedDate == null ? "" : DateUtil.formatDate(postedDate))
                + "\n"
                + " Funded Date: "
                + (fundedDate == null ? "" : DateUtil.formatDate(fundedDate))
                + "\n"
                + " Raised Amount: "
                + (raisedAmount == null ? "" : raisedAmount)
                + "\n"
                + " Sector: "
                + (sector == null ? "" : sector)
                + "\n"
                + " Status: "
                + (status == null ? "" : status)
                + "\n"
                + " Partner Id: "
                + partnerId
                + "\n"
                + " Use: "
                + (use == null ? "" : use)
                + "\n"
                + " Borrowers: "
                + "\n"
                + (borrowers == null ? "" : ("Borrower Id: " + ((Borrower) borrowers.get(0)).getId() + "\n"
                        + "Borrower First Name: " + ((Borrower) borrowers.get(0)).getFirstName() + "\n"
                        + "Borrower Last Name: " + ((Borrower) borrowers.get(0)).getLastName() + "\n"
                        + "Borrower Gender: " + ((Borrower) borrowers.get(0)).getGender() + "\n"
                        + "Borrower Pictured: " + ((Borrower) borrowers.get(0)).getPictured()))
                + "\n"
                + "Terms: "
                + "\n"
                + (terms == null ? "" : "Disbursal Amount: " + terms.getDisbursalAmount() + "\n"
                        + "Disbursal Currency: " + terms.getDisbursalCurrency() + "\n" + " Local Payments: Due Date: "
                        + (terms.getLocalPayments().get(0)).getDueDate() + "\n" + " Local Payments: Amount: "
                        + (terms.getLocalPayments().get(0)).getAmount() + "\n" + " Scheduled Payments: Due Date: "
                        + (terms.getScheduledPayments().get(0)).getDueDate() + "\n" + " Scheduled Payments: Amount: "
                        + (terms.getScheduledPayments().get(0)).getAmount() + "\n" + "Disbursal Date: "
                        + terms.getDisbursalDate() + "\n" + "Loan Amount: " + terms.getLoanAmount() + "\n"
                        + "Loss Liability: Non Payment: " + terms.getLossLiability().getNonpayment() + "\n"
                        + "Loss Liability: Currency Exchange: " + terms.getLossLiability().getCurrencyExchange())

                + "\n"
                + " Payments: "
                + "\n"
                + (payments == null ? "" : ("Payment Id: " + ((Payment) payments.get(0)).getPaymentId() + "\n"
                        + "Payment Amount: " + ((Payment) payments.get(0)).getAmount() + "\n"
                        + "Payment Local Amount: " + ((Payment) payments.get(0)).getLocalAmount() + "\n"
                        + "Payment Processed Date: " + ((Payment) payments.get(0)).getProcessedDate() + "\n"
                        + "Payment Settlement Date: " + ((Payment) payments.get(0)).getSettlementDate() + "\n"
                        + "Payment Comment: " + ((Payment) payments.get(0)).getComment() + "\n"
                        + "Payment Rounded Local Amount: " + ((Payment) payments.get(0)).getRoundedLocalAmount()))
                + "\n"
                + "Posted Date: "
                + postedDate
                + "\n"
                + "Funded Date: "
                + fundedDate
                + "\n"
                + ((journalTotals == null) ? "" : ("Journal Totals: Entries: " + journalTotals.getEntries() + "\n"
                        + "Journal Totals: Bulk Entries: " + journalTotals.getBulkEntries()));
    }
}
