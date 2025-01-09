package com.example.gwt.demo.client;

import java.util.Locale;

import com.example.gwt.demo.client.tasks.Task1;
import com.example.gwt.demo.client.tasks.Task2;
import com.example.gwt.demo.client.tasks.Task3;
import com.example.gwt.demo.client.tasks.Task4;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTDemo2 implements EntryPoint {
	private ContentPanel cp;
	private TabPanel tp;

	@Override
	public void onModuleLoad() {

		cp = new ContentPanel();
		cp.setHeaderVisible(true);
		cp.setWidth("100%");
		cp.setFrame(true);
		cp.setHeading("Test tasks");
		cp.setLayout(new FitLayout());

		tp = new TabPanel();
		tp.add(new Task1("1st Task"));
		tp.add(new Task2("2nd Task"));
		tp.add(new Task3("3rd Task"));
		tp.add(new Task4("4th Task"));
		
		




		tp.setSelection(tp.getItem(tp.getItemCount() -1)); // mindig a legutolsó legyen megnyitva alapból

		cp.add(tp);
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				Resize();
			}
		});
		Resize();

		RootPanel.get("gwt").add(cp);
	}

	// Az ablak teljes magasságára méreteződjön
	private void Resize() {
		cp.setHeight(Window.getClientHeight());
	}
	
}
