/*
 * LenderUtil.java: The Lender Util Object
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;

public class LenderUtil {

    public Lender getLenderDetails(String lenderId) {
        return ((Lender) getLendersDetails(new String[] { lenderId }).get(0));
    }

    public List getLendersDetails(String[] lenderIds) {
        return getLendersDetails(StringUtils.join(lenderIds, ','));
    }

    public List getNewestLenders() {
        return getNewestLenders(1);
    }

    public List getNewestLenders(int pageNum) {
        List lenders = new ArrayList();

        String urlSuffix = "lenders";
        String urlMethod = "newest";
        String urlParams = "page=" + pageNum;

        Object bean = getBeanResponse(urlSuffix, urlMethod, urlParams);
        
        if (!(PropertyUtils.isReadable(bean, "lenders")))
            return null;

        List jsonLenders = (List) KivaUtil.getBeanProperty(bean, "lenders");

        if (jsonLenders == null || jsonLenders.size() == 0)
            return null;

        Iterator lenderIter = jsonLenders.iterator();
        JSONObject jsonObject;
        Lender lender;
        
        while (lenderIter.hasNext()) {

            jsonObject = JSONObject.fromObject(lenderIter.next());
            bean = JSONObject.toBean(jsonObject);
            
            lender = getLenderDetails((String) KivaUtil.getBeanProperty(bean, "lender_id"));
            lenders.add(lender);

        }
        return lenders;
    }

    public List getLendersByParams(LenderSearchParams lenderSearchParams) {
        List lenders = new ArrayList();

        String urlSuffix = "lenders";
        String urlMethod = "search";
        String urlParams = lenderSearchParams.getParamString();        
        
        Object bean = getBeanResponse(urlSuffix, urlMethod, urlParams);

        if (!(PropertyUtils.isReadable(bean, "lenders")))
            return null;

        List jsonLenders = (List) KivaUtil.getBeanProperty(bean, "lenders");

        if (jsonLenders == null || jsonLenders.size() == 0)
            return null;

        Iterator lenderIter = jsonLenders.iterator();
        JSONObject jsonObject;
        Lender lender;

        while (lenderIter.hasNext()) {

            jsonObject = JSONObject.fromObject(lenderIter.next());
            bean = JSONObject.toBean(jsonObject);

            lender = getLenderDetails((String) KivaUtil.getBeanProperty(bean, "lender_id"));
            lenders.add(lender);

        }
        return lenders;
    }

    public List getLendersDetails(String lenderIds) {

        JSONObject jsonObject;

        List lenders = new ArrayList();

        String urlSuffix = "lenders";
        String urlMethod = lenderIds;

        Object bean = getBeanResponse(urlSuffix, urlMethod, null);

        if (!(PropertyUtils.isReadable(bean, "lenders")))
            return null;

        List jsonLenders = (List) KivaUtil.getBeanProperty(bean, "lenders");

        if (jsonLenders == null || jsonLenders.size() == 0)
            return null;

        Iterator lenderIter = jsonLenders.iterator();

        while (lenderIter.hasNext()) {

            jsonObject = JSONObject.fromObject(lenderIter.next());
            bean = JSONObject.toBean(jsonObject);

            Lender lender = getLender(bean);
            lenders.add(lender);

        }
        return lenders;
    }

    private Lender getLender(Object bean) {

        Lender lender = new Lender();

        lender.setLenderId((String) KivaUtil.getBeanProperty(bean, "lender_id"));
        lender.setName((String) KivaUtil.getBeanProperty(bean, "name"));
        lender.setWhereabouts((String) KivaUtil.getBeanProperty(bean, "whereabouts"));
        lender.setCountryCode((String) KivaUtil.getBeanProperty(bean, "country_code"));

        if (KivaUtil.getBeanProperty(bean, "image") != null) {

            Image image = new Image();
            JSONObject imageJSONObject = JSONObject.fromObject(KivaUtil
                    .getBeanProperty(bean, "image"));

            Object imageBean = JSONObject.toBean(imageJSONObject);

            image.setId(KivaUtil.getBeanProperty(imageBean, "id").toString());

            image.setTemplateId(KivaUtil.getBeanProperty(imageBean,
                    "template_id").toString());

            lender.setImage(image);
        }

        lender.setLoanBecause((String) KivaUtil.getBeanProperty(bean,
                "loan_because"));
        lender.setOccupationalInfo((String) KivaUtil.getBeanProperty(bean,
                "occupational_info"));
        lender.setPersonalUrl((String) KivaUtil.getBeanProperty(bean,
                "occupational_info"));
        lender.setMemberSince(KivaUtil.getDateFromISO8601((String) KivaUtil
                .getBeanProperty(bean, "member_since")));
        lender
                .setLoanCount(KivaUtil.getBeanProperty(bean, "loan_count") == null ? 0
                        : ((Integer) KivaUtil.getBeanProperty(bean,
                                "loan_count")).intValue());
        lender
                .setInviteeCount(KivaUtil
                        .getBeanProperty(bean, "invitee_count") == null ? 0
                        : ((Integer) KivaUtil.getBeanProperty(bean,
                                "invitee_count")).intValue());

        return lender;

    }

    private Object getBeanResponse(String urlSuffix, String urlMethod,
            String urlParams) {

        Object bean = null;

        String url = KivaUtil.createKivaAPIUrl(urlSuffix, urlMethod, urlParams);

        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();

        // Create a method instance.
        GetMethod method = new GetMethod(url);

        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println(url + " :: Method failed! : "
                        + method.getStatusLine());
                return null;
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.

            JSONObject jsonObject = JSONObject.fromObject(new String(
                    responseBody));

            bean = JSONObject.toBean(jsonObject);

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Fatal general error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }

        return bean;

    }

}