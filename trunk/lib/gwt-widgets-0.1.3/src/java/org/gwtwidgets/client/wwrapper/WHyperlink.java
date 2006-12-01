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
import com.google.gwt.user.client.ui.Hyperlink;


public class WHyperlink extends Hyperlink implements WrappedWidget
{
    private static final String WIDGET_TYPE = "hyperlink";
    private Element anchorElem;


    public WHyperlink (String id)
        throws ElementNotFoundException
    {
        super();
        anchorElem = DOM.getElementById(id);
        
        if (anchorElem == null) {
            throw new ElementNotFoundException(id);
        }
        
        setElement(anchorElem);
        sinkEvents(Event.ONCLICK);
        WBuilder.resetElement(this);
    }

    public WHyperlink (Element element)
    {
        super();
        anchorElem = element;
        setElement(anchorElem);
        sinkEvents(Event.ONCLICK);
        WBuilder.resetElement(this);
    }

    public String getHTML ()
    {
        return DOM.getInnerHTML(anchorElem);
    }

    public String getText ()
    {
        return DOM.getInnerText(anchorElem);
    }

    public void setHTML (String html)
    {
        DOM.setInnerHTML(anchorElem, html);
    }

    public void setTargetHistoryToken (String targetHistoryToken)
    {
        super.setTargetHistoryToken(targetHistoryToken);
        DOM.setAttribute(anchorElem, "href", "#" + targetHistoryToken);
    }

    public void setText (String text)
    {
        DOM.setInnerHTML(anchorElem, text);
    }

    public String getWidgetType ()
    {
        return WIDGET_TYPE;
    }

    public String getHref ()
    {
        return DOM.getAttribute(anchorElem, "href");
    }
    
}
