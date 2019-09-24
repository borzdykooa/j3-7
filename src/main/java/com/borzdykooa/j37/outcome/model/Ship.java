package com.borzdykooa.j37.outcome.model;

import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public abstract class Ship {

    private Parameter armor;
    private Parameter fuel;
    private Parameter fuelType;
    private Parameter name;
    private Parameter typeParameter;
    private Parameter uniqueParameter;
}
