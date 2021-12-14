package bsu.java.group6.lab3.Gritskov.var7;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;

	public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
		this.from = from;
		this.to = to;
		this.step = step;
		this.coefficients = coefficients;
	}

	public Double getFrom() {
		return from;
	}

	public void setFrom(Double from) {
		this.from = from;
	}

	public Double getTo() {
		return to;
	}

	public void setTo(Double to) {
		this.to = to;
	}

	public Double getStep() {
		return step;
	}

	public void setStep(Double step) {
		this.step = step;
	}
	
	@Override
	public int getRowCount() {
		return new Double(Math.ceil((to-from)/step)).intValue() + 1;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int col) {
		switch(col) {
		case 0:
			return "X value";
		case 1:
			return "POLINOMIAN value";
		default:
			return "Even integer part";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int col) {
		switch(col) {
			case 0:
			case 1:
				return Double.class;
			default:
				return Boolean.class;
		}
	}

	@Override
	public Object getValueAt(int row, int col) {
		double x = from + step*row;
		if (col == 0) {
			return x;
		}
		Double result = 0.0;
		for (int i = 0; i < coefficients.length; i++) {
			result += coefficients[i] * Math.pow(x, coefficients.length-i-1);
		}
		if (col == 1) {
			return result;
		}
		else {
			return (result.intValue() % 2) == 0;
		}
	}
	
}
