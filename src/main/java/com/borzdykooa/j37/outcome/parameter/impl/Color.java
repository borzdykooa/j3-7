package com.borzdykooa.j37.outcome.parameter.impl;

import com.borzdykooa.j37.outcome.parameter.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color implements Parameter {

    private ColorType color;
}
