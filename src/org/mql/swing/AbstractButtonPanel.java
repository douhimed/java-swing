package org.mql.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

public abstract class AbstractButtonPanel extends JPanel{

	
	public AbstractButtonPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	public AbstractButtonPanel(String... labels) {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		for (String label : labels) {
			AbstractButton btn = createButton(label);
			add(btn);
		}
	}
	
	public void addButton(String label) {
		add(createButton(label));
	}
	
	public void addActionListener(ActionListener listener) {
		for (int i = 0; i < getComponentCount(); i++) {
			AbstractButton btn = (AbstractButton) getComponent(i);
			btn.addActionListener(listener);
		}
	}
	
	public void addActionListener(int index, ActionListener al) {
		((AbstractButton) getComponent(index)).addActionListener(al);
	}
	
	public void addActionListener(String name, ActionListener al) {
		for (int i = 0; i < getComponentCount(); i++) {
			AbstractButton button = (AbstractButton) getComponent(i);
			if (button.getName().equals(name)) {
				button.addActionListener(al);
				break;
			}
		}
	}
	
	public abstract AbstractButton createButton(String label);
}
