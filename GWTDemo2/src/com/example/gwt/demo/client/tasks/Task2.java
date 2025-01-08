package com.example.gwt.demo.client.tasks;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;

public class Task2 extends TabItem{
	
	public Task2(String text){
		this.setText(text);
	}

	@Override
	protected void onRender(Element parent, int index){
		super.onRender(parent, index);
		Button b1 = new Button("with MessageBox");
		Button b2 = new Button("with Info");
		Button b3 = new Button("with Window");
		b1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			String word = "Task2";
            @Override
            public void componentSelected(ButtonEvent ce) {
            	MessageBox.info("Info",word, null);
            }
        });
		b2.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
            	Info.display("with Info", "Info display");
            }
        });
		b3.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
            	Window.alert("window alert");
            }
        });
		add(b1);
		add(b2);
		add(b3);
	}
	
	/*private String reverseString(String word) {
		String result = "";
		for(int i = word.length()-1; i >= 0; --i) {
			result.toCharArray();
		}
	}*/
}
