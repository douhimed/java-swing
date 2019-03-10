package org.mql.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;

public class TreePanel extends JPanel {

	private TreeModel model;
	private JTree tree;
	private JLabel label;
	private String name;
	
	public TreePanel(String name, Hashtable<String, String> values) {
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.name = name;
		if(!name.equals(":"))
			name = name + " : ";
		label = new JLabel(name);
		add(label);
		tree = new JTree(values);
		add(tree);
		
	}
	
	public TreePanel(String name, int labelWidth, Hashtable<String, String> values) {
		this(name, values);
		label = (JLabel) getComponent(0);
		label.setPreferredSize(new Dimension(labelWidth, label.getPreferredSize().height));
	}
	
}
