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


public class SVGEllipse extends SVGBasicShape
{

    SVGEllipse (Namespace ns, double cx, double cy, double rx, double ry)
    {
        setElement(createNsElement(ns, "ellipse"));
        
        this.setCenterX(cx)
            .setCenterY(cy)
            .setRadiusX(rx)
            .setRadiusY(ry);
    }

    public SVGEllipse setCenterX (double cx)
    {
        setAttributeNS(getElement(), "cx", cx + "px");
        return this;
    }

    public SVGEllipse setCenterY (double cy)
    {
        setAttributeNS(getElement(), "cy", cy + "px");
        return this;
    }

    public SVGEllipse setRadiusX (double rx)
    {
        setAttributeNS(getElement(), "rx", rx + "px");
        return this;
    }

    public SVGEllipse setRadiusY (double ry)
    {
        setAttributeNS(getElement(), "ry", ry + "px");
        return this;
    }

}
