/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema;
import java.sql.ResultSet;
/**
 *
 * @author Samsung
 */
public class BooksDAO {
    public Book [] obterCursos () throws Exception{
        String sql = "SELECT * FROM tb_curso";
        try (
            var conn = ConnectionFactory.conectar();
                
            var ps =conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );
                  
            ResultSet rs = ps.executeQuery()
        ){
            int totalDeCursos = rs.last () ? rs.getRow() : 0;
            Book [] courses = new Book[totalDeCursos];
            rs.beforeFirst();
            int contador = 0;
            
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String tipo = rs.getString ("tipo");
                courses[contador++] = new Book (id, nome, tipo);
            }
            
            return courses;
        }
    }
}
