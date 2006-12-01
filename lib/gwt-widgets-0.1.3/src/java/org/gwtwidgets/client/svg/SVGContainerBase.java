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

package org.gwtwidgets.client.svg;

import java.util.Iterator;
import java.util.Vector;
import org.gwtwidgets.client.ext.ExtDOM;
import org.gwtwidgets.client.ext.Namespace;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;


public abstract class SVGContainerBase extends SVGWidget
{
    private Vector children = new Vector();


    public Widget getParent ()
    {
        return getParentPanel();
    }


    protected boolean add (SVGWidget w)
    {
        children.add(w);
        w.setParentPanel(this);
        DOM.appendChild(getElement(), w.getElement());
        return true;
    }

    protected boolean remove (SVGWidget w)
    {
        w.setParentPanel(null);
        if (!children.remove(w)) return false;
        DOM.removeChild(getElement(), w.getElement());
        return true;
    }

    protected void clear ()
    {
        int count = getWidgetCount();
        for (int i = 0; i < count; i++) {
            remove(getWidget(0));
        }
    }

    protected SVGWidget getWidget (int index)
    {
        return (SVGWidget) children.get(index);
    }

    protected int getWidgetCount ()
    {
        return children.size();
    }

    protected Iterator iterator ()
    {
        return children.iterator();
    }

    
    
    
    protected Element createNsElement (Namespace ns, String tag)
    {
        return ExtDOM.createElementNS(ns, tag);
    }

    protected void setIntAttributeNS (Element e, String name, int value)
    {
        ExtDOM.setIntAttributeNS(e, name, value);
    };

    protected void setAttributeNS (Element e, String name, String value)
    {
        ExtDOM.setAttributeNS(e, name, value);
    }

    protected void setFloatAttributeNS (Element e, String name, double value)
    {
        ExtDOM.setAttributeNS(e, name, Double.toString(value));
    }
}
