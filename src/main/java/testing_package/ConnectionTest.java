package testing_package;

import com.mycompany._usjt_psc_sistema.ConnectionFactory;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        var factory = new ConnectionFactory();
        System.out.println(factory.conectar());
    }
}
