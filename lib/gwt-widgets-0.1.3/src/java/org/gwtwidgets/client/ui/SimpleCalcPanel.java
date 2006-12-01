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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * A simple calculator panel.  The panel follows the
 * template design pattern, which should make it fairly
 * easy to change the layout and behavior by extending
 * the class.
 * 
 * A default set of styles are provided when including
 * the following style-sheet declaration in your HTML
 * file.
 * 
 * <link rel="stylesheet" type="text/css" href="style/gwl-calcPanel.css">
 * 
 * @author rhanson
 */
public class SimpleCalcPanel extends FlowPanel
{

    private SimpleCalculator calc = null;

    
    
    public SimpleCalcPanel ()
    {
        setElement(DOM.createDiv());
        setStyleName("simpleCalcPanel");
        init();
    }

    
    protected void init ()
    {
        TextBox textDisplay = createTextDisplay();
        createCalc(createDisplayListener(textDisplay), textDisplay);
        setKeyboardListener(textDisplay);
        initComplete();
    }

    
    protected CalcDisplayListener createDisplayListener (final TextBox textDisplay)
    {
        return new CalcDisplayListener()
        {
            public void onDisplayRefresh (String value)
            {
                textDisplay.setText(value);
            }
        };
    }


    protected void setKeyboardListener (TextBox textDisplay)
    {
        textDisplay.addKeyboardListener(new CalcKeyboardListener(calc, textDisplay));
    }


    protected void initComplete ()
    {
    }


    protected void createCalc (CalcDisplayListener cdl, TextBox textDisplay)
    {
        calc = new SimpleCalculator(this, cdl, textDisplay);
    }


    protected TextBox createTextDisplay ()
    {
        TextBox result = new TextBox();
        result.setStyleName("simpleCalcDisplay");
        return result;
    }



    protected void buildCalcLayout (CalcEngine calcEngine, TextBox textDisplay)
    {
        add(textDisplay);

        HorizontalPanel numPad1 = new HorizontalPanel();
        numPad1.add(calcEngine.createNumberButton("calcButton-1", "1", 1));
        numPad1.add(calcEngine.createNumberButton("calcButton-2", "2", 2));
        numPad1.add(calcEngine.createNumberButton("calcButton-3", "3", 3));

        HorizontalPanel numPad2 = new HorizontalPanel();
        numPad2.add(calcEngine.createNumberButton("calcButton-4", "4", 4));
        numPad2.add(calcEngine.createNumberButton("calcButton-5", "5", 5));
        numPad2.add(calcEngine.createNumberButton("calcButton-6", "6", 6));

        HorizontalPanel numPad3 = new HorizontalPanel();
        numPad3.add(calcEngine.createNumberButton("calcButton-7", "7", 7));
        numPad3.add(calcEngine.createNumberButton("calcButton-8", "8", 8));
        numPad3.add(calcEngine.createNumberButton("calcButton-9", "9", 9));

        HorizontalPanel numPad4 = new HorizontalPanel();
        numPad4.add(calcEngine.createNumberButton("calcButton-0", "0", 0));
        numPad4.add(calcEngine.createOpButton("calcButton-negate", "+/-", CalcEngine.OP_NEGATE));
        numPad4.add(calcEngine.createOpButton("calcButton-decimal", ".", CalcEngine.OP_DEC));

        VerticalPanel numPad = new VerticalPanel();
        numPad.add(numPad1);
        numPad.add(numPad2);
        numPad.add(numPad3);
        numPad.add(numPad4);

        
        VerticalPanel opPad = new VerticalPanel();
        opPad.add(calcEngine.createOpButton("calcButton-plus", "+", CalcEngine.OP_PLUS));
        opPad.add(calcEngine.createOpButton("calcButton-minus", "-", CalcEngine.OP_MINUS));
        opPad.add(calcEngine.createOpButton("calcButton-multiply", "*", CalcEngine.OP_MULT));
        opPad.add(calcEngine.createOpButton("calcButton-divide", "/", CalcEngine.OP_DIV));

        VerticalPanel funcPad = new VerticalPanel();
        funcPad.add(calcEngine.createOpButton("calcButton-clear", "C", CalcEngine.OP_CLEAR));
        funcPad.add(calcEngine.createOpButton("calcButton-erase", "CE", CalcEngine.OP_ERASE));
        funcPad.add(calcEngine.createOpButton("calcButton-equals", "=", CalcEngine.OP_EQUALS));

        VerticalPanel spacerPad = new VerticalPanel();
        spacerPad.add(new HTML("&nbsp;"));
        
        this.add(numPad);
        this.add(spacerPad);
        this.add(opPad);
        this.add(funcPad);
    }

    
    public String getValue ()
    {
        return Double.toString(calc.getTotal());
    }
    
    
    class SimpleCalculator extends CalcEngine
    {
        
        SimpleCalculator (SimpleCalcPanel calcPanel, CalcDisplayListener cdl, TextBox textDisplay)
        {
            super(cdl);
            calcPanel.buildCalcLayout(this, textDisplay);
        }

    }



    public void clearValue ()
    {
        calc.pressOperator(CalcEngine.OP_CLEAR);
    }

}
