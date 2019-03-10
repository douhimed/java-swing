package org.mql.swing;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPanel extends JMenuBar {

	private JMenu menu;
	private Map<String, JMenuItem> items;

	{
		items = new Hashtable<>();
	}

	public MenuPanel(String[][] mn) {
		for (int i = 0; i < mn.length; i++) {
			addMenuBar(mn[i]);
		}
	}

	private void addMenuBar(String[] names) {
		menu = new JMenu(names[0]);
		for (int i = 1; i < names.length; i++) {
			addItems(names[i]);
		}
		add(menu);
	}

	public MenuPanel(Map<String, List<String>> mn) {
		Set<String> menuNames = mn.keySet();
		for (String menuName : menuNames) {
			menu = new JMenu(menuName);
			List<String> itemNames = mn.get(menuName);
			for (String name : itemNames) {
				addItems(name);
			}
			add(menu);
		}
	}

	private void addItems(String name) {

		if (name.equals("-") || name.toLowerCase().equals("separator")) {
			menu.addSeparator();
		} else {
			JMenuItem menuItem = new JMenuItem(name);
			items.put(name, menuItem);
			menu.add(menuItem);
		}
	}
	
	public void addActionListener(ActionListener listener) {
		Collection<JMenuItem> myItems = items.values();
		for (JMenuItem jMenuItem : myItems) {
			jMenuItem.addActionListener(listener);
		}
	}
	
	public void addActionListener(String name, ActionListener listener) {
		items.get(name).addActionListener(listener);
	}

}
