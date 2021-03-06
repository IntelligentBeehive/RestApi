package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public abstract class Database {

    protected static String host = "localhost";
    protected static int port = 3306;
    protected static String dbName = "beehive";
    protected static String user = "beehive";
    protected static String pass = "beehive";

    // TODO: One query to get sensordata from all sensors;
    // TODO: Prepared statements (?)
    // TODO: Set a (dynamic) limit on GET requests

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + port + "/" + dbName,
                user, pass);   // For MySQL only
    }
}