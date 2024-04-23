package br.com.fintech.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FintechDB {


    private static FintechDB instance;
    private Connection connection;

    private FintechDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM552825", "220105");
            this.connection.setAutoCommit(false);
            System.out.println("Conectado!");
        } catch (SQLException e) {
            System.err.println("Erro ao tentar conectar com o banco de dados");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver de conexão não encontrado");
        }
    }

    public static FintechDB getInstance() {
        if(instance == null) {
            instance = new FintechDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
