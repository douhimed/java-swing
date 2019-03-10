package org.mql.controllers;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JPanel;

import org.mql.dao.DataManager;
import org.mql.models.Student;
import org.mql.swing.ButtonPanel;
import org.mql.swing.FormPanel;
import org.mql.swing.TablePanel;
import org.mql.swing.TextFieldPanel;

public class HomePanel extends JPanel{

	private FormPanel formPanel;
	private TablePanel tablePanel;
	
	public HomePanel() {
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		formPanel = new FormPanel("Exam", 100);

		TextFieldPanel textFieldPanel1 = formPanel.addTexField("Name", 15);
		textFieldPanel1.setAlphaLock(true);
		formPanel.addChoiceField("Sexe", new String[] { "Homme", "Femme" });
		formPanel.addComboBoxField("Filiéres", Arrays.asList(new String[] { "MQL", "SIGL", "GIE" }));
		formPanel.addListPanel("Téchnologies",
				Arrays.asList(new String[] { "PHP", "JAVA", "JEE", "C++", "C#", "JS", "GoLang" }));

		ButtonPanel bs = formPanel.addButtonpanel("Ok", "Annuler");
		bs.addActionListener(new FormActionListener());
		
		tablePanel = new TablePanel(DataManager.getAllAsTab(), DataManager.getCulsAsTab());
		
		add(formPanel);
		add(tablePanel);
	}
	
	class FormActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent al) {
			Component src = (Component) al.getSource();
			String name = src.getName().toLowerCase();
			if (name.equals("ok")) {
				Student student = new Student(formPanel.getTextFieldValue("Name"),
						formPanel.getChoicePanelValue("Sexe"), 
						formPanel.getComboBoxValue("Filiéres"),
						formPanel.getListValues("Téchnologies"));
				DataManager.addStudent(student);
				addStudent(student);
			} else if (name.equals("annuler")) {
				formPanel.clear();
			}
		}
	}

	public void addStudent(Student student) {
		Vector<String> data = new Vector<>();
		data.add(student.getId()+"");
		data.add(student.getName());
		data.add(student.getFiliere());
		data.add(student.getFiliere().toString());
		tablePanel.addRow(data);
	}
	
}
