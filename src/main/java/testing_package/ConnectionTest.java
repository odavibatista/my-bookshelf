package testing_package;

import helpers.ConnectionFactory;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        var factory = new ConnectionFactory();
        System.out.println(factory.conectar());
    }
}
