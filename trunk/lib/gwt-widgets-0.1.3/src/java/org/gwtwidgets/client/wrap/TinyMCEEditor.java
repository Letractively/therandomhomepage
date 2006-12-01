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

package org.gwtwidgets.client.wrap;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.TextArea;

/**
 * Wrapper to use TinyMCE. Install by downloading tinyMCE from
 * http://tinymce.moxiecode.com/. Copy the tiny_mce folder to a 
 * location in your application like src/com.application.gwt/public/scripts/tiny_mce
 * 
 * In your GWT application Entry Point html file initialize TinyMCE.
 * 
 * <script src="scripts/tiny_mce/tiny_mce.js" type="text/javascript"></script>
 * <script language="javascript" type="text/javascript"> 
 *   tinyMCE.init({ 
 *     mode : "textareas", 
 *     theme : "advanced"
 *   });
 * </script>
 * 
 * NOTE: If you use Scriptaculous and TinyMCE, make sure you include the
 * tiny_mce.js before the prototype.js and scriptaculous.js tags, otherwise 
 * you will have loading issues.
 * 
 * @author Joe Toth (joetoth@gmail.com)
 * 
 */
public class TinyMCEEditor extends TextArea
{

	public TinyMCEEditor ()
    {
        super();
    }

    protected void onLoad ()
    {
        DeferredCommand.add(new Command()
        {
            public void execute ()
            {
                initialize(getElement());
            }
        });
    }

    public String getText ()
    {
        return getContent();
    }

    private native void initialize(Element e) /*-{
        $wnd.tinyMCE.addMCEControl(e, e.id);
    }-*/;

    private native String getContent() /*-{
        return $wnd.tinyMCE.getContent();
    }-*/;
}
