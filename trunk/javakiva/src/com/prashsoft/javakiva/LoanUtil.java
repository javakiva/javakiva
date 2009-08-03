/*
 * LoanUtil.java: The Loan Util Object
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import com.prashsoft.javakiva.Loan.Description;
import com.prashsoft.javakiva.Loan.JournalTotals;
import com.prashsoft.javakiva.Loan.Terms;
import com.prashsoft.javakiva.Loan.Terms.LossLiability;
import com.prashsoft.javakiva.Loan.Terms.TermsPayment;

public class LoanUtil {

    private JournalEntry getJournalEntryFromBean(Object bean) {

        JournalEntry journalEntry = new JournalEntry();

        if (KivaUtil.getBeanProperty(bean, "id") != null)
            journalEntry.setId(Integer.parseInt(KivaUtil.getBeanProperty(bean, "id").toString()));

        if (KivaUtil.getBeanProperty(bean, "subject") != null)
            journalEntry.setSubject(KivaUtil.getBeanProperty(bean, "subject").toString());

        if (KivaUtil.getBeanProperty(bean, "body") != null)
            journalEntry.setBody(KivaUtil.getBeanProperty(bean, "body").toString());

        if (KivaUtil.getBeanProperty(bean, "date") != null)
            journalEntry.setDate(KivaUtil.getDateFromISO8601((String) KivaUtil.getBeanProperty(bean, "date")));

        if (KivaUtil.getBeanProperty(bean, "author") != null)
            journalEntry.setAuthor(KivaUtil.getBeanProperty(bean, "author").toString());

        if (KivaUtil.getBeanProperty(bean, "bulk") != null)
            journalEntry.setBulk(KivaUtil.getBeanProperty(bean, "bulk").toString());

        if (KivaUtil.getBeanProperty(bean, "comment_count") != null)
            journalEntry.setCommentCount(Integer.parseInt(KivaUtil.getBeanProperty(bean, "comment_count").toString()));

        if (KivaUtil.getBeanProperty(bean, "recommendation_count") != null)
            journalEntry.setRecommendationCount(Integer.parseInt(KivaUtil.getBeanProperty(bean, "recommendation_count")
                    .toString()));

        return journalEntry;
    }

    private Loan getLoan(Object bean) {

        Loan loan = new Loan();

        loan.setId((Integer) KivaUtil.getBeanProperty(bean, "id"));
        loan.setName((String) KivaUtil.getBeanProperty(bean, "name"));

        if (KivaUtil.getBeanProperty(bean, "description") != null) {

            Description loanDescription = loan.new Description();

            JSONObject descJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(bean, "description"));
            Object descBean = JSONObject.toBean(descJSONObject);
            List<String> languagesList = (List) KivaUtil.getBeanProperty(descBean, "languages");
            loanDescription.setLanguages(languagesList);

            JSONObject textsJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(descBean, "texts"));
            Object textsBean = JSONObject.toBean(textsJSONObject);

            // get the text for each of the languages obtained above ...
            Map<String, String> languageTextsMap = new HashMap<String, String>();
            Iterator<String> languagesIter = languagesList.iterator();

            while (languagesIter.hasNext()) {
                String language = languagesIter.next();
                if (KivaUtil.getBeanProperty(textsBean, language) != null)
                    languageTextsMap.put(language, (String) KivaUtil.getBeanProperty(textsBean, language));
            }
            loanDescription.setTexts(languageTextsMap);

            loan.setDescription(loanDescription);
        }

        loan.setStatus((String) KivaUtil.getBeanProperty(bean, "status"));
        if (KivaUtil.getBeanProperty(bean, "loan_amount") != null)
            loan.setLoanAmount(Double.parseDouble(KivaUtil.getBeanProperty(bean, "loan_amount").toString()));
        if (KivaUtil.getBeanProperty(bean, "funded_amount") != null)
            loan.setFundedAmount(Double.parseDouble(KivaUtil.getBeanProperty(bean, "funded_amount").toString()));
        if (KivaUtil.getBeanProperty(bean, "raised_amount") != null)
            loan.setRaisedAmount(Double.parseDouble(KivaUtil.getBeanProperty(bean, "raised_amount").toString()));
        if (KivaUtil.getBeanProperty(bean, "paid_amount") != null)
            loan.setPaidAmount(Double.parseDouble(KivaUtil.getBeanProperty(bean, "paid_amount").toString()));
        if (KivaUtil.getBeanProperty(bean, "basket_amount") != null)
            loan.setBasketAmount(Double.parseDouble(KivaUtil.getBeanProperty(bean, "basket_amount").toString()));

        if (KivaUtil.getBeanProperty(bean, "image") != null) {

            Image image = new Image();
            JSONObject imageJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(bean, "image"));

            Object imageBean = JSONObject.toBean(imageJSONObject);

            image.setId(KivaUtil.getBeanProperty(imageBean, "id").toString());
            image.setTemplateId(KivaUtil.getBeanProperty(imageBean, "template_id").toString());

            loan.setImage(image);
        }

        loan.setActivity((String) KivaUtil.getBeanProperty(bean, "activity"));
        loan.setSector((String) KivaUtil.getBeanProperty(bean, "sector"));
        loan.setUse((String) KivaUtil.getBeanProperty(bean, "use"));

        if (KivaUtil.getBeanProperty(bean, "location") != null) {

            Location location = new Location();

            JSONObject locationJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(bean, "location"));
            Object locationBean = JSONObject.toBean(locationJSONObject);

            location.setCountryCode((String) KivaUtil.getBeanProperty(locationBean, "country_code"));
            location.setCountry((String) KivaUtil.getBeanProperty(locationBean, "country"));
            location.setTown((String) KivaUtil.getBeanProperty(locationBean, "town"));

            JSONObject geoJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(locationBean, "geo"));
            Object geoBean = JSONObject.toBean(geoJSONObject);

            Geo geo = new Geo();
            geo.setLevel((String) KivaUtil.getBeanProperty(geoBean, "level"));
            geo.setPairs((String) KivaUtil.getBeanProperty(geoBean, "pairs"));
            geo.setType((String) KivaUtil.getBeanProperty(geoBean, "type"));

            location.setGeo(geo);

            loan.setLocation(location);
        }

        loan.setPartnerId((Integer) KivaUtil.getBeanProperty(bean, "partner_id"));

        if (KivaUtil.getBeanProperty(bean, "borrowers") != null) {

            List<Borrower> borrowers = new ArrayList();

            List borrowersList = (List) KivaUtil.getBeanProperty(bean, "borrowers");
            Iterator borrowersIter = borrowersList.iterator();

            while (borrowersIter.hasNext()) {

                JSONObject borrowerJSONObject = JSONObject.fromObject(borrowersIter.next());
                Object borrowerBean = JSONObject.toBean(borrowerJSONObject);

                Borrower borrower = new Borrower();

                if (KivaUtil.getBeanProperty(borrowerBean, "first_name") != null)
                    borrower.setFirstName((String) KivaUtil.getBeanProperty(borrowerBean, "first_name"));

                if (KivaUtil.getBeanProperty(borrowerBean, "last_name") != null)
                    borrower.setLastName((String) KivaUtil.getBeanProperty(borrowerBean, "last_name"));

                if (KivaUtil.getBeanProperty(borrowerBean, "gender") != null)
                    borrower.setGender((String) KivaUtil.getBeanProperty(borrowerBean, "gender"));

                if (KivaUtil.getBeanProperty(borrowerBean, "pictured") != null)
                    borrower.setPictured((Boolean) KivaUtil.getBeanProperty(borrowerBean, "pictured"));

                if (KivaUtil.getBeanProperty(borrowerBean, "id") != null)
                    borrower.setId((String) KivaUtil.getBeanProperty(borrowerBean, "id"));

                borrowers.add(borrower);

            }

            loan.setBorrowers(borrowers);
        }

        if (KivaUtil.getBeanProperty(bean, "terms") != null) {

            Terms terms = loan.new Terms();

            JSONObject termsJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(bean, "terms"));
            Object termsBean = JSONObject.toBean(termsJSONObject);

            if (KivaUtil.getBeanProperty(termsBean, "disbursal_amount") != null)
                terms.setDisbursalAmount(Double.parseDouble((KivaUtil.getBeanProperty(termsBean, "disbursal_amount")
                        .toString())));

            terms.setDisbursalCurrency((String) KivaUtil.getBeanProperty(termsBean, "disbursal_currency"));

            if (KivaUtil.getBeanProperty(termsBean, "local_payments") != null) {

                List<TermsPayment> localPayments = new ArrayList();

                List localPaymentsList = (List) KivaUtil.getBeanProperty(termsBean, "local_payments");
                Iterator localPaymentsIter = localPaymentsList.iterator();

                while (localPaymentsIter.hasNext()) {

                    JSONObject paymentJSONObject = JSONObject.fromObject(localPaymentsIter.next());
                    Object paymentBean = JSONObject.toBean(paymentJSONObject);

                    TermsPayment payment = terms.new TermsPayment();

                    if (KivaUtil.getBeanProperty(paymentBean, "due_date") != null)
                        payment.setDueDate(KivaUtil.getDateFromISO8601((String) KivaUtil.getBeanProperty(paymentBean,
                                "due_date")));

                    if (KivaUtil.getBeanProperty(paymentBean, "amount") != null)
                        payment.setAmount(Double.parseDouble((KivaUtil.getBeanProperty(paymentBean, "amount")
                                .toString())));

                    localPayments.add(payment);

                }
                terms.setLocalPayments(localPayments);
            }

            if (KivaUtil.getBeanProperty(termsBean, "scheduled_payments") != null) {

                List<TermsPayment> scheduledPayments = new ArrayList();

                List scheduledPaymentsList = (List) KivaUtil.getBeanProperty(termsBean, "scheduled_payments");
                Iterator scheduledPaymentsIter = scheduledPaymentsList.iterator();

                while (scheduledPaymentsIter.hasNext()) {

                    JSONObject paymentJSONObject = JSONObject.fromObject(scheduledPaymentsIter.next());
                    Object paymentBean = JSONObject.toBean(paymentJSONObject);

                    TermsPayment payment = terms.new TermsPayment();

                    if (KivaUtil.getBeanProperty(paymentBean, "due_date") != null)
                        payment.setDueDate(KivaUtil.getDateFromISO8601((String) KivaUtil.getBeanProperty(paymentBean,
                                "due_date")));

                    if (KivaUtil.getBeanProperty(paymentBean, "amount") != null)
                        payment.setAmount(Double.parseDouble((KivaUtil.getBeanProperty(paymentBean, "amount")
                                .toString())));

                    scheduledPayments.add(payment);

                }
                terms.setScheduledPayments(scheduledPayments);
            }

            terms.setDisbursalDate(KivaUtil.getDateFromISO8601((String) KivaUtil.getBeanProperty(termsBean,
                    "disbursal_date")));
            terms.setLoanAmount(Double.parseDouble((KivaUtil.getBeanProperty(termsBean, "loan_amount").toString())));

            if (KivaUtil.getBeanProperty(termsBean, "loss_liability") != null) {

                LossLiability lossLiability = terms.new LossLiability();

                JSONObject lossLiabilityJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(termsBean,
                        "loss_liability"));

                Object lossLiabilityBean = JSONObject.toBean(lossLiabilityJSONObject);

                lossLiability.setNonpayment((String) KivaUtil.getBeanProperty(lossLiabilityBean, "nonpayment"));
                lossLiability.setCurrencyExchange((String) KivaUtil.getBeanProperty(lossLiabilityBean,
                        "currency_exchange"));

                terms.setLossLiability(lossLiability);

            }
            loan.setTerms(terms);
        }

        if (KivaUtil.getBeanProperty(bean, "payments") != null) {

            List<Payment> payments = new ArrayList();

            List paymentsList = (List) KivaUtil.getBeanProperty(bean, "payments");
            Iterator paymentsIter = paymentsList.iterator();

            JSONObject paymentJSONObject;
            Object paymentBean;

            while (paymentsIter.hasNext()) {

                paymentJSONObject = JSONObject.fromObject(paymentsIter.next());
                paymentBean = JSONObject.toBean(paymentJSONObject);

                Payment payment = getPaymentFromBean(paymentBean);
                payments.add(payment);

            }

            loan.setPayments(payments);
        }

        if (KivaUtil.getBeanProperty(bean, "posted_date") != null)
            loan.setPostedDate(KivaUtil.getDateFromISO8601((String) KivaUtil.getBeanProperty(bean, "posted_date")));

        if (KivaUtil.getBeanProperty(bean, "funded_date") != null)
            loan.setFundedDate(KivaUtil.getDateFromISO8601((String) KivaUtil.getBeanProperty(bean, "funded_date")));

        if (KivaUtil.getBeanProperty(bean, "journal_totals") != null) {

            JournalTotals journalTotals = loan.new JournalTotals();

            JSONObject journalTotalsJSONObject = JSONObject
                    .fromObject(KivaUtil.getBeanProperty(bean, "journal_totals"));

            Object journalTotalsBean = JSONObject.toBean(journalTotalsJSONObject);

            if (KivaUtil.getBeanProperty(journalTotalsBean, "entries") != null)
                journalTotals.setEntries((Integer) KivaUtil.getBeanProperty(journalTotalsBean, "entries"));

            if (KivaUtil.getBeanProperty(journalTotalsBean, "bulk_entries") != null)
                journalTotals.setBulkEntries((Integer) KivaUtil.getBeanProperty(journalTotalsBean, "bulk_entries"));

            loan.setJournalTotals(journalTotals);
        }

        return loan;

    }

    public Loan getLoanDetails(Integer loanId) {
        return (getLoansDetails(new String[] { loanId.toString() }).get(0));
    }

    public List<JournalEntry> getLoanJournalEntries(Integer loanId) {

        if (loanId == null || loanId.intValue() <= 0)
            return null;

        String urlSuffix = "loans";
        String urlMethod = loanId.intValue() + "/journal_entries";

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, null);

        if ((bean == null) || (!(PropertyUtils.isReadable(bean, "journal_entries"))))
            return null;

        List jsonJournalEntries = (List) KivaUtil.getBeanProperty(bean, "journal_entries");

        if (jsonJournalEntries == null || jsonJournalEntries.size() == 0)
            return null;

        List<JournalEntry> journalEntries = new ArrayList();
        JournalEntry journalEntry;

        Iterator journalEntryIter = jsonJournalEntries.iterator();
        JSONObject jsonObject;

        while (journalEntryIter.hasNext()) {

            jsonObject = JSONObject.fromObject(journalEntryIter.next());
            bean = JSONObject.toBean(jsonObject);

            journalEntry = getJournalEntryFromBean(bean);
            journalEntries.add(journalEntry);
        }
        return journalEntries;

    }

    public List<Lender> getLoanLenders(Integer loanId) {

        if (loanId == null || loanId.intValue() <= 0)
            return null;

        List lendersList = new ArrayList();

        String urlSuffix = "loans";
        String urlMethod = loanId.intValue() + "/lenders";

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, null);

        return new LenderUtil().getLendersFromBean(bean);
    }

    public List<Loan> getLoansByParams(LoanSearchParams loanSearchParams) {

        String urlSuffix = "loans";
        String urlMethod = "search";
        String urlParams = loanSearchParams.getParamString();

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, urlParams);

        return getLoansFromBean(bean);

    }

    public List<Loan> getLoansDetails(String loanIds) {

        JSONObject jsonObject;

        List loans = new ArrayList();

        String urlSuffix = "loans";
        String urlMethod = loanIds;

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, null);

        if ((bean == null) || (!(PropertyUtils.isReadable(bean, "loans"))))
            return null;

        List jsonLoans = (List) KivaUtil.getBeanProperty(bean, "loans");

        if (jsonLoans == null || jsonLoans.size() == 0)
            return null;

        Iterator loanIter = jsonLoans.iterator();

        while (loanIter.hasNext()) {

            jsonObject = JSONObject.fromObject(loanIter.next());
            bean = JSONObject.toBean(jsonObject);

            Loan loan = getLoan(bean);
            loans.add(loan);

        }
        return loans;
    }

    public List<Loan> getLoansDetails(String[] loanIds) {
        return getLoansDetails(StringUtils.join(loanIds, ','));
    }

    public List<Loan> getLoansFromBean(Object bean) {

        if (!(PropertyUtils.isReadable(bean, "loans")))
            return null;

        List jsonLoans = (List) KivaUtil.getBeanProperty(bean, "loans");

        if (jsonLoans == null || jsonLoans.size() == 0)
            return null;

        List loans = new ArrayList();
        JSONObject jsonObject;
        Loan loan;
        Iterator loanIter = jsonLoans.iterator();

        while (loanIter.hasNext()) {

            jsonObject = JSONObject.fromObject(loanIter.next());
            bean = JSONObject.toBean(jsonObject);

            loan = getLoanDetails((Integer) KivaUtil.getBeanProperty(bean, "id"));
            loans.add(loan);

        }
        return loans;
    }

    public List<LoanUpdate> getLoanUpdates(Integer loanId) {

        if (loanId == null || loanId.intValue() <= 0)
            return null;

        String urlSuffix = "loans";
        String urlMethod = loanId.intValue() + "/updates";

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, null);

        if ((bean == null) || (!(PropertyUtils.isReadable(bean, "loan_updates"))))
            return null;

        List jsonLoanUpdates = (List) KivaUtil.getBeanProperty(bean, "loan_updates");

        if (jsonLoanUpdates == null || jsonLoanUpdates.size() == 0)
            return null;

        List<LoanUpdate> loanUpdates = new ArrayList();
        LoanUpdate loanUpdate;

        Iterator loanUpdateIter = jsonLoanUpdates.iterator();

        JSONObject loanUpdateJSONObject;
        Object loanUpdateBean;

        while (loanUpdateIter.hasNext()) {
            loanUpdate = new LoanUpdate();

            loanUpdateJSONObject = JSONObject.fromObject(loanUpdateIter.next());
            loanUpdateBean = JSONObject.toBean(loanUpdateJSONObject);

            if (KivaUtil.getBeanProperty(loanUpdateBean, "journal_entry") != null) {
                JSONObject journalEntryJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(loanUpdateBean,
                        "journal_entry"));
                Object journalEntryBean = JSONObject.toBean(journalEntryJSONObject);
                loanUpdate.setJournalEntry(getJournalEntryFromBean(journalEntryBean));
            }

            if (KivaUtil.getBeanProperty(loanUpdateBean, "update_type") != null) {
                loanUpdate.setUpdateType(KivaUtil.getBeanProperty(loanUpdateBean, "update_type").toString());
            }

            if (KivaUtil.getBeanProperty(loanUpdateBean, "payment") != null) {
                JSONObject paymentJSONObject = JSONObject.fromObject(KivaUtil
                        .getBeanProperty(loanUpdateBean, "payment"));
                Object paymentBean = JSONObject.toBean(paymentJSONObject);
                loanUpdate.setPayment(getPaymentFromBean(paymentBean));
            }

            loanUpdates.add(loanUpdate);
        }
        return loanUpdates;

    }

    public List getNewestLoans() {
        return getNewestLoans(1);
    }

    public List getNewestLoans(int pageNum) {

        String urlSuffix = "loans";
        String urlMethod = "newest";
        String urlParams = "page=" + pageNum;

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, urlParams);

        return getLoansFromBean(bean);

    }

    private Payment getPaymentFromBean(Object paymentBean) {

        Payment payment = new Payment();

        if (KivaUtil.getBeanProperty(paymentBean, "payment_id") != null)
            payment.setPaymentId(Integer.parseInt(KivaUtil.getBeanProperty(paymentBean, "payment_id").toString()));

        if (KivaUtil.getBeanProperty(paymentBean, "amount") != null)
            payment.setAmount(Double.parseDouble(KivaUtil.getBeanProperty(paymentBean, "amount").toString()));

        if (KivaUtil.getBeanProperty(paymentBean, "local_amount") != null)
            payment
                    .setLocalAmount(Double
                            .parseDouble(KivaUtil.getBeanProperty(paymentBean, "local_amount").toString()));

        if (KivaUtil.getBeanProperty(paymentBean, "processed_date") != null)
            payment.setProcessedDate(KivaUtil.getDateFromISO8601(KivaUtil
                    .getBeanProperty(paymentBean, "processed_date").toString()));

        if (KivaUtil.getBeanProperty(paymentBean, "settlement_date") != null)
            payment.setSettlementDate(KivaUtil.getDateFromISO8601(KivaUtil.getBeanProperty(paymentBean,
                    "settlement_date").toString()));

        if (KivaUtil.getBeanProperty(paymentBean, "comment") != null)
            payment.setComment(KivaUtil.getBeanProperty(paymentBean, "comment").toString());

        if (KivaUtil.getBeanProperty(paymentBean, "rounded_local_amount") != null)
            payment.setRoundedLocalAmount(Double.parseDouble(KivaUtil.getBeanProperty(paymentBean,
                    "rounded_local_amount").toString()));

        return payment;
    }
}