package org.mql.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerImpl implements KeyListener {

	public KeyListenerImpl() {

	}

	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed : " + e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("keyRelased  : " + e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped : " + e.getKeyCode() + " : " + e.getKeyChar());
	}

}
