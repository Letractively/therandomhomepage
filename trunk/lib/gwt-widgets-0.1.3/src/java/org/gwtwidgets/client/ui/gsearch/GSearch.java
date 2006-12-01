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

public class GSearch extends JavaScriptObject {
	
	protected GSearch(int opaque) {
		super(opaque);
		// TODO Auto-generated constructor stub
	}
	public static final int LARGE_RESULTSET = 1;
	public static final int SMALL_RESULTSET = 2;
	public static final int LINK_TARGET_BLANK=10;
	public static final int LINK_TARGET_SELF=11;
	public static final int LINK_TARGET_TOP=12;
	public static final int LINK_TARGET_PARENT=13;
	
	public int getResultSize(){
		return 10;
	}
	
}
