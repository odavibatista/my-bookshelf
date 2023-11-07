/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing_package;

import com.mycompany._usjt_psc_sistema.ConnectionFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class TesteConexao {
    public static void main(String[] args){
        try{
            var factory = new ConnectionFactory();
            var minhaConexao = factory.conectar();
            System.out.println("Conectou!!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage()
            );
            e.printStackTrace();
        }
    }
}