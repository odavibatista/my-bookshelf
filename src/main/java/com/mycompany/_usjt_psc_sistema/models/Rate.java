package com.mycompany._usjt_psc_sistema.models;

public class Rate {
    private int id;
    private int userId;
    private int bookId;
    private int rate;

    // Constructor for operating existing rates in the database
    public Rate(int id, int userId, int bookId, int rate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.rate = rate;
    }

    // Constructor for creating new rates and inserting them into the database
    public Rate(int userId, int bookId, int rate) {
        this.userId = userId;
        this.bookId = bookId;
        this.rate = rate;
    }

    /* Getters */

    /* Get Rate's ID */
    public int getId() {
        return id;
    }

    /* Get Rater User's ID */
    public int getUserId() {
        return userId;
    }

    /* Get the Book's ID */
    public int getBookId() {
        return bookId;
    }

    /* Get the Rate */
    public int getRate() {
        return rate;
    }

    /* Setters */

    /* Set Rate's ID */
    public void setId(int id) {
        this.id = id;
    }

    /* Set Rater User's ID */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /* Set the Book's ID */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /* Set the Rate */
    public void setRate(int rate) {
        this.rate = rate;
    }
}
