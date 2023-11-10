package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC", "root", "123456");
            return conn;
        } catch (SQLException ex) {
           throw new RuntimeException(ex);
        }
    }
}
