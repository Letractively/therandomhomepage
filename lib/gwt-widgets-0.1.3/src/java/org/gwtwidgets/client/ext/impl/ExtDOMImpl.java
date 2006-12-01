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

public class ExtDOMImpl
{

    public Element createElementNS (Namespace ns, String tag)
    {
        return createElementNS(ns.getUri(), tag);
    }

    private native Element createElementNS (String ns, String tag) /*-{
        return $doc.createElementNS(ns, tag);
    }-*/;

    /**
     * Set a namespace attr, using the namespace of the element.
     */
    public native void setAttributeNS (Element elem, String attr, String value) /*-{
        elem.setAttributeNS(null, attr, value);
    }-*/;

    public void setAttributeNS (Namespace ns, Element elem, String attr, String value)
    {
        setAttributeNS(ns.getUri(), elem, attr, value);
    }

    private native void setAttributeNS (String uri, Element elem, String attr, String value) /*-{
        elem.setAttributeNS(uri, attr, value);
    }-*/;

}
