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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Java Class wrapping an underlying JSNI implementation of the 
 * GlocalSearch object
 *  
 * @author Adam Tacy
 * @version 0.0.2
 */
public class GlocalSearch extends JavaScriptObject{

	
	/**
	 * Link to the underlying JavaScript object 
	 */
	private static GlocalSearchImpl impl = new GlocalSearchImpl();
	

	/**
	 * Create an instance of a GlocalSearch object.
	 * @return
	 */
	public static GlocalSearch create(){
		return impl.create();
	}
	
	/**
	 * Execute a search on this particular object only.
	 *
	 */
	public void execute(){
		impl.execute(this);
	}
	
	/**
	 * Method to set the centre point - currently only strings are allowed
	 * but the API allows a GLatLng to be used, though this would imply a
	 * dependancy on Google Maps which we wish to avoid, just for now. 
	 * @param location
	 */
	public void setCenterPoint(String location) {
		impl.setCenterPoint(this,location);		
	}
	
	
	/**
	 * Constructor
	 * @param opaque
	 */protected GlocalSearch(int opaque) {
		super(opaque);
	}	
}
