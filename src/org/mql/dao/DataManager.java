package org.mql.dao;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import org.mql.models.Student;

public class DataManager {
	
	private static final Vector<String> culs;
	private static List<Student> students;
	
	static{
		students = new Vector<>();
		students.add(new Student("douhi mohammed", "H", "MQL", Arrays.asList("Java", "JEE")));
		students.add(new Student("douhi ahmed", "H", "SIGL", Arrays.asList("PHP", "Java")));
		students.add(new Student("rahmani Hicham", "H", "SIGL", Arrays.asList("C++", "C#", "JS")));
		students.add(new Student("Ilham zaradi", "F", "GIE", Arrays.asList("Python")));
		
		culs = new Vector<>();
		culs.addElement("ID");
		culs.add("Name");
		culs.add("Sexe");
		culs.add("Filiere");
		culs.add("Technologies");
	}
	
	public static void addStudent(Student student) {
		students.add(student);
	}
	
	public static void deleteStudent(int id) {
		ListIterator<Student> iterator = students.listIterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if(student.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}
	
	public static void updateStudent(Student newStudent) {
		ListIterator<Student> iterator = students.listIterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if(student.getId() == newStudent.getId()) {
				student = newStudent;
				break;
			}
		}
	}
	
	public static Vector<Vector<String>> getAllAsVector(){
		Vector<Vector<String>> data = new Vector<>();
		for (Student student : students) {
			Vector<String> currentData = new Vector<>();
			currentData.add(student.getId()+"");
			currentData.add(student.getName());
			currentData.add(student.getSexe());
			currentData.add(student.getFiliere());
			currentData.add(student.getTechnologies().toString());
			data.add(currentData);
		}
		return data;
	}
	
	public static String[][] getAllAsTab(){
		String[][] data = new String[students.size()][];
		for (int i = 0; i < data.length; i++) {
			
			Field[] fields = Student.class.getDeclaredFields();
			data[i] = new String[culs.size()];
			for (int j = 1; j < fields.length; j++) {
					boolean status = fields[j].isAccessible();
					fields[j].setAccessible(true);
					try {
						data[i][j - 1] = fields[j].get(students.get(i)).toString();
					} catch (Exception e) {
						System.err.println("went bad at getting fields with reflection");
					}
					fields[j].setAccessible(status);			
			}
		}
		return data;
	}
	
	public static Vector<String> getCulsAsVector() {
		return culs;
	}
	
	public static String[] getCulsAsTab() {
		String[] data = new String[culs.size()];
		return culs.toArray(data);
	}

}
