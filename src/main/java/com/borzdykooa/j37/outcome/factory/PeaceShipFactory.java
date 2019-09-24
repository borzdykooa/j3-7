package com.borzdykooa.j37.outcome.factory;

import com.borzdykooa.j37.income.IncomeParameter;
import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.borzdykooa.j37.outcome.parameter.impl.Color;
import com.borzdykooa.j37.outcome.parameter.impl.ColorType;

public abstract class PeaceShipFactory extends ShipFactory {

    @Override
    public Parameter getTypeParameter() {
        Color color = new Color();
        String result = this.getShipTemplate().getParameters().stream()
                .filter(param -> param.getColor() != null)
                .map(IncomeParameter::getColor)
                .findFirst().orElse(null);
        color.setColor(ColorType.getByValue(result));

        return color;
    }
}
