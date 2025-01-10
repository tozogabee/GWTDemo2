package com.example.gwt.demo.client.tasks;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

public class Task4 extends TabItem {

    public Task4(String text) {
        this.setText(text);
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);

        setLayout(new FitLayout());

        List<List<Button>> buttons = createButtons(9);
        addButtonsToThePanel(buttons,index);
        buttonTextChangeInThisRowAndColumn(buttons);
    }
    
    private List<List<Button>> createButtons(int numOfButtons) {
        List<List<Button>> buttonGrid = new ArrayList<List<Button>>();
        int wholePart = getWholeValue(numOfButtons);
        int residualValue = getResidualValue(numOfButtons);

        for (int i = 0; i < wholePart; ++i) {
            List<Button> row = new ArrayList<Button>();
            for (int j = 0; j < wholePart; ++j) {
                row.add(new Button("1"));
            }
            buttonGrid.add(row);
        }

        if (residualValue > 0) {
            List<Button> residualRow = new ArrayList<Button>();
            for (int i = 0; i < residualValue; ++i) {
                residualRow.add(new Button("1"));
            }
            buttonGrid.add(residualRow);
        }

        return buttonGrid;
    }

    private void addButtonsToThePanel(List<List<Button>> buttonGrid, int index) {
        LayoutContainer outerContainer = new LayoutContainer();
        outerContainer.setLayout(new RowLayout());

        for (List<Button> row : buttonGrid) {
            LayoutContainer rowContainer = new LayoutContainer();
            rowContainer.setLayout(new HBoxLayout());
            rowContainer.setWidth(400);

            for (Button button : row) {
                rowContainer.add(button, new HBoxLayoutData(5, index, index, index)); 
            }

            outerContainer.add(rowContainer);
        }

        add(outerContainer);
    }

    
    private int getWholeValue(int numOfButtons) {
        return (int) Math.floor(Math.sqrt(numOfButtons));
    }

    private int getResidualValue(int numOfButtons) {
        int wholePart = getWholeValue(numOfButtons);
        return numOfButtons - (wholePart * wholePart);
    }
    
    private void buttonTextChangeInThisRowAndColumn(final List<List<Button>> buttonGrid) {
        for (int rowIndex = 0; rowIndex < buttonGrid.size(); ++rowIndex) {
            List<Button> row = buttonGrid.get(rowIndex);
            for (int colIndex = 0; colIndex < row.size(); ++colIndex) {
                final int currentRow = rowIndex;
                final int currentCol = colIndex;
                final Button button = row.get(colIndex);

                button.addSelectionListener(new SelectionListener<ButtonEvent>() {
                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        List<Button> sameRowAndColumnButtons = getSameRowAndColumnButtons(buttonGrid, currentRow, currentCol);
                        
                        for (final Button b : sameRowAndColumnButtons) {
                            if (b != button) {
                                int currentValue = Integer.parseInt(b.getText());
                                b.setText(String.valueOf(currentValue + 1));
                            }
                        }
                    }
                });
            }
        }
    }

    private List<Button> getSameRowAndColumnButtons(final List<List<Button>> buttonGrid, int row, int col) {
        List<Button> result = new ArrayList<Button>();

        for (int i = 0; i < buttonGrid.get(row).size(); ++i) {
            if (i != col) {
                result.add(buttonGrid.get(row).get(i));
            }
        }

        for (int i = 0; i < buttonGrid.size(); ++i) {
            if (i != row) {
                result.add(buttonGrid.get(i).get(col));
            }
        }

        return result;
    }


}
