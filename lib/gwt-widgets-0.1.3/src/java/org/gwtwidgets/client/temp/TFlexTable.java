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

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

/**
 * Fix for removeRow(0 bug.
 * See http://groups.google.com/group/Google-Web-Toolkit/browse_thread/thread/78104bd661bebedd
 * for a full explaination.
 * 
 * @author Iancu Mihai (iancu.mihai@gmail.com) 
 */
class TFlexTable extends FlexTable
{
    public void removeRow (int row)
    {
        int total = this.getRowCount();
        int rowsBellow = total - row - 1;
        Widget[][] toMove = new Widget[rowsBellow][];
        //store old widgets
        for (int i = row + 1; i < total; i++) {
            int rCols = this.getCellCount(i);
            Widget[] wRow = new Widget[rCols];
            for (int j = 0; j < rCols; j++) {
                Widget w = this.getWidget(i, j);
                if (w != null) this.remove(w);
                wRow[j] = w;
            }
            toMove[i - row - 1] = wRow;
        }
        super.removeRow(row);
        //restore old widgets
        for (int i = row; i < total - 1; i++) {
            int rCols = this.getCellCount(i);
            Widget[] wRow = toMove[i - row];
            for (int j = 0; j < rCols; j++) {
                Widget w = wRow[j];
                if (w != null) this.setWidget(i, j, w);
            }
        }
    }
}