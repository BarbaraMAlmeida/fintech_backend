package br.com.fintech.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class FintechDB {
    public static Connection getConnectionDB () {
        Connection conecction = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conecction = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM552825", "220105");

            conecction.setAutoCommit(false);
        } catch (Exception e) {
            System.err.println("Não foi possível conectar no Banco de Dados");
            e.printStackTrace();
        }

        System.out.println("Conectado!");
        return conecction;
    }
}
