/*
 * Copyright (c) 2013 The Johns Hopkins University/Applied Physics Laboratory
 *                             All rights reserved.
 *                      
 * This material may be used, modified, or reproduced by or for the U.S. 
 * Government pursuant to the rights granted under the clauses at             
 * DFARS 252.227-7013/7014 or FAR 52.227-14.
 *                      
 * Licensed under the Apache License, Version 2.0 (the "License");            
 * you may not use this file except in compliance with the License.           
 * You may obtain a copy of the License at                                    
 *                                                                             
 *     http://www.apache.org/licenses/LICENSE-2.0                             
 *                                                                             
 * NO WARRANTY.   THIS MATERIAL IS PROVIDED "AS IS."  JHU/APL DISCLAIMS ALL
 * WARRANTIES IN THE MATERIAL, WHETHER EXPRESS OR IMPLIED, INCLUDING (BUT NOT
 * LIMITED TO) ANY AND ALL IMPLIED WARRANTIES OF PERFORMANCE,
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT OF
 * INTELLECTUAL PROPERTY RIGHTS. ANY USER OF THE MATERIAL ASSUMES THE ENTIRE
 * RISK AND LIABILITY FOR USING THE MATERIAL.  IN NO EVENT SHALL JHU/APL BE
 * LIABLE TO ANY USER OF THE MATERIAL FOR ANY ACTUAL, INDIRECT,     
 * CONSEQUENTIAL, SPECIAL OR OTHER DAMAGES ARISING FROM THE USE OF, OR    
 * INABILITY TO USE, THE MATERIAL, INCLUDING, BUT NOT LIMITED TO, ANY DAMAGES
 * FOR LOST PROFITS.
 */

package edu.jhuapl.bsp.detector;

import junit.framework.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCusumSages extends TestCase {

    static final double[] vec1 =
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
             0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0,
             0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
             0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 1, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 2, 4, 4, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 2, 1, 0, 0,
             0, 0, 3, 4, 0, 1, 2, 2, 2, 1, 0, 1, 0, 0, 0, 0, 1, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
             0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 3, 2, 2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 1, 2, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0,
             0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 2, 0, 2, 1, 0, 2, 0, 3, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1,
             0, 0, 0, 0, 0, 1, 0, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 2, 0, 3, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 2,
             0, 1, 1, 0, 0, 0, 0, 1, 0, 2, 0, 0, 1, 2, 1, 0, 0, 1, 0, 1, 0, 0, 2, 3, 1, 1, 1, 0, 1, 2, 1, 0, 1, 1, 0, 0,
             0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0,
             0, 2, 0, 1, 0, 0, 0, 1, 0, 0, 3, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0,
             1, 0, 1, 0, 1, 5, 0, 5, 1, 4, 4, 5, 5, 3, 4, 7, 1, 2, 1, 3, 5, 2, 1, 1, 2, 0, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0,
             0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0,
             0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
             0, 0, 2, 0, 1, 2, 0, 1, 0, 0, 0, 3, 1, 0, 2, 2, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 2, 2, 1, 1, 0, 1, 0, 3,
             1, 1, 1, 3, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 2,
             2, 3, 0, 3, 6, 6, 5, 3, 3, 7, 1, 4, 2, 0, 1, 1, 3, 2, 1, 1, 2, 3, 1, 0, 3, 3, 0, 1, 2, 1, 0, 1, 2, 1, 0, 2,
             0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 2, 1, 0, 0, 1, 1, 0, 1, 2, 2, 1, 1, 1, 5, 3, 6, 4, 2, 3, 3, 1, 1, 0, 0,
             0, 0, 0, 0, 0, 2, 0, 4, 1, 1, 0, 1, 0, 0, 1, 2, 3, 0, 2, 1, 2, 3, 2, 1, 2, 2, 0, 1, 2, 0, 0, 1, 2, 2, 6, 3,
             0, 0, 4, 2, 1, 0, 1, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0};

    static final double[] vec2 =
            {0, 2, 8, 5, 3, 4, 5, 1, 2, 2, 1, 2, 0, 4, 2, 3, 1, 0, 5, 3, 1, 0, 1, 2, 1, 1, 1, 0, 2, 1, 2, 5, 2, 1, 4, 0,
             4, 3, 5, 7, 4, 8, 2, 2, 2, 9, 7, 5, 4, 8, 8, 10, 5, 9, 11, 13, 11, 9, 9, 10, 10, 6, 2, 5, 3, 3, 4, 0, 0, 0,
             0, 1, 0, 0, 1, 1, 1, 0, 2, 0, 1, 1, 1, 4, 2, 5, 2, 2, 3, 3, 1, 1, 2, 3, 1, 1, 2, 3, 3, 2, 1, 0, 2, 0, 1, 2,
             2, 1, 4, 2, 0, 4, 1, 2, 2, 1, 2, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 3, 1, 4, 3, 2, 3, 4, 1, 5, 9, 7, 11, 9,
             8, 4, 7, 7, 8, 10, 5, 6, 3, 7, 6, 2, 4, 4, 1, 2, 2, 4, 3, 3, 3, 1, 2, 2, 2, 3, 0, 1, 1, 0, 1, 0, 1, 0, 0,
             1, 0, 0, 2, 0, 1, 0, 0, 1, 3, 3, 5, 2, 3, 4, 2, 0, 4, 3, 6, 2, 7, 1, 5, 2, 4, 4, 6, 8, 1, 6, 9, 14, 10, 3,
             3, 9, 6, 6, 8, 0, 4, 5, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 1, 0, 4, 0, 0, 0, 1, 0, 3, 3, 6, 3, 7, 16, 10, 6, 6,
             6, 14, 6, 8, 7, 0, 0, 2, 13, 15, 13, 13, 8, 5, 3, 4, 4, 5, 2, 4, 2, 1, 4, 0, 6, 5, 2, 2, 2, 1, 2, 2, 0, 0,
             0, 1, 0, 1, 1, 0, 0, 0, 0, 2, 4, 0, 3, 6, 6, 12, 15, 21, 31, 34, 21, 19, 29, 21, 8, 18, 23, 14, 7, 14, 12,
             8, 7, 8, 5, 7, 9, 4, 7, 2, 5, 3, 2, 3, 4, 4, 1, 2, 0, 4, 2, 3, 1, 1, 0, 1, 2, 3, 1, 1, 0, 0, 1, 3, 1, 1, 2,
             2, 0, 0, 2, 0, 3, 1, 0, 1, 3, 1, 3, 2, 0, 1, 0, 1, 0, 0, 0, 0, 2, 0, 2, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0,
             0, 0, 0, 1, 1, 0, 3, 1, 0, 3, 5, 4, 8, 6, 6, 5, 10, 13, 5, 10, 11, 13, 5, 2, 7, 5, 6, 6, 9, 8, 15, 3, 5, 9,
             11, 2, 6, 10, 6, 6, 5, 5, 9, 1, 6, 0, 0, 3, 3, 3, 2, 2, 4, 4, 3, 2, 0, 3, 3, 1, 6, 9, 7, 11, 11, 11, 11,
             12, 11, 11, 9, 7, 6, 8, 7, 5, 3, 3, 9, 5, 0, 2, 2, 2, 0, 2, 0, 2, 4, 1, 2, 0, 1, 1, 3, 3, 2, 0, 1, 0, 0, 0,
             1, 0, 1, 2, 0, 0, 0, 2, 0, 1, 2, 0, 2, 1, 4, 5, 8, 6, 1, 2, 4, 5, 8, 5, 6, 8, 4, 11, 7, 7, 18, 26, 15, 12,
             12, 6, 10, 6, 4, 11, 6, 6, 6, 5, 2, 4, 5, 6, 7, 5, 2, 4, 1, 0, 0, 1, 0, 0, 0, 0, 2, 3, 1, 2, 0, 4, 4, 1, 9,
             7, 6, 11, 7, 9, 14, 18, 11, 12, 20, 15, 14, 23, 19, 21, 18, 11, 12, 2, 10, 4, 2, 6, 3, 3, 2, 1, 4, 4, 0, 2,
             2, 1, 3, 1, 0, 1, 1, 1, 0, 0, 1, 0, 2, 1, 0, 2, 6, 2, 4, 2, 6, 11, 4, 6, 8, 9, 6, 5, 6, 9, 8, 2, 8, 3, 10,
             16, 11, 14, 9, 11, 11, 7, 10, 11, 10, 4, 7, 4, 2, 5, 3, 2, 0, 3, 1, 1, 1, 0, 0, 2, 1, 1, 1, 0, 1, 1, 1, 2,
             1, 3, 8, 4, 4, 7, 4, 10, 4, 7, 9, 9, 10, 10, 5, 6, 2, 2, 1, 4, 3, 4, 2, 3, 0, 0, 5, 3, 4, 7, 3, 5, 2, 2, 3,
             3, 3, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 2, 1, 1, 3, 5, 4, 5, 11, 5, 4, 4, 5, 9, 9, 2, 4, 6, 2, 6, 2, 3,
             7, 5, 0, 7, 1, 6, 4, 1, 1, 9, 4, 4, 3, 2, 2, 3, 2, 3, 0, 5, 1, 1, 0, 0, 2, 0, 2, 0, 0, 3, 1, 2, 3, 6, 3,
             11, 9, 16, 14, 9, 18, 18, 22, 22, 19, 7, 8, 17, 8, 25, 18, 19, 20, 9, 18, 13, 14, 13, 3, 6, 12, 10, 18, 16,
             17, 10, 10, 11, 8, 4, 2, 4, 6, 4, 3, 4, 1, 2, 2, 0, 1, 0, 6, 3, 5, 0, 4, 3, 4, 3, 5, 4, 3, 2, 7, 2, 1, 1,
             2, 4, 1, 3, 4, 1, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 4, 0, 3, 3, 2, 4, 0, 1, 1, 1, 0, 1, 1, 3, 1, 3, 0, 1, 3, 4,
             5, 3, 2, 6, 3, 6, 9, 6, 11, 9, 13, 15, 9, 13, 17, 15, 19, 18, 20, 14, 11, 5, 6, 8, 7, 2, 2, 8, 5, 5, 2, 5,
             8, 3, 0, 3, 3, 2, 2, 5, 8, 3, 5, 1, 1, 3, 0, 1, 0, 1, 1, 0, 2, 0, 0, 1, 1, 0, 3, 4, 3, 0, 6, 6, 9, 7, 15,
             28, 48, 40, 19, 18, 18, 20, 14, 13, 6, 1, 0, 0, 0, 0, 0, 1, 17, 10, 8, 12, 10, 5, 13, 10, 5, 4, 11, 4, 1,
             5, 1, 1, 0, 2, 4, 1, 2, 2, 1, 1, 0, 7, 3, 2, 4, 11, 3, 3, 0, 4, 3, 7, 11, 7, 3, 6, 2, 2, 4, 1, 4, 2, 2, 2,
             0, 0, 0};

    static final double[] vec3 =
            {1, 20, 63, 45, 29, 38, 25, 14, 11, 11, 4, 9, 4, 13, 10, 10, 11, 6, 15, 14, 22, 9, 12, 9, 10, 8, 6, 7, 7, 7,
             15, 16, 27, 14, 26, 10, 32, 39, 43, 29, 30, 45, 17, 10, 12, 79, 79, 71, 51, 76, 80, 54, 64, 78, 122, 102,
             99, 101, 88, 89, 82, 57, 46, 42, 36, 22, 24, 18, 8, 18, 7, 15, 13, 5, 11, 8, 12, 12, 17, 11, 16, 16, 23,
             34, 26, 19, 22, 15, 17, 7, 16, 13, 7, 16, 6, 16, 13, 21, 23, 13, 24, 14, 13, 11, 4, 12, 23, 16, 21, 14, 12,
             16, 9, 17, 13, 6, 7, 7, 4, 7, 5, 2, 6, 3, 6, 6, 5, 3, 6, 11, 15, 17, 13, 13, 18, 29, 39, 43, 61, 43, 59,
             64, 59, 42, 45, 63, 60, 37, 29, 35, 36, 35, 35, 34, 28, 29, 22, 28, 44, 29, 24, 18, 19, 14, 16, 22, 6, 11,
             8, 9, 10, 5, 0, 5, 3, 7, 7, 6, 3, 5, 2, 5, 9, 8, 9, 17, 19, 24, 13, 10, 27, 28, 23, 21, 23, 22, 13, 19, 20,
             24, 17, 30, 30, 43, 43, 36, 30, 50, 50, 47, 41, 38, 37, 39, 30, 29, 10, 23, 18, 9, 6, 10, 10, 5, 13, 3, 11,
             7, 9, 9, 10, 10, 8, 9, 20, 9, 23, 25, 45, 51, 76, 90, 138, 95, 97, 77, 89, 110, 77, 72, 71, 3, 0, 45, 136,
             132, 79, 133, 97, 82, 79, 35, 40, 45, 33, 26, 27, 32, 33, 27, 33, 20, 24, 21, 12, 12, 7, 11, 2, 11, 6, 13,
             7, 5, 6, 4, 7, 13, 10, 25, 23, 40, 28, 64, 72, 77, 147, 190, 243, 290, 247, 218, 182, 184, 196, 184, 176,
             175, 142, 109, 98, 71, 45, 62, 49, 73, 47, 27, 30, 26, 17, 17, 34, 28, 25, 20, 15, 11, 11, 17, 15, 12, 9,
             10, 8, 16, 16, 13, 15, 19, 12, 18, 14, 21, 11, 16, 16, 13, 12, 8, 18, 15, 17, 15, 16, 13, 13, 11, 12, 17,
             13, 11, 8, 8, 2, 1, 3, 9, 11, 9, 11, 11, 12, 9, 5, 6, 8, 6, 9, 10, 7, 20, 9, 10, 11, 10, 12, 11, 9, 22, 14,
             25, 18, 21, 36, 43, 41, 51, 55, 52, 58, 43, 46, 69, 72, 27, 37, 44, 37, 53, 31, 63, 62, 68, 43, 59, 70, 41,
             40, 61, 69, 54, 71, 90, 58, 76, 30, 35, 38, 38, 36, 33, 34, 33, 37, 27, 34, 41, 37, 43, 48, 58, 48, 66, 95,
             121, 158, 142, 188, 223, 144, 169, 148, 132, 139, 139, 127, 99, 88, 76, 60, 47, 36, 48, 55, 39, 49, 44, 31,
             21, 28, 47, 42, 43, 31, 47, 25, 15, 24, 26, 13, 7, 4, 3, 12, 8, 10, 20, 10, 10, 6, 12, 11, 24, 23, 17, 21,
             26, 53, 47, 66, 92, 84, 69, 68, 64, 62, 95, 67, 87, 75, 91, 108, 100, 99, 164, 137, 125, 96, 119, 100, 78,
             47, 77, 61, 70, 66, 53, 69, 48, 33, 49, 49, 45, 53, 24, 32, 32, 14, 18, 18, 12, 17, 11, 10, 29, 26, 24, 40,
             35, 50, 58, 71, 103, 95, 131, 160, 123, 139, 128, 146, 143, 152, 142, 132, 118, 163, 130, 130, 100, 117,
             109, 62, 72, 52, 37, 37, 27, 33, 28, 20, 25, 21, 14, 13, 7, 5, 9, 12, 7, 17, 5, 8, 9, 9, 10, 9, 17, 7, 18,
             15, 24, 29, 20, 44, 55, 54, 68, 68, 59, 94, 83, 86, 60, 50, 53, 27, 40, 48, 75, 62, 74, 80, 67, 69, 51, 27,
             43, 82, 55, 56, 58, 54, 63, 33, 41, 36, 33, 42, 30, 18, 30, 26, 26, 23, 22, 15, 20, 25, 28, 37, 39, 32, 57,
             55, 67, 57, 76, 111, 117, 131, 113, 133, 124, 123, 97, 104, 72, 72, 77, 31, 34, 47, 53, 54, 47, 46, 22, 13,
             15, 55, 62, 77, 42, 65, 40, 43, 51, 44, 32, 37, 34, 21, 32, 28, 24, 14, 12, 19, 10, 11, 20, 15, 17, 30, 35,
             47, 50, 53, 54, 44, 29, 23, 49, 52, 60, 44, 54, 62, 37, 70, 40, 36, 47, 57, 33, 52, 41, 51, 39, 25, 19, 33,
             43, 33, 51, 56, 40, 49, 45, 53, 40, 30, 33, 17, 9, 9, 13, 10, 15, 14, 10, 12, 13, 17, 40, 28, 56, 119, 156,
             201, 190, 172, 223, 176, 176, 232, 239, 151, 125, 140, 128, 152, 141, 173, 128, 112, 118, 99, 107, 91, 47,
             41, 57, 133, 166, 144, 146, 141, 114, 122, 85, 49, 52, 40, 49, 43, 37, 45, 46, 44, 59, 25, 46, 48, 43, 65,
             56, 54, 93, 58, 62, 65, 84, 66, 76, 104, 52, 56, 44, 66, 51, 66, 49, 39, 67, 65, 50, 59, 36, 0, 0, 0, 0, 0,
             0, 2, 89, 40, 54, 60, 60, 41, 35, 41, 27, 52, 32, 32, 18, 25, 52, 29, 19, 14, 34, 25, 39, 27, 67, 83, 66,
             77, 106, 85, 87, 134, 173, 162, 203, 249, 283, 193, 225, 184, 174, 158, 146, 130, 101, 121, 60, 61, 99,
             103, 117, 87, 64, 91, 143, 156, 111, 96, 110, 106, 87, 88, 98, 53, 55, 47, 50, 55, 49, 34, 17, 30, 35, 40,
             54, 33, 21, 15, 28, 30, 41, 64, 54, 12, 208, 183, 253, 329, 326, 453, 484, 322, 287, 280, 240, 172, 156,
             130, 103, 31, 0, 0, 0, 0, 0, 17, 162, 112, 118, 110, 111, 104, 123, 141, 111, 74, 102, 74, 69, 68, 51, 52,
             53, 43, 45, 42, 52, 41, 48, 34, 50, 70, 57, 72, 104, 87, 90, 100, 117, 113, 117, 158, 137, 132, 94, 117,
             103, 71, 82, 95, 113, 92, 64, 70, 39, 10, 4};

    static final double[] v1 =
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.223961955, 1, 1, 1, 0.162730529, 0.042141289, 0.083394673, 0.162730529, 0.312824207, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 0.021228997, 0.003695378, 0.173463075, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.241205824, 1,
             0.184625946, 0.359496268, 1, 1, 1, 1, 1, 1, 1, 0.247474628, 0.497461319, 1, 1, 1, 1, 0.267909959, 1,
             0.196035406, 0.385682607, 1, 1, 1, 1, 1, 1, 0.20960415, 0.437773129, 0.184625946, 0.399422043, 1, 1, 1,
             0.196035406, 0.385682607, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.196035406, 0.066972109, 0.152881939, 0.312824207, 1,
             1, 1, 1, 1, 1, 1, 0.196035406, 0.385682607, 1, 0.196035406, 0.367468007, 1, 1, 1, 1, 0.184625946,
             0.349253407, 1, 1, 1, 1, 1, 0.025426189, 0.066972109, 0.017814154, 0.056522782, 0.015912238, 0.048375446,
             0.124290287, 0.288695811, 1, 1, 1, 1, 1, 1, 1, 1, 0.20960415, 0.077582073, 0.173463075, 0.367468007,
             0.357431061, 1, 0.482858456, 1, 0.482858456, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 0.089259921, 1, 1, 1, 1, 1, 0.223961955, 1, 1, 1, 1, 0.345622753, 0.011884412,
             1.00E-05, 1.00E-05, 0.073826209, 0.095860925, 0.267849587, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.353257103, 1, 1, 1, 1, 1, 1, 1, 0.353257103, 0.227597027, 1,
             0.056296707, 0.034018114, 0.140116214, 0.431512298, 1, 1, 0.019624032, 3.66E-05, 0.274983847, 0.283505773,
             0.175773034, 0.099991054, 0.03745427, 0.044279411, 0.145275069, 0.188410825, 1, 1, 1, 1, 1, 1, 0.301432854,
             0.385812273, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1.63E-02, 0.001837842, 0.011105426, 0.095265299, 1, 0.369221853, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.223961955,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.089259921, 1, 0.223961955, 0.204340575,
             0.187506146, 0.063988768, 0.085347568, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.48131775, 1, 1, 0.145046653,
             0.43277546, 1, 0.118109426, 0.319252937, 1, 1, 1, 1, 0.446141193, 1, 1, 1, 0.388896972, 1, 0.360107285,
             0.051780403, 0.143524611, 0.013226711, 0.008526116, 0.035942798, 0.005125867, 0.258298437, 0.01264411,
             0.011946516, 0.011306261, 0.049770528, 0.058114371, 0.191798189, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.242560881, 0.313816249, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.331627053, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.234544706, 0.087708885, 0.205829096, 0.453062783, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.162730529, 1, 1, 1, 1, 1, 0.045699514, 0.320890066, 4.63E-03, 0.462634189, 0.395497731, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 0.188595792, 0.41301154, 0.325138655, 0.284469205, 1, 1, 1, 1, 0.462657631, 1, 0.164201305,
             0.425310906, 1, 1, 0.190866626, 0.188756923, 1, 1, 1, 1, 0.425937029, 1, 1, 0.129907507, 0.003225802,
             0.075631281, 0.069944587, 0.079449434, 0.267314192, 0.310535067, 0.136109105, 0.149511127, 0.468877757, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.162730529, 0.042141289, 0.223961955, 0.367468007, 1, 1, 1, 0.023188557, 0.057602558, 0.013316265,
             0.042141289, 0.11077798, 0.263507785, 0.114381455, 0.270562953, 1, 0.013171171, 0.000579809, 0.059074189,
             0.189554764, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.402779051, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.491526137,
             1, 1, 1.18E-04, 0.279289437, 1.00E-05, 0.111309262, 0.00741207, 0.016608581, 0.000578318, 0.009341284,
             0.004497234, 0.03353928, 0.000787059, 0.169687306, 0.209984572, 0.402398392, 0.437475657, 0.230492417,
             0.3591834, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.286108738, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.173463075, 0.003695378, 0.173463075, 0.312824207,
             1, 1, 1, 0.186820767, 0.021094382, 0.010642544, 0.045187916, 1, 1, 1, 1, 1, 1, 1, 0.30951234, 0.19168642,
             0.021578516, 0.011115443, 0.040239809, 0.122218419, 0.372513618, 0.390198545, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 0.163975168, 1, 0.400145549, 0.134749509, 0.434501754, 0.487241063, 1, 1, 1, 0.041790578,
             0.039821886, 0.149624572, 0.071363738, 0.030249863, 0.039148538, 0.055097597, 0.082067651, 0.290884664,
             0.387278281, 1, 1, 1, 1, 1, 1, 1, 0.227903482, 0.092923496, 0.113791279, 0.148322758, 1, 1, 1, 0.087160867,
             0.115124236, 0.148505829, 0.20805348, 0.034778546, 0.173195375, 1, 1, 1, 1, 0.271178784, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.376062907, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.184625946, 0.349253407, 0.126532184, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.173463075, 0.312824207, 1, 1,
             1, 0.173463075, 0.312824207, 1, 0.184625946, 0.057602558, 0.126532184, 0.002710757, 0.002849458, 1.22E-04,
             0.2823691, 0.01601488, 2.53E-05, 9.01E-05, 1.10E-03, 0.062416387, 0.058245861, 0.006168333, 0.233149115,
             0.162017762, 0.291173052, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 0.321756656, 0.453514684, 1, 1, 1, 1, 1, 1, 0.16712739, 0.044918289, 0.047745009,
             0.050808586, 0.058004937, 7.14E-05, 0.004317979, 1.40E-05, 0.004777599, 0.079147602, 0.047105324,
             0.036197756, 0.111687466, 0.247627176, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.277763128, 1, 1, 1, 1, 1, 1, 1, 1,
             0.441918053, 1, 1, 1, 1, 0.389882542, 0.439615482, 1, 1, 1, 1, 1, 0.49580186, 1, 1, 1, 0.399672912,
             0.340804818, 0.005628772, 0.027375484, 0.157240247, 1, 0.153755085, 0.164182396, 0.315563508, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    static final double[] v2 =
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.229613835,
             0.362097524, 1, 0.257517289, 1, 0.226968522, 0.163165483, 0.025919807, 0.000252416, 0.033345795,
             0.000217963, 0.156156573, 0.278169672, 0.495224834, 0.047851301, 0.006061599, 0.042502633, 0.041942854,
             0.00574529, 0.015795028, 0.00046338, 0.077101684, 0.012859455, 0.000637638, 0.003385987, 0.011360738,
             0.00330513, 0.045355113, 0.017302454, 0.006596385, 0.14266002, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.449708942, 1, 1, 1, 0.324608034, 0.205403811,
             0.220543927, 0.47236568, 1, 1, 1, 1, 1, 1, 1, 0.166178621, 0.227157051, 1, 0.187697658, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.225992374, 0.365416657, 0.058123774, 0.01727646, 0.013722231, 0.004448778,
             0.017700016, 0.055870039, 0.003715568, 1.13E-04, 0.001013811, 5.90E-05, 0.002205477, 0.009260689,
             0.011741657, 0.004861135, 0.052312821, 0.020075545, 0.00313898, 0.120443021, 0.11962552, 0.291266986,
             0.263884705, 0.313713531, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 0.233915665, 0.098684219, 0.003762365, 0.080688368, 0.025601947, 0.00319085, 0.08289398,
             0.302026183, 0.088462808, 0.043398003, 0.000709008, 0.095961652, 0.001295189, 0.192213574, 0.045093279,
             0.070276117, 0.036821143, 0.020476277, 0.002710893, 0.005003588, 0.256201187, 0.08773459, 0.006177913,
             1.58E-04, 0.003487237, 0.174730512, 0.349676702, 0.163729797, 0.155938797, 0.150663385, 0.087869682,
             0.489017461, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.28127255, 0.309098343,
             0.094867486, 1.67E-04, 0.002637654, 0.02636146, 0.013258972, 0.007143374, 0.003958726, 0.060568762,
             0.021724535, 0.013296093, 0.078267533, 0.325198778, 1, 0.171636364, 0.02011839, 0.002105526, 0.021885916,
             0.024654158, 0.061892808, 0.216409317, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 0.351824798, 1, 1, 0.122441545, 0.015025798, 1.00E-05, 3.04E-05, 1.00E-05, 1.00E-05,
             1.00E-05, 0.003649578, 0.024003766, 0.002261158, 0.040321697, 0.074609561, 0.060190002, 0.032501283,
             0.043662739, 0.116788213, 0.162370768, 0.253635342, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.309930437, 1, 1, 1, 0.233034855,
             0.422938514, 0.191854318, 0.188575763, 1, 1, 1, 1, 1, 1, 1, 1, 0.360867907, 1, 0.351806708, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.026749311, 0.017413454, 0.072279032, 0.002535053, 9.16E-05,
             4.31E-04, 1.00E-05, 0.000517356, 0.001229657, 0.016385354, 9.02E-05, 1.42E-04, 0.033510229, 0.002123893,
             0.013849984, 0.000401687, 0.099802166, 0.247266491, 0.230730379, 0.321856148, 0.372586851, 0.464644889,
             0.320936202, 0.282312215, 0.041046588, 0.136586422, 0.236999147, 0.190823669, 0.097538972, 0.376474707, 1,
             0.368290515, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.200047064, 0.140117585,
             0.020747979, 0.001628981, 0.007576436, 0.012246734, 0.000745025, 0.018009803, 0.003257635, 0.05261866,
             0.059060367, 0.092158571, 0.086300153, 0.108860553, 0.212356337, 1, 1, 0.390132694, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.496361923, 1, 1, 0.395231091, 1,
             0.369959033, 1, 0.080822649, 0.001743372, 6.67E-05, 4.10E-04, 0.165182844, 0.19501525, 0.107774063,
             0.031242755, 0.000642759, 0.026791749, 0.003664978, 0.008650323, 0.006487185, 0.002253634, 0.030795186,
             0.008851255, 4.20E-05, 1.76E-05, 0.001395753, 0.020885395, 0.009707503, 0.019108494, 0.015596734,
             0.03232164, 0.089366943, 0.073885433, 0.145843461, 0.272088373, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.146871553, 0.07581864, 0.035495494, 0.00073674, 0.034709263,
             0.003541126, 0.001783088, 1.85E-04, 0.013179481, 0.001592864, 0.003262076, 0.016675687, 0.003439662,
             0.005271526, 0.01661715, 0.001292259, 0.031130733, 0.038740145, 0.047152791, 0.227809923, 0.338740158, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.274760462, 0.399682635,
             0.297000444, 0.413139356, 0.071793058, 9.36E-05, 0.030604144, 0.002017244, 0.009174799, 0.000195404,
             0.033113224, 0.020192914, 0.009102957, 0.00080588, 0.025228152, 0.06867227, 0.024505805, 0.054586638,
             0.009568934, 9.56E-05, 0.014343809, 0.000402154, 0.055721757, 0.018960168, 0.007174295, 0.1172827,
             0.081734184, 0.046147152, 0.033976132, 0.145111907, 0.263958265, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 0.272611882, 0.32602618, 0.372235946, 0.18588233, 0.179519816, 0.004335913,
             0.075981423, 0.009150531, 0.000351861, 0.008222842, 0.006070799, 0.009248749, 0.00863315, 0.006780806,
             0.235980225, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.412126426, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 0.467847409, 0.170488042, 0.088499935, 0.023862509, 6.49E-05, 0.026341326,
             0.015472721, 0.014182074, 0.006900216, 0.006080023, 0.005592006, 0.186509527, 0.20436791, 0.134836924,
             0.289876683, 0.196361586, 0.42793915, 1, 0.289697905, 0.295450502, 1, 0.31138862, 1, 0.392592142, 1, 1, 1,
             0.181498228, 0.305221005, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.207826974,
             0.233011468, 0.003370585, 0.003037342, 4.66E-05, 0.00045637, 0.013698753, 8.66E-05, 0.001900358, 5.03E-04,
             0.001818995, 0.008193933, 0.11655422, 0.145921353, 0.063332466, 0.091132396, 0.009643129, 0.002833737,
             0.030905425, 0.009692544, 0.022271877, 0.012900609, 0.019564925, 0.025428155, 0.042250194, 0.229136645, 1,
             1, 1, 0.391053784, 0.419641549, 0.392420131, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 0.431633231, 1, 1, 1, 1, 0.491434748, 1, 1, 0.470106086, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 0.425756385, 1, 1, 1, 1, 0.389882542, 1, 1, 1, 1, 1, 1, 1, 0.420534057, 1, 0.409784792, 1, 1,
             0.38950597, 0.150913969, 0.019404514, 0.011792982, 0.020035974, 0.000859654, 0.077234096, 0.005707103,
             0.00068603, 0.01101462, 4.81E-05, 0.004438858, 2.35E-04, 3.84E-04, 0.016601829, 0.000536317, 0.003062709,
             0.007333867, 0.002864055, 0.007322409, 0.006053423, 0.036407354, 0.029556365, 0.082293892, 0.18091025,
             0.294414395, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 0.404008297, 0.463601731, 1, 0.184551164, 0.038549871, 0.000380124, 0.009830006, 1.00E-05,
             1.00E-05, 1.00E-05, 1.00E-05, 0.007671798, 0.040992422, 0.024289276, 0.011996082, 0.011915823, 0.014161074,
             0.035557935, 0.121175769, 0.357723995, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.266128433, 1, 1, 1, 1, 1, 0.357310554, 0.096503355, 0.048053018,
             0.089666448, 0.068088409, 0.173961013, 0.372994347, 0.483456842, 1, 1, 1, 1, 1, 1, 1, 1};

    static final double[] v3 =
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.366453876, 1, 0.179831776, 0.353269468, 0.01635638, 6.46E-05, 9.76E-05, 0.009356081, 0.001002967,
             0.004084089, 0.124842188, 0.31829784, 1, 0.002805782, 1.20E-04, 2.63E-04, 0.018543819, 0.000628569,
             0.007573441, 0.039055206, 0.01097502, 0.001395713, 0.001766857, 0.007012072, 0.010099313, 0.00103594,
             0.034720274, 0.012963443, 0.007248382, 0.130237823, 0.262821146, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.336464404, 0.17464204, 0.326700537,
             0.152136796, 0.279328871, 1, 1, 1, 1, 0.306049219, 0.450227029, 0.359121433, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.389476227, 0.20597202, 0.182899386, 0.165423948, 0.068864278,
             0.001677687, 1.51E-04, 6.88E-05, 1.00E-05, 0.000870035, 2.34E-04, 0.001406321, 0.004352013, 0.030284672,
             0.009538453, 0.000767231, 0.019403437, 0.015257032, 0.022178142, 0.026088393, 0.030636815, 0.038771604,
             0.051276309, 0.073857497, 0.143623818, 0.262965221, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.431823989, 0.250177433, 0.323326989, 1, 0.097939648, 0.006270404,
             0.013233562, 0.00279167, 0.025053425, 0.007446194, 0.110059973, 0.070385332, 0.041283775, 0.012469763,
             0.011392404, 0.001083934, 0.017646306, 0.000160485, 0.002732415, 0.010551818, 0.003431633, 0.004822785,
             0.006100781, 0.008657411, 0.001634194, 0.044174841, 0.025986895, 0.013170736, 0.019284147, 0.033350244,
             0.27339221, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.16211293, 0.016985571,
             5.00E-05, 6.89E-05, 1.00E-05, 2.77E-04, 0.00156242, 0.023229387, 0.003691622, 0.01176744, 0.004497015,
             0.054485723, 0.038357414, 0.16075757, 1, 1, 0.114185117, 0.018519398, 0.012088017, 0.001436518,
             0.056812851, 0.053163268, 0.060307787, 0.18503436, 0.466614459, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.184672444, 0.142014096, 0.001637627, 1.60E-04, 9.39E-05,
             1.00E-05, 1.00E-05, 1.00E-05, 1.00E-05, 1.68E-04, 0.004126629, 0.021961788, 0.006025447, 0.031033636,
             0.011882918, 0.005703104, 0.054981523, 0.051862085, 0.075507311, 0.126938028, 0.271569222, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 0.367286439, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.105439049,
             0.198183254, 0.272771405, 0.31450604, 0.411247202, 0.365667982, 0.381766814, 1, 0.042823525, 0.015262137,
             7.48E-05, 0.016406642, 0.000666329, 1.74E-04, 6.98E-05, 9.18E-05, 9.00E-05, 2.19E-04, 0.0014849,
             0.002155643, 0.021679206, 0.004367879, 0.00559256, 0.005165124, 0.121307606, 0.113014044, 0.087208456,
             0.096782179, 0.049124056, 0.083802961, 0.024634035, 0.006961505, 0.021085472, 0.024884914, 0.011243343,
             0.002348516, 0.144701771, 0.257738465, 0.17382771, 0.071965285, 0.07255595, 0.021226006, 0.000586987,
             0.084731929, 0.018638532, 0.1760278, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.492012337, 1, 0.308821316,
             0.030024149, 9.49E-05, 4.49E-05, 1.42E-04, 7.44E-05, 9.43E-05, 0.008409883, 0.000322092, 0.029409092,
             0.013232105, 0.005867898, 0.050417688, 0.036216139, 0.047294883, 0.079800532, 0.16117114, 0.381243702, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.08743157, 0.013500082, 0.000127083, 1.56E-04, 3.82E-04, 0.004708147, 0.013023789, 0.002660058,
             0.032169203, 0.001710043, 0.033674737, 0.004466575, 0.034084802, 0.006147358, 0.011705501, 0.001422585,
             0.02231233, 0.000187557, 0.007636956, 0.014091768, 0.007805097, 0.035318403, 0.024788011, 0.036384658,
             0.127897632, 0.202472566, 0.468281039, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 0.361883037, 0.136442357, 0.005288298, 0.003613811, 1.75E-04, 9.66E-05, 0.001947341, 0.002792189,
             0.011748616, 0.000551081, 0.013839702, 0.001187983, 0.022868378, 0.007300914, 0.054658712, 0.01266697,
             0.0064995, 0.055510921, 0.066920475, 0.062731187, 0.073542184, 0.203355269, 0.451135807, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.11323096, 1.40E-03, 5.60E-04,
             1.10E-04, 5.41E-04, 0.004134935, 2.97E-04, 0.002728237, 0.003259704, 0.032630393, 0.021270107, 0.014431151,
             0.033924011, 0.046594896, 0.049337543, 0.016627645, 0.00949214, 0.002929281, 0.031964607, 0.019031148,
             0.010987912, 0.017816903, 0.086238808, 0.189634712, 0.095651563, 0.144226375, 0.209647135, 0.298805149, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.33466134, 0.23178077, 0.062563646,
             0.027765214, 0.002213324, 5.49E-04, 1.35E-04, 9.42E-05, 0.00224367, 0.001777418, 0.007618072, 0.010958946,
             0.003868873, 0.039144563, 0.045816713, 0.057286089, 0.066293994, 0.22263952, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.378846828, 0.257735797,
             0.144327537, 0.076082456, 0.073316935, 0.158327312, 0.397839672, 0.265184362, 0.132779451, 0.023715653,
             0.014179807, 0.003305458, 0.016209219, 0.019967949, 0.001235903, 0.10051202, 0.141670333, 0.123419009,
             0.061304561, 0.120908999, 0.085112517, 0.120131347, 0.097935812, 0.16768439, 1, 1, 1, 1, 1, 0.475392883,
             0.329654908, 1, 1, 1, 0.391378559, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.477829296, 1, 0.189656956,
             1.77E-04, 1.00E-05, 1.00E-05, 4.23E-05, 0.000644969, 0.000771999, 0.009390564, 0.000710964, 0.007235629,
             0.008000316, 0.046016728, 0.039878141, 0.032211769, 0.032325173, 0.023901919, 0.021759471, 0.012683922,
             0.016190987, 0.027315772, 0.044464501, 0.093812773, 0.173022778, 0.370307768, 1, 1, 1, 1, 0.480296846, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.32334515, 1, 1, 1,
             1, 1, 0.456600948, 1, 1, 0.467140956, 0.485697596, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.187332586, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.20776174, 0.030318851, 0.007604671, 0.015697612,
             0.000195981, 0.014184996, 0.001495696, 0.001424279, 1.30E-04, 1.89E-04, 1.23E-04, 1.25E-04, 1.14E-04,
             0.007621728, 0.007983828, 0.032848674, 0.013910084, 0.008999911, 0.007767652, 0.104734539, 0.175664252,
             0.245129399, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             1, 1, 1, 1, 1, 1, 1, 0.020088171, 0.000166948, 4.80E-05, 4.52E-05, 8.74E-05, 4.80E-05, 1.07E-04,
             0.006851491, 0.02435114, 0.009061547, 0.005740662, 0.107893114, 0.149265307, 0.249534542, 0.467115395, 1,
             1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
             0.391458529, 0.474392833, 1, 0.389090255, 0.193886308, 0.09085389, 0.030969197, 0.000992641, 0.013745851,
             0.001565174, 0.078961579, 0.033751352, 0.025149745, 0.055907461, 0.085839999, 0.092343956, 0.058802742,
             0.072304845, 0.19416021, 0.410625523, 1, 1, 1};

    private CusumSagesDetector detector;

    @Override
    protected void setUp() throws Exception {
        detector = new CusumSagesDetector();
    }

    @Override
    protected void tearDown() throws Exception {
        detector = null;
    }

    public void testCusumDetector() {
        double data[], dataReal[];
        TemporalDetectorDataInterface tddo = new TemporalDetectorSimpleDataObject();
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("M/d/yyyy");
        Date startDate = null;
        try {
            startDate = inputDateFormat.parse("1/10/2007");
        } catch (ParseException e) {
            e.printStackTrace();
        }
//
        System.out.println("Testing Cusum detector");
        data = vec1;
        dataReal = v1;
        tddo.setCounts(data);
        tddo.setStartDate(startDate);
        detector.testDetector(tddo);
        for (int i = 0; i < tddo.getLevels().length; i++) {
            assertEquals(dataReal[i], tddo.getLevels()[i], .0001);
        }
        data = vec2;
        dataReal = v2;
        tddo.setCounts(data);
        tddo.setStartDate(startDate);
        detector.testDetector(tddo);
        for (int i = 0; i < tddo.getLevels().length; i++) {
            assertEquals(dataReal[i], tddo.getLevels()[i], .0001);
        }
        data = vec3;
        dataReal = v3;
        tddo.setCounts(data);
        tddo.setStartDate(startDate);
        detector.testDetector(tddo);
        for (int i = 0; i < tddo.getLevels().length; i++) {
            assertEquals(dataReal[i], tddo.getLevels()[i], .0001);
        }
    }
}
