package org.mql.swing;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

public class CheckBoxPanel extends AbstractButtonPanel {

	public CheckBoxPanel() {
		super();
	}

	public CheckBoxPanel(String... labels) {
		super(labels);
	}

	@Override
	public AbstractButton createButton(String label) {
		return new JCheckBox(label);
	}

}