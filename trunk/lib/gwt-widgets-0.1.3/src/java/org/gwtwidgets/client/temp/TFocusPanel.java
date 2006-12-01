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
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.MouseListener;
import com.google.gwt.user.client.ui.MouseListenerCollection;
import com.google.gwt.user.client.ui.Widget;


public class TFocusPanel extends FocusPanel
{
    private MouseListenerCollection mouseListeners;



    public TFocusPanel (Widget w)
    {
        super(w);
    }

    public void addMouseListener (MouseListener listener)
    {
        super.addMouseListener(listener);
        if (mouseListeners == null) {
            mouseListeners = new TMouseListenerCollection();
        }
        mouseListeners.add(listener);
    }

    public void onBrowserEvent (Event event)
    {
        switch (DOM.eventGetType(event)) {
            case Event.ONMOUSEDOWN:
            case Event.ONMOUSEUP:
            case Event.ONMOUSEMOVE:
                if (mouseListeners != null) {
                    mouseListeners.fireMouseEvent(this, event);
                }
                break;
            default:
                super.onBrowserEvent(event);
                break;
        }
    }

    public void removeMouseListener (MouseListener listener)
    {
        super.removeMouseListener(listener);
        if (mouseListeners != null) {
            mouseListeners.remove(listener);
        }
    }
}
