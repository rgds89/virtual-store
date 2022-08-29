package br.com.alura.virtual.store;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mysql://localhost/VIRTUAL_STORE?useTimezone=true&serverTimezone=UTC");
        cpds.setUser("root");
        cpds.setPassword("Fpcci#2022");

        cpds.setMaxStatements(15);

        this.dataSource = cpds;
    }

    public Connection returnConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
