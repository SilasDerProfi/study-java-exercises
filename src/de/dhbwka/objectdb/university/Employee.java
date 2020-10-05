package de.dhbwka.objectdb.university;

import javax.persistence.*;

@Entity
public class Employee {

	private String name;

	Employee() {}

	public Employee(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}	
}
