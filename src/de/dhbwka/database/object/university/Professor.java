package de.dhbwka.database.object.university;

import javax.persistence.*;

@Entity
public class Professor extends Employee {

	public Professor(String name) {
        super(name);
        
	}
    
}
