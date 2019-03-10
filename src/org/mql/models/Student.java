package org.mql.models;

import java.util.List;
import java.util.Vector;

public class Student {
	
	private static int nbre = 0;
	private int id;
	private String name;
	private String sexe;
	private String filiere;
	private List<String> technologies;
	
	{
		technologies = new Vector<>();
	}
	
	private Student() {
		nbre++;
		this.id = nbre;
	}

	public Student(String name, String sexe, String filiere) {
		this();
		this.name = name;
		this.sexe = sexe;
		this.filiere = filiere;
	}

	public Student(String name, String sexe, String filiere, List<String> technologies) {
		this(name, sexe, filiere);
		this.technologies = technologies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	public static int getNbre() {
		return nbre;
	}
	
	public void addTechnology(String technology) {
		technologies.add(technology);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sexe=" + sexe + ", filiere=" + filiere + ", technologies="
				+ technologies + "]";
	}

}
