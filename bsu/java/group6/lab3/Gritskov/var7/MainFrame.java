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
		
		
	}
	
	

	public static void main(String[] args) {
		


		MainFrame frame = new MainFrame(coefficients);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
