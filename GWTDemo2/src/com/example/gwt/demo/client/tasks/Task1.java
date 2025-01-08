package com.example.gwt.demo.client.tasks;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;


public class Task1 extends TabItem
{
	public Task1(String text){
		this.setText(text);
	}

	@Override
	protected void onRender(Element parent, int index){
		super.onRender(parent, index);
		Button b = new Button("with MessageBox");
		b.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                Window.alert("Task1");
            }
        });
		add(b);
	}

}
