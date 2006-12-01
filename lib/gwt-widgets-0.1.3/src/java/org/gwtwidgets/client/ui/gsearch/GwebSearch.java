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

/**
 * Java Class wrapping an underlying JSNI implementation of the 
 * GwebSearch object
 *  
 * @author Adam Tacy
 * @version 0.0.2
 */
public class GwebSearch extends GSearch{

	protected GwebSearch(int opaque) {
		super(opaque);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Reference to underlying JAvaScript implementaiton 
	 */
	private static GwebSearchImpl impl = new GwebSearchImpl();
	
	/**
	 * Method to create a GwebSearch object
	 * @return The search object.
	 */
	public static GwebSearch create(){ 
		return impl.create();
	}

	/**
	 * Sets a restriction on the sites that are searched over. 
	 * @param site Site searches are to be restricted to.
	 */
	public void setSiteRestriction(String site) {
		impl.setSiteRestriction(this,site);
	}
}
