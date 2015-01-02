package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import lib.Const;

public class ControlPanel extends JPanel {

	private JPanel algPanel, labelValuesPanel, valuesPanel, valuesWrapperPanel, speedPanel;
	private JLabel bubblesortLabel, lowestValueLabel, highestValueLabel,
			countLabel;
	private JSlider speed;
	private JTextField min, max, count;

	public ControlPanel() {
		this.setLayout(new BorderLayout());
		
		//Values and labels
		lowestValueLabel = new JLabel(Const.LAB_LOW);
		highestValueLabel = new JLabel(Const.LAB_HIGH);
		countLabel = new JLabel(Const.LAB_COUNT);
		labelValuesPanel = new JPanel(new BorderLayout());
		labelValuesPanel.add(lowestValueLabel, BorderLayout.NORTH);
		labelValuesPanel.add(highestValueLabel, BorderLayout.CENTER);
		labelValuesPanel.add(countLabel, BorderLayout.SOUTH);
		min = new JTextField(Const.VALUES_LNGT);
		max = new JTextField(Const.VALUES_LNGT);
		count = new JTextField(Const.VALUES_LNGT);
		valuesPanel = new JPanel(new BorderLayout());
		valuesPanel.add(min, BorderLayout.NORTH);
		valuesPanel.add(max, BorderLayout.CENTER);
		valuesPanel.add(count, BorderLayout.SOUTH);
		valuesWrapperPanel = new JPanel(new BorderLayout());
		valuesWrapperPanel.add(labelValuesPanel, BorderLayout.WEST);
		valuesWrapperPanel.add(valuesPanel, BorderLayout.EAST);
		
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
		valuesWrapperPanel.setBorder(BorderFactory.createTitledBorder(Const.CONT_VALUES));
		
		//Adding all panels
		this.add(valuesWrapperPanel, BorderLayout.WEST);
		this.add(speedPanel, BorderLayout.EAST);

	}

}