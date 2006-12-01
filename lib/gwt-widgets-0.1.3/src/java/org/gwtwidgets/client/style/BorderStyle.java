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

package org.gwtwidgets.client.style;

/**
 * This class is under consideration for removal,
 * if you have an opion please comment on http://gwtwidgets.blogspot.com.
 */
public class BorderStyle
{
   
    
    public static class BorderStyleConstant
    {

        private String styleName;
        
        private BorderStyleConstant (String styleName)
        {
            this.styleName = styleName;
        }

        public String getBorderStyleName() {
            return styleName;
        }
        
    }

    final public static BorderStyleConstant BORDER_STYLE_NONE = new BorderStyleConstant("none");

    final public static BorderStyleConstant BORDER_STYLE_DOTTED = new BorderStyleConstant("dotted");

    final public static BorderStyleConstant BORDER_STYLE_DASHED = new BorderStyleConstant("dashed");

    final public static BorderStyleConstant BORDER_STYLE_SOLID = new BorderStyleConstant("solid");

    final public static BorderStyleConstant BORDER_STYLE_DOUBLE = new BorderStyleConstant("double");

    final public static BorderStyleConstant BORDER_STYLE_GROOVE = new BorderStyleConstant("groove");

    final public static BorderStyleConstant BORDER_STYLE_RIDGE = new BorderStyleConstant("ridge");

    final public static BorderStyleConstant BORDER_STYLE_INSET = new BorderStyleConstant("inset");

    final public static BorderStyleConstant BORDER_STYLE_OUTSET = new BorderStyleConstant("outset");

}
