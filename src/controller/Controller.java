package controller;

import java.security.InvalidParameterException;

import lib.ButtonType;
import model.DataCreator;
import view.BarPanel;
import view.Window;

public class Controller {

	private Window window;
	private BarPanel barPanel;
	private int[] data;

	public Controller() {
		data = DataCreator.createDataArray(1, 50, 50);
		barPanel = new BarPanel(data);
		window = new Window(barPanel);
		// window.setDataPanel(barPanel);

		window.setButtonListener(new ButtonListener() {

			@Override
			public void buttonPressed(ButtonType bt) {
				switch (bt) {
				case SORT:
					// Trying to change existing data-set
					int[] data = DataCreator.createDataArray(1, 10, 10);
					BarPanel barPanel = new BarPanel(data);
					window.setDataPanel(barPanel);
					window.setButtonText("Changed");
					break;
				default:
					throw new InvalidParameterException("Wrong on button type "
							+ this.getClass().getName());
				}
			}
		});

	}

}
