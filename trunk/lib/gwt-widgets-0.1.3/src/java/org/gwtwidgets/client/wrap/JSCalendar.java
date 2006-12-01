/**
 * Created on 31/05/2006
 * 
 * Wrapper for JSCalendar
 * NOTE: Excepts Javascript includes to be in enclosing HTML
 * 
 * Author: Aaron Watkins (aaronDOTjDOTwatkinsATgmailDOTcom)
 * Website: http://www.goannatravel.com
 * Home Page for initial release of this widget: http://www.goannatravel.com/home/goanna/55/56
 * 
 * Copyright [Aaron Watkins] [name of copyright owner]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtwidgets.client.wrap;

import org.gwtwidgets.client.style.Color;
import org.gwtwidgets.client.ui.ImageButton;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;

public class JSCalendar extends HorizontalPanel {

	private ImageButton button;
	private TextBox date;
	private String textId;
	private String buttonId;
	private static final String defaultImgLocation = "jscalendar/img.gif"; 
	
	/**
	 * JSCalendar() -
	 *
	 * Create a new instance of JSCalendar.
	 * Default constructor
	 */
	public JSCalendar() {
		this(defaultImgLocation);
	}
	
	/**
	 * JSCalendar() -
	 *
	 * Create a new instance of JSCalendar.
	 * Default constructor
	 * @param imgLocation - the path to the image to use for the button
	 */
	public JSCalendar(String imgLocation) {
		this(imgLocation, new Color(255, 0, 0));
	}
	
	/**
	 * JSCalendar() -
	 *
	 * Create a new instance of JSCalendar.
	 * Default constructor
	 * @param imgLocation - the path to the image to use for the button
	 * @param background - the background colour to use on mouseover
	 */
	public JSCalendar(String imgLocation, Color background) {
		super();
		
		date = new TextBox();
		date.setEnabled(false);
		date.setVisibleLength(10);
		textId = HTMLPanel.createUniqueId();
		DOM.setAttribute(date.getElement(), "id", textId);
		add(date);
		
		button = new ImageButton(imgLocation, 20, 14);
		button.setBackgroundOnColor(background);
		buttonId = HTMLPanel.createUniqueId();
		DOM.setAttribute(button.getElement(), "id", buttonId);
		add(button);
	}
	
	/**
	 * getDateBox() -
	 * 
	 * Simple getter for the datebox
	 * @return the datebox widget
	 */
	public TextBox getDateBox() {
		return date;
	}
	
	/**
	 * onLoad() -
	 * 
	 * Runs when widgets has been loaded into the browser.
	 * Initialises the calendar widget
	 */
	protected void onLoad() {
		DeferredCommand.add(new Command() {
			public void execute() {
				initCalendar(textId, buttonId);
			}
		});
	}

	/**
	 * initCalendar() -
	 * 
	 * Javascript native function that initialises the calendar widget
	 * @param textId - the DOM id of the textbox to display the date in
	 * @param buttonId - the DOM id of the button to trigger from
	 */
	protected native void initCalendar(String textId, String buttonId) /*-{
	    $wnd.Calendar.setup({
	        inputField     :    textId,     // id of the input field
	        button         :    buttonId,  // trigger for the calendar (button ID)
	        align          :    "Bl",           // alignment (defaults to "Bl")
	        singleClick    :    true
	    });
	}-*/;
	
	/**
	 * getDate() -
	 * 
	 * Simple function that formats the date.
	 * NOTE: This should use Java built in date formatting
	 *       Possibly not supported by GWT yet
	 * @param year
	 * @param month
	 * @param day
	 * @return the formatted date
	 */
	public static String getDate(int year, int month, int day) {
		String y = year + "";
		String m = month + "";
		if (month < 10)
			m = "0" + month;
		String d = day + "";
		if (day < 10)
			d = "0" + day;
		
		return y + "/" + m + "/" + d;
	}
}
