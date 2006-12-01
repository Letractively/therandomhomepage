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

import java.util.EventListener;

public interface CalendarListener extends EventListener
{
    
    /**
     * Called when a date in the calendar is clicked.
     * This call may be surpressed if the date also]
     * has an event (see onEventDateClick).
     * 
     * @param date
     */
    void onDateClick (CalendarDate date);

    /**
     * Called when a date in the calendar that has events
     * is clicked.  Returning true will cause the event to
     * also call the onDateClick() method, or false to
     * supress the call to onDateClick().
     * 
     * @param date
     * @return false to supress onDateClick
     */
    boolean onEventDateClick (CalendarDate date);

    /**
     * Triggered when the current calendar month or year
     * is changed.
     * 
     * @param month
     */
    void onMonthChange (CalendarMonth month);

}
