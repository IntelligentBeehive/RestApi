package database;

import model.Pollen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hugo Mkandawire
 */
public class PollenRepository extends Database {
    private String entity = "pollen";
    private String headers = "plant_name, hex, rgb, date_created";

    /**
     * Insert pollen
     *
     * @param pollen
     * @return update count
     */
    public int insertPollen(Pollen pollen) {
        String values = "'"
                + pollen.getPlantName() + "', '"
                + pollen.getHex() + "', '"
                + pollen.getRgb() + "', '"
                + pollen.getDateCreated() + "'";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(
                    String.format("INSERT INTO %s(%s) VALUES ('%s')", entity, headers, values));
            return stmt.getUpdateCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * Get pollen by id
     *
     * @param id
     * @return pollen
     */
    public Pollen getPollenById(int id) {
        Pollen pollen = null;
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement()) {
            String select = String.format("SELECT * FROM %s WHERE id = %d;", entity, id);
            ResultSet result = stmt.executeQuery(select);
            while (result.next()) {
                Pollen p = new Pollen(
                        result.getInt("id"),
                        result.getString("plant_name"),
                        result.getString("hex"),
                        result.getString("rgb"),
                        result.getString("date_created"));
                pollen = p;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pollen;
    }

    /**
     * Get all pollen between
     *
     * @param dateFrom
     * @param dateTo
     * @return list of pollen
     */
    public Map<Integer, Pollen> getAllBetween(String dateFrom, String dateTo) {
        Map<Integer, Pollen> pollen = new HashMap<>();

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement()) {
            String select = String.format("SELECT * FROM %s WHERE date_created BETWEEN '%s' AND '%s'", entity, dateFrom, dateTo);
            ResultSet result = stmt.executeQuery(select);

            while (result.next()) {
                Pollen p = new Pollen(
                        result.getInt("id"),
                        result.getString("plant_name"),
                        result.getString("hex"),
                        result.getString("rgb"),
                        result.getString("date_created"));
                pollen.put(p.getId(), p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pollen;
    }

    /**
     * Get all pollen
     *
     * @return list of pollen
     */
    public Map<Integer, Pollen> getAll() {
        Map<Integer, Pollen> pollen = new HashMap<>();

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement()) {
            String select = String.format("SELECT * FROM %s", entity);
            ResultSet result = stmt.executeQuery(select);

            while (result.next()) {
                Pollen p = new Pollen(
                        result.getInt("id"),
                        result.getString("plant_name"),
                        result.getString("hex"),
                        result.getString("rgb"),
                        result.getString("date_created"));
                pollen.put(p.getId(), p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pollen;
    }
}
