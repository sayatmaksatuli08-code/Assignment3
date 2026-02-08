package com.gameclub.service;

import java.util.List;

public class SessionService {

    public void printLongSessions(List<Integer> minutes) {
        minutes.stream()
                .filter(m -> m > 60)
                .sorted((a, b) -> b - a)
                .forEach(System.out::println);
    }
}
