package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import lib.ButtonType;
import lib.Const;
import controller.ButtonListener;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener {

	private ControlPanel controlPanel;
	private JButton sortButton;

	private JPanel dataPanel; //for now only for testing
	private JPanel wrapperPanel;
	private JPanel buttonPanel;

	private ButtonListener buttonListener;

	public Window(BarPanel panel) {
		super("Sorting visualizer");

		controlPanel = new ControlPanel();
		sortButton = new JButton("Sort");

		dataPanel = new JPanel(new BorderLayout());
		dataPanel.setBorder(BorderFactory.createTitledBorder(Const.DATA_PANEL));
		dataPanel.add(panel, BorderLayout.CENTER);
		wrapperPanel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel();
		buttonPanel.add(sortButton, BorderLayout.CENTER);

		wrapperPanel.add(controlPanel, BorderLayout.NORTH);
		wrapperPanel.add(dataPanel, BorderLayout.CENTER);
		wrapperPanel.add(buttonPanel, BorderLayout.SOUTH);

		controlPanel.setButtonListener(new ButtonListener() {
			@Override
			public void buttonPressed(ButtonType bt) {
				switch (bt) {
				case NEW_DATA:
					//Sends to controller
					buttonListener.buttonPressed(ButtonType.NEW_DATA);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Nothing happend");
				}
			}
		});

		// Listeners
		sortButton.addActionListener(this);

		this.add(wrapperPanel);

		// this.pack();
		this.setSize(800, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setDataPanel(BarPanel panel) {
		dataPanel.removeAll();
		dataPanel.add(panel, BorderLayout.CENTER);
		dataPanel.revalidate();
		dataPanel.repaint();
		// Thread th1 = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// wrapperPanel.add(panel, BorderLayout.CENTER);
		// }
		// });
		// th1.start();
		// this.barPanel.remove(barPanel);
		// barPanel.revalidate();
		// barPanel.repaint();
		// this.barPanel = panel;
		// barPanel.revalidate();
		// barPanel.repaint();
		// wrapperPanel.revalidate();
		// wrapperPanel.repaint();
	}
	
	public int[] getValues(){
		return controlPanel.getValues();
	}
	
	public void setValues(int[] v){
		controlPanel.setValues(v);
	}

	public void setButtonText(String text) {
		this.sortButton.setText(text);
	}

	public void setButtonListener(ButtonListener bl) {
		this.buttonListener = bl;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sortButton) {
			buttonListener.buttonPressed(ButtonType.SORT);
		}
		// if(e.getSource() == controlPanel.getNewData()){
		// JOptionPane.showMessageDialog(null, "Starter fra window");
		// }
	}
}
