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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class KivaUtil {

    private static final String API_BASE_URL = "http://api.kivaws.org/v1";
    private static final String APP_ID = "app_id=com.prashsoft.javakiva";
    private static final int BYTE_CHUNK_SIZE = 8192;
    private static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String createKivaAPIUrl(String urlSuffix, String urlMethod, String urlParams) {
        return (API_BASE_URL + "/" + urlSuffix + "/" + urlMethod + ".json" + "?"
                + ((urlParams == null || urlParams.equals("")) ? "" : urlParams + "&") + KivaUtil.APP_ID);
    }

    public static Object getBeanProperty(Object bean, String name) {
        Object beanProperty = null;
        try {
            beanProperty = PropertyUtils.isReadable(bean, name) ? PropertyUtils.getProperty(bean, name) : null;
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

    public static Object getBeanResponse(String urlSuffix, String urlMethod, String urlParams) {

        Object bean = null;

        String url = createKivaAPIUrl(urlSuffix, urlMethod, urlParams);

        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();

        // Create a method instance.
        GetMethod method = new GetMethod(url);

        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println(url + " :: Method failed! : " + method.getStatusLine());
                return null;
            }

            // Read the response body.

            InputStream is = method.getResponseBodyAsStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(is));

            String datastr = null;
            StringBuffer sb = new StringBuffer();

            String inputLine;

            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);

            in.close();
            is.close();

            String response = sb.toString();

            // Deal with the response.
            JSONObject jsonObject = JSONObject.fromObject(response);

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

    public static Date getDateFromISO8601(String iso8601Date) {
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_8601_DATE_FORMAT);
        try {
            return sdf.parse(iso8601Date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}