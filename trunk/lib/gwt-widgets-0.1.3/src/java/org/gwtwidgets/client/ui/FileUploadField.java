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
import com.google.gwt.user.client.ui.Widget;

/**
 * A file upload form field widget.
 * 
 * @author rhanson
 * @deprecated similar class included in GWT 1.1.0
 */
public class FileUploadField extends Widget
{

    /**
     * @param name name of this form field
     */
    public FileUploadField (String name)
    {
        setElement(DOM.createElement("input"));
        DOM.setAttribute(getElement(), "type", "file");
        DOM.setAttribute(getElement(), "name", name);
    }

}
