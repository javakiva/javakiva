/*
 * KivaUtil.java: The Kiva Util Object
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

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

public class KivaUtil {

    public static final String API_BASE_URL = "http://api.kivaws.org/v1";
    public static final String APP_ID = "app_id=com.prashsoft.javakiva";
    public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String createKivaAPIUrl(String urlSuffix, String urlMethod,
            String urlParams) {
        return (API_BASE_URL + "/" + urlSuffix + "/" + urlMethod + ".json"
                + "?" + (urlParams == null ? "" : urlParams + "&") + KivaUtil.APP_ID);
    }

    public static Date getDateFromISO8601(String iso8601Date) {
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_8601_DATE_FORMAT);
        try {
            return sdf.parse(iso8601Date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getBeanProperty(Object bean, String name) {
        Object beanProperty = null;
        try {
            beanProperty = PropertyUtils.isReadable(bean, name) ? PropertyUtils
                    .getProperty(bean, name) : null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beanProperty;
    }
}