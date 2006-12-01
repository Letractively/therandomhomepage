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

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;


/**
 * Simple popup calculator.  The popup calculator is not meant
 * to be very configurable and does not make it easy to alter
 * the appearance.  It was designed specifically to allow
 * for quick use with almost no options.
 * 
 * Custom calculators may be created using the SimpleCalcPanel
 * widget as a base, or perhaps by using the CalcEngine class
 * directly.
 * 
 * A default set of styles are provided when including
 * the following style-sheet declaration in your HTML
 * file.
 * 
 * <link rel="stylesheet" type="text/css" href="style/gwl-calcPanel.css">
 *
 * @author rhanson
 */
public final class PopupCalcPanel extends PopupPanel
{

    /**
     * Create new calculator popup widget.  The widget will be 
     * displayed when the widget defined by showCalcButton is 
     * clicked, and will appear directly below the calcTextBox 
     * widget.
     * 
     * @param calcTextBox
     * @param showCalcBtn
     */
    public PopupCalcPanel (final TextBoxBase calcTextBox, Button showCalcBtn)
    {
        super();

        final SimpleCalcPanel calc = new SimpleCalcPanel();
        
        DockPanel calcPanel = new DockPanel();
        calcPanel.setStyleName("popupCalc-panel");
        
        HorizontalPanel actionButtons = new HorizontalPanel();
        actionButtons.setStyleName("popupCalc-actionButtons");
        
        Button doneBtn = new Button("DONE");
        doneBtn.setStyleName("popupCalc-doneButton");
        actionButtons.add(doneBtn);

        Button cancelBtn = new Button("CANCEL");
        cancelBtn.setStyleName("popupCalc-cancelButton");
        actionButtons.add(cancelBtn);
        
        calcPanel.add(actionButtons, DockPanel.SOUTH);
        calcPanel.add(calc, DockPanel.CENTER);
        
        
        final PopupPanel popup = this;
        popup.add(calcPanel);
        popup.setVisible(false);

        
        // "Show Calc" button handler
        showCalcBtn.addClickListener(new ClickListener()
        {
            public void onClick (Widget sender)
            {
                popup.setPopupPosition(calcTextBox.getAbsoluteLeft(),
                        calcTextBox.getAbsoluteTop() + calcTextBox.getOffsetHeight());
                calc.clearValue();
                popup.setVisible(true);
            }
        });

        // "Done" button handler
        doneBtn.addClickListener(new ClickListener()
        {
            public void onClick (Widget sender)
            {
                popup.setVisible(false);
                calcTextBox.setText(calc.getValue());
            }
        });

        // "Cancel" button handler
        cancelBtn.addClickListener(new ClickListener()
        {
            public void onClick (Widget sender)
            {
                popup.setVisible(false);
            }
        });
    }
    
}
