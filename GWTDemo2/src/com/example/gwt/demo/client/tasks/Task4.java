package com.example.gwt.demo.client.tasks;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;

public class Task4 extends TabItem {

	public Task4(String text) {
		this.setText(text);
	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		HBoxLayout layout = new HBoxLayout();
		setLayout(layout);
		List<Button> buttons = createButtons(9);
		addButtonsToThePanel(buttons, index);
	}
	
	private List<Button> createButtons(int numOfButtons) {
	    List<Button> buttons = new ArrayList<Button>();
	    for (int i = 0; i < numOfButtons; ++i) {
	        buttons.add(new Button("1")); // Label each button uniquely
	    }
	    return buttons;
	}
	
	private void addButtonsToThePanel(List<Button> buttons, int index) {
	    int wholePart = getWholeValue(buttons.size());   // Number of buttons per row
	    int residualValue = getResidualValue(buttons.size()); // Remaining buttons for the last row

	    LayoutContainer outerContainer = new LayoutContainer();
	    outerContainer.setLayout(new RowLayout()); // Use RowLayout to stack rows vertically

	    int buttonIndex = 0;

	    // Add full rows
	    for (int i = 0; i < wholePart; ++i) {
	        LayoutContainer rowContainer = new LayoutContainer();
	        rowContainer.setLayout(new HBoxLayout()); // HBoxLayout for horizontal row

	        for (int j = 0; j < wholePart; ++j) {
	            rowContainer.add(buttons.get(buttonIndex++), new HBoxLayoutData(10, index, index, index));
	        }

	        outerContainer.add(rowContainer); // Add the row to the outer container
	    }

	    // Handle the remaining buttons (if any)
	    if (residualValue > 0) {
	        LayoutContainer residualRow = new LayoutContainer();
	        residualRow.setLayout(new HBoxLayout());

	        for (int i = 0; i < residualValue; ++i) {
	            residualRow.add(buttons.get(buttonIndex++), new HBoxLayoutData(10, index, index, index));
	        }

	        outerContainer.add(residualRow); // Add the last row with remaining buttons
	    }

	    add(outerContainer); // Add the outer container to the TabItem
	}

	private int getWholeValue(int numOfButtons) {
	    return (int) Math.floor(Math.sqrt(numOfButtons)); // Correct whole part
	}

	private int getResidualValue(int numOfButtons) {
	    int wholePart = getWholeValue(numOfButtons);
	    return numOfButtons - (wholePart * wholePart); // Remaining buttons
	}

}
