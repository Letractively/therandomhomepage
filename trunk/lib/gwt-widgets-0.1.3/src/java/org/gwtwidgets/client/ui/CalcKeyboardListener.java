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

import org.gwtwidgets.client.util.CalcEngine;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;


public class CalcKeyboardListener extends KeyboardListenerAdapter
{

    public CalcKeyboardListener (final CalcEngine calc, final TextBoxBase textBox)
    {
        textBox.addKeyboardListener(new KeyboardListenerAdapter()
        {
            public void onKeyPress (Widget sender, char keyCode, int modifiers)
            {

                if (keyCode >= 48 && keyCode <= 57) {
                    calc.pressDigit(keyCode - 48);
                }
                switch (keyCode) {
                    case 43: // "+"
                        calc.pressOperator(CalcEngine.OP_PLUS);
                        break;
                    case 45: // "-"
                        calc.pressOperator(CalcEngine.OP_MINUS);
                        break;
                    case 42: // "*"
                        calc.pressOperator(CalcEngine.OP_MULT);
                        break;
                    case 47: // "/"
                        calc.pressOperator(CalcEngine.OP_DIV);
                        break;
                    case 61: // "="
                    case 13: // <ENTER>
                        calc.pressOperator(CalcEngine.OP_EQUALS);
                        break;
                    case 27: // <ESC>
                        calc.pressOperator(CalcEngine.OP_CLEAR);
                        break;
                    case 46: // "."
                        calc.pressOperator(CalcEngine.OP_DEC);
                        break;
                }
                calc.refreshDisplay();
                textBox.cancelKey();
            }
        });
    }
}
