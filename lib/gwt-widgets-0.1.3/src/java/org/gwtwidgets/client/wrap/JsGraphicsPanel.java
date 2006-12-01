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

package org.gwtwidgets.client.wrap;

import java.util.ArrayList;
import org.gwtwidgets.client.style.Color;
import org.gwtwidgets.client.style.Coords;
import org.gwtwidgets.client.util.ArrayUtils;
import org.gwtwidgets.client.wwrapper.ElementNotFoundException;
import org.gwtwidgets.client.wwrapper.WBuilder;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTMLPanel;


/**
* Wrapper Panel for Walter Zorn's JsGraphics library.  To use this wrapper
* you will need to download the JsGraphics library from
* http://www.walterzorn.com/jsgraphics/jsgraphics_e.htm.  This code was
* built and tested for JsGraphics version 2.35.
* 
* To use this panel you will need top include the JsGraphics library
* in the &lt;head> of the HTMl page.
* 
* &lt;script src="script/wz_jsgraphics.js" type="text/javascript">&lt;/script>
* 
* You will also need to place a DIV in the HTML page with an ID and must specify
* the "position:relative" style attribute.  If you don't specify this you
* will find that when you draw shapes, they will be relative to the top-left
* corner of the page, and not relative to the placement of the DIV.
* 
* &lt;div style="position:relative;width:350px;height:300px;" id="g">&lt;/div>
* 
* In your code you will create the JsGraphicsPanel, passing the ID
* of the DIV that will be used as your canvas.  You DO NOT need to add
* this panel to the RootPanel, although there (seems) to be no harm
* in doing so.
*/
public class JsGraphicsPanel extends HTMLPanel
{

    private JavaScriptObject graphics;
    
    
    public final static Style PLAIN = new Style("font-weight:normal;");
    public final static Style BOLD = new Style("font-weight:bold;");
    public final static Style ITALIC = new Style("font-style:italic;");
    public final static Style ITALIC_BOLD = new Style("font-style:italic;" + "font-weight:bold;");
    public final static Style BOLD_ITALIC = ITALIC_BOLD;

    

    /**
     * @param id ID of the DIV element to turn into a canvas.
     * @throws ElementNotFoundException
     */
    public JsGraphicsPanel (String id) throws ElementNotFoundException
    {
        super("");
        Element e = DOM.getElementById(id);
        if (e == null) {
            throw new ElementNotFoundException(id);
        }
        setElement(e);
        WBuilder.resetElement(this);
        this.graphics = newJsGraphics(id);
    }

    
    private native JavaScriptObject newJsGraphics (String id) /*-{
        return new $wnd.jsGraphics(id);
    }-*/;
    
    
    public void setColor (Color color)
    {
        setColor(graphics, color.getHexValue());
    }
    
    private native void setColor (JavaScriptObject g, String color) /*-{
        g.setColor(color);
    }-*/;



    public native void setStrokeWidth (int width) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.setStroke(width);
    }-*/;
   
    public native void setStrokeDotted () /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.setStroke($wnd.Stroke.DOTTED);
    }-*/;

    public native void drawLine (int x1, int y1, int x2, int y2) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.drawLine(x1, y1, x2, y2);
    }-*/;

    
    
    public void drawPolyline (int[] xPoints, int[] yPoints)
    {
        drawPolyline(graphics, ArrayUtils.toJsArray(xPoints), ArrayUtils.toJsArray(yPoints));
    }

    private native void drawPolyline (JavaScriptObject g, JavaScriptObject xPoints, JavaScriptObject yPoints) /*-{
        g.drawPolyline(xPoints, yPoints);
    }-*/;

    

    public native void drawRect (int x, int y, int width, int height) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.drawRect(x, y, width, height);
    }-*/;
    
    public native void fillRect (int x, int y, int width, int height) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.fillRect(x, y, width, height);
    }-*/;


    
    public void drawPolygon (int[] xPoints, int[] yPoints)
    {
        drawPolygon(graphics, ArrayUtils.toJsArray(xPoints), ArrayUtils.toJsArray(yPoints));
    }

    public void drawPolygon (ArrayList coords)
    {
        int[] x = new int[coords.size()];
        int[] y = new int[coords.size()];
        
        for (int i = 0; i < coords.size(); i++) {
            x[i] = ((Coords)coords.get(i)).getX();
            y[i] = ((Coords)coords.get(i)).getY();
        }
        
        drawPolygon(x, y);
    }
    
    private native void drawPolygon (JavaScriptObject g, JavaScriptObject xPoints, JavaScriptObject yPoints) /*-{
        g.drawPolygon(xPoints, yPoints);
    }-*/;


    
    public void fillPolygon (int[] xPoints, int[] yPoints)
    {
        fillPolygon(graphics, ArrayUtils.toJsArray(xPoints), ArrayUtils.toJsArray(yPoints));
    }

    private native void fillPolygon (JavaScriptObject g, JavaScriptObject xPoints, JavaScriptObject yPoints) /*-{
        g.fillPolygon(xPoints, yPoints);
    }-*/;

    
    
    public native void drawEllipse (int x, int y, int width, int height) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.drawEllipse(x, y, width, height); 
    }-*/;

    public native void fillEllipse (int x, int y, int width, int height) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.fillEllipse(x, y, width, height); 
    }-*/;

    
    public void setFont (String text, String size, Style style)
    {
        setFont(text, size, style.toString());
    }
    
    private native void setFont (String text, String size, String style) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.setFont(text, size, style); 
    }-*/;

    public native void drawString (String text, int x, int y) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.drawString(text, x, y); 
    }-*/;

    public native void drawStringRect (String text, int x, int y, int width, int height) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.drawStringRect(text, x, y, width, height); 
    }-*/;

    public native void drawImage (String src, int x, int y, int width, int height) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.drawImage(src, x, y, width, height); 
    }-*/;

    
    

    public native void paint () /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.paint();
    }-*/;

    public native void clear () /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.clear();
    }-*/;

    public native void setPrintable (boolean val) /*-{
        this.@org.gwtwidgets.client.wrap.JsGraphicsPanel::graphics.setPrintable(val);
    }-*/;
    
    
    private static class Style {
        
        private String val;

        public Style (String val)
        {
            this.val = val;
        }
        
        public String toString ()
        {
            return val;
        }
    }
    
}
