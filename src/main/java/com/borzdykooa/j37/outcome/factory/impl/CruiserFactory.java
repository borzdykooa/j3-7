package com.borzdykooa.j37.outcome.factory.impl;

import com.borzdykooa.j37.income.IncomeParameter;
import com.borzdykooa.j37.outcome.factory.WarShipFactory;
import com.borzdykooa.j37.outcome.model.Cruiser;
import com.borzdykooa.j37.outcome.model.Ship;
import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.borzdykooa.j37.outcome.parameter.impl.NumberOfGuns;

public class CruiserFactory extends WarShipFactory {

    @Override
    public Ship getShip() {
        return new Cruiser();
    }

    @Override
    public Parameter getUniqueParameter() {
        NumberOfGuns numberOfGuns = new NumberOfGuns();
        Integer result = this.getShipTemplate().getParameters().stream()
                .filter(param -> param.getNumberOfGuns() != null)
                .map(IncomeParameter::getNumberOfGuns)
                .findFirst().orElse(null);
        numberOfGuns.setNumberOfGuns(result);

        return numberOfGuns;
    }
}
