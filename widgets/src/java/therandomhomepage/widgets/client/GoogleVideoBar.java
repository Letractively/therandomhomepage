/*
 * Copyright 2006 Siddique Hameed <siddii AT gmail.com> - http://www.TheRandomHomepage.com
 *
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

package therandomhomepage.widgets.client;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Feb 22, 2007
 * Time: 2:06:27 PM
 */
public class GoogleVideoBar extends Widget {
    private String searchTerms;
    private Element videoBarElement;
    private Element videoPlayerElement;
    private JavaScriptObject vbr;

    public GoogleVideoBar(String searchTerms) {
        this.searchTerms = searchTerms;
        Element googleVideoBarElement = DOM.createDiv();
        videoBarElement = DOM.createDiv();
        DOM.appendChild(googleVideoBarElement,videoBarElement);

        videoPlayerElement = DOM.createDiv();
        DOM.appendChild(googleVideoBarElement,videoPlayerElement);
        setElement(googleVideoBarElement);
    }


    protected void onLoad() {
        loadVideoBar();
    }

    /*
    function LoadVideoBar() {
    var vbr;

    var options = {
      largeResultSet : true
    }
    vbr = new GSvideoBar(
                document.getElementById("videoBar"),
                document.getElementById("videoPlayer"),
                options
                );
    vbr.execute("VW GTI");
  }
     */

    protected static native void loadVideoBar() /*-{
        var options = {
          largeResultSet : true
        }
        vbr = new GSvideoBar(
                    videoBarElement,
                    videoPlayerElement,
                    options
                    );
        vbr.execute(searchTerms);
        GSearch.setOnLoadCallback(loadVideoBar);
    }-*/;
}
