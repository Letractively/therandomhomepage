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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * An HTML form widget.
 * 
 * @author rhanson
 * @deprecated similar class included in GWT 1.1.0
 */
public class FormPanel extends FlowPanel
{

    private Panel panel;

    
    /**
     * @param panel internal panel used for organizing widgets added to the form.
     */
    public FormPanel (Panel panel)
    {
        this.panel = panel;
        setElement(DOM.createElement("form"));
        super.add(panel);
    }

    public FormPanel (Panel panel, String action, String target, boolean isPost)
    {
        this(panel);
        
        setAction(action);
        setTarget(target);
        if (isPost) {
            setMethodAsPost();
        }
        else {
            setMethodAsGet();
        }
    }

    public FormPanel (Panel panel, String action, String target, boolean isPost, String enctype)
    {
        this(panel, action, target, isPost);
        setEncodingType(enctype);
    }

    public Panel getPanel ()
    {
        return panel;
    }
     
    /**
     * Sets the enctype attribute of the form
     * 
     * @param type
     */
    public void setEncodingType (String type)
    {
        DOM.setAttribute(getElement(), "enctype", type);
        DOM.setAttribute(getElement(), "encoding", type); 
    }

    /**
     * Sets the enctype attribute of the form to "multipart/form-data"
     */
    public void setMultipartEncoding ()
    {
        setEncodingType("multipart/form-data");
    }

    public void setMethodAsGet ()
    {
        DOM.setAttribute(getElement(), "method", "get");
    }

    public void setMethodAsPost ()
    {
        DOM.setAttribute(getElement(), "method", "post");
    }

    /**
     * @param url the form action attribute
     */
    public void setAction (String url)
    {
        DOM.setAttribute(getElement(), "action", url);
    }
    
    /**
     * @param url the form target attribute
     */
    public void setTarget (String targetName)
    {
        DOM.setAttribute(getElement(), "target", targetName);
    }

    public void add (Widget widget) {
        if (panel == null) {
            return;
        }
        panel.add(widget);
    }

    
    /**
     * Adds a widget to the underlying panel and sets the "name"
     * attribute.  This will allow the value of the form field to
     * be passed to the server when the form is submitted.
     * 
     * @param field the widget to add to the form
     * @param name the form field name
     * @return false if widget can not be added
     */
    public boolean addField (Widget field, String name)
    {
       DOM.setAttribute(field.getElement(), "name", name);
       add(field);
       return true;
    } 


    public void submit ()
    {
        submitForm(getElement());
    }
    
    private native void submitForm (Element e) /*-{
        e.submit();
    }-*/;

}
