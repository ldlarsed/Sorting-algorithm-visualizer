package controller;

import java.security.InvalidParameterException;

import javax.swing.JOptionPane;

import lib.ButtonType;
import model.AnimBubbleSort;
import model.DataCreator;
import view.BarPanel;
import view.Window;

public class Controller {

	private Window window;
	private BarPanel barPanel;
	private int[] data;

	public Controller() {
		data = DataCreator.createDataArray(1, 50, 50); // Creates some data at
														// start
		barPanel = new BarPanel(data);
		window = new Window(barPanel);

		window.setButtonListener(new ButtonListener() {

			@Override
			public void buttonPressed(ButtonType bt) {
				switch (bt) {
				case SORT:
					// Sorting button pressed
					AnimBubbleSort bub = new AnimBubbleSort(data);

					Thread thread = new Thread(new Runnable() {
						@Override
						public void run() {
							while (bub.hasNext()) {
								bub.sortNextStep();
								window.revalidate();
								window.repaint();
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								sendNewDataset(bub.getCurrentData());
							}
						}
					});
					thread.start();
					// try {
					// // thread.wait(500);
					// thread.join();
					// } catch (InterruptedException e) {
					// e.printStackTrace();
					// }
					if(!bub.hasNext()) thread.interrupt();
					break;
				case NEW_DATA:
					updateBars();
					break;
				default:
					throw new InvalidParameterException("Wrong on button type "
							+ this.getClass().getName());
				}
			}
		});

	}

	/**
	 * Updates bars from the values input
	 */
	private void updateBars() {
		int[] v = window.getValues();
		createNewDataset(v[0], v[1], v[2]);
	}

	/**
	 * Creates and sends a new dataset to the window;
	 * 
	 * @param min
	 * @param max
	 * @param n
	 */
	private void createNewDataset(int min, int max, int n) {
		int[] data = DataCreator.createDataArray(min, max, n);
		BarPanel barPanel = new BarPanel(data);
		window.setDataPanel(barPanel);
		window.setButtonText("Changed");
	}

	/**
	 * Sends a choosen dataset to the window
	 * 
	 * @param data
	 */
	private void sendNewDataset(int[] data) {
		BarPanel barPanel = new BarPanel(data);
		window.setDataPanel(barPanel);
		window.setButtonText("Sorted");
	}

}
