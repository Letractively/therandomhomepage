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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class WBuilder
{

    /**
     * Wraps the HTML element with the specified ID as a widget.
     * All widgets returned extend Widget and implement the
     * WrappedWidget interface.
     * 
     * The following HTML tags are currently supported:
     * a (WHyperlink), div (WPanel), button (WButton),
     * img (WImage).
     * 
     * <pre>
     * WrappedWidget navLinkSearch = WBuilder.getWidgetFromDOM("nav-link-search");
     * 
     * if (navLinkSearch.isHyperlink()) {
     *   ((WHyperlink)navLinkSearch).addClickListener(navListener);
     * }
     * </pre>
     * 
     * @param id
     * @return null if unable to find or build the widget)
     */
    public static WrappedWidget getWidgetFromDOM (String id)
    {
        Element e = DOM.getElementById(id);
        
        if (e == null) {
            return null;
        }
        
        String tag = getTagName(e);
        tag = tag.toLowerCase();
        
        if (tag == null) {
            return null;
        }
        
        if (tag.equals("a")) {
            return new WHyperlink(e);
        }
        if (tag.equals("div")) {
            return new WPanel(e);
        }
        if (tag.equals("button")) {
            return new WButton(e);
        }
        if (tag.equals("img")) {
            return new WImage(e);
        }
        
        return null;
    }


    /**
     * Replaces an existing element in the HTML
     * document with a different widget.
     * 
     * @param from element being replaced
     * @param to widget being added
     * @return the element being replaced
     */
    public static Element replaceElementWithWidget (Element from, Widget to)
    {
        RootPanel.get().add(to);
        
        Element parent = DOM.getParent(from);
        int index = DOM.getChildIndex(parent, from);

        DOM.insertChild(parent, to.getElement(), index);
        DOM.removeChild(parent, from);
        
        return from;
    }

    /**
     * Replaces an existing widget in the HTML
     * document with a different widget.
     * 
     * @param from widget being replaced
     * @param to widget being added
     * @return the widget being replaced
     */
    public static Widget replaceWidget (Widget from, Widget to)
    {
        replaceElementWithWidget(from.getElement(), to);
        return from;
    }

    
    private static native String getTagName (Element e) /*-{
        return e.tagName;
    }-*/;


    public static void resetElement (Widget widget)
    {
        Element parent = DOM.getParent(widget.getElement());
        Element child = widget.getElement();
        int index = DOM.getChildIndex(parent, child);

        RootPanel.get().add(widget);
        DOM.insertChild(parent, child, index);
    }
    
}
