package com.example.gwt.demo.client.tasks;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;

public class Task2 extends TabItem{
	
	public Task2(String text){
		this.setText(text);
	}

	@Override
	protected void onRender(Element parent, int index){
		super.onRender(parent, index);
        HBoxLayout layout = new HBoxLayout();
        setLayout(layout);

		final TextField<String> textField = new TextField<String>();
		textField.setWidth(200);
		Button b1 = createButton1(textField);
		Button b2 = createButton2(textField);
		Button b3 = createButton3(textField);
		add(textField, new HBoxLayoutData(10, index, index, index));
		add(b1, new HBoxLayoutData(10, index, index, index));
		add(b2, new HBoxLayoutData(10, index, index, index));
		add(b3, new HBoxLayoutData(10, index, index, index));
	}
	
	
	// Method to create Button1 and add its listener
	private Button createButton1(final TextField<String> textField) {
	    Button b1 = new Button("With MessageBox");
	    b1.addSelectionListener(new SelectionListener<ButtonEvent>() {
	        @Override
	        public void componentSelected(ButtonEvent ce) {
	        	String value = textField.getValue();
	            handleButton1Click(value);
	        }
	    });
	    return b1;
	}

	// Method to create Button2 and add its listener
	private Button createButton2(final TextField<String> textField) {
	    Button b2 = new Button("with Info");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>() {
	        @Override
	        public void componentSelected(ButtonEvent ce) {
	        	String value = textField.getValue();
	            handleButton2Click(value);
	        }
	    });
	    return b2;
	}

	// Method to create Button3 and add its listener
	private Button createButton3(final TextField<String> textField) {
	    Button b3 = new Button("with Window alert");
	    b3.addSelectionListener(new SelectionListener<ButtonEvent>() {
	        @Override
	        public void componentSelected(ButtonEvent ce) {
	            String value = textField.getValue();
	            handleButton3Click(value);
	        }
	    });
	    return b3;
	}

	// Method to handle Button1 click
	private void handleButton1Click(final String value) {
		if(!value.isEmpty())
			MessageBox.info("Info", reverseString(value), null);
	}

	// Method to handle Button2 click
	private void handleButton2Click(String value) {
		if(!value.isEmpty())
			Info.display("with Info", reverseString(value));
	}

	// Method to handle Button3 click
	private void handleButton3Click(String value) {
		if(!value.isEmpty())
			Window.alert(reverseString(value));
	}

	
	private String reverseString(String word) {
		StringBuilder result = new StringBuilder();
		for(int i = word.length()-1; i >= 0; --i) {
			result.append(word.charAt(i));
		}
		return result.toString();
	}
}
