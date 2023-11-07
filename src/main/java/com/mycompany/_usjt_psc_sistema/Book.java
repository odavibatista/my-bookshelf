/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema;

/**
 *
 * @author Samsung
 */
public class Book {
  private int id;
  private String title;
  private int registererUser;
  private int genre;
  private int author;

  public Book(int id, String title, int registererUser, int genre, int author) {
    this.id = id;
    this.title = title;
    this.registererUser = registererUser;
    this.genre = genre;
    this.author = author;
  }

  /* Getters */
  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getGenre() {
    return genre;
  }

  public int getRegistererUser() {
    return registererUser;
  }

  public int getAuthor() {
    return author;
  }

  /* Setters */
  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String title) {
    this.title = title;
  }

  public void setGenre(int genre) {
    this.genre = genre;
  }

  public void setRegistererUser(int registererUser) {
    this.registererUser = registererUser;
  }

  public void setAuthor(int author) {
    this.author = author;
  }

}