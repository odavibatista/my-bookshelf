/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.DAOS;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.mycompany._usjt_psc_sistema.ConnectionFactory;
import com.mycompany._usjt_psc_sistema.models.Rate;

/**
 *
 * @author Usuario
 */
public class RateDAO {

    /* Creating new ratings */
    public void register(Rate rate) throws Exception {
        int id = rate.getId();
        int bookId = rate.getBookId();
        int userId = rate.getUserId();
        int rating = rate.getRate();

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
}
