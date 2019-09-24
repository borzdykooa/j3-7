package com.borzdykooa.j37.outcome;

import com.borzdykooa.j37.outcome.factory.ShipFactory;
import com.borzdykooa.j37.outcome.model.Ship;

public class MainDock {

    private Ship ship;

    public MainDock(ShipFactory factory) {
        ship = factory.getShip();
        ship.setArmor(factory.getArmor());
        ship.setFuel(factory.getFuel());
        ship.setFuelType(factory.getFuelType());
        ship.setName(factory.getName());
        ship.setTypeParameter(factory.getTypeParameter());
        ship.setUniqueParameter(factory.getUniqueParameter());
    }

    public Ship buildShip() {
        return ship;
    }
}
