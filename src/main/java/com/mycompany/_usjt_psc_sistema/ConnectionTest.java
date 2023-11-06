package com.mycompany._usjt_psc_sistema;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        var fabrica = new ConnectionFactory();
        System.out.println(fabrica.conectar());
    }
}
