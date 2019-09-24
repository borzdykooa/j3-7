package com.borzdykooa.j37.outcome.parameter.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum FuelTypeValue {

    DIESEL("diesel"),
    URAN("uran");

    private String value;

    public static FuelTypeValue getByValue(String value) {
        return Arrays.stream(values())
                .filter(type -> type.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
