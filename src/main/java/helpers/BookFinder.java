/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import javax.swing.JOptionPane;

import com.mycompany._usjt_psc_sistema.DAOS.BookDAO;
import com.mycompany._usjt_psc_sistema.DAOS.GenreDAO;
import com.mycompany._usjt_psc_sistema.DAOS.RateDAO;
import com.mycompany._usjt_psc_sistema.models.Book;
import com.mycompany._usjt_psc_sistema.models.ExtendedBook;

/**
 *
 * @author Usuario
 */
public class BookFinder {
    public void findAll() {
        BookDAO books = new BookDAO();
        RateDAO rates = new RateDAO();
        GenreDAO gd = new GenreDAO();

        String message = "";

        try {
            Book[] foundBooks = books.getBooks();
            ExtendedBook[] ratedBooks = new ExtendedBook[foundBooks.length];

            for (Book book : foundBooks) {
                int bookId = book.getId();
                int ratings = rates.countRatings(bookId);
                int sumOfRatings = rates.getSumOfRatings(bookId);
                // if rateAverage is 0, then it will be 0, otherwise it will be the average
                double rateAverage = ratings == 0 && sumOfRatings == 0 ? 0 : (double) sumOfRatings / ratings;

                ExtendedBook extendedBook = new ExtendedBook(book, ratings, sumOfRatings, rateAverage);
                ratedBooks[bookId - 1] = extendedBook;
            }
            ExtendedBook[] sortedBooks = ExtendedBook.sort(ratedBooks);
            for (ExtendedBook eBook : sortedBooks) {
                /* Page splitter */
                if (message.length() > 400) {
                    JOptionPane.showMessageDialog(null, message);
                    message = "";
                }
                message += "ID: " + eBook.getId() + "\n";
                message += "Título: " + eBook.getTitle() + "\n";
                message += "Autor: " + eBook.getAuthor() + "\n";
                message += "Gênero: " + gd.findGenreName(eBook.getGenre()) + "\n";
                message += "Nota Média: " + eBook.getRateAverage() + "\n\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
