/*
 * Copyright 2006 Robert Hanson <iamroberthanson AT gmail.com>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gwtwidgets.test.client.util;

import java.util.Date;
import org.gwtwidgets.client.util.SimpleDateFormat;
import org.gwtwidgets.test.client.TestBase;

public class SimpleDateFormatTest extends TestBase
{

    public void testMonthDigits ()
    {
        SimpleDateFormat mFormat = new SimpleDateFormat("M");
        SimpleDateFormat mmFormat = new SimpleDateFormat("MM");

        assertEquals("1", mFormat.format(new Date(2006, 0, 1)));
        assertEquals("01", mmFormat.format(new Date(2006, 0, 1)));

        assertEquals("9", mFormat.format(new Date(2006, 8, 1)));
        assertEquals("09", mmFormat.format(new Date(2006, 8, 1)));

        assertEquals("10", mFormat.format(new Date(2006, 9, 1)));
        assertEquals("10", mmFormat.format(new Date(2006, 9, 1)));

        assertEquals("12", mFormat.format(new Date(2006, 11, 1)));
        assertEquals("12", mmFormat.format(new Date(2006, 11, 1)));
    }
    
}
