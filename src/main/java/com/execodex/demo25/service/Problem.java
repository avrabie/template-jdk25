package com.execodex.demo25.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Problem {
    public static void main(String[] args) {
        List<String> iaka = List.of("iaka", "cool", "iaka", "inna", "davide", "adrian", "whatever", "inna", "iaka");
        Map<String, Integer> collect = iaka.stream().collect(Collectors.toMap(s -> s, s -> 1, (i,j)->i+1)
        );

        System.out.println(collect);
    }
}
