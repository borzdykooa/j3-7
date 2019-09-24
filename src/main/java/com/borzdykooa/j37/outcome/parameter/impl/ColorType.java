package com.borzdykooa.j37.outcome.parameter.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ColorType {

    RED("red"),
    GREEN("green"),
    YELLOW("yellow");

    private String value;

    public static ColorType getByValue(String value) {
        return Arrays.stream(values())
                .filter(type -> type.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
