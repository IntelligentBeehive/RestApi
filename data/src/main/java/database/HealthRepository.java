package database;

import model.BeeInfo;
import model.Sensor;
import model.SensorType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HealthRepository extends Database {
    public List<BeeInfo> getAllBetween(String timeFrom, String timeTo) {
        List<BeeInfo> beeInfo = new ArrayList<>();
        try (
                Connection conn = this.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            String select = "SELECT id, date_created, bee_count, brood_pattern_healthy_confidence, brood_pattern_unhealthy_confidence, hive_health, message " +
                    "FROM beehealth WHERE date_created BETWEEN '" + timeFrom + "' AND '" + timeTo + "'";
            ResultSet result = stmt.executeQuery(select);

            while (result.next()) {
                var p = new BeeInfo(
                        result.getInt("id"),
                        result.getString("date_created"),
                        result.getInt("bee_count"),
                        result.getInt("brood_pattern_healthy_confidence"),
                        result.getInt("brood_pattern_unhealthy_confidence"),
                        result.getInt("hive_health"),
                        result.getString("message")
                );

                beeInfo.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return beeInfo;
    }
    public void addBeeInfo(BeeInfo beeInfo){
        try (
                Connection conn = this.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            String query = "INSERT INTO beehealth(bee_count,brood_pattern_healthy_confidence,brood_pattern_unhealthy_confidence,hive_health,message) " +
                    "VALUES(" +
                        String.format("%s, %s, %s, %s, '%s'", beeInfo.getBeeCount(),
                                beeInfo.getBroodPatternHealthyConfidence(), beeInfo.getBroodPatternUnhealthyConfidence(),beeInfo.getHiveHealth(),beeInfo.getMessage()) +
                    ")";
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
