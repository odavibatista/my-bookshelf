/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mycompany._usjt_psc_sistema.models.Rate;

import helpers.ConnectionFactory;

/**
 *
 * @author Usuario
 */
public class RateDAO {
    /* Find all Ratings of a book in the database */
    public Rate[] getRatings(int bookId) throws Exception {
        String sql = "SELECT * FROM ratings WHERE book_id = ?";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);) {
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            int totalRatings = rs.last() ? rs.getRow() : 0;
            Rate[] ratings = new Rate[totalRatings];
            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int book_id = rs.getInt("book_id");
                int rating = rs.getInt("rating");
                ratings[contador++] = new Rate(id, user_id, book_id, rating);
            }

            return ratings;
        }
    }

    /* Get the sum of the book's ratings */
    public int getSumOfRatings(int id) throws Exception {
        String sql = "SELECT SUM(rating) FROM ratings WHERE book_id = ?";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int totalRatings = rs.last() ? rs.getRow() : 0;
            int sumOfRatings = 0;
            if (totalRatings > 0) {
                sumOfRatings = rs.getInt("SUM(rating)");
            }
            return sumOfRatings;
        }

        // Why is this method giving an error java.sql.SQLException: No value specified
        // for parameter 1?
        // Explain below
        // Answer: The parameter 1 is the book_id, which is not being passed to the
        // method
        // Fix the ps.setInt(1, id); line and give me the answer below

    }

    /* Counting the ratings of a book */
    public int countRatings(int id) throws Exception {
        String sql = "SELECT COUNT(*) FROM ratings WHERE book_id = ?";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            // Get the number of ratings, even if there's only one
            int totalRatings = rs.last() ? rs.getRow() : 0;
            return totalRatings;
        }
    }

    /* Creating new ratings */
    public void register(Rate rate) throws Exception {
        int bookId = rate.getBookId();
        int userId = rate.getUserId();
        int rating = rate.getRate();

        // Check if the user has already rated the book
        if (wasRated(rate)) {
            JOptionPane.showMessageDialog(null, "Você já avaliou este livro.");
            return;
        } else {
            String sql = "INSERT INTO ratings (user_id, book_id, rating) VALUES (?, ?, ?);";
            var connection = ConnectionFactory.conectar();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            ps.setInt(3, rating);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Avaliação cadastrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a avaliação. Tente novamente.");
            }

            ps.close();
            connection.close();
        }
    }

    /* Updating existing ratings */
    public void update(Rate rate) throws Exception {
        int id = rate.getId();
        int userId = rate.getUserId();
        int bookId = rate.getBookId();
        int rating = rate.getRate();

        String sql = "UPDATE ratings SET user_id = ?, book_id = ?, rating = ? WHERE id = ?;";

        try (
                var connection = ConnectionFactory.conectar();
                var ps = connection.prepareStatement(sql);) {
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            ps.setInt(3, rating);
            ps.setInt(4, id);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar a sua avaliação. Tente novamente.");
            e.printStackTrace();
        }
    }

    /* Delete existing rating */
    public void delete(int id) {
        String sql = "DELETE FROM ratings WHERE id = ?;";
        try (
                var connection = ConnectionFactory.conectar();
                var ps = connection.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar a avaliação. Tente novamente.");
            e.printStackTrace();
        }
    }

    /* Check if the user has already rated a book */
    public boolean wasRated(Rate rate) throws Exception {
        int userId = rate.getUserId();
        int bookId = rate.getBookId();
        String sql = "SELECT * FROM ratings WHERE user_id = ? AND book_id = ?";

        try (var connection = ConnectionFactory.conectar();
                var ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            var rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar a avaliação. Tente novamente.");
            e.printStackTrace();
        }
        return false;
    }
}
