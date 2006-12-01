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

package org.gwtwidgets.client.temp;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.MouseListenerCollection;
import com.google.gwt.user.client.ui.Widget;


/**
 * Fixed (?) coords for FocusPanel.  The FocusPanel that
 * comes with GWT returns very strange coords for the
 * content in the panel.  This panel will report the coords
 * as 0,0 for top-left of the panel, meaning the coords
 * are relative to the panel, not to the window.
 *  
 * @author rhanson
 */
public class TMouseListenerCollection extends MouseListenerCollection
{
    private static final long serialVersionUID = 7877053813928824224L;

    
    public void fireMouseEvent (Widget sender, Event event)
    {
        int x = 0, y = 0;
        
        /*
         * this should not be needed, but for some reason will
         * throw the occasional exception, usually when hovering
         * the mouse right on the edge of the focus panel. the
         * error in hosted mode (Windows) is:
         * org.eclipse.swt.SWTException: Failed to change
         *  Variant type result = -2147352566.
         * the error does not seem to be related to the values
         * that are retrieved from getAbsoluteLeft/Top().
         */
        try {
            x = eventGetOffsetX(event, DOM.getAbsoluteLeft(sender.getElement()));
            y = eventGetOffsetY(event, DOM.getAbsoluteTop(sender.getElement()));
        }
        catch (Exception e) {
            return;
        }

        switch (DOM.eventGetType(event)) {
            case Event.ONMOUSEDOWN:
                fireMouseDown(sender, x, y);
                break;
            case Event.ONMOUSEUP:
                fireMouseUp(sender, x, y);
                break;
            case Event.ONMOUSEMOVE:
                fireMouseMove(sender, x, y);
                break;
            default:
                super.fireMouseEvent(sender, event);
        }
    }


    private native int eventGetOffsetX (Event event, int left) /*-{
        return event.offsetX || event.pageX - left;
    }-*/;

    private native int eventGetOffsetY (Event event, int top) /*-{
        return event.offsetY || event.pageY - top;
    }-*/;

}