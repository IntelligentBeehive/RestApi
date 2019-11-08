package database;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.ArrayList;

public class Database {

    private static String host = "studmysql01.fhict.local";
    private static String user = "dbi391176";
    private static String pass = "appelsenperen12";

    public ArrayList<SensorDTO> getAllSensors() {

        ArrayList<SensorDTO> Sensors = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":3306/dbi391176",
                        user, pass);   // For MySQL only
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select * from Sensor";
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {

                SensorDTO p = new SensorDTO(
                        rset.getInt("id"),
                        rset.getString("name"),
                        rset.getInt("score"),
                        rset.getInt("games_played")
                );

                Sensors.add(p);

                System.out.println(p);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Sensors;
    }

    public SensorDTO getSensorById(int id) {

        SensorDTO Sensor = null;

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":3306/dbi391176",
                        user, pass);   // For MySQL only
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = String.format("select * from Sensor WHERE id = %d;", id);
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");

            while (rset.next()) {

                SensorDTO p = new SensorDTO(
                        rset.getInt("id"),
                        rset.getString("name"),
                        rset.getInt("score"),
                        rset.getInt("games_played")
                );

                System.out.println(p);

                Sensor = p;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Sensor;
    }


    public void insertSensor(SensorDTO Sensor) {

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":3306/dbi391176",
                        user, pass);   // For MySQL only
                Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(String.format("INSERT INTO Sensor (name) VALUES ('%s')", Sensor.getName()));
            System.out.println("Affected rows: " + stmt.getUpdateCount());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void addScore(int SensorId, int score) {

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":3306/dbi391176",
                        user, pass);   // For MySQL only
                Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(String.format(" UPDATE Sensor    SET score = score + %d, games_played = games_played + 1    WHERE id = %d", score, SensorId));
            System.out.println("Affected rows: " + stmt.getUpdateCount());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public SensorDTO checkPassword(String name, String password) {
        SensorDTO Sensor = null;
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":3306/dbi391176",
                        user, pass);   // For MySQL only
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = String.format("select * from Sensor WHERE name = %s AND password=%s;", name, password);
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                SensorDTO p = new SensorDTO(
                        rset.getInt("id"),
                        rset.getString("name"),
                        rset.getInt("score"),
                        rset.getInt("games_played")
                );

                System.out.println(p);

                Sensor = p;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Sensor;
    }
}