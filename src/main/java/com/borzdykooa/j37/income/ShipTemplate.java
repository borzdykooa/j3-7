package com.borzdykooa.j37.income;

import com.borzdykooa.j37.income.impl.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TransportTemplate.class, name = "transport"),
        @JsonSubTypes.Type(value = DeathStarTemplate.class, name = "deathStar"),
        @JsonSubTypes.Type(value = FighterTemplate.class, name = "fighter"),
        @JsonSubTypes.Type(value = CruiserTemplate.class, name = "cruiser"),
        @JsonSubTypes.Type(value = SpyProbeTemplate.class, name = "spyProbe")
})
@Data
public abstract class ShipTemplate {

    private List<IncomeParameter> parameters;
}
