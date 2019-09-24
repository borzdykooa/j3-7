package com.borzdykooa.j37.outcome.factory.impl;

import com.borzdykooa.j37.income.IncomeParameter;
import com.borzdykooa.j37.outcome.factory.WarShipFactory;
import com.borzdykooa.j37.outcome.model.Fighter;
import com.borzdykooa.j37.outcome.model.Ship;
import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.borzdykooa.j37.outcome.parameter.impl.Speed;

public class FighterFactory extends WarShipFactory {

    @Override
    public Ship getShip() {
        return new Fighter();
    }

    @Override
    public Parameter getUniqueParameter() {
        Speed speed = new Speed();
        Integer result = this.getShipTemplate().getParameters().stream()
                .filter(param -> param.getSpeed() != null)
                .map(IncomeParameter::getSpeed)
                .findFirst().orElse(null);
        speed.setSpeed(result);

        return speed;
    }
}
