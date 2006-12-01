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

import java.util.ArrayList;
import java.util.List;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * 
 * @author rhanson
 */
public class SearchUtils
{

    /**
     * Returns a List of Element objects that have the specified CSS class name.
     * 
     * @param element Element to start search from
     * @param className name of class to find
     * @return
     */
    public static List findElementsForClass (Element element, String className)
    {
        ArrayList result = new ArrayList();
        recElementsForClass(result, element, className);
        return result;
    }

    private static void recElementsForClass (ArrayList res, Element element, String className)
    {
        String c;
        
        if (element == null) {
            return;
        }

        c = DOM.getAttribute(element, "className");
        
        if (c != null) {
            String[] p = c.split(" ");
            
            for (int x = 0; x < p.length; x++) {
                if (p[x].equals(className)) {
                    res.add(element);
                }
            }
        }
        
        for (int i = 0; i < DOM.getChildCount(element); i++) {
            Element child = DOM.getChild(element, i);
            recElementsForClass(res, child, className);
        }
    }
    
}
