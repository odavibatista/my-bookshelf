/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.DAOS;

import com.mycompany._usjt_psc_sistema.models.Book;

import helpers.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author Samsung
 */
public class BookDAO {

    /* Get all the books in the database */
    public Book[] getBooks() throws Exception {
        String sql = "SELECT * FROM books";
        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                ResultSet rs = ps.executeQuery()) {
            int totalBooks = rs.last() ? rs.getRow() : 0;
            Book[] books = new Book[totalBooks];
            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int genre = rs.getInt("genre_id");
                String author = rs.getString("author");
                books[contador++] = new Book(id, title, author, genre);
            }

            return books;
        }
    }

    /* Get the book's name */
    public String getBookName(int id) throws Exception {
        String sql = "SELECT title FROM books WHERE id = ?;";
        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("title");
        }
    }

    /* Search a book by its name */
    public Book[] search(String title) throws Exception {
        String sql = "SELECT * FROM books WHERE title LIKE ?;";
        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY)) {
            ps.setString(1, "%" + title + "%");
            ResultSet rs = ps.executeQuery();
            int totalBooks = rs.last() ? rs.getRow() : 0;
            Book[] books = new Book[totalBooks];
            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                String bookTitle = rs.getString("title");
                int genre = rs.getInt("genre_id");
                String author = rs.getString("author");
                books[contador++] = new Book(bookTitle, author, genre);
            }

            return books;
        }
    }

    /* Find a single book by its name */
    public Book searchByName(String title) throws Exception {
        String sql = "SELECT * FROM books WHERE title = ?;";
        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY)) {
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String bookTitle = rs.getString("title");
            int genre = rs.getInt("genre_id");
            String author = rs.getString("author");
            return new Book(id, bookTitle, author, genre);
        }
    }

    /* Create a new book */
    public void register(Book book) throws Exception {
        String title = book.getTitle();
        String author = book.getAuthor();
        int genre = book.getGenre();

        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Tem certeza que deseja cadastrar o livro " + title + ", do autor " + author + " na categoria " + genre
                        + "?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            String sql = "INSERT INTO books (title, author, genre_id) VALUES (?, ?, ?);";
            var connection = ConnectionFactory.conectar();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, genre);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro. Tente novamente.");
            }
            ps.close();
            connection.close();
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
        }

    }

    /* Update an existing book's info */
    public void update(Book book) throws Exception {
        int id = book.getId();
        String title = book.getTitle();
        String author = book.getAuthor();
        int genre = book.getGenre();

        String sql = "UPDATE books SET title = ?, author = ?, genre_id = ? WHERE id = ?;";
        try {
            var connection = ConnectionFactory.conectar();
            var ps = connection.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, genre);
            ps.setInt(4, id);

            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o livro. Tente novamente.");
            e.printStackTrace();
        }
    }

    /* See if the book exists in the database */
    public boolean exists(Book book) throws Exception {
        String sql = "SELECT * FROM books WHERE id = ? AND title = ? AND author = ? AND genre_id = ?;";
        int id = book.getId();
        String title = book.getTitle();
        String author = book.getAuthor();
        int genre = book.getGenre();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setInt(4, genre);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    /* Find a book by its ID */
    public Book findOne(int id) throws Exception {
        String sql = "SELECT * FROM books WHERE id = ?;";

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    int genre = rs.getInt("genre_id");

                    return new Book(title, author, genre);
                } else {
                    return null;
                }
            }
        }
    }

    /* Delete a book from the database */
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM books WHERE id = ?;";

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Livro deletado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar livro. Tente novamente.");
                }
            }
        }
    }

    /* Get the id of the last book on the database */
    public int getLastId() throws Exception {
        String sql = "SELECT id FROM books ORDER BY id DESC LIMIT 1;";

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    return 0;
                }
            }
        }
    }
}
