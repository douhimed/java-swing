package org.mql.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.lang.reflect.Field;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardPanel extends JPanel {

	private JLabel label;
	private int LabelWidth = 100;
	private JPanel container;

	public CardPanel(Object object) {
		this(object, 100);
	}

	public CardPanel(Object object, int labelWidth) {

		this.LabelWidth = labelWidth;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Class<?> clazz = object.getClass();
		Field fields[] = clazz.getDeclaredFields();
		for (Field field : fields) {

			container = new JPanel(new FlowLayout(FlowLayout.LEFT));

			boolean status = field.isAccessible();
			field.setAccessible(true);
			label = new JLabel(field.getName() + " : ");
			label.setPreferredSize(new Dimension(this.LabelWidth, label.getPreferredSize().height));

			JLabel labelData = new JLabel();
			try {
				labelData.setText(field.get(object).toString());
			} catch (Exception e) {
				System.out
						.println("went bad at getting fields values from object in card constructor" + e.getMessage());
			}

			container.add(label);
			container.add(labelData);
			field.setAccessible(status);
			add(container);
		}
	}

}
