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

package org.gwtwidgets.client.ui;

import org.gwtwidgets.client.style.BorderStyle;
import org.gwtwidgets.client.style.Color;
import org.gwtwidgets.client.style.BorderStyle.BorderStyleConstant;
import com.google.gwt.user.client.DOM;


public class ImageButtonFactory
{
    private Color backgroundOnColor = Color.NONE;
    private Color backgroundOffColor = Color.NONE;

    private Color borderOnColor = Color.BLACK;
    private Color borderOffColor = Color.NONE;
    
    private int borderOnWidth = 1;
    private int borderOffWidth = 0;
    
    private BorderStyleConstant borderOnStyle = BorderStyle.BORDER_STYLE_SOLID;
    private BorderStyleConstant borderOffStyle = BorderStyle.BORDER_STYLE_NONE;
    private int marginLeft;
    private int marginRight;
    private int marginTop;
    private int marginBottom;



    public ToggleButton createToggleButton (String url, int width, int height)
    {
        ToggleButton result = new ToggleButton(url, width, height);
        result.setBackgroundOnColor(backgroundOnColor);
        result.setBackgroundOffColor(backgroundOffColor);

        result.setBorderOnColor(borderOnColor);
        result.setBorderOffColor(borderOffColor);

        result.setBorderOnWidth(borderOnWidth);
        result.setBorderOffWidth(borderOffWidth);

        result.setBorderOnStyle(borderOnStyle);
        result.setBorderOffStyle(borderOffStyle);

        result.setOn(false);
        result.setColors();
        
        return result;
    }

    public ImageButton createImageButton (String url, int width, int height)
    {
        ImageButton result = new ImageButton(url, width, height);
        result.setBackgroundOnColor(backgroundOnColor);
        result.setBackgroundOffColor(backgroundOffColor);

        result.setBorderOnColor(borderOnColor);
        result.setBorderOffColor(borderOffColor);

        result.setBorderOnWidth(borderOnWidth);
        result.setBorderOffWidth(borderOffWidth);

        result.setBorderOnStyle(borderOnStyle);
        result.setBorderOffStyle(borderOffStyle);

        DOM.setStyleAttribute(result.getElement(), "marginLeft", marginLeft + "px");
        DOM.setStyleAttribute(result.getElement(), "marginRight", marginRight + "px");
        DOM.setStyleAttribute(result.getElement(), "marginTop", marginTop + "px");
        DOM.setStyleAttribute(result.getElement(), "marginBotom", marginBottom + "px");

        result.setColors();
        
        return result;
    }
    

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public Color getBackgroundOffColor ()
    {
        return backgroundOffColor;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setBackgroundOffColor (Color backgroundOffColor)
    {
        this.backgroundOffColor = backgroundOffColor;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public Color getBackgroundOnColor ()
    {
        return backgroundOnColor;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setBackgroundOnColor (Color backgroundOnColor)
    {
        this.backgroundOnColor = backgroundOnColor;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public Color getBorderOffColor ()
    {
        return borderOffColor;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setBorderOffColor (Color borderOffColor)
    {
        this.borderOffColor = borderOffColor;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public BorderStyleConstant getBorderOffStyle ()
    {
        return borderOffStyle;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setBorderOffStyle (BorderStyleConstant borderOffStyle)
    {
        this.borderOffStyle = borderOffStyle;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public int getBorderOffWidth ()
    {
        return borderOffWidth;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setBorderOffWidth (int borderOffWidth)
    {
        this.borderOffWidth = borderOffWidth;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public Color getBorderOnColor ()
    {
        return borderOnColor;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setBorderOnColor (Color borderOnColor)
    {
        this.borderOnColor = borderOnColor;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public BorderStyleConstant getBorderOnStyle ()
    {
        return borderOnStyle;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setBorderOnStyle (BorderStyleConstant borderOnStyle)
    {
        this.borderOnStyle = borderOnStyle;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public int getBorderOnWidth ()
    {
        return borderOnWidth;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setBorderOnWidth (int borderOnWidth)
    {
        this.borderOnWidth = borderOnWidth;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setMargin (int px)
    {
        marginLeft = px;
        marginRight = px;
        marginTop = px;
        marginBottom = px;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setHorizontalMargin (int px)
    {
        marginLeft = px;
        marginRight = px;
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setVerticalMargin (int px)
    {
        marginTop = px;
        marginBottom = px;
    }
}
