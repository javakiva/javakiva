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
        LenderUtil lenderUtil = new LenderUtil();

        
        // Test Lender.getLendersDetails()        
        List lendersList = lenderUtil
                .getLendersDetails(new String[] { "nellie8209" });
        Lender lender = (Lender) lendersList.get(0);
        System.out.println(lender.toString());
        
        // Test Lender.getNewestLenders()        
        lendersList = lenderUtil.getNewestLenders();
        lender = (Lender) lendersList.get(10);
        System.out.println(lender.toString());
        
        // Test Lender.getLendersByParams()        
        LenderSearchParams lenderSearchParams = new LenderSearchParams(null, "farmer", null, "newest", 11);
        lendersList = lenderUtil.getLendersByParams(lenderSearchParams);
        lender = (Lender) lendersList.get(0);
        System.out.println(lender.toString());
        
    }
}
