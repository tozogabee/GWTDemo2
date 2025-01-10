package com.example.gwt.demo.client.tasks;

import com.extjs.gxt.ui.client.event.DomEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;


public class Task3 extends TabItem {
	
	
	public Task3(String text){
		this.setText(text);
	}
	
	@Override
	protected void onRender(Element parent, int index){
		super.onRender(parent, index);
		LayoutContainer container = new LayoutContainer();
        container.setLayout(new FlowLayout());
        container.setStyleAttribute("background-color", "#d0e4f7");
        
        container.addListener(Events.OnClick, new Listener<DomEvent>() {

			@Override
			public void handleEvent(DomEvent be) {
		        final Window gxtWindow = new Window();
		         int windowWidth = com.google.gwt.user.client.Window.getClientWidth();
		         int windowHeight = com.google.gwt.user.client.Window.getClientHeight();
		        gxtWindow.setHeading("GXT Window Example");
		        gxtWindow.setSize(400, 200);
		        gxtWindow.setModal(true);
		        gxtWindow.setResizable(false); 

				int clickX = be.getClientX();
				int clickY = be.getClientY();
				
		        int gxtWindowWidth = 400;
		        int gxtWindowHeight = 200;
				

		        if (clickX + gxtWindowWidth > windowWidth) {
		            clickX = windowWidth - gxtWindowWidth;
		        }
		        if (clickY + gxtWindowHeight > windowHeight) {
		            clickY = windowHeight - gxtWindowHeight;
		        }

		         clickX = Math.max(clickX, 0);
		         clickY = Math.max(clickY, 0);
		         gxtWindow.setPosition(clickX,clickY);
		         gxtWindow.show();
			}
        	
        });
        
     
        setLayout(new FitLayout());
		add(container);
	}
}
