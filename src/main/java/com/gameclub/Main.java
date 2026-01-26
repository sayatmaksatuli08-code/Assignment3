package com.gameclub;

import com.gameclub.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection con = factory.createConnection()) {
            System.out.println("DB connection OK: " + con.getMetaData().getURL());
            System.out.println();

            printCustomers(con);
            System.out.println();

            printStations(con);
            System.out.println();

            printGamingSessions(con);

        } catch (Exception e) {
            System.out.println("DB connection FAILED: " + e.getMessage());
        }
    }

    private static void printCustomers(Connection con) throws Exception {
        System.out.println("=== CUSTOMERS ===");
        String sql = "SELECT id, full_name, phone, membership_type FROM public.customer ORDER BY id";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean any = false;
            while (rs.next()) {
                any = true;
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("full_name") + " | " +
                                rs.getString("phone") + " | " +
                                rs.getString("membership_type")
                );
            }
            if (!any) System.out.println("(empty)");
        }
    }

    private static void printStations(Connection con) throws Exception {
        System.out.println("=== STATIONS ===");
        String sql = "SELECT id, name, type, price_per_hour, status FROM public.station ORDER BY id";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean any = false;
            while (rs.next()) {
                any = true;
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("type") + " | " +
                                rs.getBigDecimal("price_per_hour") + " | " +
                                rs.getString("status")
                );
            }
            if (!any) System.out.println("(empty)");
        }
    }

    private static void printGamingSessions(Connection con) throws Exception {
        System.out.println("=== GAMING SESSIONS ===");
        String sql = """
                SELECT gs.id,
                       gs.customer_id,
                       gs.station_id,
                       gs.start_time,
                       gs.end_time,
                       gs.minutes_played,
                       gs.total_price,
                       gs.status
                FROM public.gaming_session gs
                ORDER BY gs.id
                """;
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean any = false;
            while (rs.next()) {
                any = true;
                System.out.println(
                        rs.getInt("id") + " | " +
                                "cust=" + rs.getInt("customer_id") + " | " +
                                "station=" + rs.getInt("station_id") + " | " +
                                rs.getTimestamp("start_time") + " | " +
                                rs.getTimestamp("end_time") + " | " +
                                rs.getInt("minutes_played") + " min | " +
                                rs.getBigDecimal("total_price") + " | " +
                                rs.getString("status")
                );
            }
            if (!any) System.out.println("(empty)");
        }
    }
}
