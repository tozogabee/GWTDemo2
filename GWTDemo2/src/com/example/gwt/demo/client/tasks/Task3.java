package com.example.gwt.demo.client.tasks;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;
import com.extjs.gxt.ui.client.widget.Window;


public class Task3 extends TabItem {
	
	
	public Task3(String text){
		this.setText(text);
	}
	
	@Override
	protected void onRender(Element parent, int index){
		super.onRender(parent, index);
		LayoutContainer container = new LayoutContainer();
        final Window gxtWindow = new Window();
        gxtWindow.setHeading("GXT Window Example");
        gxtWindow.setSize(400, 200);
        gxtWindow.setModal(true); // Makes the window modal (blocks background interactions)
        gxtWindow.setResizable(false); // Disables window resizing
        container.setLayout(new FlowLayout());
        container.setStyleAttribute("background-color", "#d0e4f7"); // Set a background color

        container.addListener(Events.OnClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                gxtWindow.show();
            }
        });
        setLayout(new FitLayout());
		add(container);
	}

}
