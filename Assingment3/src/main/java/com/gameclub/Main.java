package com.gameclub;

import com.gameclub.config.ConnectionFactory;
import com.gameclub.model.MembershipType;
import com.gameclub.model.Role;
import com.gameclub.repository.SessionRepository;
import com.gameclub.util.Security;
import com.gameclub.util.Validator;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (Connection con = ConnectionFactory.getConnection()) {
            System.out.println("DB connection OK: " + con.getMetaData().getURL());

            Role currentRole = Role.MANAGER;
            System.out.println("Current role: " + currentRole);

            String phone = "+77001234567";
            System.out.println("Phone '" + phone + "' valid: " + Validator.isValidPhone(phone));

            MembershipType mt = MembershipType.fromString("vip");
            System.out.println("Parsed membership type: " + mt);

            System.out.println("\n=== SECURED ACTION (ADMIN ONLY) ===");
            try {
                Security.require(currentRole, Role.ADMIN);
                System.out.println("Admin action executed");
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("\n=== JOIN DEMO: FULL SESSION DESCRIPTION ===");
            SessionRepository sessionRepo = new SessionRepository();
            sessionRepo.getFullSessionDescription(1);

            System.out.println("\n=== LAMBDA/STREAM DEMO: TOP STATIONS BY HOURLY RATE ===");
            List<StationRate> rates = fetchStationRates(con);

            rates.stream()
                    .sorted(Comparator.comparing(StationRate::rate).reversed())
                    .limit(3)
                    .forEach(r -> System.out.println(r.code() + " -> " + r.rate()));

            System.out.println("\n=== STREAM FILTER DEMO: AVAILABLE STATIONS ONLY ===");
            List<StationInfo> stations = fetchStations(con);

            stations.stream()
                    .filter(s -> "AVAILABLE".equalsIgnoreCase(s.status()))
                    .forEach(s -> System.out.println(s.code() + " | " + s.status()));

        } catch (Exception e) {
            System.out.println("FAILED: " + e.getMessage());
        }
    }

    private static List<StationRate> fetchStationRates(Connection con) throws Exception {
        String sql = "SELECT code, hourly_rate FROM public.stations ORDER BY id";
        List<StationRate> list = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new StationRate(
                        rs.getString("code"),
                        rs.getBigDecimal("hourly_rate")
                ));
            }
        }
        return list;
    }

    private static List<StationInfo> fetchStations(Connection con) throws Exception {
        String sql = "SELECT code, status FROM public.stations ORDER BY id";
        List<StationInfo> list = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new StationInfo(
                        rs.getString("code"),
                        rs.getString("status")
                ));
            }
        }
        return list;
    }

    private record StationRate(String code, BigDecimal rate) { }
    private record StationInfo(String code, String status) { }
}
