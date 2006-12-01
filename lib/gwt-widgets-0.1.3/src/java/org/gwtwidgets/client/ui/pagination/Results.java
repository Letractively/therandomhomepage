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

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Size is the total number of possible rows to page through. List is the list
 * of objects on the current page.
 * 
 * @author Joe Toth (joetoth@gmail.com)
 * 
 */
public class Results implements IsSerializable {

	private int size;

	private List list;

	public Results() {

	}

	public Results(int size, List list) {
		this.size = size;
		this.list = list;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
