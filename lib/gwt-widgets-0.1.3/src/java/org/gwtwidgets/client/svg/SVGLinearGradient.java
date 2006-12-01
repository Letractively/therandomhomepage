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


public class SVGLinearGradient implements SVGGradient
{
    private String id;
    private SVGLinearGradientWidget widget;
    private Namespace ns;



    protected SVGLinearGradient (Namespace ns, String id)
    {
        this.id = id;
        this.ns = ns;
        this.widget = new SVGLinearGradientWidget(ns, id);
    }

    protected SVGLinearGradientWidget getWidget ()
    {
        return widget;
    }

    public String getId ()
    {
        return id;
    }

    
    /**
     * Set a gradient stop
     * @param percent 1-100
     * @param color
     */
    public SVGLinearGradient addStop (int percent, Color color)
    {
        SVGStop stop = new SVGStop(ns);
        stop.setOffset(percent + "%");
        stop.setStopColor(color);
        this.getWidget().add(stop);
        return this;
    }

    public SVGLinearGradient addStop (int percent, double opacity, Color color)
    {
        SVGStop stop = new SVGStop(ns);
        stop.setOffset(percent + "%");
        stop.setOpacity(opacity);
        stop.setStopColor(color);
        this.getWidget().add(stop);
        return this;
    }

    public SVGLinearGradient setVector (int x1Percent, int y1Percent, int x2Percent, int y2Percent)
    {
        SVGWidget w = getWidget();
        w.setAttributeNS(w.getElement(), "gradientUnits", "objectBoundingBox");
        w.setAttributeNS(w.getElement(), "x1", x1Percent + "%");
        w.setAttributeNS(w.getElement(), "y1", y1Percent + "%");
        w.setAttributeNS(w.getElement(), "x2", x2Percent + "%");
        w.setAttributeNS(w.getElement(), "y2", y2Percent + "%");
        return this;
    }

    
    public class SVGLinearGradientWidget extends SVGContainerBase
    {

        protected SVGLinearGradientWidget (Namespace ns, String id)
        {
            setElement(createNsElement(ns, "linearGradient"));
            setAttributeNS(getElement(), "id", id);
        }

    }

}
