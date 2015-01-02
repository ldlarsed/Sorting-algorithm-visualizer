package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.NoSuchElementException;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BarPanel extends JPanel {

	private int[] values;

	public BarPanel(int[] values) {
		this.values = values;
//		System.out.println(Arrays.toString(values));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (values == null || values.length == 0){
			throw new IndexOutOfBoundsException("Zero values");
		}

		int minValue = 0;
		int maxValue = 0;

		// Finding min and max values in data array
		for (int i = 0; i < values.length; i++) {
			if (minValue > values[i]){
				minValue = values[i];
//				System.out.println("New min value "+minValue);
			}
			if (maxValue < values[i]){
				maxValue = values[i];
//				System.out.println("New max value "+maxValue);
			}
		}

		// Setting up propriate size for the component
		Dimension d = getSize();
		int panelWidth = d.width;
		int panelHeight = d.height;
		int barWidth = panelWidth / values.length;

		if (maxValue == minValue){
			throw new NoSuchElementException("Equal values");
		}

		// Setts up the scale based on height divided by value differance
		double scale = panelHeight / (maxValue - minValue);

		for (int i = 0; i < values.length; i++) {
			int valueX = i * barWidth + 1;
			int valueY = 0;
			int height = (int) (values[i] * scale);
			if (values[i] >= 0)
				valueY += (int) ((maxValue - values[i]) * scale);
			else {
				valueY += (int) (maxValue * scale);
				height = -height;
			}

			g.setColor(Color.BLUE);
			g.fillRect(valueX, valueY, barWidth - 2, height);
			g.setColor(Color.BLACK);
			g.drawRect(valueX, valueY, barWidth - 2, height);
		}
	}

}
