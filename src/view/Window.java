package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Window extends JFrame{

	private JTable table;
	private JButton button;
	
	private JPanel wrapperPanel;
	private JPanel tablePanel;
	private JPanel buttonPanel;
	
	public Window(){
		super("Sorting visualizer");
		
		table = new JTable();
		button = new JButton("Sort");
		
		wrapperPanel = new JPanel(new BorderLayout());
		tablePanel = new JPanel();
		buttonPanel = new JPanel();
		
		tablePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		tablePanel.add(table);
		buttonPanel.add(button);
		
	}
}
