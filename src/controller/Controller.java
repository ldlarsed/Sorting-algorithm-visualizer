package controller;

import model.DataCreator;
import view.BarPanel;
import view.Window;

public class Controller {

//	private Window window;
	private BarPanel barPanel;
	private int[] data;
	
	public Controller(){
		data = DataCreator.createDataArray(1, 100, 100);
		barPanel = new BarPanel(data);
		new Window(barPanel);
//		window.setDataPanel(barPanel);
	}
}
