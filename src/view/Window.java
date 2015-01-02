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
	
	public Window(){
		super("Sorting visualizer");
		
//		tablePanel = new TablePanel();
		
		double[] values = new double[3];
	    String[] names = new String[3];
	    values[0] = 1;
	    names[0] = "Item 1";

	    values[1] = 2;
	    names[1] = "Item 2";

	    values[2] = 4;
	    names[2] = "Item 3";
	    
	    int[] values2 = new int[3];
	    values2[0] = 1;
	    values2[1] = 2;
	    values2[2] = 4;
		
		barPanel = new BarPanel(values2);
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
}
