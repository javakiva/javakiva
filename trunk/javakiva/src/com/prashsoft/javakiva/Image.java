/*
 * Image.java: The Image Object
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

import java.util.HashMap;
import java.util.Map;

public class Image {

    /* Just using a simple String array for image templates for now */
    private static Map imageTemplate = new HashMap();

    /* Id */
    private String id;

    /* Image Url */
    private String imageUrl;

    /* Template Id */
    private String templateId;

    /**
     * Default Constructor
     */
    public Image() {
        imageTemplate.put("1", "http://www.kiva.org/img");
    }

    /**
     * Parameterized Constructor
     */
    public Image(String id, String templateId) {
        this.id = id;
        this.templateId = templateId;
    }

    /**
     * Get Id
     * 
     * @return id - Id - String
     * @see String
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get Image Url
     * 
     * @return imageUrl - Image Url - String
     * @see String
     */
    public String getImageUrl() {
        return getImageUrl("800");
    }

    /**
     * Get Image Url
     * 
     * @return imageUrl - Image Url - String
     * @see String
     */
    public String getImageUrl(String width) {
        if (imageUrl == null)
            return imageTemplate.get(this.templateId) + "/w" + width + "/" + this.id + ".jpg";
        else
            return this.imageUrl;
    }

    /**
     * Get Template Id
     * 
     * @return templateId - Template Id - String
     * @see String
     */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
     * Set Id
     * 
     * @param id
     *            - Id - String
     * @see String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set Image Url
     * 
     * @param imageUrl
     *            - Image Url - String
     * @see String
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Set Template Id
     * 
     * @param templateId
     *            - Template Id - String
     * @see String
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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
