package org.mql.swing;

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class ButtonPanel extends AbstractButtonPanel{

	public ButtonPanel() {
		super();
	}

	public ButtonPanel(String... labels) {
		super(labels);
	}

	@Override
	public AbstractButton createButton(String label) {
		JButton btn = new JButton(label);
		btn.setName(label);
		return btn;
	}

}