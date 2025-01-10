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
import com.example.gwt.demo.client.tasks.handler.ButtonClickHandler;

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
		Button b1 = createButton("With MessageBox", textField, new ButtonClickHandler() {
            @Override
            public void handleClick(String value) {
                handleButtonClick("MessageBox",value);
            }
        });
		
		Button b2 = createButton("With Info", textField, new ButtonClickHandler() {
            @Override
            public void handleClick(String value) {
            	handleButtonClick("Info",value);
            }
        });
		
		Button b3 = createButton("With Window alert", textField, new ButtonClickHandler() {
            @Override
            public void handleClick(String value) {
            	handleButtonClick("Alert",value);
            }
        });
		
		add(textField, new HBoxLayoutData(10, index, index, index));
		add(b1, new HBoxLayoutData(10, index, index, index));
		add(b2, new HBoxLayoutData(10, index, index, index));
		add(b3, new HBoxLayoutData(10, index, index, index));
	}
	
	
	private Button createButton(String label, final TextField<String> textField, final ButtonClickHandler clickHandler) {
	    Button button = new Button(label);
	    button.addSelectionListener(new SelectionListener<ButtonEvent>() {
	        @Override
	        public void componentSelected(ButtonEvent ce) {
	            String value = textField.getValue();
	            clickHandler.handleClick(value);
	        }
	    });
	    return button;
	}

	private void handleButtonClick(String action, String value) {
	    if (value != null && !value.isEmpty()) {
	        String reversedValue = reverseString(value);
	        if ("MessageBox".equals(action)) {
	            MessageBox.info("Info", reversedValue, null);
	        } else if ("Info".equals(action)) {
	            Info.display("with Info", reversedValue);
	        } else if ("Alert".equals(action)) {
	            Window.alert(reversedValue);
	        } else {
	            Window.alert("Unknown action: " + action);
	        }
	    }
	}


	private String reverseString(String word) {
		StringBuilder result = new StringBuilder();
		for(int i = word.length()-1; i >= 0; --i) {
			result.append(word.charAt(i));
		}
		return result.toString();
	}
}
