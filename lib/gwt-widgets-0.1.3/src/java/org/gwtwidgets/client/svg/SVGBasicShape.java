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

public class SVGBasicShape extends SVGWidget
{

    /**
     * Sets the fill and stroke colors.
     * @param color
     */
    public SVGBasicShape setColor (Color color)
    {
        setAttributeNS(getElement(), "color", defaultColor(color.getHexValue()));
        return this;
    }

    public SVGBasicShape setFill (Color color)
    {
        setAttributeNS(getElement(), "fill", defaultColor(color.getHexValue()));
        return this;
    }

    public SVGBasicShape setFill (SVGGradient gradient)
    {
        setAttributeNS(getElement(), "fill", "url(#" + gradient.getId() + ")");
        return this;
    }

    public SVGBasicShape setStroke (Color color)
    {
        setAttributeNS(getElement(), "stroke", defaultColor(color.getHexValue()));
        return this;
    }

    public SVGBasicShape setStroke (SVGGradient gradient)
    {
        setAttributeNS(getElement(), "stroke", "url(#" + gradient.getId() + ")");
        return this;
    }

    /**
     * Set sroke width.
     * @param width in pixels
     * @return
     */
    public SVGBasicShape setStrokeWidth (int width)
    {
        setAttributeNS(getElement(), "stroke-width", width + "px");
        return this;
    }

    /**
     * Sets the stroke and fill opacity.  Values outside of the
     * valid range are ignored.
     * @param opacity percent value between 0 - 100
     */
    public SVGBasicShape setOpacity (int opacity)
    {
        if (opacity < 0.0 || opacity > 1.0) return this;
        setFloatAttributeNS(getElement(), "opacity", ((float)opacity/100.0));
        return this;
    }

    /**
     * Sets the stroke opacity.  Values outside of the
     * valid range are ignored.
     * @param opacity percent value between 0 - 100
     */
    public SVGBasicShape setStrokeOpacity (int opacity)
    {
        if (opacity < 0 || opacity > 100) return this;
        setFloatAttributeNS(getElement(), "stroke-opacity", ((float)opacity/100.0));
        return this;
    }

    /**
     * Sets the fill opacity.  Values outside of the
     * valid range are ignored.
     * @param opacity percent value between 0 - 100
     */
    public SVGBasicShape setFillOpacity (double opacity)
    {
        if (opacity < 0 || opacity > 100) return this;
        setFloatAttributeNS(getElement(), "fill-opacity", (opacity/100.0));
        return this;
    }

    
    
    private String defaultColor (String color)
    {
        if (color.equals("")) {
            return "none";
        }
        return color;
    }
    
}
