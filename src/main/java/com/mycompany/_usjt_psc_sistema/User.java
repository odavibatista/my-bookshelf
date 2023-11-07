/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema;

/**
 *
 * @author Usuario
 */
public class User {
    private int codigo;
    private String name, email, age, gender, password;
    private boolean superUser;

    /* Default user constructor */
    public User(String name, String email, String age, String gender, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.superUser = false;
    }

    /* Admin user constructor */
    public User(String name, String email, String age, String gender, String password, boolean superUser) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.superUser = superUser;
    }

    /* Getters */
    public int getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    /* Setters */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        if (this.password.equals(password)) {
            System.out.println("Senha idêntica à atual.");
        }
        this.password = password;
    }
}