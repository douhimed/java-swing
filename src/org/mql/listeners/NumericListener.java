package org.mql.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class NumericListener extends KeyAdapter {

	public void keyTyped(KeyEvent e) {
		JTextField src = (JTextField)e.getSource();
		char c = e.getKeyChar();
		if (c < '0' || c > '9') {
			if (c != '.') {
				e.setKeyChar((char)0);
			}
			else if (src.getText().contains(".")) {
				e.setKeyChar((char)0);
			}
		}
	}
}
