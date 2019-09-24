package com.borzdykooa.j37.outcome.factory.impl;

import com.borzdykooa.j37.income.IncomeParameter;
import com.borzdykooa.j37.outcome.factory.WarShipFactory;
import com.borzdykooa.j37.outcome.model.DeathStar;
import com.borzdykooa.j37.outcome.model.Ship;
import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.borzdykooa.j37.outcome.parameter.impl.CapacityOfFighters;

public class DeathStarFactory extends WarShipFactory {

    @Override
    public Ship getShip() {
        return new DeathStar();
    }

    @Override
    public Parameter getUniqueParameter() {
        CapacityOfFighters capacityOfFighters = new CapacityOfFighters();
        Integer result = this.getShipTemplate().getParameters().stream()
                .filter(param -> param.getCapacityOfFighters() != null)
                .map(IncomeParameter::getCapacityOfFighters)
                .findFirst().orElse(null);
        capacityOfFighters.setCapacityOfFighters(result);

        return capacityOfFighters;
    }
}
