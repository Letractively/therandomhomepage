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

package org.gwtwidgets.client.ext.impl;

import org.gwtwidgets.client.ext.Namespace;
import com.google.gwt.user.client.Element;

public class ExtDOMImplIE6 extends ExtDOMImpl
{

    public Element createElementNS (Namespace ns, String tag)
    {
        return createElementNS(ns.getPrefix(), tag);
    }

    private native Element createElementNS (String prefix, String tag) /*-{
        return $doc.createElement(prefix + ":" + tag);
    }-*/;

    /**
     * Set a namespace attr, using the namespace of the element.
     */
    public native void setAttributeNS (Element elem, String attr, String value) /*-{
        elem.setAttribute(attr, value);
    }-*/;

    
    public void setAttributeNS (Namespace ns, Element elem, String attr, String value)
    {
        setAttributeNS(ns.getPrefix(), elem, attr, value);
    }

    private native void setAttributeNS (String prefix, Element elem, String attr, String value) /*-{
        elem.setAttribute(prefix + ":" + attr, value);
    }-*/;

}
