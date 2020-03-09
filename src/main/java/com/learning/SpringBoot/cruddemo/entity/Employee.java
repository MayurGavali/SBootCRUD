package com.learning.SpringBoot.cruddemo.entity;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

//define field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String Lastname;

    @Column(name="email")
    private String email;

    //defining the constructor
    public Employee() {
    }

    //define the getter /setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //define the toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
