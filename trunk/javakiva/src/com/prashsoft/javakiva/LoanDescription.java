/*
 * LoanDescription.java: The Loan Description Object
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
import java.util.Map;

public class LoanDescription {

    List languages;
    Map texts;

    /**
     * Get languages
     * 
     * @return languages - Languages - List
     * @see List
     */
    public List getLanguages() {
        return languages;
    }

    /**
     * Get texts
     * 
     * @return texts - Texts - Map
     * @see Map
     */
    public Map getTexts() {
        return texts;
    }

    /**
     * Set languages
     * 
     * @param languages
     *            - Languages - List
     * @see List
     */
    public void setLanguages(List languages) {
        this.languages = languages;
    }

    /**
     * Set texts
     * 
     * @param texts
     *            - Texts - Map
     * @see Map
     */
    public void setTexts(Map texts) {
        this.texts = texts;
    }

}
