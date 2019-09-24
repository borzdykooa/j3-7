package com.borzdykooa.j37.outcome.factory.impl;

import com.borzdykooa.j37.income.IncomeParameter;
import com.borzdykooa.j37.outcome.factory.PeaceShipFactory;
import com.borzdykooa.j37.outcome.model.Ship;
import com.borzdykooa.j37.outcome.model.Transport;
import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.borzdykooa.j37.outcome.parameter.impl.Capacity;

public class TransportFactory extends PeaceShipFactory {

    @Override
    public Ship getShip() {
        return new Transport();
    }

    @Override
    public Parameter getUniqueParameter() {
        Capacity capacity = new Capacity();
        Integer result = this.getShipTemplate().getParameters().stream()
                .filter(param -> param.getCapacity() != null)
                .map(IncomeParameter::getCapacity)
                .findFirst().orElse(null);
        capacity.setCapacity(result);

        return capacity;
    }
}
