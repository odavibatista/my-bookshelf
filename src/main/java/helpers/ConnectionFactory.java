/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {
    // Obtenção das variáveis do arquivo .env
    private static Dotenv dotenv = Dotenv.configure().load();
    private static final String host = dotenv.get("HOST");
    private static final String port = dotenv.get("PORT");
    private static final String user = dotenv.get("USER");
    private static final String password = dotenv.get("PASSWORD");
    private static final String db = dotenv.get("DATABASE");
    private static final String engine = dotenv.get("ENGINE");
    private static final String ssl = dotenv.get("SSL");
    private static String s;

    public static Connection conectar() throws Exception {
        // String s = "jdbc:mysql://" + host + ":" + port + "/" + db;
        s = String.format(
                "jdbc:%s://%s:%s/%s?serverTimezone=UTC",
                engine, host, port, db);

        var c = DriverManager.getConnection(
                s,
                user,
                password);
        return c;
    }

}