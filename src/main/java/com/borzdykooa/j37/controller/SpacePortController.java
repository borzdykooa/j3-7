package com.borzdykooa.j37.controller;

import com.borzdykooa.j37.income.ShipTemplate;
import com.borzdykooa.j37.outcome.model.Ship;
import com.borzdykooa.j37.service.SpacePort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpacePortController {

    @PostMapping("/api/v1/ships/build")
    public List<Ship> buildShip(@RequestBody List<ShipTemplate> shipTemplates) {
        return SpacePort.getInstance().buildShips(shipTemplates);
    }
}
