package org.mql.swing;

import javax.swing.AbstractButton;
import javax.swing.JRadioButton;

public class RadioButtonPanel extends AbstractButtonPanel {

	public RadioButtonPanel() {
		super();
	}

	public RadioButtonPanel(String... labels) {
		super(labels);
	}

	@Override
	public AbstractButton createButton(String label) {
		return new JRadioButton(label);
	}

}
