package org.mql.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	public ButtonPanel(String... names) {
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		for (String name : names) {
			JButton button = new JButton(name);
			button.setName(name);
			add(button);
		}
	}
	
	public void addActionListener(ActionListener al) {
		for (int i = 0; i < getComponentCount(); i++) {
			((JButton) getComponent(i)).addActionListener(al);
		}
	}
	
	public void addActionListener(int index, ActionListener al) {
		((JButton) getComponent(index)).addActionListener(al);
	}
	
	public void addActionListener(String name, ActionListener al) {
		for (int i = 0; i < getComponentCount(); i++) {
			JButton button = (JButton) getComponent(i);
			if (button.getName().equals(name)) {
				button.addActionListener(al);
				break;
			}
		}
	}
	
}
