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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ListBox;


/**
 * A ListBox extension.
 * 
 * @author Jack Tang - original implementation
 * @author Aaron Watkins - added indexOfValue(String)
 */
public class OptionList extends ListBox
{
    /**
     * Creates an empty list box.
     */
    public OptionList ()
    {
        super();
    }

    /**
     * Adds an item to the list box.
     *
     * @param item the text of the item to be added
     */
    public void addItem (String value, String item)
    {
        insertItem(value, item, getItemCount());
    }

    /**
     * Inserts an item into the list box.
     *
     * @param item the text of the item to be inserted
     * @param idx the index at which to insert it
     */
    public void insertItem (String value, String item, int idx)
    {
        Element option = DOM.createElement("OPTION");
        DOM.setAttribute(option, "value", value);
        DOM.setInnerText(option, item);
        DOM.insertChild(getElement(), option, idx);
    }
   
    public String getValue (int index)
    {
        Element child = DOM.getChild(getElement(), index);
        return DOM.getAttribute(child, "value");
    }
    
    public int indexOfValue (String value)
    {
        int numChildren = DOM.getChildCount(getElement());
        for (int i = 0; i < numChildren; i++) {
            if (getValue(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }
 
}