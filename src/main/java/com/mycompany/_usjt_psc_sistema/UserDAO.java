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
 * @author Usuario
 */
public class UserDAO {
    // Data Access Object
    // Oferece funcionalidades de acesso aos dados no banco de dados de tipo Pessoa

    public void register(User pessoa) throws Exception {
        String name = pessoa.getName();
        String email = pessoa.getEmail();
        String age = pessoa.getAge();
        String gender = pessoa.getGender();
        String password = pessoa.getPassword();

        String sql = "INSERT INTO users (first_name, last_name, email, age, gender, user_password, favorite_gender, second_favorite_gender, super_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        var connection = ConnectionFactory.conectar();

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, "");
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

            DashboardScreen dashboardScreen = new DashboardScreen();
            dashboardScreen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno");
        }
        ps.close();
        connection.close();
    }

    public void update(User pessoa) throws Exception {
        int codigo = pessoa.getId();
        String email = pessoa.getEmail();
        String password = pessoa.getPassword();

        // 1. Especificar o comando SQL
        String sql = "UPDATE users SET email = ?, password = ?, WHERE cod_pessoa = ?;";

        // 2 - Abrir uma conexão com o mySql

        try (
                var connection = ConnectionFactory.conectar();
                // 3 - Preparar o comando
                var ps = connection.prepareStatement(sql);) {
            // 4 - Substituir os eventuais placeholders
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setInt(3, codigo);
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o usuário. Tente novamente.");
            e.printStackTrace();
        }

    }

    public void delete(int codigo) throws Exception {
        // 1. Especificar o comando SQL
        String sql = "DELETE FROM users WHERE cod_pessoa = ?;";
        // 2 - Abrir uma conexão com o SQL
        try (
                var conexao = new ConnectionFactory().conectar();
                // 3 - Preparar o comando
                var ps = conexao.prepareStatement(sql);) {
            // 4 - Substituir os eventuais placeholders
            ps.setInt(1, codigo);
            // 5 - Executar o comando preparado
            ps.execute();
            // 6 - Fechar a conexão -> Já foi feito pelo try
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deleter o usuário. Tente novamente.");
            e.printStackTrace();
        }

    }

    public boolean exists(String user, String password) throws Exception {
        String sql = "SELECT * FROM users WHERE user = ? AND password = ?";
        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void index() throws Exception {
        String sql = "SELECT * FROM users;";

        try (
                var conexao = ConnectionFactory.conectar();
                // 3 - Preparar o comando
                var ps = conexao.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                String email = rs.getString("email");

                System.out.printf("email: %s\n", email);
                rs.next();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários. Tente novamente.");
            e.printStackTrace();
        }
    }

    public User findOne(User user) throws Exception {
        String sql = "SELECT * FROM users WHERE id = ?;";
        int id = user.getId();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String age = rs.getString("age");
                    String gender = rs.getString("gender");
                    String password = rs.getString("password");
                    int firstFavorite = rs.getInt("first_favorite");
                    int secondFavorite = rs.getInt("second_favorite");
                    boolean superUser = rs.getBoolean("super_user");

                    return new User(name, email, age, gender, password, firstFavorite, secondFavorite, superUser);
                } else {
                    return null;
                }
            }
        }
    }
}