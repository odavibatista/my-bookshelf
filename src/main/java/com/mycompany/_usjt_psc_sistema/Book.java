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
  private String author;
  private int genre;

  public Book(String title, int genre, String author) {
    this.title = title;
    this.author = author;
    this.genre = genre;
  }

  /* Getters */

  // Get the book's id
  public int getId() {
    return id;
  }

  // Get the book's title
  public String getTitle() {
    return title;
  }

  // Get the book's genre
  public int getGenre() {
    return genre;
  }

  // Get the book's author
  public String getAuthor() {
    return author;
  }

  /* Setters */

  // Set the book's id
  public void setId(int id) {
    this.id = id;
  }

  // Set the book's title
  public void setNome(String title) {
    this.title = title;
  }

  // Set the book's genre
  public void setGenre(int genre) {
    this.genre = genre;
  }

  // Set the book's author
  public void setAuthor(String author) {
    this.author = author;
  }

}