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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

/**
 * Pagination is a wrapper for FlexTable that allows easy support for paging
 * through data.
 * 
 * NOTE: In case your wondering, Pagination takes a FlexTable as a parameter to
 * abstract its logic from the view. Pagination (the term in general) is more of
 * a logic implementation than a UI control, it controls a table, hence the
 * current implementation. You can keep your UI construction in a completely
 * separate class to keep the MVC paradigm architecture.
 * 
 * h3>CSS Style Rules</h3>
 * <ul class="css">
 * <li>.oddRow { }</li>
 * <li>.evenRow { }</li>
 * <li>.oddCell { }</li>
 * <li>.evenCell { }</li>
 * </ul>
 * 
 * @author Joe Toth (joetoth@gmail.com)
 * 
 */
abstract public class PaginationBehavior {

	PaginationParameters parameters;

	Results results;

	int rowCount;

	int resultsPerPage;

	int page;

	FlexTable table;

	public PaginationBehavior(FlexTable table, int resultsPerPage) {
		table.clear();
		this.table = table;
		this.resultsPerPage = resultsPerPage;
	}

	public void showPage(int page, String parameter, boolean isAscending) {
		this.page = page;
		this.parameters = new PaginationParameters();
		this.parameters.setAscending(isAscending);
		this.parameters.setMaxResults(resultsPerPage);
		this.parameters.setParameter(parameter);

		int firstResults = 0;
		if (page > 1) {
			firstResults = (page - 1) * resultsPerPage;
		}
		this.parameters.setOffset(firstResults);

		getDataProvider().update(this.parameters, new AsyncCallback() {

			public void onSuccess(Object result) {

				if (!(result instanceof Results)) {
					throw new RuntimeException(
							"result from DataProvider must be of type Results");
				}

				int rowCount = table.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					table.removeRow(0);
				}

				results = (Results) result;

				List resultsList = results.getList();

				rowCount = resultsList.size();
				if (rowCount > resultsPerPage) {
					rowCount = resultsPerPage;
				}

				for (int i = 0; i < rowCount; i++) {
					getRowRenderer().populateRow(PaginationBehavior.this, i,
							resultsList.get(i));

					// Set style of row
					DOM.setAttribute(
							getTable().getRowFormatter().getElement(i),
							"className", (i % 2 == 1 ? "evenRow" : "oddRow"));
				}

				onUpdateSuccess(result);
			}

			public void onFailure(Throwable caught) {
				onUpdateFailure(caught);
			}

		});
	}

	public void setCell(int row, int column, Widget widget) {
		table.setWidget(row, column, widget);

		// Set style of cell
		DOM.setAttribute(getTable().getCellFormatter().getElement(row, column),
				"className", (row % 2 == 1 ? "evenCell" : "oddCell"));
	}

	protected void onUpdateSuccess(Object result) {

	}

	protected void onUpdateFailure(Throwable caught) {
		throw new RuntimeException(caught);
	}

	abstract protected RowRenderer getRowRenderer();

	abstract protected DataProvider getDataProvider();

	public FlexTable getTable() {
		return table;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getResultsPerPage() {
		return resultsPerPage;
	}

	public PaginationParameters getParameters() {
		return parameters;
	}

	public int getPage() {
		return page;
	}

	public Results getResults() {
		return results;
	}

}
