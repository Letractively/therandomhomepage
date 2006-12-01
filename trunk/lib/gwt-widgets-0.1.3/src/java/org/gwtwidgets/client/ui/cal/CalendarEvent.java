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

/**
 * Bean class to hold information about an event.
 * 
 * @author rhanson
 */
public class CalendarEvent
{
    private String title = "";
    private Date start;
    private Date end;
    private boolean timeSignificant;



    CalendarEvent (Date date, boolean timeSignificant)
    {
        this.start = date;
        this.end = date;
        this.timeSignificant = timeSignificant;
    }

    CalendarEvent (Date start, Date end, boolean timeSignificant)
    {
        this.start = start;
        this.end = end;
        this.timeSignificant = timeSignificant;
    }

    public Date getEnd ()
    {
        return end;
    }

    public Date getStart ()
    {
        return start;
    }

    public boolean isTimeSignificant ()
    {
        return timeSignificant;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }
}
