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
		panel.add(label);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		formatter.setMaximumFractionDigits(5);
		formatter.setGroupingUsed(false);
		DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
		dottedDouble.setDecimalSeparator('.');
		formatter.setDecimalFormatSymbols(dottedDouble);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		String formattedDouble = formatter.format(value);
		label.setText(formattedDouble);
		if ((col == 0 || col == 1) && needle != null && needle.equals(formattedDouble)) {
			panel.setBackground(Color.RED);
		}
		else {
			panel.setBackground(Color.WHITE);	
		}
		return panel;
	}

}
