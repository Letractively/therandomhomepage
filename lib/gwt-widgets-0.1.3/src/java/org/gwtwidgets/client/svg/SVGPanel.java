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


public class SVGPanel extends SVGPanelBase
{
    private Namespace ns;
    private SVGDefs defs;
    private int genId = 0;

    
    /**
     * Create a new SVG panel of the specified size using
     * the default namespace and URI.  The default namespace
     * prefix is "svg", and the URI is "http://www.w3.org/2000/svg".
     * 
     * @param width in pixels
     * @param height in pixels
     */
    public SVGPanel (double width, double height)
    {
        this(new Namespace("svg", "http://www.w3.org/2000/svg"), width, height);
    }

    /**
     * Create a new SVG panel of the specified size using
     * a custom namespace.  In most cases you should use
     * the default namespace, but for cases where you can't
     * you may specify a custom one with this constructor.
     * 
     * @param ns namespace
     * @param width in pixels
     * @param height in pixels
     */
    public SVGPanel (Namespace ns, double width, double height)
    {
        this.ns = ns;
        setElement(createNsElement(ns, "svg"));
        setAttributeNS(getElement(), "width", width + "px");
        setAttributeNS(getElement(), "height", height + "px");
        
        this.defs = new SVGDefs(ns);
        this.add(defs);
    }

    /**
     * Create a new cicle.
     * 
     * @param cx x-coordinate for the center of the circle
     * @param cy y-coordinate for the center of the circle
     * @param radius of the circle in pixels
     * @return circle widget
     */
    public SVGCircle createCircle (double cx, double cy, double radius)
    {
        return new SVGCircle(ns, cx, cy, radius);
    }

    
    /**
     * Create a new ellipse.
     * 
     * @param cx x-coordinate for the center of the ellipse
     * @param cy y-coordinate for the center of the ellipse
     * @param rx horizontal radius of the ellipse in pixels
     * @param ry vertical radius of the ellipse in pixels
     * @return ellipse widget
     */
    public SVGEllipse createEllipse (double cx, double cy, double rx, double ry)
    {
        return new SVGEllipse(ns, cx, cy, rx, ry);
    }

    
    /**
     * Create a new rectangle.
     * 
     * @param x x-coordinate of the top-left corner
     * @param y y-coordinate of the top-left corner
     * @param width in pixels
     * @param height in pixels
     * @return rectangle widget
     */
    public SVGRectangle createRectangle (double x, double y, double width, double height)
    {
        return new SVGRectangle(ns, x, y, width, height);
    }
    
    public SVGPath createPath (double x, double y)
    {
        return new SVGPath(ns, x, y);
    }
    
    public SVGLinearGradient createLinearGradient ()
    {
        String id = getNewId();
        SVGLinearGradient result = new SVGLinearGradient(ns, id);
        defs.add(result.getWidget());
        return result;
    }

    public SVGLinearGradient createLinearGradient (String id)
    {
        SVGLinearGradient result = new SVGLinearGradient(ns, id);
        defs.add(result.getWidget());
        return result;
    }

    /*
    public SVGImage createImage (String href, int x, int y, int width, int height)
    {
        return new SVGImage(ns, href, x, y, width, height);
    }
    */
    
    public SVGText createText (int x, int y, String text)
    {
        return new SVGText(ns, x, y, text);
    }

    
    private synchronized String getNewId ()
    {
        genId ++;
        return "grad_id_" + genId;
    }

}
