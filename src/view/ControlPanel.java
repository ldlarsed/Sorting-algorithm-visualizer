package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import controller.ButtonListener;
import lib.ButtonType;
import lib.Const;

public class ControlPanel extends JPanel {

	private JPanel algPanel, labelValuesPanel, valuesPanel, valuesWrapperPanel, speedPanel;
	private JLabel bubblesortLabel, lowestValueLabel, highestValueLabel,
			countLabel;
	private JSlider speed;
	private JTextField min, max, count;
	private JButton newDataButton;
	
	private ButtonListener buttonListener;
	private Listener listener;
	private Mouse mouse;
	
	public ControlPanel() {
		this.setLayout(new BorderLayout());
		listener = new Listener();
		mouse = new Mouse();
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
		newDataButton = new JButton(Const.BUTTON_NEW);
		newDataButton.addActionListener(listener);
		valuesWrapperPanel = new JPanel(new BorderLayout());
		valuesWrapperPanel.add(labelValuesPanel, BorderLayout.WEST);
		valuesWrapperPanel.add(valuesPanel, BorderLayout.CENTER);
		valuesWrapperPanel.add(newDataButton, BorderLayout.EAST);
		
//		SLUTTET HER, MÅ LEGGE TIL DE ØVRIGE KOMPONENTENE
		
		//Speedslider
		speed = new JSlider(JSlider.HORIZONTAL, 10, 30, 12);
		speed.setMajorTickSpacing(10);
		speed.setMinorTickSpacing(1);
		speed.setPaintTicks(true);
		speed.setPaintLabels(true);
		speed.addMouseListener(mouse);
		speed.setEnabled(false);
		speedPanel = new JPanel(new BorderLayout());
		speedPanel.add(speed, BorderLayout.CENTER);
		
		//Borders
		this.setBorder(BorderFactory.createTitledBorder(Const.CONTROL_PANEL));
		speedPanel.setBorder(BorderFactory.createTitledBorder(Const.ANIM_SPEED));
		valuesWrapperPanel.setBorder(BorderFactory.createTitledBorder(Const.CONT_VALUES));
		
		//Adding all panels
		this.add(valuesWrapperPanel, BorderLayout.WEST);
		this.add(speedPanel, BorderLayout.EAST);
		
		setInitialValues();
	}
	
	private void setInitialValues(){
		min.setText(String.valueOf(Const.MIN_INIT));
		max.setText(String.valueOf(Const.MAX_INIT));
		count.setText(String.valueOf(Const.COUNT_INIT));
	}
	
	public int[] getValues(){
		return new int[]{Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), Integer.parseInt(count.getText())}; 
	}
	
	public void setValues(int[] v){
		min.setText(String.valueOf(v[0]));
		max.setText(String.valueOf(v[1]));
		count.setText(String.valueOf(v[2]));
	}
	
	public void setButtonListener(ButtonListener bl){
		this.buttonListener = bl;
	}
	
	public JButton getNewData(){
		return newDataButton;
	}
	
	private class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == newDataButton){
				//Sends to window
				buttonListener.buttonPressed(ButtonType.NEW_DATA);
			}
		}
	}
	
	private class Mouse implements MouseListener{

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
