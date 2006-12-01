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

import org.gwtwidgets.client.ext.Namespace;
import com.google.gwt.user.client.DOM;


public class SVGText extends SVGWidget
{

    SVGText (Namespace ns, double x, double y, String text)
    {
        setElement(createNsElement(ns, "text"));

        this.setX(x)
            .setY(y)
            .setText(text);
    }

    public SVGText setX (double x)
    {
        setAttributeNS(getElement(), "x", x + "px");
        return this;
    }

    public SVGText setY (double y)
    {
        setAttributeNS(getElement(), "y", y + "px");
        return this;
    }

    public SVGText setText (String text)
    {
        DOM.setInnerText(getElement(), text);
        return this;
    }

}
