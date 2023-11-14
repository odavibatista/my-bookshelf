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

    public ExtendedBook (Book book, int rateAmount, int rateTotal) {
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
}