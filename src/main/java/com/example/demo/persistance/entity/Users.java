package com.example.demo.persistance.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name="phone_number")
    private String phoneNumber;

    private Integer active;

    private String roles;

    private String permissions;



    public Users(Long id, String name, String surname, String username, String password, String phoneNumber, Integer active, String roles, String permissions) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.roles = roles;
        this.permissions = permissions;

    }

    public Users(){}

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }

    //    public List<String> getRoleList(){
//        if (this.roles.length()>0){
//            return Arrays.asList(this.roles.split(","));
//        }
//        return new ArrayList<>();
//    }
//
//    public List<String> getPersmissionList(){
//        if (this.permissions.length()>0){
//            return Arrays.asList(this.permissions.split(","));
//        }
//        return new ArrayList<>();
//    }
}
