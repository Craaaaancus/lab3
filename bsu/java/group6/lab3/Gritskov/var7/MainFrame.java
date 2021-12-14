package bsu.java.group6.lab3.Gritskov.var7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFileChooser;



public class MainFrame extends JFrame{
	private static final int WIDTH = 700;
	private static final int HEIGHT = 500;
	private Double[] coefficients;
	private JFileChooser fileChooser = null;
	
	private JMenuItem saveToTextMenuItem;
	private JMenuItem saveToGraphicsMenuItem;
	private JMenuItem searchValueMenuItem;
	
	private JTextField textFieldFrom;
	private JTextField textFieldTo;
	private JTextField textFieldStep;
	private Box hBoxResult;
	
	private GornerTableCellRenderer renderer = new GornerTableCellRenderer();
	private GornerTableModel data;
	
	public MainFrame(Double[] coefficients) {
		super("Horner's method");
		this.coefficients = coefficients;
		setSize(WIDTH, HEIGHT);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setLocation((kit.getScreenSize().width - WIDTH)/2, (kit.getScreenSize().height - HEIGHT)/2);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenu tableMenu = new JMenu("Table");
		menuBar.add(tableMenu);
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		Action saveToTextAction = new AbstractAction("Save text file") {
			public void actionPerformed(ActionEvent event) {
				if (fileChooser == null) {
					fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File("."));
				}
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					saveToTextFile(fileChooser.getSelectedFile());
				}
			}
		};
		saveToTextMenuItem = fileMenu.add(saveToTextAction);
		saveToTextMenuItem.setEnabled(false);
		
		Action saveToGraphicsAction = new AbstractAction("Save data for graphic") {
			public void actionPerformed(ActionEvent event) {
				if (fileChooser == null) {
					fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File("."));
				}
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					saveToGraphicsFile(fileChooser.getSelectedFile());
				}
			}
		};
		saveToGraphicsMenuItem = fileMenu.add(saveToGraphicsAction);
		saveToGraphicsMenuItem.setEnabled(false);
		
		
		Action searchValueAction = new AbstractAction("Found polinom") {
			public void actionPerformed(ActionEvent event) {
				String value = JOptionPane.showInputDialog(MainFrame.this, "Enter value", "Found value", JOptionPane.QUESTION_MESSAGE);
				renderer.setNeedle(value);
				getContentPane().repaint();
			}
		};
		searchValueMenuItem = tableMenu.add(searchValueAction);
		searchValueMenuItem.setEnabled(false);
		
		Action aboutProgramAction = new AbstractAction("About program") {
			public void actionPerformed(ActionEvent event) {
				JLabel info = new JLabel ("Author: Gritskov Denis;  Group: 6");
				JOptionPane.showMessageDialog(MainFrame.this, info, "Information about myself", JOptionPane.PLAIN_MESSAGE);
			}
		};
		helpMenu.add(aboutProgramAction);
		
		JLabel labelForFrom = new JLabel("X changes from:");
		textFieldFrom = new JTextField("0.0", 10);
		textFieldFrom.setMaximumSize(textFieldFrom.getPreferredSize());
		
		JLabel labelForTo = new JLabel("to:");
		textFieldTo = new JTextField("1.0", 10);
		textFieldTo.setMaximumSize(textFieldTo.getPreferredSize());
		
		JLabel labelForStep = new JLabel("with step:");
		textFieldStep = new JTextField("0.1", 10);
		textFieldStep.setMaximumSize(textFieldStep.getPreferredSize());
		
		Box hboxRange = Box.createHorizontalBox();
		hboxRange.setBorder(BorderFactory.createBevelBorder(1));
		hboxRange.add(Box.createHorizontalGlue());
		hboxRange.add(labelForFrom);
		hboxRange.add(Box.createHorizontalStrut(10));
		hboxRange.add(textFieldFrom);
		hboxRange.add(Box.createHorizontalStrut(20));
		hboxRange.add(labelForTo);
		hboxRange.add(Box.createHorizontalStrut(10));
		hboxRange.add(textFieldTo);
		hboxRange.add(Box.createHorizontalStrut(20));
		hboxRange.add(labelForStep);
		hboxRange.add(Box.createHorizontalStrut(10));
		hboxRange.add(textFieldStep);
		hboxRange.add(Box.createHorizontalGlue());
		hboxRange.setPreferredSize(new Dimension(
				new Double(hboxRange.getMaximumSize().getWidth()).intValue(),
				new Double(hboxRange.getMinimumSize().getHeight()).intValue()*2
				));
		getContentPane().add(hboxRange, BorderLayout.SOUTH);
	}
	
	

	public static void main(String[] args) {
		


		MainFrame frame = new MainFrame(coefficients);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
