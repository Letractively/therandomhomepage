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

package org.gwtwidgets.client.ui.pagination;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Retrieves the next page. Pass the AsyncCallback provided to a RPC call or
 * call it manually with a new List to update the table.
 * 
 * @author Joe Toth (joetoth@gmail.com)
 * 
 */
public interface DataProvider {
	/**
	 * 
	 * Since javascript is asynchronous, after the Results object is create the
	 * updateTableCallback needs to be executed. Usually you will retrieve
	 * results via a remote servlet, so you can call your service with the
	 * callback.
	 * 
	 * Ex. service.find(parameters, callback);
	 * 
	 * @param parameters
	 * @param callback
	 * @return
	 */
	public abstract void update(PaginationParameters parameters,
			AsyncCallback updateTableCallback);
}