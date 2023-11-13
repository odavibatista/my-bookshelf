/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import javax.swing.JOptionPane;

import com.mycompany._usjt_psc_sistema.DAOS.BookDAO;
import com.mycompany._usjt_psc_sistema.models.Book;

/**
 *
 * @author 823212382
 */
public class BookNames {
    public static String[] getBookNames()   {
        BookDAO bookDAO = new BookDAO();
        Book[] books = null;
        try {
                books = bookDAO.getBooks();
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar livros: " + e.getMessage());
        }
        String[] bookNames = new String[books.length];
        for (int i = 0; i < books.length; i++) {
                bookNames[i] = books[i].getTitle();
        };

        return bookNames;
    }

}
