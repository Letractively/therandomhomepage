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


public class SVGPath extends SVGBasicShape
{
    private String shapePath = "";



    SVGPath (Namespace ns, double x, double y)
    {
        setElement(createNsElement(ns, "path"));
        this.moveTo(x, y);
    }

    /**
     * Move to a given location.
     * 
     * @param x target point
     * @param y target point
     * @return
     */
    public SVGPath moveTo (double x, double y)
    {
        String path = "M" + x + " " + y;
        appendPath(path);
        return this;
    }

    /**
     * Same as moveTo, but using relative coordinates.
     * 
     * @param x target point relative to the current point
     * @param y target point relative to the current point
     * @return
     */
    public SVGPath relMoveTo (double x, double y)
    {
        String path = "m" + x + " " + y;
        appendPath(path);
        return this;
    }

    /**
     * Draw a line to the target point.
     * 
     * @param x target point
     * @param y target point
     * @return
     */
    public SVGPath lineTo (double x, double y)
    {
        String path = "L" + x + " " + y;
        appendPath(path);
        return this;
    }

    /**
     * Same as lineTo, but using relative coordinates
     *
     * @param x target point relative to the current point
     * @param y target point relative to the current point
     * @return
     */
    public SVGPath relLineTo (double x, double y)
    {
        String path = "l" + x + " " + y;
        appendPath(path);
        return this;
    }

    /**
     * Draw "C"ubic Bezier curve from the current point.
     * 
     * @param x1 control point for beginning of curve  
     * @param y1 control point for beginning of curve  
     * @param x2 control point for end of curve
     * @param y2 control point for end of curve
     * @param x target point
     * @param y target point
     * @return
     */
    public SVGPath curveToC (double x1, double y1, double x2, double y2, double x, double y)
    {
        String path = "C" + x1 + "," + y1 + " " + x2 + "," + y2 + " " + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Same as curveToC, but using relative coordinates.
     */
    public SVGPath relCurveToC (double x1, double y1, double x2, double y2, double x, double y)
    {
        String path = "c" + x1 + "," + y1 + " " + x2 + "," + y2 + " " + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Draw cubic Bezier curve from the current point using 
     * "S"horthand notation.  Same as curveToC except that
     * x1,y1 are assumed to be the reflection of x2,y2 for
     * the previous command.  See the SVG 1.1 specification
     * for the fine details.
     *
     * @param x2 control point for end of curve
     * @param y2 control point for end of curve
     * @param x target point
     * @param y target point
     * @return
     */
    public SVGPath curveToS (double x2, double y2, double x, double y)
    {
        String path = "S" + x2 + "," + y2 + " " + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Same as curveToS, but using relative coordinates.
     */
    public SVGPath relCurveToS (double x2, double y2, double x, double y)
    {
        String path = "s" + x2 + "," + y2 + " " + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Draw quadratic Bezier curve.
     * 
     * @param x1 control point
     * @param y1 control point
     * @param x target point
     * @param y target point
     * @return
     */
    public SVGPath curveToQ (double x1, double y1, double x, double y)
    {
        String path = "Q" + x1 + "," + y1 + " " + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Same as curveToQ, but using relative coordinates.
     */
    public SVGPath relCurveToQ (double x1, double y1, double x, double y)
    {
        String path = "q" + x1 + "," + y1 + " " + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Draw shorthand quadratic Bezier curve.  The control point
     * is assumed to be the reflection of the control point on 
     * the previous command relative to the current point.
     * 
     * @param x target point
     * @param y target point
     * @return
     */
    public SVGPath curveToT (double x, double y)
    {
        String path = "T" + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Same as curveToT, but using relative coordinates.
     */
    public SVGPath relCurveToT (double x, double y)
    {
        String path = "t" + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Draw elliptical arc from current point to x,y.  Path
     * is derived by radius and rotation settings.  Based on
     * the settings there will be four possible arcs, the
     * flags are used to determine the arc to use.  When
     * largeArcFlag is true, an arc greater than 180 degrees
     * will be chosen.  When sweepFlag is true, the arc
     * will be drawn in a "positive angle".  See the SVG 1.1
     * specification for a full explaination and examples.
     * 
     * @param rx x-raxius
     * @param ry y-radius
     * @param xAxisRotation rotation in degrees
     * @param largeArcFlag
     * @param sweepFlag
     * @param x
     * @param y
     * @return
     */
    public SVGPath curveToA (double rx, double ry, double xAxisRotation, boolean largeArcFlag,
            boolean sweepFlag, double x, double y)
    {
        String path = "A" + rx + "," + ry + " " + xAxisRotation + " " + (largeArcFlag ? 1 : 0)
                + "," + (sweepFlag ? 0 : 1) + " " + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Same as curveToA, but using relative coordinates.
     */
    public SVGPath relCurveToA (double rx, double ry, double xAxisRotation, boolean largeArcFlag,
            boolean sweepFlag, double x, double y)
    {
        String path = "a" + rx + "," + ry + " " + xAxisRotation + " " + (largeArcFlag ? 1 : 0)
                + "," + (sweepFlag ? 0 : 1) + " " + x + "," + y;
        appendPath(path);
        return this;
    }

    /**
     * Closes the path by drawing a line to the starting point.
     * 
     * @return
     */
    public SVGPath closePath ()
    {
        String path = "Z";
        appendPath(path);
        return this;
    }

    private void appendPath (String path)
    {
        shapePath += path;
        setAttributeNS(getElement(), "d", shapePath);
    }
}
