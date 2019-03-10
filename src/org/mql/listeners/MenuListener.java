package org.mql.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String src = e.getActionCommand().toLowerCase();
		switch (src) {
		case "exit":
			System.exit(0);
			break;
		default:
			break;
		}
	}

}
