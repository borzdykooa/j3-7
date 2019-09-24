package com.borzdykooa.j37.outcome.factory;

import com.borzdykooa.j37.income.IncomeParameter;
import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.borzdykooa.j37.outcome.parameter.impl.FirePower;

public abstract class WarShipFactory extends ShipFactory {

    @Override
    public Parameter getTypeParameter() {
        FirePower firePower = new FirePower();
        Integer result = this.getShipTemplate().getParameters().stream()
                .filter(param -> param.getFirePower() != null)
                .map(IncomeParameter::getFirePower)
                .findFirst().orElse(null);
        firePower.setFirepower(result);

        return firePower;
    }
}
