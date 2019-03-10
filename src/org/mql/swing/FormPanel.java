package org.mql.swing;

import java.awt.FlowLayout;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class FormPanel extends JPanel {

	private int labelWidth = 100;
	private JPanel container;

	private Map<String, Object> inputFields;

	{
		inputFields = new HashMap<>();
	}

	public FormPanel() {
		this("");
	}

	public FormPanel(int labelWidth) {
		this();
		this.labelWidth = labelWidth;
	}

	public FormPanel(String title, int labelWidth) {
		this(title);
		this.labelWidth = labelWidth;
	}

	public FormPanel(String title) {

		setLayout(new FlowLayout(FlowLayout.LEFT));

		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		add(container);

		if (!title.equals("") && !title.contains(":"))
			title = title + " : ";
		container.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));

	}
	
	public FormPanel(Class<?> clazz) {
		this(clazz.getSimpleName());
		
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String fieldType = fields[i].getType().getSimpleName().toLowerCase();
			if(fieldType.equals("int") || fieldType.equals("double") || fieldType.equals("string")) {
				addTexField(fields[i].getName(), fields[i].getName(), 25);
			}
		}
	}

	public int getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(int labelWidth) {
		this.labelWidth = labelWidth;
	}

	public TextFieldPanel addTexField(String label, int size) {
		return addTexField(label, label, size);
	}

	public TextFieldPanel addTexField(String name, String label, int size) {
		return addTextField(new TextFieldPanel(label, size));
	}

	public TextFieldPanel addTextField(TextFieldPanel textFieldPanel) {
		container.add(textFieldPanel);
		inputFields.put(textFieldPanel.getLabel(), textFieldPanel);
		return textFieldPanel;
	}

	public ChoicePanel addChoiceField(String label, String... choices) {
		return addChoiceField(ChoicePanel.SINGLE_CHOICE, label, choices);
	}

	public ChoicePanel addChoiceField(int type, String label, String... choices) {
		return addChoiceField(new ChoicePanel(type, label, this.labelWidth, choices));
	}

	public ChoicePanel addChoiceField(ChoicePanel choicePanel) {
		container.add(choicePanel);
		inputFields.put(choicePanel.getName(), choicePanel);
		return choicePanel;
	}

	public ComboBoxPanel addComboBoxField(String name, List<String> list) {
		String[] data = new String[list.size()];
		return addComboBoxField(name, list.toArray(data));
	}
	
	public ComboBoxPanel addComboBoxField(String name, String... values) {
		return addComboBoxField(new ComboBoxPanel(name, values));
	}

	public ComboBoxPanel addComboBoxField(ComboBoxPanel comboBoxPanel) {
		container.add(comboBoxPanel);
		inputFields.put(comboBoxPanel.getLabel(), comboBoxPanel);
		return comboBoxPanel;
	}

	public ListPanel addListPanel(String label, String... values) {
		return addListPanel(new ListPanel(label, this.labelWidth, values));
	}

	public ListPanel addListPanel(String label, int labelWidth, String... values) {
		return addListPanel(new ListPanel(label, labelWidth, values));
	}

	public ListPanel addListPanel(String label, List<String> values) {
		return addListPanel(new ListPanel(label, this.labelWidth, values));
	}

	public ListPanel addListPanel(String label, int labelWidth, List<String> values) {
		return addListPanel(new ListPanel(label, labelWidth, values));
	}

	public ListPanel addListPanel(ListPanel listPanel) {
		container.add(listPanel);
		inputFields.put(listPanel.getLabel(), listPanel);
		return listPanel;
	}

	public TreePanel addTreePanel(String name, int labelWidth, Hashtable<String, String> values) {
		return addTreePanel(new TreePanel(name, labelWidth, values));
	}

	private TreePanel addTreePanel(TreePanel treePanel) {
		container.add(treePanel);
		return treePanel;
	}

	public ButtonPanel addButtonpanel(String... names) {
		return addButtonPanel(new ButtonPanel(names));
	}

	public ButtonPanel addButtonPanel(ButtonPanel buttonPanel) {
		container.add(buttonPanel);
		return buttonPanel;
	}

	public void setValue(String name, int index, String oldValue, String newValue) {
		Object object = inputFields.get(name);
		if (object instanceof ChoicePanel) {
			((ChoicePanel) object).setValue(oldValue, newValue);
		} else if (object instanceof TextFieldPanel) {
			((TextFieldPanel) object).setValue(newValue);
		} else if (object instanceof ComboBoxPanel) {
			((ComboBoxPanel) object).setValue(oldValue, newValue);
		} else if (object instanceof ListPanel) {
			((ListPanel) object).setValue(index, newValue);
		}
	}

	public String getTextFieldValue(String name) {
		String value = "Not exist, or the field's name is wrong";
		if (inputFields.containsKey(name))
			value = ((TextFieldPanel) inputFields.get(name)).getValue();
		return value;
	}

	public String getChoicePanelValue(String name) {
		String value = "Not exist, or the field's name is wrong";
		if (inputFields.containsKey(name))
			value = ((ChoicePanel) inputFields.get(name)).getValue();
		return value;
	}

	public String[] getChoicePanelValues(String name) {
		String[] value = new String[] { "Not exist, or the field's name is wrong" };
		if (inputFields.containsKey(name))
			value = ((ChoicePanel) inputFields.get(name)).getValues();
		return value;
	}

	public String getComboBoxValue(String name) {
		String value = "Not exist, or the field's name is wrong";
		if (inputFields.containsKey(name))
			value = ((ComboBoxPanel) inputFields.get(name)).getValue();
		return value;
	}

	public List<String> getListValues(String name) {
		List<String> value = Arrays.asList("Not exist, or the field's name is wrong");
		if (inputFields.containsKey(name))
			value = ((ListPanel) inputFields.get(name)).getSelectedValues();
		return value;
	}

	public void clear() {
		Collection<Object> inputs = inputFields.values();
		for (Object object : inputs) {
			if (object instanceof TextFieldPanel) {
				((TextFieldPanel) object).setValue("");
			} else if (object instanceof ChoicePanel) {
				((ChoicePanel) object).clear();
			} else if (object instanceof ListPanel) {
				((ListPanel) object).clear();
			}
		}
	}

}
