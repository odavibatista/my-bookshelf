/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.models;

/**
 *
 * @author Usuario
 */
public class User {
    private int id;
    private String name, surname, email, age, gender, password;
    private int firstFavorite, secondFavorite;
    private boolean superUser;
    public static User user;

    public User(int id, String name, String surname, String email, String age, String gender, String password,
            int firstFavorite,
            int secondFavorite) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.firstFavorite = firstFavorite;
        this.secondFavorite = secondFavorite;
        this.superUser = false;
    }

    /* Default user constructor */
    public User(String name, String surname, String email, String age, String gender, String password,
            int firstFavorite,
            int secondFavorite) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.firstFavorite = firstFavorite;
        this.secondFavorite = secondFavorite;
        this.superUser = false;
    }

    /* Admin user constructor */
    public User(int id, String name, String surname, String email, String age, String gender, String password,
            int firstFavorite,
            int secondFavorite, boolean superUser) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.firstFavorite = firstFavorite;
        this.secondFavorite = secondFavorite;
        this.superUser = superUser;
    }

    /* Admin user constructor */
    public User(String name, String surname, String email, String age, String gender, String password,
            int firstFavorite,
            int secondFavorite, boolean superUser) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.firstFavorite = firstFavorite;
        this.secondFavorite = secondFavorite;
        this.superUser = superUser;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /* Getters */
    // Get user's id
    public int getId() {
        return id;
    }

    // Get user's name
    public String getName() {
        return name;
    }

    // Get user's surname
    public String getSurname() {
        return surname;
    }

    // Get user's email
    public String getEmail() {
        return email;
    }

    // Get user's age
    public String getAge() {
        return age;
    }

    // Get user's gender
    public String getGender() {
        return gender;
    }

    // Get user's password
    public String getPassword() {
        return password;
    }

    // Get user's first favorite book genre
    public int getFirstFavorite() {
        return firstFavorite;
    }

    // Get user's second favorite book genre
    public int getSecondFavorite() {
        return secondFavorite;
    }

    // Get user's type
    public boolean getUserType() {
        return superUser;
    }

    /* Setters */

    // Set user's id
    public void setId(int codigo) {
        this.id = codigo;
    }

    // Set user's name
    public void setName(String name) {
        this.name = name;
    }

    // Set user's surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Set user's email
    public void setEmail(String email) {
        this.email = email;
    }

    // Set user's age
    public void setAge(String age) {
        this.age = age;
    }

    // Set user's gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Set or change the user's password
    public void setPassword(String password) {
        if (this.password.equals(password)) {
            System.out.println("Senha idêntica à atual.");
        }
        this.password = password;
    }

    // Turn user into admin
    public void setToAdmin() {
        this.superUser = true;
    }

    // Turn user into default user
    public void setToDefaultUser() {
        this.superUser = false;
    }
}