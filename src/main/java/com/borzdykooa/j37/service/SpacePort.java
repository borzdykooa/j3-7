package com.borzdykooa.j37.service;

import com.borzdykooa.j37.income.ShipTemplate;
import com.borzdykooa.j37.income.impl.CruiserTemplate;
import com.borzdykooa.j37.income.impl.DeathStarTemplate;
import com.borzdykooa.j37.income.impl.FighterTemplate;
import com.borzdykooa.j37.income.impl.TransportTemplate;
import com.borzdykooa.j37.outcome.MainDock;
import com.borzdykooa.j37.outcome.factory.ShipFactory;
import com.borzdykooa.j37.outcome.factory.impl.*;
import com.borzdykooa.j37.outcome.model.Ship;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpacePort {

    private static final SpacePort INSTANCE = new SpacePort();

    public List<Ship> buildShips(List<ShipTemplate> shipTemplates) {
        ShipFactory factory;
        MainDock mainDock;
        List<Ship> ships = new ArrayList<>();
        for (ShipTemplate shipTemplate : shipTemplates) {
            if (shipTemplate instanceof TransportTemplate) {
                factory = new TransportFactory();
            } else if (shipTemplate instanceof DeathStarTemplate) {
                factory = new DeathStarFactory();

            } else if (shipTemplate instanceof CruiserTemplate) {
                factory = new CruiserFactory();

            } else if (shipTemplate instanceof FighterTemplate) {
                factory = new FighterFactory();

            } else {
                factory = new SpyProbeFactory();
            }
            factory.setShipTemplate(shipTemplate);
            mainDock = new MainDock(factory);
            ships.add(mainDock.buildShip());
        }
        return ships;
    }

    public static SpacePort getInstance() {
        return INSTANCE;
    }
}
