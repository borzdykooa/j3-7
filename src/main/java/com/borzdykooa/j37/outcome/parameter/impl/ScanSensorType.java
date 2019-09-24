package com.borzdykooa.j37.outcome.parameter.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ScanSensorType {

    SIMPLE("simple"),
    OPTICAL("optical");

    private String value;

    public static ScanSensorType getByValue(String value) {
        return Arrays.stream(values())
                .filter(type -> type.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
