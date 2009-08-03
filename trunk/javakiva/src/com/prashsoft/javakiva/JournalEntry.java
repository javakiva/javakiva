/*
 * JournalEntry.java: The Journal Entry Object
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

public class JournalEntry {

    /* Author */
    private String author;

    /* Body */
    private String body;

    /* Bulk */
    private String bulk;

    /* Comment Count */
    private Integer commentCount;

    /* Date */
    private Date date;

    /* Id */
    private Integer id;

    /* Recommendation Count */
    private Integer recommendationCount;

    /* Subject */
    private String subject;

    /**
     * Default Constructor
     */
    public JournalEntry() {

    }

    /**
     * Get Author
     * 
     * @return author - Author - String
     * @see String
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Get Body
     * 
     * @return body - Body - String
     * @see String
     */
    public String getBody() {
        return this.body;
    }

    /**
     * Get Bulk
     * 
     * @return bulk - Bulk - String
     * @see String
     */
    public String getBulk() {
        return this.bulk;
    }

    /**
     * Get Comment Count
     * 
     * @return commentCount - Comment Count - Integer
     * @see Integer
     */
    public Integer getCommentCount() {
        return this.commentCount;
    }

    /**
     * Get Date
     * 
     * @return date - Date - Date
     * @see Date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Get Id
     * 
     * @return id - Id - Integer
     * @see Integer
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Get Recommendation Count
     * 
     * @return recommendationCount - Recommendation Count - Integer
     * @see Integer
     */
    public Integer getRecommendationCount() {
        return this.recommendationCount;
    }

    /**
     * Get Subject
     * 
     * @return subject - Subject - String
     * @see String
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * Set Author
     * 
     * @param author
     *            - Author - String
     * @see String
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Set Body
     * 
     * @param body
     *            - Body - String
     * @see String
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Set Bulk
     * 
     * @param bulk
     *            - Bulk - String
     * @see String
     */
    public void setBulk(String bulk) {
        this.bulk = bulk;
    }

    /**
     * Set Comment Count
     * 
     * @param commentCount
     *            - Comment Count - Integer
     * @see Integer
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * Set Date
     * 
     * @param date
     *            - Date - Date
     * @see Date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Set Id
     * 
     * @param id
     *            - Id - Integer
     * @see Integer
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Set Recommendation Count
     * 
     * @param recommendationCount
     *            - Recommendation Count - Integer
     * @see Integer
     */
    public void setRecommendationCount(Integer recommendationCount) {
        this.recommendationCount = recommendationCount;
    }

    /**
     * Set Subject
     * 
     * @param subject
     *            - Subject - String
     * @see String
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * To String
     * 
     * @return toString Of Attributes
     * @see String
     */
    @Override
    public String toString() {
        return "" + " Jounral Entry Author: " + (author == null ? "" : author) + "\n" + " Jounral Entry Body: "
                + (body == null ? "" : body) + "\n" + " Jounral Entry Bulk: " + (bulk == null ? "" : bulk) + "\n"
                + " Jounral Entry Comment Count: " + (commentCount == null ? "" : commentCount) + "\n"
                + " Jounral Entry Date: " + (date == null ? "" : date) + "\n" + " Jounral Entry Id: "
                + (id == null ? "" : id) + "\n" + " Jounral Entry Recommendation Count: "
                + (recommendationCount == null ? "" : recommendationCount) + "\n" + " Jounral Entry Subject: "
                + (subject == null ? "" : subject) + "\n";

    }

}