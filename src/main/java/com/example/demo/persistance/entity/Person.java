package com.example.demo.persistance.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String pin;

    @Column(name = "start_date")
    private Date startDate;

    private Double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

        @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pin='" + pin + '\'' +
                ", startDate=" + startDate +
                ", salary=" + salary +
                '}';
    }

    public Person(Long id, String name, String surname, String pin, Date startDate, Double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pin = pin;
        this.startDate = startDate;
        this.salary = salary;
    }

    public Person() {
    }
}
