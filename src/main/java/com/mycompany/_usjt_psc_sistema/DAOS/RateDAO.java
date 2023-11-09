/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mycompany._usjt_psc_sistema.ConnectionFactory;
import com.mycompany._usjt_psc_sistema.models.Rate;

/**
 *
 * @author Usuario
 */
public class RateDAO {
    /* Find Ratings in the database */
    public Rate[] getRatings(int id) throws Exception {
        String sql = "SELECT * FROM ratings WHERE book_id = ?";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                ResultSet rs = ps.executeQuery()) {
            ps.setInt(1, id);
            int totalRatings = rs.last() ? rs.getRow() : 0;
            Rate[] ratings = new Rate[totalRatings];
            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int title = rs.getInt("user_id");
                int bookId = rs.getInt("book_id");
                int rate = rs.getInt("rating");
                ratings[contador++] = new Rate(title, bookId, rate);
            }

            return ratings;
        }
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

                ResultSet rs = ps.executeQuery()) {
            ps.setInt(1, id);
            int totalRatings = rs.last() ? rs.getRow() : 0;
            return totalRatings;
        }
    }

    /* Creating new ratings */
    public void register(Rate rate) throws Exception {
        int id = rate.getId();
        int bookId = rate.getBookId();
        int userId = rate.getUserId();
        int rating = rate.getRate();

        // Check if the user has already rated the book
        if (wasRated(rate)) {
            JOptionPane.showMessageDialog(null, "Você já avaliou este livro.");
            return;
        } else {
            String sql = "INSERT INTO ratings (id, book_id, user_id, rating) VALUES (?, ?, ?, ?);";
            var connection = ConnectionFactory.conectar();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setInt(2, bookId);
            ps.setInt(3, userId);
            ps.setInt(4, rating);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Avaliação cadastrada!");
            } else {
                System.out.println("Erro ao cadastrar avaliação");
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
