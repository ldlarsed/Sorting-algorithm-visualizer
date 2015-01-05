package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import lib.ButtonType;
import lib.Const;
import controller.ButtonListener;

public class ControlPanel extends JPanel {

	private JPanel algPanel, labelValuesPanel, valuesPanel, valuesWrapperPanel,
			speedPanel, timePanel;
	private JLabel lowestValueLabel, highestValueLabel,
			countLabel, timeLabel;
	private JSlider speed;
	private JTextField min, max, count;
	private JButton newDataButton;
	private JRadioButton bubbleSort, insertionSort, quickSort, selectSort,
			mergeSort, heapSort;
	private ButtonGroup algGroup;

	private ButtonListener buttonListener;
	private Listener listener;
	private Mouse mouse;

	public ControlPanel() {
		this.setLayout(new GridLayout(1, 4));
		listener = new Listener();
		mouse = new Mouse();
		// Values and labels
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
		newDataButton = new JButton(Const.BUTTON_NEW);
		newDataButton.addActionListener(listener);
		valuesWrapperPanel = new JPanel(new BorderLayout());
		valuesWrapperPanel.add(labelValuesPanel, BorderLayout.WEST);
		valuesWrapperPanel.add(valuesPanel, BorderLayout.CENTER);
		valuesWrapperPanel.add(newDataButton, BorderLayout.EAST);

		//Algorithm radio buttons
		algPanel = new JPanel(new GridLayout(3, 2));
		algPanel.setBorder(BorderFactory.createTitledBorder(Const.ALG_PANEL));
		bubbleSort = new JRadioButton(Const.ALG_BUBBLE);
		insertionSort = new JRadioButton(Const.ALG_INSERT);
		quickSort = new JRadioButton(Const.ALG_QUICK);
		selectSort = new JRadioButton(Const.ALG_SELECT);
		mergeSort = new JRadioButton(Const.ALG_MERGE);
		heapSort = new JRadioButton(Const.ALG_HEAP);
		algGroup = new ButtonGroup();
		algGroup.add(bubbleSort);
		algGroup.add(insertionSort);
		algGroup.add(quickSort);
		algGroup.add(selectSort);
		algGroup.add(mergeSort);
		algGroup.add(heapSort);
		algPanel.add(bubbleSort);
		algPanel.add(insertionSort);
		algPanel.add(quickSort);
		algPanel.add(selectSort);
		algPanel.add(mergeSort);
		algPanel.add(heapSort);
		bubbleSort.setSelected(true);

		//Timer
		timeLabel = new JLabel("00:00:00");
		timePanel = new JPanel(new BorderLayout());
		timePanel
				.setBorder(BorderFactory.createTitledBorder(Const.TIMER_PANEL));
		timePanel.add(timeLabel, BorderLayout.CENTER);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		Font labelFont = timeLabel.getFont();
		timeLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));

		// Speedslider
		speed = new JSlider(JSlider.HORIZONTAL, 10, 30, 12);
		speed.setMajorTickSpacing(10);
		speed.setMinorTickSpacing(1);
		speed.setPaintTicks(true);
		speed.setPaintLabels(true);
		speed.addMouseListener(mouse);
		speed.setEnabled(false);
		speedPanel = new JPanel(new BorderLayout());
		speedPanel.add(speed, BorderLayout.CENTER);

		// Borders
		this.setBorder(BorderFactory.createTitledBorder(Const.CONTROL_PANEL));
		speedPanel
				.setBorder(BorderFactory.createTitledBorder(Const.ANIM_SPEED));
		valuesWrapperPanel.setBorder(BorderFactory
				.createTitledBorder(Const.CONT_VALUES));

		// Adding all panels
		this.add(valuesWrapperPanel, BorderLayout.WEST);
		this.add(algPanel);
		this.add(timePanel);
		this.add(speedPanel, BorderLayout.EAST);

		setInitialValues();
	}

	private void setInitialValues() {
		min.setText(String.valueOf(Const.MIN_INIT));
		max.setText(String.valueOf(Const.MAX_INIT));
		count.setText(String.valueOf(Const.COUNT_INIT));
	}

	public int[] getValues() {
		return new int[] { Integer.parseInt(min.getText()),
				Integer.parseInt(max.getText()),
				Integer.parseInt(count.getText()) };
	}

	public void setValues(int[] v) {
		min.setText(String.valueOf(v[0]));
		max.setText(String.valueOf(v[1]));
		count.setText(String.valueOf(v[2]));
	}

	public void setButtonListener(ButtonListener bl) {
		this.buttonListener = bl;
	}

	public JButton getNewData() {
		return newDataButton;
	}

	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == newDataButton) {
				// Sends to window
				buttonListener.buttonPressed(ButtonType.NEW_DATA);
			}
		}
	}

	private class Mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			JOptionPane.showMessageDialog(null, Const.NOT_IMPLEMENTED);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
