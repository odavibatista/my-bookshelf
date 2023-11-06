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
public class PessoaDAO {
    // Data Access Object
    // Oferece funcionalidades de acesso aos dados no banco de dados de tipo Pessoa

    public void cadastrar(Pessoa pessoa) throws Exception {
        String name = pessoa.getName();
        String email = pessoa.getEmail();
        String age = pessoa.getAge();
        String gender = pessoa.getGender();
        String password = pessoa.getPassword();

        String sql = "INSERT INTO users (first_name, last_name, email, age, gender, user_password, favorite_gender, second_favorite_gender, super_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        var conexao = ConnectionFactory.conectar();

        PreparedStatement ps = conexao.prepareStatement(sql);

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

            DashboardScreen dashboardScreen = new DashboardScreen(); // Substitua "NomeDoNovoFrame" pelo nome real do
                                                                     // seu novo JFrame
            dashboardScreen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno");
        }
        ps.close();
        conexao.close();
    }

    public void atualizar(Pessoa pessoa) throws Exception {
        int codigo = pessoa.getCodigo();
        String email = pessoa.getEmail();
        String password = pessoa.getPassword();

        // 1. Especificar o comando SQL
        String sql = "UPDATE users SET email = ?, password = ?, WHERE cod_pessoa = ?;";

        // 2 - Abrir uma conexão com o mySql

        try (
                var conexao = ConnectionFactory.conectar();
                // 3 - Preparar o comando
                var ps = conexao.prepareStatement(sql);) {
            // 4 - Substituir os eventuais placeholders
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setInt(3, codigo);
            // 5 - Executar o comando preparado
            ps.execute();
            // 6 - Fechar a conexão -> Já foi feito pelo try
        } catch (Exception e) {
        }
    }

    public void desativar(Pessoa pessoa) throws Exception {
        // 1. Especificar o comando SQL

    }

    public void deletar(int codigo) throws Exception {
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
        }

    }

    public boolean exists(Pessoa pessoa) throws Exception {
        String sql = "SELECT * FROM users WHERE email = ? AND user_password  = ?";
        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pessoa.getEmail());
            ps.setString(2, pessoa.getPassword());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void listar() throws Exception {
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

        }
    }
}