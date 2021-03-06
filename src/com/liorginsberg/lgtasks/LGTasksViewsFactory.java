/***
  Copyright (c) 2008-2012 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
  
  From _The Busy Coder's Guide to Advanced Android Development_
    http://commonsware.com/AdvAndroid
 */

package com.liorginsberg.lgtasks;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class LGTasksViewsFactory implements RemoteViewsService.RemoteViewsFactory {

	private List<Task> mWidgetItems;
	private Context ctxt = null;


	public LGTasksViewsFactory(Context ctxt, Intent intent) {
		this.ctxt = ctxt;
		
	}

	@Override
	public void onCreate() {
		mWidgetItems = TaskList.getInstance(ctxt).getTasks();
		
	}

	@Override
	public void onDestroy() {
		// no-op
	}

	@Override
	public int getCount() {
		return (mWidgetItems.size());
	}

	@Override
	public RemoteViews getViewAt(int position) {
		RemoteViews row = new RemoteViews(ctxt.getPackageName(), R.layout.widget_row);

		row.setTextViewText(android.R.id.title, mWidgetItems.get(position).getTitle());

		return (row);
	}

	@Override
	public RemoteViews getLoadingView() {
		return (null);
	}

	@Override
	public int getViewTypeCount() {
		return (1);
	}

	@Override
	public long getItemId(int position) {
		return (position);
	}

	@Override
	public boolean hasStableIds() {
		return (true);
	}

	@Override
	public void onDataSetChanged() {
		
	}
}