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

package org.gwtwidgets.client.ui.cal;

import java.util.Date;
import java.util.List;


/**
 * Bean to hold information about a single day.
 * 
 * @author rhanson
 */
public class CalendarDate
{
    private Date date;
    private List events;



    CalendarDate (Date date, List events)
    {
        this.date = date;
        this.events = events;
    }

    public Date getDate ()
    {
        return date;
    }

    public List getCalendarEvents ()
    {
        return events;
    }

    public boolean hasEvents ()
    {
        return events.size() > 0;
    }
}
