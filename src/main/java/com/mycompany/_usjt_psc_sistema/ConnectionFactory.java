/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._usjt_psc_sistema;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    // Preencher com informações do Aiven
    private static final String host = "mysql-eb0f1eb-project-java.a.aivencloud.com";
    private static final String port = "22760";
    private static final String user = "avnadmin";
    private static final String password = "AVNS_FbWtPipks52tMpOAy1w";
    private static final String db = "defaultdb";
    
    public static Connection conectar() throws Exception {
        //http://dontpad.com:80/bossini
        //String de conexão
        //String s = "jdbc:mysql://" + host + ":" + port + "/" + db;
        String s = String.format(
            "jdbc:mysql://%s:%s/%s",
            host, port, db
        );
        
        Connection c = DriverManager.getConnection(
                s, 
                user, 
                password
        );
        return c;
    }
    
}