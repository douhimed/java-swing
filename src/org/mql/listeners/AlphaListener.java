package org.mql.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AlphaListener implements KeyListener {

	public AlphaListener() {
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed : " + e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("keyRelased  : " + e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if ((c  < 'a' || c> 'z' ) && (c  < 'A' || c> 'Z' )) {
			e.setKeyChar((char)0);
		}else
			System.out.println("keyTyped : " + e.getKeyCode() + " : " + e.getKeyChar());

	}
	
	

}
