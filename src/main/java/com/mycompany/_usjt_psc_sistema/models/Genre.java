/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.models;

/**
 *
 * @author Usuario
 */
public class Genre {
    private int id;
    private String name;

    /* Constructor for getting db's data */
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Default genre constructor */
    public Genre(String name) {
        this.name = name;
    }

    /* Getters */
    /* Get the Genre's id */
    public int getId() {
        return id;
    }

    /* Get the Genre's name */
    public String getName() {
        return name;
    }

    /* Setters */
    /* Set the Genre's id */
    public void setId(int id) {
        this.id = id;
    }

    /* Set the Genre's name */
    public void setName(String name) {
        this.name = name;
    }

}
