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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * A calendar engine.  Allows for creation of CalendarMonth beans,
 * provides access to events, performs caching of data, manages
 * listeners, fires events, and provides utilities.  The class
 * is not a widget, and has no interface.
 * 
 * If you require two calendars with seperate event lists, you
 * should use two factory instances.
 * 
 * @author rhanson
 */
public class CalendarFactory
{
    private static final long DAY_IN_MILLISECONDS = 86400000;
    private HashMap cachedCalendars = new HashMap();
    private Vector clickListeners = new Vector();


    /**
     * Gets, caches, and returns a CalendarMonth object for
     * the requested month.  
     * 
     * @param month 0 - 11
     * @param year 4 digit year (e.g. 2006)
     * @return month object
     */
    public synchronized CalendarMonth getCalendar (int month, int year)
    {
        String key = month + "-" + year;
        CalendarMonth result = (CalendarMonth) cachedCalendars.get(key);

        if (result != null) {
            return result;
        }
        
        result = new CalendarMonth(month, year);
        cachedCalendars.put(key, result);
        
        return result;
    }

    /**
     * Gets, caches, and returns a CalendarMonth object for
     * the requested month.  
     * 
     * @param date date
     * @return month object
     */
    public CalendarMonth getCalendar (Date date)
    {
        return getCalendar(date.getMonth(), date.getYear() + 1900);
    }

    /**
     * Gets, caches, and returns a CalendarMonth object for
     * the current month.  
     * 
     * @return month object
     */
    public CalendarMonth getCurrentCalendar ()
    {
        Date now = new Date();
        return getCalendar(now.getMonth(), now.getYear() + 1900);
    }

    /**
     * Gets, caches, and returns a list of CalendarMonth objects
     * for the requested date range.  
     * 
     * @param start first month
     * @param end last month
     * @return list of month objects
     */
    public List getCalendars (Date start, Date end)
    {
        if (start.after(end)) {
            Date tmp = start;
            start = end;
            end = tmp;
        }

        ArrayList result = new ArrayList();
        CalendarMonth cm = getCalendar(start);
        result.add(cm);

        int c = 1;
        while (cm.getYear() != (end.getYear()+1900) || cm.getMonth() != end.getMonth()) {
            cm = getNextMonth(cm);
            result.add(cm);
            c++;
        }
        
        return result;
    }

    /**
     * Utility method to return the number of days in the specified month.
     *
     * @param month 0-11
     * @param year 4 digit year
     * @return number of days
     */
    public static int getNumberOfDays (int month, int year)
    {
        MonthYear my = getNextMonthValue(month, year);
        Date nextMonth = new Date(fixYear(my.year), my.month, 1);
        Date monthEnd = new Date(nextMonth.getTime() - DAY_IN_MILLISECONDS);
        return monthEnd.getDate();
    }

    private static int fixYear (int year)
    {
        return year - 1900;
    }

    private static MonthYear getNextMonthValue (int month, int year)
    {
        MonthYear result = new MonthYear();
        if (month == 11) {
            result.month = 0;
            result.year = year + 1;
        }
        else {
            result.month = month + 1;
            result.year = year;
        }
        return result;
    }

    private static MonthYear getPrevMonthValue (int month, int year)
    {
        MonthYear result = new MonthYear();
        if (month == 0) {
            result.month = 11;
            result.year = year - 1;
        }
        else {
            result.month = month - 1;
            result.year = year;
        }
        return result;
    }

    /**
     * Get the calendar object for the following month.
     * 
     * @param cal current month object
     * @return calendar object for the following month
     */
    public CalendarMonth getNextMonth (CalendarMonth cal)
    {
        MonthYear my = getNextMonthValue(cal.getMonth(), cal.getYear());
        return getCalendar(my.month, my.year);
    }

    /**
     * Get the calendar object for the following year
     * (current plus 12 months).
     * 
     * @param cal current month object
     * @return calendar object for the following year
     */
    public CalendarMonth getNextYear (CalendarMonth cal)
    {
        return getCalendar(cal.getMonth(), cal.getYear() + 1);
    }

    /**
     * Get the calendar object for the previous month.
     * 
     * @param cal current month object
     * @return calendar object for the previous month
     */
    public CalendarMonth getPrevMonth (CalendarMonth cal)
    {
        MonthYear my = getPrevMonthValue(cal.getMonth(), cal.getYear());
        return getCalendar(my.month, my.year);
    }

    /**
     * Get the calendar object for the previous year
     * (current minus 12 months).
     * 
     * @param cal current month object
     * @return calendar object for the previous year
     */
    public CalendarMonth getPrevYear (CalendarMonth cal)
    {
        return getCalendar(cal.getMonth(), cal.getYear() - 1);
    }

    private static class MonthYear
    {
        public int month;
        public int year;
    }

    /**
     * Creates a new event and registers it with the factory.
     * 
     * @param date date/time of the event
     * @param timeSignificant false for "all day" events (e.g. holiday)
     * @return the event registered
     */
    public CalendarEvent createEvent (Date date, boolean timeSignificant)
    {
        CalendarEvent result = new CalendarEvent(date, timeSignificant);
        CalendarMonth cal = getCalendar(date);
        cal.addEvent(result);
        return result;
    }

    /**
     * Creates a new event for a specified range
     * and registers it with the factory.
     * 
     * @param start start date/time of the event
     * @param end end date/time of the event
     * @param timeSignificant false for "all day" events (e.g. holiday)
     * @return the event registered
     */
    public CalendarEvent createEvent (Date start, Date end, boolean timeSignificant)
    {
        if (start.after(end)) {
            Date tmp = start;
            start = end;
            end = tmp;
        }
        
        CalendarEvent result = new CalendarEvent(start, end, timeSignificant);
        List cals = getCalendars(start, end);

        for (Iterator i = cals.iterator(); i.hasNext();) {
            CalendarMonth cal = (CalendarMonth) i.next();
            cal.addEvent(result);
        }
        return result;
    }


    /**
     * Removes an event from the factory and all cached months.
     * 
     * @param event event object
     */
    public void removeEvent (CalendarEvent event)
    {
        List cals = getCalendars(event.getStart(), event.getEnd());

        for (Iterator i = cals.iterator(); i.hasNext();) {
            CalendarMonth cal = (CalendarMonth) i.next();
            cal.removeEvent(event);
        }
    }


    /**
     * Add a listener for calendar events.  Events are NOT
     * triggered automatically.  You must call the appropriate
     * fire method to inform listeners.
     * 
     * @param listener calendar listener
     */
    public void addCalendarListener (CalendarListener listener)
    {
        clickListeners.add(listener);
    }

    /**
     * Remove a calendar listener.
     * 
     * @param listener calendar listener
     */
    public void removeCalendarListener (CalendarListener listener)
    {
        clickListeners.remove(listener);
    }

    
    /**
     * Inform registered listeners that a date was clicked.
     * 
     * @param date date object to pass to listeners
     */
    public void fireDateClick (CalendarDate date)
    {
        for (Iterator i = clickListeners.iterator(); i.hasNext();) {
            CalendarListener listener = (CalendarListener) i.next();
            listener.onDateClick(date);
        }
    }

    /**
     * Inform registered listeners that a event date was clicked.
     * 
     * @param date date object to pass to listeners
     */
    public void fireEventDateClick (CalendarDate date)
    {
        for (Iterator i = clickListeners.iterator(); i.hasNext();) {
            CalendarListener listener = (CalendarListener) i.next();
            boolean res = listener.onEventDateClick(date);
            if (res) {
                listener.onDateClick(date);
            }
        }
    }

    /**
     * Inform registered listeners that the month was changed.
     * 
     * @param month month object to pass to listeners
     */
    public void fireMonthChange (CalendarMonth month)
    {
        for (Iterator i = clickListeners.iterator(); i.hasNext();) {
            CalendarListener listener = (CalendarListener) i.next();
            listener.onMonthChange(month);
        }
    }

}
