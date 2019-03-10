package org.mql.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class ChoicePanel extends JPanel {

	public final static int SINGLE_CHOICE = 0;
	public final static int MULTIPLE_CHOICE = 1;
	
	private JLabel myLabel;
	private JCheckBox checkBox;
	private JRadioButton radioButton;
	private ButtonGroup bGroup;
	private String name;
	private int type;

	public ChoicePanel(String labels, String... choices) {
		this(SINGLE_CHOICE, labels, choices);
	}

	public ChoicePanel(int type, String label, String... choices) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.type = type;
		this.name = label;
		if (!label.contains(":"))
			label = label + " : ";
		myLabel = new JLabel(label);
		add(myLabel);
		
		if (type == SINGLE_CHOICE) {
			bGroup = new ButtonGroup();
			for (int i = 0; i < choices.length; i++) {
				radioButton = new JRadioButton(choices[i]);
				radioButton.setText(choices[i]);
				if(i==0)
					radioButton.setSelected(true);
				add(radioButton);
				bGroup.add(radioButton);
			}
		} else if (type == MULTIPLE_CHOICE) {
			for (int i = 0; i < choices.length; i++) {
				checkBox = new JCheckBox(choices[i]);
				checkBox.setText(choices[i]);
				add(checkBox);
			}
		}
	}
	
	public ChoicePanel(Integer type, String label, int labelWidth,  String... choices) {
		this(type, label, choices);
		myLabel = (JLabel)getComponent(0);
		myLabel.setPreferredSize(new Dimension(labelWidth, myLabel.getPreferredSize().height));
	}

	public ChoicePanel(String label, int labelWidth, String... choices) {
		this(SINGLE_CHOICE, label, labelWidth, choices);
	}

	public String getValue() {
		for (int i = 1; i < getComponentCount(); i++) {
			JToggleButton button = (JToggleButton) getComponent(i);
			if (button.isSelected())
				return button.getText();
		}
		return null;
	}

	public String[] getValues() {
		List<String> choices = new Vector<>();
		for (int i = 1; i < getComponentCount(); i++) {
			JToggleButton button = (JToggleButton) getComponent(i);
			if (button.isSelected())
				choices.add(button.getText());
		}

		String t[] = new String[choices.size()];
		choices.toArray(t);
		return t;
	}
	
	public void setValue(String oldValue, Object newValue) {
		for (int i = 1; i < getComponentCount(); i++) {
			JToggleButton toggleButton = (JToggleButton) getComponent(i);
			if (toggleButton.getText().equals(oldValue)) {
				toggleButton.setText(newValue.toString());
				break;
			}
		}
	}
	
	public String getName() {
		return this.name;
	}

	public void clear() {
		for (int i = 1; i < getComponentCount(); i++) {
			JToggleButton toggleButton = (JToggleButton) getComponent(i);
			if(i == 1 && this.type == SINGLE_CHOICE){
				toggleButton.setSelected(true);
				continue;
			}
			toggleButton.setSelected(false);
		}
	}
}
