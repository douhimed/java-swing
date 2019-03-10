package org.mql.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ToUpperListener extends KeyAdapter {

	public ToUpperListener() {
	}
	
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') {
			char c = (char)(e.getKeyChar() - 'a' + 'A');
			e.setKeyChar(c);
		}
	}
	
	

}
