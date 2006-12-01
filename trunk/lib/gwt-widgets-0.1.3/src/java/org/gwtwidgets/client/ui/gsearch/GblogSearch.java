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
 * GblogSearch object
 *  
 * @author Adam Tacy
 * @version 0.0.2
 */
public class GblogSearch extends JavaScriptObject{

	/**
	 * Reference to the underlying Javascript object. 
	 */
	private static GblogSearchImpl impl = new GblogSearchImpl();
	

	/**
	 * Create an instance of the GblogSearch object
	 * @return The search object
	 */
	public static GblogSearch create(){
		return impl.create();
	}
	

	/**
	 * Constructor 
	 * @param opaque
	 */
	protected GblogSearch(int opaque) {
		super(opaque);
		// TODO Auto-generated constructor stub
	}
}
