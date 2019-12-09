package database;

import model.Sensor;
import model.SensorType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dion Trilsbeek
 */
public class SensorRepository extends Database {
    public Map<Integer, Sensor> getAllByType(SensorType type) {

        Map<Integer, Sensor> Sensors = new HashMap<>();

        try (
                Connection conn = this.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            String select = "SELECT id, value, date_created FROM " + type.getTypeString();
            ResultSet result = stmt.executeQuery(select);

            int rowCount = 0;
            while (result.next()) {

                Sensor p = new Sensor(
                        result.getInt("id"),
                        type,
                        result.getFloat("value"),
                        result.getString("date_created")
                );

                Sensors.put(p.getId(), p);

                ++rowCount;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Sensors;
    }

    public Map<Integer, Sensor> getAllByTypeBetween(SensorType type, String timeFrom, String timeTo) {

        Map<Integer, Sensor> Sensors = new HashMap<>();

        try (
                Connection conn = this.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            String select = "SELECT id, value, date_created FROM " + type.getTypeString()
                    + " WHERE date_created BETWEEN '" + timeFrom + "' AND '" + timeTo + "'";
            ResultSet result = stmt.executeQuery(select);

            while (result.next()) {

                Sensor p = new Sensor(
                        result.getInt("id"),
                        type,
                        result.getFloat("value"),
                        result.getString("date_created")
                );

                Sensors.put(p.getId(), p);
            }

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
            String select = "SELECT id, value, date_created FROM " + type.getTypeString()
                    + " WHERE id = " + id; // join tables
            ResultSet result = stmt.executeQuery(select);

            while (result.next()) {

                Sensor p = new Sensor(
                        result.getInt("id"),
                        type,
                        result.getFloat("value"),
                        result.getString("date_created")
                );

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
            stmt.executeUpdate("INSERT INTO " + type + " (value) VALUES ('" + value + "')");

            return stmt.getUpdateCount();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}
