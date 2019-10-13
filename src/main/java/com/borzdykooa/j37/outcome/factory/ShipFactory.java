package com.borzdykooa.j37.outcome.factory;

import com.borzdykooa.j37.income.IncomeParameter;
import com.borzdykooa.j37.income.ShipTemplate;
import com.borzdykooa.j37.outcome.model.Ship;
import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.borzdykooa.j37.outcome.parameter.impl.Armor;
import com.borzdykooa.j37.outcome.parameter.impl.Fuel;
import com.borzdykooa.j37.outcome.parameter.impl.FuelType;
import com.borzdykooa.j37.outcome.parameter.impl.FuelTypeValue;
import com.borzdykooa.j37.outcome.parameter.impl.Name;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ShipFactory {

    private ShipTemplate shipTemplate;

    public Parameter getArmor() {
        Armor armor = new Armor();
        Integer result = shipTemplate.getParameters().stream()
                .filter(param -> param.getArmor() != null)
                .map(IncomeParameter::getArmor)
                .findFirst().orElse(null);
        armor.setArmor(result);

        return armor;
    }

    public Parameter getFuel() {
        Fuel fuel = new Fuel();
        Integer result = shipTemplate.getParameters().stream()
                .filter(param -> param.getFuel() != null)
                .map(IncomeParameter::getFuel)
                .findFirst().orElse(null);
        fuel.setFuel(result);

        return fuel;
    }

    public Parameter getFuelType() {
        FuelType fuelType = new FuelType();
        String result = shipTemplate.getParameters().stream()
                .filter(param -> param.getFuelType() != null)
                .map(IncomeParameter::getFuelType)
                .findFirst().orElse(null);
        fuelType.setFuelType(FuelTypeValue.getByValue(result));

        return fuelType;
    }

    public Parameter getName() {
        Name name = new Name();
        String result = shipTemplate.getParameters().stream()
                .filter(param -> param.getName() != null)
                .map(IncomeParameter::getName)
                .findFirst().orElse(null);
        name.setName(result);

        return name;
    }

    public abstract Parameter getTypeParameter();

    public abstract Parameter getUniqueParameter();

    public abstract Ship getShip();
}
