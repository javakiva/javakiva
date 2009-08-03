/*
 * KivaTest.java: The Kiva Test File
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

import java.util.List;

public class KivaTest {

    public static void main(String[] args) {

        LoanUtil loanUtil = new LoanUtil();
        /*
         * // Test Loan.getLoanDetails() List loansList = loanUtil.getLoansDetails("55781"); Loan loan = (Loan)
         * loansList.get(0); System.out.println(loan.toString());
         * System.out.println("-------------------------------------------------");
         * 
         * List loanLendersList = loanUtil.getLoanLenders(new Integer(123526)); Lender lender = (Lender)
         * loanLendersList.get(0); System.out.println(lender.toString());
         * System.out.println("-------------------------------------------------");
         * 
         * List loanJournalEntriesList = loanUtil.getLoanJournalEntries(new Integer(123526)); JournalEntry journalEntry
         * = (JournalEntry) loanJournalEntriesList.get(0); System.out.println(journalEntry.toString());
         * System.out.println("-------------------------------------------------");
         * 
         * loansList = loanUtil.getLoansByParams(new LoanSearchParams("fishing", "in_repayment", "female", "food", "af",
         * "mz", "23", "newest", 1)); loan = (Loan) loansList.get(0); System.out.println(loan.toString());
         * System.out.println("-------------------------------------------------");
         */
        List loanUpdatesList = loanUtil.getLoanUpdates(51107);
        LoanUpdate loanUpdate = (LoanUpdate) loanUpdatesList.get(1);
        System.out.println(loanUpdate.toString());
        System.out.println("-------------------------------------------------");

        // LenderUtil lenderUtil = new LenderUtil();

        // List lendersList = lenderUtil.getLendersDetails(new String[] { "alainh", "pamela1889" });
        // lender = (Lender) lendersList.get(0);
        // System.out.println(lender.toString());
        // System.out.println("-------------------------------------------------");

        // lender = (Lender) lendersList.get(1);
        // System.out.println(lender.toString());
        // System.out.println("-------------------------------------------------");

        // Test Loan.getNewestLoans()

        // loansList = loanUtil.getNewestLoans(5);
        // loan = (Loan) loansList.get(10);
        // System.out.println(loan.toString());

        /*
         * LenderUtil lenderUtil = new LenderUtil();
         * 
         * // Test Lender.getLendersDetails() List lendersList = lenderUtil.getLendersDetails(new String[] { "jeremy"
         * }); Lender lender = (Lender) lendersList.get(0); System.out.println(lender.toString());
         * 
         * // Test Lender.getNewestLenders() lendersList = lenderUtil.getNewestLenders(); lender = (Lender)
         * lendersList.get(10); System.out.println(lender.toString());
         */
        // Test Lender.getLendersByParams()
        // LenderUtil lenderUtil = new LenderUtil();
        // LenderSearchParams lenderSearchParams = new LenderSearchParams(null, null, null, "newest", 11);
        // List lendersList = lenderUtil.getLendersByParams(lenderSearchParams);
        // Lender lender = (Lender) lendersList.get(0);
        // System.out.println(lender.toString());

    }
}
