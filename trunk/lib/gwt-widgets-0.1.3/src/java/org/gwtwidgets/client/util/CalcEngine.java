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

package org.gwtwidgets.client.util;

import org.gwtwidgets.client.ui.CalcDisplayListener;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;


public abstract class CalcEngine
{
    private static final int STATE_KEYING = 1;
    private static final int STATE_KEYING_DEC = 2;
    private static final int STATE_POSTOP = 3;

    public static final int OP_NONE = 0;
    public static final int OP_PLUS = 1;
    public static final int OP_MINUS = 2;
    public static final int OP_EQUALS = 3;
    public static final int OP_CLEAR = 4;
    public static final int OP_ERASE = 5;
    public static final int OP_MULT = 6;
    public static final int OP_DIV = 7;
    public static final int OP_DEC = 8;
    public static final int OP_NEGATE = 9;

    private int currentState = STATE_POSTOP;
    private int pendingOp = OP_NONE;
    private String currentDisplay = "0";
    private double totalBuffer = 0;
    private CalcDisplayListener displayListener;



    protected CalcEngine (CalcDisplayListener cdl)
    {
        this.displayListener = cdl;
        refreshDisplay();
    }

    public Button createNumberButton (String styleName, String symbol, int num)
    {
        Button b = new Button(symbol);
        b.setStyleName("calcButton");
        b.addStyleName(styleName);
        b.addClickListener(new NumberClickListener(num, this));
        return b;
    }

    public Button createOpButton (String styleName, String symbol, int op)
    {
        Button b = new Button(symbol);
        b.setStyleName("calcButton");
        b.addStyleName(styleName);
        b.addClickListener(new OpClickListener(op, this));
        return b;
    }

    public void pressOperator (int op)
    {
        switch (op) {
            case OP_PLUS:
            case OP_MINUS:
            case OP_MULT:
            case OP_DIV:
                pendingOp = op;
                totalBuffer = Double.parseDouble(currentDisplay);
                currentState = STATE_POSTOP;
                break;
            case OP_EQUALS:
                totalValue();
                break;
            case OP_ERASE:
                currentDisplay = "0";
                refreshDisplay();
                break;
            case OP_CLEAR:
                currentDisplay = "0";
                totalBuffer = 0;
                refreshDisplay();
                break;
            case OP_DEC:
                if (currentState == STATE_KEYING_DEC) break;
                if (currentState == STATE_POSTOP) currentDisplay = "0";
                currentDisplay += ".";
                currentState = STATE_KEYING_DEC;
                refreshDisplay();
                break;
            case OP_NEGATE:
                if (currentDisplay.length() > 0 && currentDisplay.startsWith("-")) {
                    currentDisplay = currentDisplay.substring(1);
                }
                else {
                    currentDisplay = "-" + currentDisplay;
                }
                refreshDisplay();
                break;
        }
    }

    private void totalValue ()
    {
        switch (pendingOp) {
            case OP_PLUS:
                addValues();
                break;
            case OP_MINUS:
                subtractValues();
                break;
            case OP_MULT:
                multiplyValues();
                break;
            case OP_DIV:
                divideValues();
                break;
        }
        currentDisplay = Double.toString(totalBuffer);
        currentState = STATE_POSTOP;
        pendingOp = OP_NONE;
        refreshDisplay();
    }

    private void divideValues ()
    {
        setTotalBuffer(totalBuffer / Double.parseDouble(currentDisplay));
    }

    private void multiplyValues ()
    {
        setTotalBuffer(totalBuffer * Double.parseDouble(currentDisplay));
    }

    private void subtractValues ()
    {
        setTotalBuffer(totalBuffer - Double.parseDouble(currentDisplay));
    }

    private void setTotalBuffer (double total)
    {
        this.totalBuffer = total;
    }

    private void addValues ()
    {
        setTotalBuffer(totalBuffer + Double.parseDouble(currentDisplay));
    }

    public void refreshDisplay ()
    {
        displayListener.onDisplayRefresh(currentDisplay);
    }

    public void pressDigit (int num)
    {
        switch (currentState) {
            case STATE_POSTOP:
                currentDisplay = Integer.toString(num);
                currentState = STATE_KEYING;
                break;
            case STATE_KEYING:
            case STATE_KEYING_DEC:
                if (currentDisplay.equals("0")) {
                    currentDisplay = Integer.toString(num);
                }
                else {
                    currentDisplay += Integer.toString(num);
                }
                break;
        }

        refreshDisplay();
    }

    public double getTotal ()
    {
        return totalBuffer;
    }


    private class OpClickListener implements ClickListener
    {
        private int op;
        private CalcEngine calc;



        public OpClickListener (int op, CalcEngine calc)
        {
            this.calc = calc;
            this.op = op;
        }

        public void onClick (Widget sender)
        {
            calc.pressOperator(op);
        }
    }

    private class NumberClickListener implements ClickListener
    {
        private int num;
        private CalcEngine calc;



        public NumberClickListener (int num, CalcEngine calc)
        {
            this.calc = calc;
            this.num = num;
        }

        public void onClick (Widget sender)
        {
            calc.pressDigit(num);
        }
    }
}
