/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.DAOS;

import com.mycompany._usjt_psc_sistema.screens.AdminDashboardScreen;

import helpers.ConnectionFactory;

import com.mycompany._usjt_psc_sistema.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class UserDAO {

    /* Get the existing users from the database */
    public User[] getUsers() throws Exception {
        String sql = "SELECT * FROM books";

        try (
                var conn = ConnectionFactory.conectar();

                var ps = conn.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                ResultSet rs = ps.executeQuery()) {
            int totalUsers = rs.last() ? rs.getRow() : 0;
            User[] users = new User[totalUsers];
            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String gender = rs.getString("gender");
                String password = rs.getString("password");
                int firstFavorite = rs.getInt("first_favorite");
                int secondFavorite = rs.getInt("second_favorite");
                boolean superUser = rs.getBoolean("super_user");
                users[contador++] = new User(name, surname, email, age, gender, password, firstFavorite,
                        secondFavorite, superUser);
            }

            return users;
        }
    }

    /* Create a new user */
    public void register(User pessoa) throws Exception {
        String name = pessoa.getName();
        String surname = pessoa.getSurname();
        String email = pessoa.getEmail();
        String age = pessoa.getAge();
        String gender = pessoa.getGender();
        String password = pessoa.getPassword();

        String sql = "INSERT INTO users (name, surname, email, age, gender, user_password, favorite_gender, second_favorite_gender, super_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        var connection = ConnectionFactory.conectar();

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setString(3, email);
        ps.setInt(4, Integer.parseInt(age));
        ps.setString(5, gender);
        ps.setString(6, password);
        ps.setInt(7, 1);
        ps.setInt(8, 2);
        ps.setInt(9, 0);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Aluno cadastrado!");

            AdminDashboardScreen dashboardScreen = new AdminDashboardScreen();
            dashboardScreen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno");
        }

        ps.close();
        connection.close();
    }

    /* Update an user's info */
    public void update(User pessoa) throws Exception {
        int id = pessoa.getId();
        String email = pessoa.getEmail();
        String password = pessoa.getPassword();

        String sql = "UPDATE users SET email = ?, password = ?, WHERE id = ?;";

        try (
                var connection = ConnectionFactory.conectar();
                var ps = connection.prepareStatement(sql);) {
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setInt(3, id);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o usuário. Tente novamente.");
            e.printStackTrace();
        }

    }

    /* Delete a user from the database */
    public void delete(int codigo) throws Exception {
        String sql = "DELETE FROM users WHERE id = ?;";
        try (
                var conexao = new ConnectionFactory().conectar();
                // 3 - Preparar o comando
                var ps = conexao.prepareStatement(sql);) {
            ps.setInt(1, codigo);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deleter o usuário. Tente novamente.");
            e.printStackTrace();
        }

    }

    /* See if the user exists in the database */
    public boolean exists(User user) throws Exception {
        String email = user.getEmail();
        String password = user.getPassword();
        String sql = "SELECT * FROM users WHERE email = ? AND user_password = ?";

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                boolean next = rs.next();
                if (next) {
                    user.setId(rs.getInt("id"));
                }
                return next;
            }
        }
    }

    /* Find a user in the database */
    public User findOne(User user) throws Exception {
        String sql = "SELECT * FROM users WHERE id = ?;";
        int id = user.getId();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String email = rs.getString("email");
                    String age = rs.getString("age");
                    String gender = rs.getString("gender");
                    String password = rs.getString("password");
                    int firstFavorite = rs.getInt("first_favorite");
                    int secondFavorite = rs.getInt("second_favorite");
                    boolean superUser = rs.getBoolean("super_user");

                    return new User(name, surname, email, age, gender, password, firstFavorite, secondFavorite,
                            superUser);
                } else {
                    return null;
                }
            }
        }
    }

    /* See if the user is a superuser / admin */
    public boolean isSuperUser(User user) throws Exception {
        String sql = "SELECT * FROM users WHERE email = ? AND user_password = ?;";
        String email = user.getEmail();
        String password = user.getPassword();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Retornou true");
                    return true;
                } else {
                    System.out.println("Retornou false");
                    return false;
                }
            }
        }
    }
}