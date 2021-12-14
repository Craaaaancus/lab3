package bsu.java.group6.lab3.Gritskov.var7;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Color;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {

	private String needle = null;
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();
	
	public void setNeedle(String needle) {
		this.needle = needle;
	}

	
	public GornerTableCellRenderer() {
		
	}

	

}
