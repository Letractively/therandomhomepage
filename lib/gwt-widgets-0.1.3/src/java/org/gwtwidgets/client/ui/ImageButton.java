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
import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.Widget;

/**
 * Use an image as a button.  Allows for setting of on/off 
 * background color, border color, border width, and border 
 * style.  The "on" colors are used on mouse over.
 * 
 * @author rhanson
 */
public class ImageButton extends PNGImage
{

    protected final static int ON_STATE = 1;
    protected final static int OFF_STATE = -1;
    private int state = OFF_STATE;
    
    private String onStyle = "gwl-ImageButton-On";
    private String offStyle = "gwl-ImageButton-Off";

    private Color backgroundOnColor = Color.NONE;
    private Color backgroundOffColor = Color.NONE;

    private Color borderOnColor = Color.BLACK;
    private Color borderOffColor = Color.NONE;
    
    private int borderOnWidth = 1;
    private int borderOffWidth = 0;
    
    private int paddingLeft = 0;
    private int paddingRight = 0;
    private int paddingTop = 0;
    private int paddingBottom = 0;
    
    private BorderStyleConstant borderOnStyle = BorderStyle.BORDER_STYLE_SOLID;
    private BorderStyleConstant borderOffStyle = BorderStyle.BORDER_STYLE_NONE;


    public ImageButton (String url, int width, int height)
    {
        super(url, width, height);
        setStyleName("gwl-image-button");
        setColors();
        init();
    }

    
    protected void init ()
    {
        addMouseListener(new MouseListenerAdapter(){

            public void onMouseEnter (Widget sender)
            {
                state = ON_STATE;
                setColors();
            }

            public void onMouseLeave (Widget sender)
            {
                state = OFF_STATE;
                setColors();
            }
        });
    }
    
    
    public boolean isOn ()
    {
        return state == ON_STATE;
    }
    
    /**
     * Updates the colors of the widget based on the state
     * and color settings. This is usually only used after 
     * setting one or more of the colors.
     */
    public void setColors ()
    {
        DOM.setStyleAttribute(getElement(), "paddingTop", getPaddingTopWidth() + "px");
        DOM.setStyleAttribute(getElement(), "paddingRight", getPaddingRightWidth() + "px");
        DOM.setStyleAttribute(getElement(), "paddingBottom", getPaddingBottomWidth() + "px");
        DOM.setStyleAttribute(getElement(), "paddingLeft", getPaddingLeftWidth() + "px");
        DOM.setStyleAttribute(getElement(), "borderWidth", getBorderWidth() + "px");
        DOM.setStyleAttribute(getElement(), "borderColor", getBorderColor().getHexValue());
        DOM.setStyleAttribute(getElement(), "borderStyle", getBorderStyle().getBorderStyleName());
        DOM.setStyleAttribute(getElement(), "backgroundColor", getBackgroundColor().getHexValue());
        setStyleName(getCssStyleName());
    }

    private String getCssStyleName ()
    {
        if (state == ON_STATE)
            return onStyle;
        else
            return offStyle;
    }


    private Color getBackgroundColor ()
    {
        if (state == ON_STATE)
            return backgroundOnColor;
        else
            return backgroundOffColor;
    }

    private BorderStyleConstant getBorderStyle ()
    {
        if (state == ON_STATE)
            return borderOnStyle;
        else
            return borderOffStyle;
    }

    private Color getBorderColor ()
    {
        if (state == ON_STATE)
            return borderOnColor;
        else
            return borderOffColor;
    }

    private int getBorderWidth ()
    {
        if (state == ON_STATE)
            return borderOnWidth;
        else
            return borderOffWidth;
    }

    private int getPaddingLeftWidth ()
    {
        int max = (borderOnWidth > borderOffWidth) ? borderOnWidth : borderOffWidth;
        
        if (state == ON_STATE) {
            return (max - borderOnWidth + paddingLeft);
        }
        else {
            return (max - borderOffWidth + paddingLeft);
        }
    }

    private int getPaddingRightWidth ()
    {
        int max = (borderOnWidth > borderOffWidth) ? borderOnWidth : borderOffWidth;
        
        if (state == ON_STATE) {
            return (max - borderOnWidth + paddingRight);
        }
        else {
            return (max - borderOffWidth + paddingRight);
        }
    }

    private int getPaddingTopWidth ()
    {
        int max = (borderOnWidth > borderOffWidth) ? borderOnWidth : borderOffWidth;
        
        if (state == ON_STATE) {
            return (max - borderOnWidth + paddingTop);
        }
        else {
            return (max - borderOffWidth + paddingTop);
        }
    }
    
    private int getPaddingBottomWidth ()
    {
        int max = (borderOnWidth > borderOffWidth) ? borderOnWidth : borderOffWidth;
        
        if (state == ON_STATE) {
            return (max - borderOnWidth + paddingBottom);
        }
        else {
            return (max - borderOffWidth + paddingBottom);
        }
    }
    
    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setMargin (int px)
    {
        DOM.setStyleAttribute(getElement(), "margin", px + "px");
    }
    
    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setHorizontalMargin (int px)
    {
        DOM.setStyleAttribute(getElement(), "marginLeft", px + "px");
        DOM.setStyleAttribute(getElement(), "marginRight", px + "px");
    }

    /**
     * This method is under consideration for removal,
     * if you have an opion please comment on http://gwtwidgets.blogspot.com.
     */
    public void setVerticleMargin (int px)
    {
        DOM.setStyleAttribute(getElement(), "marginTop", px + "px");
        DOM.setStyleAttribute(getElement(), "marginBotom", px + "px");
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

    protected int getState ()
    {
        return state;
    }

    protected void setState (int state)
    {
        this.state = state;
    }


    public String getOffStyle ()
    {
        return offStyle;
    }


    public void setOffStyle (String offStyle)
    {
        this.offStyle = offStyle;
    }


    public String getOnStyle ()
    {
        return onStyle;
    }


    public void setOnStyle (String onStyle)
    {
        this.onStyle = onStyle;
    }


}
