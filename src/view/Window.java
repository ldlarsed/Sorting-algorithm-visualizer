package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame{

	private BarPanel barPanel;
	private JButton button;
	
	private JPanel wrapperPanel;
	private JPanel buttonPanel;
	
	public Window(BarPanel panel){
		super("Sorting visualizer");
		
		barPanel = panel;
		button = new JButton("Sort");
		
		wrapperPanel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel();
		
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		buttonPanel.add(button, BorderLayout.CENTER);
		
		wrapperPanel.add(barPanel, BorderLayout.CENTER);
		wrapperPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		this.add(wrapperPanel);
		
//		this.pack();
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setDataPanel(BarPanel panel){
		this.barPanel = panel;
	}
}
