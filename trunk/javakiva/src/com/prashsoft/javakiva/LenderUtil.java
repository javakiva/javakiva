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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

public class LenderUtil {

    private Lender getLender(Object bean) {

        Lender lender = new Lender();

        lender.setLenderId((String) KivaUtil.getBeanProperty(bean, "lender_id"));
        lender.setName((String) KivaUtil.getBeanProperty(bean, "name"));

        if (KivaUtil.getBeanProperty(bean, "image") != null) {

            Image image = new Image();
            JSONObject imageJSONObject = JSONObject.fromObject(KivaUtil.getBeanProperty(bean, "image"));

            Object imageBean = JSONObject.toBean(imageJSONObject);

            image.setId(KivaUtil.getBeanProperty(imageBean, "id").toString());

            image.setTemplateId(KivaUtil.getBeanProperty(imageBean, "template_id").toString());

            lender.setImage(image);
        }

        lender.setWhereabouts((String) KivaUtil.getBeanProperty(bean, "whereabouts"));
        lender.setCountryCode((String) KivaUtil.getBeanProperty(bean, "country_code"));
        lender.setUid((String) KivaUtil.getBeanProperty(bean, "uid"));
        lender.setMemberSince(KivaUtil.getDateFromISO8601((String) KivaUtil.getBeanProperty(bean, "member_since")));
        lender.setPersonalUrl((String) KivaUtil.getBeanProperty(bean, "personal_url"));
        lender.setOccupation((String) KivaUtil.getBeanProperty(bean, "occupation"));
        lender.setLoanBecause((String) KivaUtil.getBeanProperty(bean, "loan_because"));
        lender.setOccupationalInfo((String) KivaUtil.getBeanProperty(bean, "occupational_info"));
        lender.setLoanCount(KivaUtil.getBeanProperty(bean, "loan_count") == null ? 0 : ((Integer) KivaUtil
                .getBeanProperty(bean, "loan_count")).intValue());
        lender.setInviteeCount(KivaUtil.getBeanProperty(bean, "invitee_count") == null ? 0 : ((Integer) KivaUtil
                .getBeanProperty(bean, "invitee_count")).intValue());

        return lender;

    }

    public Lender getLenderDetails(String lenderId) {
        return ((Lender) getLendersDetails(new String[] { lenderId }).get(0));
    }

    public List getLendersByParams(LenderSearchParams lenderSearchParams) {
        List lenders = new ArrayList();

        String urlSuffix = "lenders";
        String urlMethod = "search";
        String urlParams = lenderSearchParams.getParamString();

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, urlParams);

        return getLendersFromBean(bean);
    }

    public List getLendersDetails(String lenderIds) {

        JSONObject jsonObject;

        List lenders = new ArrayList();

        String urlSuffix = "lenders";
        String urlMethod = lenderIds;

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, null);

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

    public List getLendersDetails(String[] lenderIds) {
        return getLendersDetails(StringUtils.join(lenderIds, ','));
    }

    public List getLendersFromBean(Object bean) {

        if (!(PropertyUtils.isReadable(bean, "lenders")))
            return null;

        List jsonLenders = (List) KivaUtil.getBeanProperty(bean, "lenders");

        if (jsonLenders == null || jsonLenders.size() == 0)
            return null;

        List lenders = new ArrayList();
        JSONObject jsonObject;
        Lender lender;
        Iterator lenderIter = jsonLenders.iterator();

        while (lenderIter.hasNext()) {

            jsonObject = JSONObject.fromObject(lenderIter.next());
            bean = JSONObject.toBean(jsonObject);

            lender = getLenderDetails((String) KivaUtil.getBeanProperty(bean, "lender_id"));
            lenders.add(lender);

        }
        return lenders;
    }

    public List getNewestLenders() {
        return getNewestLenders(1);
    }

    public List getNewestLenders(int pageNum) {

        String urlSuffix = "lenders";
        String urlMethod = "newest";
        String urlParams = "page=" + pageNum;

        Object bean = KivaUtil.getBeanResponse(urlSuffix, urlMethod, urlParams);

        return getLendersFromBean(bean);
    }

}