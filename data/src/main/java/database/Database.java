package database;

import model.Sensor;
import model.SensorType;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private static String host = "rdbms.strato.de";
    private static String dbName = "DB3496989";
    private static String user = "U3496989";
    private static String pass = "Bijenkast112";

    // TODO: One query to get sensordata from all sensors;
    // TODO: Prepared statements (?)

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://" + host + ":3306/"+dbName,
                user, pass);   // For MySQL only
    }

    public Map<Integer, Sensor> getAllSensors() {

        Map<Integer, Sensor> Sensors = new HashMap<>();

        try (
                Connection conn = this.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "SELECT 'id', 'type', 'value', 'date_created' FROM "; // join tables 'table1' as TableName
            ResultSet result = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (result.next()) {

                Sensor p = new Sensor(
                        result.getInt("id"),
                        SensorType.valueOf("test"),
                        result.getFloat("value")
                );

                Sensors.put(p.getId(), p);

                System.out.println(p);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Sensors;
    }

    public Map<Integer, Sensor> getAllByType(SensorType type) {

        Map<Integer, Sensor> Sensors = new HashMap<>();

        try (
                Connection conn = this.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            String select = "SELECT 'id', 'value', 'date_created' FROM "+type.getTypeString();
            ResultSet result = stmt.executeQuery(select);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (result.next()) {

                Sensor p = new Sensor(
                    result.getInt("id"),
                    type,
                    result.getFloat("value")
                );

                Sensors.put(p.getId(), p);

                System.out.println(p);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Sensors;
    }

    public Sensor getSensorById(SensorType type, int id) {

        Sensor Sensor = null;

        try (
                Connection conn = this.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            String select = "SELECT 'id', 'value', 'date_created' FROM "+type.getTypeString(); // join tables
            ResultSet result = stmt.executeQuery(select);

            System.out.println("The records selected are:");

            while (result.next()) {

                Sensor p = new Sensor(
                        result.getInt("id"),
                        type,
                        result.getFloat("value")
                );

                System.out.println(p);

                Sensor = p;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Sensor;
    }

    public int insertSensor(Sensor sensor) {

        var type = sensor.getType().getTypeString();
        var value = sensor.getValue();

        try (
                Connection conn = this.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate("INSERT INTO "+type+" (value) VALUES ('"+value+"')");
            System.out.println("Affected rows: " + stmt.getUpdateCount());

            return stmt.getUpdateCount();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}