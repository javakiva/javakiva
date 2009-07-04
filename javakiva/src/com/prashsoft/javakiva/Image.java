/*
 * Lender.java: The Kiva Image Object
 * 
 * Copyright (C) 2009 prashsoft.com
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License version 2 for more details:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * You should have received a copy of the GNU General Public License
 * version 2 along with this program; if not, write to the
 * Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301, USA. 
 */

package com.prashsoft.javakiva;

public class Image {

    /* Just using a simple String array for image templates for now */
    private static final String[] imageTemplate = { "http://www.kiva.org/img/" };

    /* Id */
    private int id;

    /* Image Url */
    private String imageUrl;

    /* Template Id */
    private int templateId;

    /**
     * Default Constructor
     */
    public Image() {
    }

    /**
     * Parameterized Constructor
     */
    public Image(int id, int templateId) {
        this.id = id;
        this.templateId = templateId;
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
     * Get Image Url
     * 
     * @return imageUrl - Image Url - String
     * @see String
     */
    public String getImageUrl(int width) {
        if (imageUrl == null)
            return imageTemplate[this.templateId - 1] + "/w" + width + "/"
                    + this.id + ".jpg";
        else
            return this.imageUrl;
    }

    /**
     * Get Template Id
     * 
     * @return templateId - Template Id - int
     * @see int
     */
    public int getTemplateId() {
        return this.templateId;
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
     *            - Template Id - int
     * @see int
     */
    public void setTemplateId(int templateId) {
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
