package org.mql.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ListPanel extends JPanel {

	private JList<String> list;
	private DefaultListModel<String> model;
	private String label;
	private JLabel myLabel;

	public ListPanel(String label, String[] values) {
		this(label, Arrays.asList(values));
	}

	public ListPanel(String label, int labelWidth, String[] values) {
		this(label, values);
		myLabel = (JLabel) getComponent(0);
		myLabel.setPreferredSize(new Dimension(labelWidth, myLabel.getPreferredSize().height));
	}
	
	public ListPanel(String label, int labelWidth, List<String> values) {
		this(label, values);
		myLabel = (JLabel) getComponent(0);
		myLabel.setPreferredSize(new Dimension(labelWidth, myLabel.getPreferredSize().height));
	}

	public ListPanel(String label, List<String> values) {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		this.label = label;
		if (!label.contains(":"))
			label = label + " : ";
		myLabel = new JLabel(label);
		add(myLabel);

		model = new DefaultListModel<>();
		for (String value : values) {
			model.addElement(value);
		}

		list = new JList<>(model);
		add(list);
	}
	
	public void addElement(int index, String value) {
		model.add(index, value);
	}

	public void addElement(String value) {
		model.addElement(value);
	}
	
	public String getValue() {
		return list.getSelectedValue();
	}
	
	public List<String> getSelectedValues() {
		/*List<String> objects = list.getSelectedValuesList();
		String[] data = new String[objects.size()];
		objects.toArray(data);
		return data;*/
		return list.getSelectedValuesList();
	}
	
	public void setValue(int index, String value) {
		model.setElementAt(value.toString(), index);
	}
	
	public String getLabel() {
		return this.label;
	}

	public void clear() {
		list.clearSelection();
	}

}
