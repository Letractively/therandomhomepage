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

package org.gwtwidgets.client.ext;

import org.gwtwidgets.client.ext.impl.ExtDOMImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;


public class ExtDOM extends DOM
{
    private static ExtDOMImpl impl;
    static {
        impl = (ExtDOMImpl) GWT.create(ExtDOMImpl.class);
    }



    public static Element createElementNS (Namespace ns, String tag)
    {
        return impl.createElementNS(ns, tag);
    }

    /**
     * Set a namespace attr, using the namespace of the element.
     */
    public static void setAttributeNS (Element elem, String attr, String value)
    {
        impl.setAttributeNS(elem, attr, value);
    }

    /**
     * Set a namespace attr, using the namespace of the element.
     */
    public static void setIntAttributeNS (Element elem, String attr, int value)
    {
        setAttributeNS(elem, attr, Integer.toString(value));
    }


    public static void setAttributeNS (Namespace ns, Element elem, String attr, String value)
    {
        impl.setAttributeNS(ns, elem, attr, value);
    }

}
