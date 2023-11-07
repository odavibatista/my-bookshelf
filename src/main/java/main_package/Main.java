/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

import com.mycompany._usjt_psc_sistema.UserDAO;
import com.mycompany._usjt_psc_sistema.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String menu = "1-Cadastrar\n2-Listar\n3-Atualizar\n4-Remover\n0-Sair";
        var pessoaDAO = new UserDAO();
        int op;

        do {
            op = Integer.parseInt(
                    JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome");
                    String email = JOptionPane.showInputDialog("Digite o e-mail:");

                    var pessoa = new User(nome, email, null, "", null, 0, 0, false);

                    pessoaDAO.register(pessoa);
                    JOptionPane.showMessageDialog(null, "Usuário " + nome + " cadastrado com sucesso!");
                    break;
                case 2:
                    pessoaDAO.index();
                    break;
                case 4:
                    int codigo = Integer
                            .parseInt(JOptionPane.showInputDialog("Digite o código do usuário a ser removido"));
                    JOptionPane.showInputDialog("Digite o código do usuário a ser removido");
                    pessoaDAO.delete(codigo);
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Insira uma opção válida.");
                    break;
            }
        } while (true);
    }
}