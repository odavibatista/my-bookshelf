/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author Samsung
 */
public class BookDAO {
    public Book[] getBooks() throws Exception {
        String sql = "SELECT * FROM tb_curso";
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
                String title = rs.getString("title");
                int genre = rs.getInt("genre");
                String author = rs.getString("author");
                books[contador++] = new Book(title, author, genre);
            }

            return books;
        }
    }

    public void register(Book book) throws Exception {
        String title = book.getTitle();
        String author = book.getAuthor();
        int genre = book.getGenre();

        String sql = "INSERT INTO users (title, author, genre_id) VALUES (?, ?, ?);";
        var connection = ConnectionFactory.conectar();

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, title);
        ps.setString(2, author);
        ps.setInt(3, genre);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");

            DashboardScreen dashboardScreen = new DashboardScreen();
            dashboardScreen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro. Tente novamente.");
        }
        ps.close();
        connection.close();
    }

    public void update(Book book) throws Exception {
        int id = book.getId();
        String title = book.getTitle();
        String author = book.getAuthor();
        int genre = book.getGenre();

        // 1. Especificar o comando SQL
        String sql = "UPDATE books SET title = ?, author = ?, genre_id = ? WHERE id = ?;";

        // 2 - Abrir uma conexão com o mySql
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

    public void index() throws Exception {
        String sql = "SELECT * FROM books;";

        try (
                Connection connection = ConnectionFactory.conectar();
                // 3 - Preparar o comando
                PreparedStatement ps = connection.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int genre = rs.getInt("genre_id");

                System.out.printf("Título: %s\n", title);
                System.out.printf("Autor: %s\n", author);
                System.out.printf("Gênero: %d\n", genre);

                rs.next();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários. Tente novamente.");
            e.printStackTrace();
        }
    }
}
