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

package org.gwtwidgets.client.wwrapper;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.TextBox;

/**
 * 
 * @author John Menke
 */
public class WTextBox extends TextBox implements WrappedWidget
{
    private static final String WIDGET_TYPE = "text";


    public WTextBox (String id) throws ElementNotFoundException
    {
        super();
        Element e = DOM.getElementById(id);
        if (e == null) {
            throw new ElementNotFoundException(id);
        }
        setElement(e);
        sinkEvents(Event.KEYEVENTS);
        WBuilder.resetElement(this);
    }

    public WTextBox (Element element)
    {
        super();
        setElement(element);
        sinkEvents(Event.KEYEVENTS);
        WBuilder.resetElement(this);
    }

    public String getWidgetType ()
    {
        return WIDGET_TYPE;
    }

}
