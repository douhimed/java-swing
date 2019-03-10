package org.mql.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxPanel extends JPanel {

	private JLabel label;
	private JComboBox<String> comboBox;
	private ComboBoxModel<String> model;
	private int labelWidth = 100;
	private String labelName;
	
	public ComboBoxPanel(String name, String... values) {

		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		labelName = name;
		if(!name.contains(":"))
			name = name + " : ";
		label = new JLabel(name);
		label.setPreferredSize(new Dimension(labelWidth, label.getPreferredSize().height));
		add(label);
		
		model = new DefaultComboBoxModel<>(values);
		comboBox = new JComboBox<>(model);
		add(comboBox);
		
	}
	
	public ComboBoxPanel(String name, int labelWidth, String... values) {
		this(name, values);
		this.labelWidth = labelWidth;
		label = (JLabel) getComponent(0);
		label.setSize(new Dimension(labelWidth, label.getPreferredSize().height));
	}
	
	public void addValue(String value) {
		comboBox.addItem(value);
	}
	
	public String getValue() {
		return comboBox.getSelectedItem().toString();
	}

	public String getLabel() {
		return this.labelName;
	}

	public void setValue(String oldValue, String newValue) {
		comboBox.removeItem(oldValue);
		comboBox.addItem(newValue);
	}
	
}
