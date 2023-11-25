/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.models;

/**
 *
 * @author 823212382
 */
public class ExtendedBook extends Book {
    private int rateAmount;
    private int rateTotal;
    private double rateAverage;

    public ExtendedBook(Book book, int rateAmount, int rateTotal) {
        super(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre());
        this.rateAmount = rateAmount;
        this.rateTotal = rateTotal;
        this.rateAverage = rateTotal / rateAmount;
    }

    /* Getters */
    public int getRateAmount() {
        return rateAmount;
    }

    public int getRateTotal() {
        return rateTotal;
    }

    public double getRateAverage() {
        return rateAverage;
    }

    /* Setters */
    public void setRateAmount(int rateAmount) {
        this.rateAmount = rateAmount;
    }

    public void setRateTotal(int rateTotal) {
        this.rateTotal = rateTotal;
    }

    public void setRateAverage(double rateAverage) {
        this.rateAverage = rateAverage;
    }

    /* Sorting method */
    public static ExtendedBook[] sort(ExtendedBook[] books) {
        for (int i = 0; i < books.length; i++) {
            /* Sorting the books by its average rating */
            for (int j = 0; j < books.length - 1; j++) {
                if (books[j].getRateAverage() < books[j + 1].getRateAverage()) {
                    ExtendedBook temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                    /* Sorting the books by the amount of ratings if they have the same average */
                } else if (books[j].getRateAverage() == books[j + 1].getRateAverage()) {
                    if (books[j].getRateAmount() < books[j + 1].getRateAmount()) {
                        ExtendedBook temp = books[j];
                        books[j] = books[j + 1];
                        books[j + 1] = temp;
                        /* Sorting the books alphabetically if they have same average and rate amount */
                    } else if (books[j].getRateAmount() == books[j + 1].getRateAmount()) {
                        if (books[j].getTitle().compareTo(books[j + 1].getTitle()) > 0) {
                            ExtendedBook temp = books[j];
                            books[j] = books[j + 1];
                            books[j + 1] = temp;
                        }
                    }
                }
            }
        }
        return books;
    }
}
