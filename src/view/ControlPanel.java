package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import lib.Const;

public class ControlPanel extends JPanel {

	private JPanel algPanel, valuesPanel, speedPanel;
	private JLabel bubblesortLabel, lowestValueLabel, highestValueLabel,
			countLabel;
	private JSlider speed;
	private JTextField min, max, count;

	public ControlPanel() {
		this.setLayout(new BorderLayout());

		
		
		//Speedslider
		speed = new JSlider(JSlider.HORIZONTAL, 10, 30, 12);
		speed.setMajorTickSpacing(10);
		speed.setMinorTickSpacing(1);
		speed.setPaintTicks(true);
		speed.setPaintLabels(true);
		speedPanel = new JPanel(new BorderLayout());
		speedPanel.add(speed, BorderLayout.CENTER);
		
		
		//Borders
		this.setBorder(BorderFactory.createTitledBorder(Const.CONTROL_PANEL));
		speedPanel.setBorder(BorderFactory.createTitledBorder(Const.ANIM_SPEED));

		this.add(speedPanel, BorderLayout.CENTER);

	}

}
