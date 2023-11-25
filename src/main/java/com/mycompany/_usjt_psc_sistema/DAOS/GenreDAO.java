/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.DAOS;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mycompany._usjt_psc_sistema.models.Genre;

import helpers.ConnectionFactory;

/**
 *
 * @author Usuario
 */
public class GenreDAO {
    /* Find all the genres in the database */
    public Genre[] getGenres() throws Exception {
        String sql = "SELECT * FROM genres";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                ResultSet rs = ps.executeQuery()) {
            int totalGenres = rs.last() ? rs.getRow() : 0;
            Genre[] genres = new Genre[totalGenres];
            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                String name = rs.getString("genre_name");
                genres[contador++] = new Genre(name);
            }

            return genres;
        }
    }

    /* Register a new genre */
    public void register(Genre genre) throws Exception {
        String name = genre.getName();
        String sql = "INSERT INTO genres (genre_name) VALUES (?)";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar novo gênero. Tente novamente.");
            e.printStackTrace();
        }

    }

    /* Edit a genre */
    public void edit(Genre genre) throws Exception {
        int id = genre.getId();
        String name = genre.getName();
        String sql = "UPDATE genres SET genre_name = ? WHERE id = ?";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o gênero. Tente novamente.");
            e.printStackTrace();
        }
    }

    /* Delete a genre */
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM genres WHERE id = ?";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o gênero. Tente novamente.");
            e.printStackTrace();
        }
    }

    /* Find a genre's name */
    public static String findGenreName(int id) throws Exception {
        String sql = "SELECT genre_name FROM genres WHERE id = ?";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("genre_name");
                } else {
                    return null;
                }
            }
        }
    }
}
