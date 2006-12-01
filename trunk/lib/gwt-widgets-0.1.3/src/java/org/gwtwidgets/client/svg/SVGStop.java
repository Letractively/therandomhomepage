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

import org.gwtwidgets.client.style.Color;
import org.gwtwidgets.client.ext.Namespace;


public class SVGStop extends SVGWidget
{

    SVGStop (Namespace ns)
    {
        setElement(createNsElement(ns, "stop"));
    }

    void setOffset (String offset)
    {
        setAttributeNS(getElement(), "offset", offset);
    }

    void setStopColor (Color stopColor)
    {
        setAttributeNS(getElement(), "stop-color", stopColor.getHexValue());
    }

    public void setOpacity (double opacity)
    {
        setFloatAttributeNS(getElement(), "stop-opacity", opacity);
    }

}

