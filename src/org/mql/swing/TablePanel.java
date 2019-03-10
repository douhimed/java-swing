package org.mql.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel {

	private DefaultTableModel model;
	private JTable table;
	private Vector<String> culs;
	private String[] culsV2;
	
	public TablePanel(Vector<Vector<String>> data, Vector<String> culs) {
		this.culs = culs;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		model = new DefaultTableModel(data, culs);
		table = new JTable(model);
		add(table.getTableHeader());
		add(new JScrollPane(table));

	}
	
	public TablePanel(String[][] data, String[] culsV2) {
		this.culsV2 = culsV2;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		model = new DefaultTableModel(data, culsV2);
		table = new JTable(model);
		add(table.getTableHeader());
		add(new JScrollPane(table));
	}
	
	public void addRow(Vector<String> row) {
		model.addRow(row);
	}
	
	public void refresh() {
		model.fireTableDataChanged();
	}
	
}
