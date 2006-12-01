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

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * A bean to hold the state of a given calendar month.
 * 
 * @author rhanson
 */
public class CalendarMonth
{
    private int month;
    private int year;
    private int days;
    private int firstDay;
    private Vector events = new Vector();



    CalendarMonth (int month, int year)
    {
        this.month = month;
        this.year = year;
        this.days = CalendarFactory.getNumberOfDays(month, year);
        this.firstDay = getFirstDay(month, year);
    }

    private static int getFirstDay (int month, int year)
    {
        Date thisMonth = new Date(year, month, 1);
        return thisMonth.getDay();
    }

    public int getDays ()
    {
        return days;
    }

    public int getMonth ()
    {
        return month;
    }

    public int getYear ()
    {
        return year;
    }

    public int getFirstDay ()
    {
        return firstDay;
    }

    public List getEvents ()
    {
        return new ArrayList(events);
    }

    void addEvent (CalendarEvent event)
    {
        events.add(event);
    }

    void removeEvent (CalendarEvent event)
    {
        events.remove(event);
    }

    public boolean hasEvent (int date)
    {
        for (Iterator i = events.iterator(); i.hasNext();) {
            CalendarEvent event = (CalendarEvent) i.next();

            long checkDateEarly = new Date(getYear() - 1900, getMonth(), date, 0, 0, 0).getTime();
            long checkDateLate = new Date(getYear() - 1900, getMonth(), date, 23, 59, 59).getTime();
            long eStart = event.getStart().getTime();
            long eEnd = event.getEnd().getTime();
            
            if (eStart <= checkDateLate && eEnd >= checkDateEarly) {
                return true;
            }
        }

        return false;
    }

    public List getEvents (int date)
    {
        ArrayList results = new ArrayList();
        
        for (Iterator i = events.iterator(); i.hasNext();) {
            CalendarEvent event = (CalendarEvent) i.next();

            long checkDateEarly = new Date(getYear() - 1900, getMonth(), date, 0, 0, 0).getTime();
            long checkDateLate = new Date(getYear() - 1900, getMonth(), date, 23, 59, 59).getTime();
            long eStart = event.getStart().getTime();
            long eEnd = event.getEnd().getTime();
            
            if (eStart <= checkDateLate && eEnd >= checkDateEarly) {
                results.add(event);
            }
        }

        return results;
    }
}
