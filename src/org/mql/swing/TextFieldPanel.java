package org.mql.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.mql.listeners.AlphaListener;
import org.mql.listeners.NumericListener;
import org.mql.listeners.ToUpperListener;

public class TextFieldPanel extends JPanel {
	
	private static final NumericListener NUM_LOCK = new NumericListener();
	private static final AlphaListener ALPHA_LOCK = new AlphaListener();
	private static final ToUpperListener TO_UPPER_LOCK = new ToUpperListener();
	
	private JLabel l1;
	private int labelWidth = 100;
	private String label;

	public TextFieldPanel(String label, int size) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.label = label;
		if(!label.contains(":")) 
			label = label + " : ";
		l1 = new JLabel(label);
		l1.setPreferredSize(new Dimension(this.labelWidth, l1.getPreferredSize().height));
		JTextField t1 = new JTextField(size);
		add(l1);
		add(t1);
	}
	
	public TextFieldPanel(String label, int size, int labelWidth) {
		this(label, size);
		this.labelWidth = labelWidth;
		JLabel l1 = (JLabel)getComponent(0);
		l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
	}
	
	public void setValue(Object value) {
		((JTextField)getComponent(1)).setText(value.toString());
	}
	
	public String getValue() {
		return ((JTextField)getComponent(1)).getText();
	}
	
	public int getIntValue() {
		String text = getValue();
		try {
			return Integer.parseInt(text);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public double getDoubleValue() {
		String text = getValue();
		try {
			return Double.parseDouble(text);
		} catch (Exception e) {
			return -1;
		}
	}
	
	@Override
	public synchronized void addKeyListener(KeyListener keyListener) {
		getComponent(1).addKeyListener(keyListener);
	}
	
	public void setNumLock(boolean state) {
		getComponent(1).removeKeyListener(NUM_LOCK);
		if (state)
			getComponent(1).addKeyListener(NUM_LOCK);
	}

	public void setAlphaLock(boolean state) {
		getComponent(1).removeKeyListener(ALPHA_LOCK);
		if (state)
			getComponent(1).addKeyListener(ALPHA_LOCK);
	}
	
	public void setToUpperLock(boolean state) {
		getComponent(1).removeKeyListener(TO_UPPER_LOCK);
		if (state)
			getComponent(1).addKeyListener(TO_UPPER_LOCK);
	}

	public String getLabel() {
		return this.label;
	}

}
