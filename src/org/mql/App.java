package org.mql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;

import org.mql.controllers.HomePanel;
import org.mql.dao.DataManager;
import org.mql.models.Student;
import org.mql.swing.CardPanel;
import org.mql.swing.FormPanel;
import org.mql.swing.MenuPanel;
import org.mql.swing.TablePanel;

public class App extends JFrame {

	private TablePanel tablePanel;
	
	public App() {
		exp01();
		init();
	}

	private void exp03() {
		CardPanel cardPanel = new CardPanel(new Student("Douhi mohammed", "Homme", "MQL", Arrays.asList("JAVA", "JEE")));
		setContentPane(cardPanel);
	}

	private void exp02() {
		FormPanel formPanel = new FormPanel(Student.class);
		setContentPane(formPanel);
	}

	private void exp01() {

		MenuPanel menuPanel = new MenuPanel(
				new String[][] { { "Gestion", "Ajouter", "Table"}, { "System", "Refresh", "-", "Exit" } });
		setJMenuBar(menuPanel);
		menuPanel.addActionListener(new MenuListenerInner());

		tablePanel =  new TablePanel(DataManager.getAllAsVector(), DataManager.getCulsAsVector());
		
		setContentPane(tablePanel);
		
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new App();
	}

	class MenuListenerInner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String src = e.getActionCommand().toLowerCase();
			switch (src) {
			case "ajouter":
				setContentPane(new HomePanel());
				pack();
				break;
			case "table":
				setContentPane(new TablePanel(DataManager.getAllAsVector(), DataManager.getCulsAsVector()));
				pack();
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
}
