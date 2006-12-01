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
import org.gwtwidgets.client.temp.TGrid;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SourcesClickEvents;
import com.google.gwt.user.client.ui.Widget;


/**
 * A simple plain calendar panel without controls.
 * 
 * Styles, one or more may apply to a given cell:
 * 
 * .calendar-panel { calendar grid }
 * .calendar-cell { each calendar cell }
 * .calendar-dateCell { cells with dates }
 * .calendar-eventCell { calls with events }
 * .calendar-headingCell { cells with weekday names }
 * .calendar-cellSunday { cells for Sunday }
 * .calendar-cellMonday { cells for Monday }
 * .calendar-cellTuesday { cells for Tuesday }
 * .calendar-cellWednesday { cells for Wednesday }
 * .calendar-cellThurday { cells for Thursday }
 * .calendar-cellFriday { cells for Friday}
 * .calendar-cellSatuday { cells for Saturday }
 *  
 * @author rhanson
 */
public class CalendarPanel extends TGrid
{
    public final int OFFSET_SUNDAY = 0;
    public final int OFFSET_MONDAY = 1;
    public final int OFFSET_TUESDAY = 2;
    public final int OFFSET_WEDNESDAY = 3;
    public final int OFFSET_THURSDAY = 4;
    public final int OFFSET_FRIDAY = 5;
    public final int OFFSET_SATURDAY = 6;
    
    private CalendarFactory factory = new CalendarFactory();
    private CalendarMonth cm;
    private String[] monthNames = new String[] { "January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December" };
    private String[] weekDayNames = new String[] { "S", "M", "T", "W", "T", "F", "S" };
    private int firstDayOffset = OFFSET_SUNDAY;


    public CalendarPanel ()
    {
        super(7, 7);
        
        cm = factory.getCurrentCalendar();
        setBorderWidth(1);
        setCellPadding(0);
        setCellSpacing(0);
        setStyleName("calendar-panel");
        fillCalendar();
    }

    /**
    * @param month 0 - 11
    * @param year 4 digit year (e.g. 2006)
    */
    public CalendarPanel (int month, int year)
    {
        super(7, 7);
        
        cm = factory.getCalendar(month, year);
        setBorderWidth(1);
        setCellPadding(0);
        setCellSpacing(0);
        setStyleName("calendar-panel");
        fillCalendar();
    }


    public CalendarPanel (Date date)
    {
        super(7, 7);
        
        cm = factory.getCalendar(date);
        setBorderWidth(1);
        setCellPadding(0);
        setCellSpacing(0);
        setStyleName("calendar-panel");
        fillCalendar();
    }


    /**
     * Change the calendar to a specific month and year
     * 
     * @param month 0 - 11
     * @param year 4 digit year (e.g. 2006)
     */
    public void setCalendarMonth (int month, int year)
    {
        cm = factory.getCalendar(month, year);
        redraw();
        factory.fireMonthChange(cm);
    }

    
    /**
     * Change the calendar to a specific date
     * 
     * @param date date object
     */
    public void setCalendarMonth (Date date)
    {
        cm = factory.getCalendar(date);
        redraw();
        factory.fireMonthChange(cm);
    }

    
    /**
     * Adds appropriate event handling for a previous 
     * year button/link.
     * 
     * @param source button or other widget that handles click events
     */
    public void addPrevYearActivator (SourcesClickEvents source)
    {
        source.addClickListener(new ClickListener()
        {
            public void onClick (Widget sender)
            {
                cm = factory.getPrevYear(cm);
                fillCalendar();
                factory.fireMonthChange(cm);
            }
        });
    }

    /**
     * Adds appropriate event handling for a next 
     * year button/link.
     * 
     * @param source button or other widget that handles click events
     */
    public void addNextYearActivator (SourcesClickEvents source)
    {
        source.addClickListener(new ClickListener()
        {
            public void onClick (Widget sender)
            {
                cm = factory.getNextYear(cm);
                fillCalendar();
                factory.fireMonthChange(cm);
            }
        });
    }

    /**
     * Adds appropriate event handling for a previous 
     * month button/link.
     * 
     * @param source button or other widget that handles click events
     */
    public void addPrevMonthActivator (SourcesClickEvents source)
    {
        source.addClickListener(new ClickListener()
        {
            public void onClick (Widget sender)
            {
                cm = factory.getPrevMonth(cm);
                fillCalendar();
                factory.fireMonthChange(cm);
            }
        });
    }

    /**
     * Adds appropriate event handling for a next 
     * month button/link.
     * 
     * @param source button or other widget that handles click events
     */
    public void addNextMonthActivator (SourcesClickEvents source)
    {
        source.addClickListener(new ClickListener()
        {
            public void onClick (Widget sender)
            {
                cm = factory.getNextMonth(cm);
                fillCalendar();
                factory.fireMonthChange(cm);
            }
        });
    }

    /**
     * Redraws the calendar.  In most cases this is not required,
     * but may be required after adding events.
     */
    public void redraw ()
    {
        fillCalendar();
    }
    
    private void fillCalendar ()
    {
        clear();

        for (int row = 0; row < getRowCount(); ++row) {
            for (int col = 0; col < getCellCount(row); ++col) {
                HTML contents = new HTML("&nbsp;");
                contents.setStyleName("calendar-cell");
                contents.addStyleName(getStylenameForDay(col + firstDayOffset));
                setWidget(row, col, contents);
            }
        }

        for (int col = 0 + firstDayOffset; col < (7 + firstDayOffset); col++) {
            int tCol = col < 7 ? col : col - 7;
            HTML contents = new HTML(weekDayNames[tCol]);
            contents.setStyleName("calendar-cell");
            contents.addStyleName("calendar-headingCell");
            contents.addStyleName(getStylenameForDay(tCol));
            setWidget(0, col - firstDayOffset, contents);
        }
        
        int firstDay = cm.getFirstDay() - firstDayOffset;
        firstDay = firstDay < 0 ? firstDay + 7 : firstDay;
        
        for (int d = 0; d < cm.getDays(); d++) {
            final int date = d + 1;
            final boolean hasEvents = cm.hasEvent(date);
            int row = (int) Math.floor((firstDay + d + 6) / 7) + (firstDay == 0 ? 1 : 0);
            int col = (firstDay + d + 6) % 7;
            HTML contents = new HTML(Integer.toString(date));
            contents.setStyleName("calendar-cell");
            contents.addStyleName("calendar-dateCell");
            contents.addStyleName(getStylenameForDay(col + firstDayOffset));
            if (hasEvents) {
                contents.addStyleName("calendar-eventCell");
            }
            contents.addClickListener(new ClickListener()
            {
                public void onClick (Widget sender)
                {
                    Date dateObj = new Date(cm.getYear() - 1900, cm.getMonth(), date, 0, 0, 0);
                    CalendarDate calDate = new CalendarDate(dateObj, cm.getEvents(date));

                    if (hasEvents) {
                        factory.fireEventDateClick(calDate);
                    }
                    else {
                        factory.fireDateClick(calDate);
                    }
                }
            });
            setWidget(row, col, contents);
        }
    }

    private String getStylenameForDay (int col)
    {
        if (col > 6) {
            col -= 7;
        };
        
        switch (col) {
            case 0:
                return "calendar-cellSunday";
            case 1:
                return "calendar-cellMonday";
            case 2:
                return "calendar-cellTuesday";
            case 3:
                return "calendar-cellWednesday";
            case 4:
                return "calendar-cellThursday";
            case 5:
                return "calendar-cellFriday";
            case 6:
                return "calendar-cellSaturday";
            default:
                break;
        }
        return "";
    }

    /**
     * Add a new event to the calendar and returns an event object.
     * 
     * @param date date/time of the event
     * @param timeSignificant false for "all day" events, like a holiday
     * @return the event created
     */
    public CalendarEvent addEvent (Date date, boolean timeSignificant)
    {
        return factory.createEvent(date, timeSignificant);
    }

    /**
     * Add a new event to the calendar that spans multiple days,
     * and returns an event object.
     * 
     * @param start start date/time of the event
     * @param end end date/time of the event
     * @param timeSignificant false for "all day" events, like a holiday
     * @return the event created
     */
    public CalendarEvent addEvent (Date start, Date end, boolean timeSignificant)
    {
        return factory.createEvent(start, end, timeSignificant);
    }

    /**
     * Removes an event from the calendar.
     * 
     * @param event event to be removed
     */
    public void removeEvent (CalendarEvent event)
    {
        factory.removeEvent(event);
    }

    /**
     * Add listener for calendar events.
     * 
     * @param listener
     */
    public void addCalendarListener (CalendarListener listener)
    {
        factory.addCalendarListener(listener);
    }

    /**
     * Remove a listener for calendar events.
     * 
     * @param listener
     */
    public void removeCalendarListener (CalendarListener listener)
    {
        factory.removeCalendarListener(listener);
    }

    /**
     * Get the current month number 0-11.
     * 
     * @return month number 0-11
     */
    public int getCurrentMonth ()
    {
        return cm.getMonth();
    }

    /**
     * Get the name of the current month.  A default set of
     * names uses full English names (January, February, etc.).
     * The list of available names may be changed using
     * the setMonthNames(String[]) method.
     * 
     * @return month name
     */
    public String getCurrentMonthName ()
    {
        return monthNames[cm.getMonth()];
    }

    /**
     * Get the current year.
     * 
     * @return current year
     */
    public String getCurrentYear ()
    {
        return Integer.toString(cm.getYear());
    }

    /**
     * Set the month names to be used.  You must
     * pass an array of 12 names or a RuntimeException
     * will be thrown.
     * 
     * @param inMonthNames array of 12 month names
     */
    public void setMonthNames (String[] inMonthNames)
    {
        if (inMonthNames.length != 12) {
            throw new RuntimeException("wrong number of month names");
        }
        this.monthNames = inMonthNames;
    }

    /**
     * Set the weekday names to be used.  These names
     * appear in the first row of the calendar.  The
     * default values are S, M, T, W, T, F, S.  You must
     * pass an array of 7 names, otherwise a RuntimeException
     * will be thrown.
     *  
     * @param inWeekDayNames array of names
     */
    public void setWeekDayNames (String[] inWeekDayNames)
    {
        if (inWeekDayNames.length != 7) {
            throw new RuntimeException("wrong number of weekday names");
        }
        this.weekDayNames = inWeekDayNames;
    }

    /**
     * Get the number of days that the calendar
     * columns have been shifted. A result of 0 means
     * that Sunday is the first column, 1 for Monday,
     * 2 for Tuesday, etc.  You may also use the constants
     * for these offsets for comparison.
     * 
     * @return offset
     */
    public int getFirstDayOffset ()
    {
        return firstDayOffset;
    }

    /**
     * Set the number of columns to shift calendar days. Use
     * this to change what the first day of the week is.
     * Valid values are 0-6.  Values outside of this range
     * will throw a RuntimeException.
     * 
     * The following will make Monday the first day of the week,
     * causing the calendar headings to read M, T, W, T, F, S, S.
     * 
     * cal.setFirstDayOffset(CalendarPanel.OFFSET_MONDAY);
     * 
     * @param firstDayOffset offset in days
     */
    public void setFirstDayOffset (int firstDayOffset)
    {
        if (firstDayOffset < 0 || firstDayOffset > 6) {
            throw new RuntimeException("offset out of bounds");
        }
        
        this.firstDayOffset = firstDayOffset;
    }
    
}
