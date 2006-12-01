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

package org.gwtwidgets.client.ui.gsearch;

import com.google.gwt.user.client.Element;

/**
 * Java Class providing operations for the underlying psuedo implementation of the 
 * GdrawOptions object - there is no corresponding JNSI implementation for this object.
 *  
 * @author Adam Tacy
 * @version 0.0.2
 */
public class GdrawOptions {


	/**
	 * Should the input be taken from a non default input box? 
	 */
	private Element eToAttachInput=null;
	
	/**
	 * What should the draw mode be?
	 */
	private int drawMode = -1;
	
	/**
	 * Is the draw mode been set to anything but the default?
	 * @return True if it has.
	 */
	public boolean isDrawModeSet(){
		return (drawMode!=-1);
	}

	/**
	 * Is an non default input box attached to the draw options?
	 * @return true if one is.
	 */
	public boolean isInputAttached(){
		return (eToAttachInput!=null);
	}
	
	
	/**
	 * Get the input element
	 * @return Input element
	 */public Element getInputElement(){
		return eToAttachInput;
	}
	
	 /**
	  * Set input element
	  * @param e Input element
	  */
	public void setInput(Element e){
		eToAttachInput = e;
	}
	
	/**
	 * Set Draw Mode
	 * @param mode The new Draw Mode
	 */
	public void setDrawMode(int mode){
		drawMode = mode;
	}

	/**
	 * Get Draw Mode
	 * @return The Draw Mode.
	 */
	public int getDrawMode(){
		return drawMode;
	}
	
	/**
	 * Constructor
	 *
	 */
	public GdrawOptions() {
	}
}
