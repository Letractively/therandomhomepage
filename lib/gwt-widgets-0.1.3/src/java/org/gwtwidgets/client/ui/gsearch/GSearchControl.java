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

import org.gwtwidgets.client.ui.gsearch.KeepListener;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;


/**
 * Main Java Class in the Google Ajax Web Search GWT implementation
 * This class contains a link through to the object controlling the
 * GSearchControl
 * 
 * @author Adam Tacy
 * @version 0.0.2
 */
public class GSearchControl extends JavaScriptObject{

	protected GSearchControl(int opaque) {
		super(opaque);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Object that implements the JNSI calls to the GSearchControl
	 */
	private static GSearchControlImpl impl = new GSearchControlImpl();

	/**
	 * Various constants defined here
	 */
	public static final int DRAW_MODE_LINEAR=1;
	public static final int DRAW_MODE_TABBED=2;
	public static final int TIMEOUT_SHORT = 10;
	public static final int TIMEOUT_MEDIUM = 11;
	public static final int TIMEOUT_LONG = 12;
	public static final int EXPAND_MODE_CLOSED = 20;
	public static final int EXPAND_MODE_OPEN = 21;
	public static final int EXPAND_MODE_PARTIAL = 22;

	/**
	 * For future use of onKeep callback functionality
	 */
	public static KeepListener theThing;
	

	/**
	 * For future use of onKeep callback functionality
	 */
	public static void onKeep2(){
		theThing.onKeep();
	}

	/**
	 * Create method provides an instance from the underlying javascript object
	 * @return A valid GSearchControl Javascript object
	 */
	public static GSearchControl create(){
		return GSearchControlImpl.createSearchObject();
	}
	
	/**
	 * For future use
	 * @param theListener
	 */
	public  void addOnKeepListener(KeepListener theListener){
		theThing = theListener;
		impl.setOnKeepCallback(this, theListener);	
	}

	
	/**
	 * For future use
	 * @param theListener
	 */
	public void addOnKeepListener() {
		theThing = new KeepListener(){
			public void onKeep() {
				Window.alert("Default onKeep");
			}
		};
		impl.setOnKeepCallback(this, theThing);
	}


	public void execute(String searchString){
		impl.execute(this, searchString);
	}

	public void execute() {
		impl.execute(this);
	}

	
	public void addSearcher(GwebSearch theWebSearcher) {
		impl.addSearcher(this, theWebSearcher);
	}
	
	public void addSearcher(GlocalSearch theLocalSearcher) {
		impl.addSearcher(this,theLocalSearcher);
	}
	
	public void addSearcher(GvideoSearch theVideoSearcher) {
		impl.addSearcher(this,theVideoSearcher);
	}
	
	public void addSearcher(GblogSearch theBlogSearcher) {
		impl.addSearcher(this,theBlogSearcher);
	}
	
	public void addSearcher(GwebSearch theWebSearcher, GsearcherOptions options) {
		impl.addSearcher(this, theWebSearcher, options);
	}
	
	public void addSearcher(GlocalSearch theLocalSearcher, GsearcherOptions options) {
		impl.addSearcher(this,theLocalSearcher, options);
	}
	
	public void addSearcher(GvideoSearch theVideoSearcher, GsearcherOptions options) {
		impl.addSearcher(this,theVideoSearcher, options);
	}
	
	public void addSearcher(GblogSearch theBlogSearcher, GsearcherOptions options) {
		impl.addSearcher(this,theBlogSearcher, options);
	}
	
	public void draw(Element e){
		impl.draw(this,e);
	}
	
	public void draw(Element e, GdrawOptions options){
		impl.draw(this,e,options);
	}	
	
	public void setLinkTarget(int flag){
		impl.setLinkTarget(this,flag);
	}
	
	public void setTimeoutInterval(int timeoutInterval){
		impl.setTimeoutInterval(this,timeoutInterval);
	}

	public void setResultSetSize(int size) {
		impl.setResultSetSize(this,size);
	}

	public void cancelSearch() {
		impl.cancelSearch(this);
	}
	
	public void clearAllResults(){
		impl.clearAllResults(this);
	}
}
