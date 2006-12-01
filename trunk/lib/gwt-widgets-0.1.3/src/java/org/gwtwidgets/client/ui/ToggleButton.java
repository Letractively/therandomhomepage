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

import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.Widget;

public class ToggleButton extends ImageButton
{
    private int trueState;


    public ToggleButton (String url, int width, int height)
    {
        super(url, width, height);
    }

    protected void init ()
    {
        addMouseListener(new MouseListenerAdapter(){

            public void onMouseEnter (Widget sender)
            {
                trueState = getState();
                setState(ON_STATE);
                setColors();
            }

            public void onMouseLeave (Widget sender)
            {
                setState(trueState);
                setColors();
            }
        });
    }
    
    public void setOn (boolean on)
    {
        if (on) {
            setState(ON_STATE);
            trueState = ON_STATE;
        }
        else {
            setState(OFF_STATE);
            trueState = OFF_STATE;
        }
        setColors();
    }


    /**
     * Toggle button state
     * @param on
     */
    public void toggle ()
    {
        if (trueState == ON_STATE) {
            trueState = OFF_STATE;
        }
        else {
            trueState = ON_STATE;
        }
        setColors();
    }
}
