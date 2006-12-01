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

package org.gwtwidgets.client.temp;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Grid;

/**
 * An extension of Grid that does not put an &nbsp;
 * inside a cell when it is cleared.  This is a temporary
 * fix until this same fix is made in the GWT Grid
 * component, or may become a permanant addition to
 * the GWT-WL if this change is not made in the Grid.
 * 
 * @author rhanson
 */
public class TGrid extends Grid
{

    public TGrid (int width, int height)
    {
        super(width, height);
    }

    /**
     * Completely clear cell, does not leave an &nbsp;
     */
    public boolean clearCell (int row, int column)
    {
        boolean result = super.clearCell(row, column);
        Element td = getCellFormatter().getElement(row, column);
        DOM.setInnerHTML(td, "");
        return result;
    }

}
