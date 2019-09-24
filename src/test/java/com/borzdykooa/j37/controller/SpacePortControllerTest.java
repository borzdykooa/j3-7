package com.borzdykooa.j37.controller;

import com.borzdykooa.j37.income.ShipTemplate;
import com.borzdykooa.j37.outcome.model.Ship;
import com.borzdykooa.j37.outcome.model.Transport;
import com.borzdykooa.j37.outcome.parameter.impl.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpacePortControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SpacePortController spacePortController;

    @Test
    public void buildShip() throws IOException {
        String json = "[\n" +
                "  {\n" +
                "    \"type\": \"transport\",\n" +
                "    \"parameters\": [\n" +
                "      {\n" +
                "        \"capacity\": 5000\n" +
                "      },\n" +
                "      {\n" +
                "        \"armor\": 100\n" +
                "      },\n" +
                "      {\n" +
                "        \"fuel\": 1000\n" +
                "      },\n" +
                "      {\n" +
                "        \"fuelType\": \"diesel\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"color\": \"green\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Victory\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "    {\n" +
                "    \"type\": \"deathStar\",\n" +
                "    \"parameters\": [\n" +
                "      {\n" +
                "        \"capacityOfFighters\": 5000\n" +
                "      },\n" +
                "      {\n" +
                "        \"armor\": 100\n" +
                "      },\n" +
                "      {\n" +
                "        \"fuel\": 1000\n" +
                "      },\n" +
                "      {\n" +
                "        \"fuelType\": \"diesel\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"firePower\": 123\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Victory\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "      {\n" +
                "    \"type\": \"deathStar\",\n" +
                "    \"parameters\": [\n" +
                "      {\n" +
                "        \"capacityOfFighters\": 5000\n" +
                "      },\n" +
                "      {\n" +
                "        \"armor\": 321\n" +
                "      },\n" +
                "      {\n" +
                "        \"fuel\": 1313\n" +
                "      },\n" +
                "      {\n" +
                "        \"fuelType\": \"uran\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"firePower\": 123\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"deathStar\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        List<ShipTemplate> shipTemplates = Arrays.asList(objectMapper.readValue(json, ShipTemplate[].class));
        List<Ship> ships = spacePortController.buildShip(shipTemplates);

        assertEquals(3, ships.size());

        Ship firstShip = new Transport.Builder()
                .setArmor(new Armor(100))
                .setFuel(new Fuel(1000))
                .setFuelType(new FuelType(FuelTypeValue.DIESEL))
                .setName(new Name("Victory"))
                .setTypeParameter(new Color(ColorType.GREEN))
                .setUniqueParameter(new Capacity(5000))
                .build();
        assertEquals(ships.get(0), firstShip);
    }
}
