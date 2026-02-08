package com.gameclub.repository;

import com.gameclub.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionRepository {

    /**
     * JOIN query
     * Returns full information about gaming session:
     * customer + station + session data
     */
    public void getFullSessionDescription(int sessionId) {

        String sql = """
            SELECT
                gs.id                AS session_id,
                c.full_name          AS customer_name,
                c.phone              AS customer_phone,
                c.membership_type    AS membership_type,
                s.code               AS station_code,
                s.hourly_rate        AS hourly_rate,
                gs.start_time,
                gs.end_time,
                gs.minutes_played,
                gs.total_price,
                gs.status
            FROM gaming_sessions gs
            JOIN customers c ON gs.customer_id = c.id
            JOIN stations s ON gs.station_id = s.id
            WHERE gs.id = ?
        """;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, sessionId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("=== FULL GAMING SESSION INFO ===");
                System.out.println("Session ID: " + resultSet.getInt("session_id"));
                System.out.println("Customer: " + resultSet.getString("customer_name"));
                System.out.println("Phone: " + resultSet.getString("customer_phone"));
                System.out.println("Membership: " + resultSet.getString("membership_type"));
                System.out.println("Station: " + resultSet.getString("station_code"));
                System.out.println("Hourly rate: " + resultSet.getBigDecimal("hourly_rate"));
                System.out.println("Start time: " + resultSet.getTimestamp("start_time"));
                System.out.println("End time: " + resultSet.getTimestamp("end_time"));
                System.out.println("Minutes played: " + resultSet.getInt("minutes_played"));
                System.out.println("Total price: " + resultSet.getBigDecimal("total_price"));
                System.out.println("Status: " + resultSet.getString("status"));
            } else {
                System.out.println("Session with ID " + sessionId + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error while fetching full session description");
            e.printStackTrace();
        }
    }
}
