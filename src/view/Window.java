package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lib.ButtonType;
import controller.ButtonListener;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener{

	private BarPanel barPanel;
	private JButton sortButton;
	
	private JPanel wrapperPanel;
	private JPanel buttonPanel;
	
	private ButtonListener buttonListener;
	
	public Window(BarPanel panel){
		super("Sorting visualizer");
		
		barPanel = panel;
		sortButton = new JButton("Sort");
		
		wrapperPanel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel();
		
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		buttonPanel.add(sortButton, BorderLayout.CENTER);
		
		wrapperPanel.add(new ControlPanel(), BorderLayout.NORTH);
		wrapperPanel.add(barPanel, BorderLayout.CENTER);
		wrapperPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		//Listeners
		sortButton.addActionListener(this);
		
		this.add(wrapperPanel);
		
//		this.pack();
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setDataPanel(BarPanel panel){
		wrapperPanel.add(panel, BorderLayout.CENTER);
//		this.barPanel.remove(barPanel);
//		barPanel.revalidate();
//		barPanel.repaint();
//		this.barPanel = panel;
//		barPanel.revalidate();
//		barPanel.repaint();
//		wrapperPanel.revalidate();
//		wrapperPanel.repaint();
	}
	
	public void setButtonText(String text){
		this.sortButton.setText(text);
	}
	
	public void setButtonListener(ButtonListener bl){
		this.buttonListener = bl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sortButton){
			buttonListener.buttonPressed(ButtonType.SORT);
		}
	}
}
